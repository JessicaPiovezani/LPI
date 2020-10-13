package model;

public class Mercadoria  {
	
	private int idMercadoria=0;
	private String tipo;
	private String descricao;
	private String unPeso;
	private Float peso;
	private Boolean auditada;
	
	
	
	public Mercadoria(int idMercadoria, String tipo, String descricao,
			String unPeso, Float peso, Boolean auditada) {
		this.idMercadoria = idMercadoria;
		this.tipo = tipo;
		this.descricao = descricao;
		this.unPeso = unPeso;
		this.peso = peso;
		this.auditada = auditada;
	}



	public int getIdMercadoria() {
		return idMercadoria;
	}



	public void setIdMercadoria(int idMercadoria) {
		this.idMercadoria = idMercadoria;
	}



	public String getTipo() {
		return tipo;
	}



	public void setTipo(String tipo) {
		this.tipo = tipo;
	}



	public String getDescricao() {
		return descricao;
	}



	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}



	public String getUnPeso() {
		return unPeso;
	}



	public void setUnPeso(String unPeso) {
		this.unPeso = unPeso;
	}



	public Float getPeso() {
		return peso;
	}



	public void setPeso(Float peso) {
		this.peso = peso;
	}



	public Boolean getAuditada() {
		return auditada;
	}



	public void setAuditada(Boolean auditada) {
		this.auditada = auditada;
	}
	
	

}
