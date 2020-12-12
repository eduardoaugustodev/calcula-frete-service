package br.com.frete.api.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.frete.api.model.Servico;
import br.com.frete.api.service.ICalculaFreteService;

@RestController
public class CalculaFreteResource {

	@Autowired
	private ICalculaFreteService service;

	@GetMapping("/calcular")
	@ResponseBody
	public ResponseEntity<Servico> calcular(@RequestParam String sCepDestino, @RequestParam String nCdServico) {
		return ResponseEntity.ok(this.service.calcularFrete(sCepDestino, nCdServico));
	}
}
