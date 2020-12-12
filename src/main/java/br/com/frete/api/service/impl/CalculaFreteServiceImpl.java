package br.com.frete.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import br.com.frete.api.model.Servico;
import br.com.frete.api.service.ICalculaFreteService;
import reactor.core.publisher.Mono;

@Service
public class CalculaFreteServiceImpl implements ICalculaFreteService {

	@Autowired
	private WebClient webclient;
	
	@Override
	public Servico calcularFrete(String sCepDestino, String nCdServico) {
		return calcularPrecoPrazo(sCepDestino, nCdServico);	  
	}

	private Servico calcularPrecoPrazo(String sCepDestino, String nCdServico) {
		Mono<Servico> monoServico =	this.webclient.get()
						.uri(uriBuilder -> uriBuilder
							    .path("/calculador/CalcPrecoPrazo.aspx")
							    .queryParam("sCepOrigem", "{sCepOrigem}")
							    .queryParam("sCepDestino", "{sCepDestino}")
							    .queryParam("nVlPeso", "{nVlPeso}")
							    .queryParam("nVlComprimento", "{nVlComprimento}")
							    .queryParam("nVlAltura", "{nVlAltura}")
							    .queryParam("nVlLargura", "{nVlLargura}")
							    .queryParam("nVlDiametro", "{nVlDiametro}")
							    .queryParam("nCdFormato", "{nCdFormato}")
							    .queryParam("sCdMaoPropria", "{sCdMaoPropria}")
							    .queryParam("sCdAvisoRecebimento", "{sCdAvisoRecebimento}")
							    .queryParam("nVlValorDeclarado", "{nVlValorDeclarado}")
							    .queryParam("nCdServico", "{nCdServico}")
							    .queryParam("nCdEmpresa", "{nCdEmpresa}")
							    .queryParam("sDsSenha", "{sDsSenha}")
							    .queryParam("StrRetorno", "{StrRetorno}")
							    .build("06030460", sCepDestino, "0.3",	"30", 	"2",  	"15", 	"0.0",	"1", "N", "N",	"0,00",	nCdServico,"",	"",	"xml"))
						.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_XML_VALUE)
		                .accept(MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML)
						.retrieve()
						.bodyToMono(Servico.class);
		Servico servico =  monoServico.block();
		return servico;
	}

	
}
