package controller.service;

import java.sql.SQLException;

import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.util.ArrayList;

import BD.DbException;
import BD.MySQLConnector;
import model.service.FDemanda;

public class CFDeamanda {
	
private MySQLConnector connection;
	
	public CFDeamanda() {
		connection = new MySQLConnector();
		connection.connectionBd();
	}
	
	final String criarTabelaDemanda = "CREATE TABLE IF NOT EXISTS tb_fdemanda (idFrete INTEGER NOT NULL primary key AUTO_INCREMENT, opcaoFrete VARCHAR (20) NOT NULL, origem VARCHAR (256) NOT NULL, destino VARCHAR (256) NOT NULL, distancia DOUBLE NOT NULL, dcoleta VARCHAR (10), dprevisao VARCHAR (10), mercadoria VARCHAR (80), preco DOUBLE)";
	final String inserirTabelaDemanda = "INSERT INTO tb_fdemanda (opcaoFrete, origem, destino, distancia, dcoleta, dprevisao, mercadoria, preco) values (?,?,?,?,?,?,?,?)";
	final String selecionarTabelaDemanda = "SELECT * FROM tb_fdemanda";
	
	public void nova(FDemanda fdemanda) throws SQLException {
		try {
			connection.preparation(criarTabelaDemanda);
			connection.getPreparedStatement().executeUpdate();
			
			connection.preparation(inserirTabelaDemanda);
			connection.getPreparedStatement().setString(1, fdemanda.getOpcaoFrete());
			connection.getPreparedStatement().setString(2, fdemanda.getOrigem());
			connection.getPreparedStatement().setString(3, fdemanda.getDestino());
			connection.getPreparedStatement().setDouble(4, fdemanda.getDistancia());
			connection.getPreparedStatement().setString(5, fdemanda.getDcoleta());
			connection.getPreparedStatement().setString(6, fdemanda.getDprevisao());
			connection.getPreparedStatement().setString(7, fdemanda.getMercadoria());
			connection.getPreparedStatement().setDouble(8, fdemanda.getPreco());
			connection.getPreparedStatement().executeUpdate();
			JOptionPane.showMessageDialog(null, "Cadastro Realizado com Sucesso !!!");
		} catch (DbException e ) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
	
	public ArrayList<FDemanda> queryFdemanda() {
        ResultSet rs = null;
        ArrayList<FDemanda> fdemandas = new ArrayList<FDemanda>();
        try {
            rs = connection.getStatement().executeQuery(selecionarTabelaDemanda);
            while (rs.next()) {
            	FDemanda fdemanda = new FDemanda(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDouble(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getDouble(9));
            	fdemanda.setIdFrete(rs.getInt("idFrete"));
            	fdemanda.setOpcaoFrete(rs.getString("opcaoFrete"));
            	fdemanda.setOrigem(rs.getString("origem"));
            	fdemanda.setDestino(rs.getString("destino"));
            	fdemanda.setDistancia(rs.getDouble("distancia"));
            	fdemanda.setDcoleta(rs.getString("dcoleta"));
            	fdemanda.setDprevisao(rs.getString("dprevisao"));
            	fdemanda.setMercadoria(rs.getString("mercadoria"));
            	fdemanda.setPreco(rs.getDouble("preco"));
            	
            	fdemandas.add(fdemanda);
            	
            	}
            } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            }
        return fdemandas;
    }
	

}
