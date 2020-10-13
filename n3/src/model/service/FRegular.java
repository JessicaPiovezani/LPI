package model.service;

import model.Frete;

public class FRegular extends Frete implements IFrete {
	
	private Integer qntdOperacoes;
	private Integer frequencia;
	private String unFrequencia;
	
	public FRegular(int idFrete, String opcaoFrete, String origem, String destino, Double distancia,
			 Integer qntdOperacoes, Integer frequencia, String unFrequencia, String mercadoria, Double preco) {
		super(idFrete, opcaoFrete, origem, destino, distancia, mercadoria, preco);
		this.qntdOperacoes = qntdOperacoes;
		this.frequencia = frequencia;
		this.unFrequencia = unFrequencia;
		this.setPreco(valorFrete(distancia));
	}

	@Override
	public double valorFrete(Double distancia) {
		return (200 + 0.5 * distancia);
		// TODO Auto-generated method stub
		
	}

	public Integer getQntdOperacoes() {
		return qntdOperacoes;
	}

	public void setQntdOperacoes(Integer qntdOperacoes) {
		this.qntdOperacoes = qntdOperacoes;
	}

	public Integer getFrequencia() {
		return frequencia;
	}

	public void setFrequencia(Integer frequencia) {
		this.frequencia = frequencia;
	}

	public String getUnFrequencia() {
		return unFrequencia;
	}

	public void setUnFrequencia(String unFrequencia) {
		this.unFrequencia = unFrequencia;
	}
	

}
