package model.service;

import model.Frete;

public class FDemanda extends Frete implements IFrete {
	
	private String dcoleta;
	private String dprevisao;
	
	public FDemanda(int idFrete, String opcaoFrete, String origem, String destino, Double distancia,
			String dcoleta, String dprevisao, String mercadoria, Double preco) {
		super(idFrete, opcaoFrete, origem, destino, distancia, mercadoria, preco);
		this.dcoleta = dcoleta;
		this.dprevisao = dprevisao;
		this.setPreco(valorFrete(distancia));
	}

	@Override
	public double valorFrete(Double distancia) {
		// TODO Auto-generated method stub
		return (300 + 0.6 * distancia);
	}

	public String getDcoleta() {
		return dcoleta;
	}

	public void setDcoleta(String dcoleta) {
		this.dcoleta = dcoleta;
	}

	public String getDprevisao() {
		return dprevisao;
	}

	public void setDprevisao(String dprevisao) {
		this.dprevisao = dprevisao;
	}

}
