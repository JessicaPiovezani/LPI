package model.service;

import model.Mercadoria;

public class MAuditada extends Mercadoria implements IMAuditada {
	
	private String datainspencao;
	private String nomeorgao;
	
	public MAuditada(int idMercadoria, String tipo, String descricao, String unPeso, Float peso, Boolean auditada,
			String datainspencao, String nomeorgao) {
		super(idMercadoria, tipo, descricao, unPeso, peso, auditada);
		this.datainspencao = datainspencao;
		this.nomeorgao = nomeorgao;
	}
	public String getDatainspencao() {
		return datainspencao;
	}
	public void setDatainspencao(String datainspencao) {
		this.datainspencao = datainspencao;
	}
	public String getNomeorgao() {
		return nomeorgao;
	}
	public void setNomeorgao(String nomeorgao) {
		this.nomeorgao = nomeorgao;
	}
	@Override
	public boolean auditada(int idMercadoria) {
		// TODO Auto-generated method stub
		return false;
	}
	
	

}
