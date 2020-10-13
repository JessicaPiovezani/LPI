package controller;


import java.sql.SQLException;

import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.util.ArrayList;

import BD.DbException;
import BD.MySQLConnector;
import model.Categoria;

public class CCategoria {
	
private MySQLConnector connection;
	
	public CCategoria() {
		connection = new MySQLConnector();
		connection.connectionBd();
	}
	
	final String criarTabelaCategoria2 = "CREATE TABLE IF NOT EXISTS tb_categorias (idCategoria INTEGER NOT NULL primary key AUTO_INCREMENT, categoriaName VARCHAR (80) NOT NULL);";
	final String inserirCategoria = "INSERT INTO tb_categorias (categoriaName) values (?)";
	final String selecionarCategoria = "SELECT * FROM tb_categorias";
	
	public void nova(Categoria categoria) throws SQLException {
		try {
			
			connection.preparation(criarTabelaCategoria2);
			connection.getPreparedStatement().executeUpdate();
			
			connection.preparation(inserirCategoria);
			connection.getPreparedStatement().setString(1, categoria.getCategoriaName());
			connection.getPreparedStatement().executeUpdate();
			
		} catch (DbException e ) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
	
	public ArrayList<Categoria> queryCategoria() {
        ResultSet rs = null;
        ArrayList<Categoria> categorias = new ArrayList<Categoria>();
        try {
            rs = connection.getStatement().executeQuery(selecionarCategoria);
            while (rs.next()) {
            	Categoria categoria = new Categoria(rs.getInt(1),rs.getString(2));
            	categoria.setIdCategoria(rs.getInt("idCategoria"));
            	categoria.setCategoriaName(rs.getString("categoriaName"));
            	categorias.add(categoria);
            	}
   
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return categorias;
    }

}
