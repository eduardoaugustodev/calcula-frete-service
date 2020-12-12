package br.com.frete.api;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.http.HttpStatus.OK;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import br.com.frete.api.model.Servico;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CalculaFreteResourceTest {

	@LocalServerPort
	int randomServerPort;

	private RestTemplate restTemplate;

	private String urlBase;

	@BeforeEach
	void setUp() {
		this.restTemplate = new RestTemplate();
		this.urlBase = "http://localhost:" + randomServerPort + "/calcula-frete/calcular";
	}
	
	@Test
	void deveAcionarOServicoComSucesso() {
		ResponseEntity<Servico> response = restTemplate.getForEntity(urlBase + "?sCepDestino=90619900&nCdServico=04510", Servico.class);
		assertEquals(OK, response.getStatusCode());
	}
	
	@Test
	void deveAcionarOServicoComSucessoERetornarOValorDoFrete() {
		ResponseEntity<Servico> response = restTemplate.getForEntity(urlBase + "?sCepDestino=90619900&nCdServico=04510", Servico.class);
		assertEquals(OK, response.getStatusCode());
		assertNotNull(response.getBody().getcServico().getValor());
	}
	
	@Test
	void deveAcionarOServicoComSucessoERetornarMensagemDeCEPDestinoInvalido() {
		ResponseEntity<Servico> response = restTemplate.getForEntity(urlBase + "?sCepDestino=null&nCdServico=04510", Servico.class);
		assertEquals(OK, response.getStatusCode());
		assertNotNull(response.getBody().getcServico().getMsgErro());
		assertTrue("CEP de destino invalido.".equalsIgnoreCase(response.getBody().getcServico().getMsgErro()));
	}
	
	@Test
	void deveAcionarOServicoComSucessoERetornarMensagemErroCalculoTarifca() {
		ResponseEntity<Servico> response = restTemplate.getForEntity(urlBase + "?sCepDestino=06365185&nCdServico=null", Servico.class);
		assertEquals(OK, response.getStatusCode());
		assertNotNull(response.getBody().getcServico().getMsgErro());
		assertTrue("Erro ao calcular tarifa. Tente novamente mais tarde. Servidores indisponíveis.".equalsIgnoreCase(response.getBody().getcServico().getMsgErro()));
	}
	
}
