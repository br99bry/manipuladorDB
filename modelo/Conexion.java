
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
     public Conexion(){};
     
        /**
         * Este metodo se escarga de intentar una conexion a una base de datos en un servidor
         * @return devuelve la conexion
         */
	public static Connection init() {
		Connection con = null;
		String host="remotemysql.com:3306";
                String bd="pKjDbUYxIt";
		String password = "5myj9ywNvK";
		String usuario = "pKjDbUYxIt";
		String url = "jdbc:mysql://"+host+"/"+bd+"?user=" + usuario+ "&password=" + password;
		try {
			con = DriverManager.getConnection(url);
			if (con != null) {
				System.out.println("Conectado");
			}
		} catch (SQLException e) {
			System.out.println("No se pudo conectar a la base de datos");
			e.printStackTrace();
		}
		return con;
	}
}
