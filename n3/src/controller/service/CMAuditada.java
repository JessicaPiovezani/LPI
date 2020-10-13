package controller.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import BD.DbException;
import BD.MySQLConnector;
import model.service.MAuditada;

public class CMAuditada {
	
private MySQLConnector connection;
	
	public CMAuditada() {
		connection = new MySQLConnector();
		connection.connectionBd();
	}
	
	final String criarTabelaMAuditada = "CREATE TABLE IF NOT EXISTS tb_mauditadas (idMercadoria INTEGER NOT NULL primary key AUTO_INCREMENT, tipo VARCHAR (256) NOT NULL, descricao VARCHAR (256) NOT NULL, unpeso VARCHAR (256) NOT NULL, peso FLOAT (10) NOT NULL, auditada BOOLEAN NOT NULL, datainspencao VARCHAR(10), nomeorgao VARCHAR (256));";
	final String inserirMercadoria = "INSERT INTO tb_mauditadas (tipo, descricao, unpeso, peso, auditada, datainspencao, nomeorgao) values (?,?,?,?,?,?,?)";
	final String selecionarMercadoria = "SELECT * FROM tb_mauditadas";
	
	public void nova(MAuditada mauditada) throws SQLException {
		try {
			connection.preparation(criarTabelaMAuditada);
			connection.getPreparedStatement().executeUpdate();
			
			connection.preparation(inserirMercadoria);
			connection.getPreparedStatement().setString(1, mauditada.getTipo());
			connection.getPreparedStatement().setString(2, mauditada.getDescricao());
			connection.getPreparedStatement().setString(3, mauditada.getUnPeso());
			connection.getPreparedStatement().setFloat(4, mauditada.getPeso());
			connection.getPreparedStatement().setBoolean(5, mauditada.getAuditada());
			connection.getPreparedStatement().setString(6, mauditada.getDatainspencao());
			connection.getPreparedStatement().setString(7, mauditada.getNomeorgao());
			connection.getPreparedStatement().executeUpdate();
			JOptionPane.showMessageDialog(null, "Cadastro Realizado com Sucesso !!!");
		} catch (DbException e ) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
	
	public ArrayList<MAuditada> queryMeradoriaAuditada() {
        ResultSet rs = null;
        ArrayList<MAuditada> mauditadas = new ArrayList<MAuditada>();
        try {
            rs = connection.getStatement().executeQuery(selecionarMercadoria);
            while (rs.next()) {
            	MAuditada mauditada = new MAuditada(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getFloat(5), rs.getBoolean(6), rs.getString(7), rs.getString(8));
            	mauditada.setIdMercadoria(rs.getInt("idMercadoria"));
            	mauditada.setTipo(rs.getString("tipo"));
            	mauditada.setDescricao(rs.getString("descricao"));
            	mauditada.setUnPeso(rs.getString("unPeso"));
            	mauditada.setPeso(rs.getFloat("peso"));
            	mauditada.setAuditada(rs.getBoolean("auditada"));
            	mauditada.setDatainspencao(rs.getString("datainspencao"));
            	mauditada.setNomeorgao(rs.getString("nomeorgao"));
            	mauditadas.add(mauditada);
            	}
            } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            }
        return mauditadas;
    }

}
