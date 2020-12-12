package br.com.frete.api.service;

import br.com.frete.api.model.Servico;

public interface ICalculaFreteService {

	public Servico calcularFrete(String sCepDestino, String nCdServico);
}
