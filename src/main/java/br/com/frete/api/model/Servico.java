package br.com.frete.api.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Servicos")
public class Servico {
	
	private CServico cServico;

	public CServico getcServico() {
		return cServico;
	}

	public void setcServico(CServico cServico) {
		this.cServico = cServico;
	}

}
