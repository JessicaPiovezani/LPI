package controller.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import BD.DbException;
import BD.MySQLConnector;
import model.service.FRegular;

public class CFRegular {
	
	private MySQLConnector connection;
	
	public CFRegular() {
		connection = new MySQLConnector();
		connection.connectionBd();
	}
	
	final String criarTabelaRegular = "CREATE TABLE IF NOT EXISTS tb_fregular (idFrete INTEGER NOT NULL primary key AUTO_INCREMENT, opcaoFrete VARCHAR (256) NOT NULL, origem VARCHAR (256) NOT NULL, destino VARCHAR (256) NOT NULL, distancia DOUBLE NOT NULL, qntdOperacoes INTEGER (10), frequencia INTEGER (10), unFrequencia VARCHAR (10), mercadoria VARCHAR (80), preco DOUBLE)";
	final String inserirTabelaRegular = "INSERT INTO tb_fregular (opcaoFrete, origem, destino, distancia, qntdOperacoes, frequencia, unFrequencia, mercadoria, preco) values (?,?,?,?,?,?,?,?,?)";
	final String selecionarTabelaRegular = "SELECT * FROM tb_fregular";
	
	public void nova(FRegular fregular) throws SQLException {
		try {
			connection.preparation(criarTabelaRegular);
			connection.getPreparedStatement().executeUpdate();
			
			connection.preparation(inserirTabelaRegular);
			connection.getPreparedStatement().setString(1, fregular.getOpcaoFrete());
			connection.getPreparedStatement().setString(2, fregular.getOrigem());
			connection.getPreparedStatement().setString(3, fregular.getDestino());
			connection.getPreparedStatement().setDouble(4, fregular.getDistancia());
			connection.getPreparedStatement().setInt(5, fregular.getQntdOperacoes());
			connection.getPreparedStatement().setInt(6, fregular.getFrequencia());
			connection.getPreparedStatement().setString(7, fregular.getUnFrequencia());
			connection.getPreparedStatement().setString(8, fregular.getMercadoria());
			connection.getPreparedStatement().setDouble(9, fregular.getPreco());
			connection.getPreparedStatement().executeUpdate();
			JOptionPane.showMessageDialog(null, "Cadastro Realizado com Sucesso !!!");
		} catch (DbException e ) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
	
	public ArrayList<FRegular> queryFregular() {
        ResultSet rs = null;
        ArrayList<FRegular> fregulares = new ArrayList<FRegular>();
        try {
            rs = connection.getStatement().executeQuery(selecionarTabelaRegular);
            while (rs.next()) {
            	FRegular fregular = new FRegular(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDouble(5), rs.getInt(6), rs.getInt(7), rs.getString(8), rs.getString(9), rs.getDouble(10));
            	fregular.setIdFrete(rs.getInt("idFrete"));
            	fregular.setOpcaoFrete(rs.getString("opcaoFrete"));
            	fregular.setOrigem(rs.getString("origem"));
            	fregular.setDestino(rs.getString("destino"));
            	fregular.setDistancia(rs.getDouble("distancia"));
            	fregular.setQntdOperacoes(rs.getInt("qntdOperacoes"));
            	fregular.setFrequencia(rs.getInt("frequencia"));
            	fregular.setUnFrequencia(rs.getString("unFrequencia"));
            	fregular.setMercadoria(rs.getString("mercadoria"));
            	fregular.setPreco(rs.getDouble("preco"));
            	
            	fregulares.add(fregular);
            	
            	}
            } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            }
        return fregulares;
    }
	
}
