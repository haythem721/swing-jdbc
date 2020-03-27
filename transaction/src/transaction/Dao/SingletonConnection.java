package transaction.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SingletonConnection {
	
	private static Connection connection;
	
	private SingletonConnection()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost/banque","root","");
			System.out.println("connexion établie");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getInstance()
	{
		if(connection==null) new SingletonConnection();
		return connection;
	}

}
