package com.ifp.utilidades;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 
 * @author Víctor Henry Fall Turrientes
 * @version 1.0.0
 *
 */

public class Conexion {

	/**
	 * 
	 * Declaramos los siguientes atributos: 
	 * <ul>
	 * <li>URL: Introducimos la ruta en la que se encuentra nuestra base de datos.</li>
	 * <li>USER: Introducimos el nombre del usuario.</li>
	 * <li>PASS: Introducimos la contraseña de dicho usuario.</li>
	 * </ul>
	 * Todos los atributos recientemente nombrados son de tipo String.
	 * 
	 */
	
	private String url, user, pass;
	private static Connection conn = null;
	
	/**
	 * Creamos nuestro pertinente constructor vacío en el cuál daremos valor a todas las variables de la clase (url, user y pass).
	 */
	private Conexion() {
		
		super();
		
		this.url = "jdbc:mysql://localhost:3306/nba?serverTimezone=Europe/Madrid&amp";
		this.user = "root";
		this.pass = "AlumnoIFP";
		
		try {
			conn = DriverManager.getConnection(url, user, pass);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Problemas de conexión.");
		}
		
	}
	
	/**
	 * 
	 * @return Connection - Devuelve la variable conn de tipo Connection una vez se le da el nuevo valor.
	 */
	public static Connection getConnection() {
		
		if (conn == null) {
			new Conexion();
		}
		
		return conn;
	}
	
}