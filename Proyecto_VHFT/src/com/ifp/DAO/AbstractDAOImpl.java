package com.ifp.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.ifp.utilidades.Conexion;

/**
 * 
 * @author Víctor Henry Fall Turrientes
 * @version 1.0.0
 *
 */

public abstract class AbstractDAOImpl {

	/**
	 * 
	 * Declaramos los atributos de tipo Connection, PreparedStatement, ResultSet y String. 
	 * Dichos atributos serán utilizados posteriormente en todas nuestras clases de implementación de MySQL (EquipoDAOImplMySQL, JugadorDAOImplMySQL, EstadisticaDAOImplMySQL, PartidoDAOImplMySQL).
	 * 
	 */
	
	protected Connection conn;
	protected PreparedStatement ps;
	protected ResultSet rs;
	protected String sql;
	
	/**
	 * 
	 * Creamos el pertinente constructor de la clase en el cual le daremos valor a nuestra variable conn.
	 * El valor que recibe dicha variable va en base a nuestra clase "Conexion.java" en la cual establecemos conexión con nuestra base de datos.
	 * 
	 */
	
	protected AbstractDAOImpl() {
		conn = Conexion.getConnection();
	}
	
}