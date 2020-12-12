package br.com.frete.api.model;

import javax.xml.bind.annotation.XmlElement;

public class CServico {

	@XmlElement
	private String MsgErro;

	@XmlElement
	private String ValorAvisoRecebimento;

	@XmlElement
	private String ValorSemAdicionais;

	@XmlElement
	private String Codigo;

	@XmlElement
	private String ValorMaoPropria;

	@XmlElement
	private String EntregaSabado;

	@XmlElement
	private String Erro;

	@XmlElement
	private String ValorValorDeclarado;

	@XmlElement
	private String EntregaDomiciliar;

	@XmlElement
	private String Valor;

	@XmlElement
	private String PrazoEntrega;

	private String obsFim;
	
	public String getMsgErro() {
		return MsgErro;
	}

	public void setMsgErro(String msgErro) {
		MsgErro = msgErro;
	}

	public String getValorAvisoRecebimento() {
		return ValorAvisoRecebimento;
	}

	public void setValorAvisoRecebimento(String valorAvisoRecebimento) {
		ValorAvisoRecebimento = valorAvisoRecebimento;
	}

	public String getValorSemAdicionais() {
		return ValorSemAdicionais;
	}

	public void setValorSemAdicionais(String valorSemAdicionais) {
		ValorSemAdicionais = valorSemAdicionais;
	}

	public String getCodigo() {
		return Codigo;
	}

	public void setCodigo(String codigo) {
		Codigo = codigo;
	}

	public String getValorMaoPropria() {
		return ValorMaoPropria;
	}

	public void setValorMaoPropria(String valorMaoPropria) {
		ValorMaoPropria = valorMaoPropria;
	}

	public String getEntregaSabado() {
		return EntregaSabado;
	}

	public void setEntregaSabado(String entregaSabado) {
		EntregaSabado = entregaSabado;
	}

	public String getErro() {
		return Erro;
	}

	public void setErro(String erro) {
		Erro = erro;
	}

	public String getValorValorDeclarado() {
		return ValorValorDeclarado;
	}

	public void setValorValorDeclarado(String valorValorDeclarado) {
		ValorValorDeclarado = valorValorDeclarado;
	}

	public String getEntregaDomiciliar() {
		return EntregaDomiciliar;
	}

	public void setEntregaDomiciliar(String entregaDomiciliar) {
		EntregaDomiciliar = entregaDomiciliar;
	}

	public String getValor() {
		return Valor;
	}

	public void setValor(String valor) {
		Valor = valor;
	}

	public String getPrazoEntrega() {
		return PrazoEntrega;
	}

	public void setPrazoEntrega(String prazoEntrega) {
		PrazoEntrega = prazoEntrega;
	}

	public String getObsFim() {
		return obsFim;
	}

	public void setObsFim(String obsFim) {
		this.obsFim = obsFim;
	}

}
