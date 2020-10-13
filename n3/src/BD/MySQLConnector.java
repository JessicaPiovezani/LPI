package BD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class MySQLConnector {
	private final String url = "jdbc:mysql://localhost:3306/n3fretamento";
	private final String user = "root";
	private final String password = "";
	private Connection connection = null;
	private PreparedStatement preparedStatement = null;
	private Statement statement = null;

	public void connectionBd() {
		try {
			//System.out.println("conection db");
			connection = DriverManager.getConnection(url, user, password);
			statement = connection.createStatement();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
	
	public void teste() {
		System.out.println("testou");
	}

	public void preparation(String comando) throws SQLException {
		System.out.println("prearation db");
		preparedStatement = connection.prepareStatement(comando);
	}

	public void executesCommand(String comando) throws SQLException {
		System.out.println("execute db");
		preparation(comando);
		preparedStatement.executeUpdate();
	}

	public Connection getConnection() {
		return connection;
	}

	public PreparedStatement getPreparedStatement() {
		return preparedStatement;
	}

	public Statement getStatement() {
		return statement;
	}

}
