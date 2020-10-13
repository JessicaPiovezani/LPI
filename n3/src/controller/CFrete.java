package controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import BD.DbException;
import BD.MySQLConnector;
import model.Frete;

public class CFrete {
	
private MySQLConnector connection;
	
	public CFrete() {
		connection = new MySQLConnector();
		connection.connectionBd();
	}
	
	final String criarTabelaFretes = "CREATE TABLE IF NOT EXISTS tb_fretes (idFrete INTEGER NOT NULL primary key AUTO_INCREMENT, opcaoFrete VARCHAR (256) NOT NULL, origem VARCHAR (256) NOT NULL, destino VARCHAR (256) NOT NULL, distancia DOUBLE (10) NOT NULL, mercadoria VARCHAR (80), preco DOUBLE(10);";
	final String inserirTabelaFretes = "INSERT INTO tb_fretes (opcaoFrete, origem, destino, distancia, mercadoria, preco) values (?,?,?,?,?,?)";
	final String selecionarTabelaFretes = "SELECT * FROM tb_fretes";
	
	public void nova(Frete frete) throws SQLException {
		try {
			connection.preparation(criarTabelaFretes);
			connection.getPreparedStatement().executeUpdate();
			
			connection.preparation(inserirTabelaFretes);
			connection.getPreparedStatement().setString(1, frete.getOpcaoFrete());
			connection.getPreparedStatement().setString(2, frete.getOrigem());
			connection.getPreparedStatement().setString(3, frete.getDestino());
			connection.getPreparedStatement().setDouble(4, frete.getDistancia());
			connection.getPreparedStatement().setString(5, frete.getMercadoria());
			connection.getPreparedStatement().setDouble(6, frete.getPreco());
			connection.getPreparedStatement().executeUpdate();
			JOptionPane.showMessageDialog(null, "Cadastro Realizado com Sucesso !!!");
		} catch (DbException e ) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
	
	public ArrayList<Frete> queryFdemanda() {
        ResultSet rs = null;
        ArrayList<Frete> fretes = new ArrayList<Frete>();
        try {
            rs = connection.getStatement().executeQuery(selecionarTabelaFretes);
            while (rs.next()) {
            	Frete frete = new Frete(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDouble(5), rs.getString(6), rs.getDouble(7));
            	frete.setIdFrete(rs.getInt("idFrete"));
            	frete.setOpcaoFrete(rs.getString("opcaoFrete"));
            	frete.setOrigem(rs.getString("origem"));
            	frete.setDestino(rs.getString("destino"));
            	frete.setDistancia(rs.getDouble("distancia"));
            	frete.setMercadoria(rs.getString("qntdMercadoria"));
            	frete.setPreco(rs.getDouble("preco"));
            	
            	fretes.add(frete);
            	
            	}
            } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            }
        return fretes;
    }

}
