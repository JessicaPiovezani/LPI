package model;

public class Frete {
	
	private int idFrete=0;
	private String opcaoFrete;
	private String origem;
	private String destino;
	private Double distancia;
	private String mercadoria;
	private Double preco;
	
	public Frete(int idFrete, String opcaoFrete, String origem, String destino, Double distancia
			, String mercadoria, Double preco) {
		this.idFrete = idFrete;
		this.opcaoFrete = opcaoFrete;
		this.origem = origem;
		this.destino = destino;
		this.distancia = distancia;
	}

	public Integer getIdFrete() {
		return idFrete;
	}



	public void setIdFrete(Integer idFrete) {
		this.idFrete = idFrete;
	}



	public String getOpcaoFrete() {
		return opcaoFrete;
	}

	public void setOpcaoFrete(String opcaoFrete) {
		this.opcaoFrete = opcaoFrete;
	}

	public String getOrigem() {
		return origem;
	}

	public void setOrigem(String origem) {
		this.origem = origem;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public Double getDistancia() {
		return distancia;
	}

	public void setDistancia(Double distancia) {
		this.distancia = distancia;
	}

	public String getMercadoria() {
		return mercadoria;
	}

	public void setMercadoria(String mercadoria) {
		this.mercadoria = mercadoria;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

}
