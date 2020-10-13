package controller;


import java.sql.SQLException;

import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.util.ArrayList;

import BD.DbException;
import BD.MySQLConnector;
import model.Mercadoria;

public class CMercadoria {
	
	private MySQLConnector connection;
	
	public CMercadoria() {
		connection = new MySQLConnector();
		connection.connectionBd();
	}
	
	final String criarTabelaMercadoria = "CREATE TABLE IF NOT EXISTS tb_mercadorias (idMercadoria INTEGER NOT NULL primary key AUTO_INCREMENT, tipo VARCHAR (256) NOT NULL, descricao VARCHAR (256) NOT NULL, unpeso VARCHAR (256) NOT NULL, peso FLOAT (10) NOT NULL, auditada BOOLEAN NOT NULL);";
	final String inserirMercadoria = "INSERT INTO tb_mercadorias (tipo, descricao, unpeso, peso, auditada) values (?,?,?,?,?)";
	final String selecionarMercadoria = "SELECT * FROM tb_mercadorias";
	
	public void nova(Mercadoria mercadoria) throws SQLException {
		try {
			connection.preparation(criarTabelaMercadoria);
			connection.getPreparedStatement().executeUpdate();
			
			connection.preparation(inserirMercadoria);
			connection.getPreparedStatement().setString(1, mercadoria.getTipo());
			connection.getPreparedStatement().setString(2, mercadoria.getDescricao());
			connection.getPreparedStatement().setString(3, mercadoria.getUnPeso());
			connection.getPreparedStatement().setFloat(4, mercadoria.getPeso());
			connection.getPreparedStatement().setBoolean(5, mercadoria.getAuditada());
			connection.getPreparedStatement().executeUpdate();
			JOptionPane.showMessageDialog(null, "Cadastro Realizado com Sucesso !!!");
		} catch (DbException e ) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
	
	public ArrayList<Mercadoria> queryMeradoria() {
        ResultSet rs = null;
        ArrayList<Mercadoria> mercadorias = new ArrayList<Mercadoria>();
        try {
            rs = connection.getStatement().executeQuery(selecionarMercadoria);
            while (rs.next()) {
            	Mercadoria mercadoria = new Mercadoria(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getFloat(5), rs.getBoolean(6));
            	mercadoria.setIdMercadoria(rs.getInt("idMercadoria"));
            	mercadoria.setTipo(rs.getString("tipo"));
            	mercadoria.setDescricao(rs.getString("descricao"));
            	mercadoria.setUnPeso(rs.getString("unPeso"));
            	mercadoria.setPeso(rs.getFloat("peso"));
            	mercadoria.setAuditada(rs.getBoolean("auditada"));
            	
            	mercadorias.add(mercadoria);
            	
            	}
            } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            }
        return mercadorias;
    }
}
