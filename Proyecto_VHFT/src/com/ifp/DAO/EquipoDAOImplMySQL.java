package com.ifp.DAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.ifp.modelo.Equipo;
import com.ifp.modelo.Jugador;
import com.ifp.utilidades.Logs;

/**
 * 
 * @author Víctor Henry Fall Turrientes
 * @version 1.0.0
 *
 */

public class EquipoDAOImplMySQL extends AbstractDAOImpl implements EquipoDAO {

	/**
	 * Creamos el pertinente constructor vacío de la clase EquipoDAOImplMySQL donde se implementarán todos los métodos de la clase EquipoDAO.
	 */
	
	public EquipoDAOImplMySQL() {
		super();
	}
	
	/**
	 * {@inheritDoc}
	 */
	
	@Override
	public Equipo findbyID(String equipo) {
		
		Equipo nombreEquipo = new Equipo();
		
		try {
						
			sql = "SELECT * FROM equipos where nombre = ?";
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, equipo);
			
			rs = ps.executeQuery();
						
			if(rs.next()) {
				nombreEquipo.setNombre(rs.getString("nombre"));
				nombreEquipo.setCiudad(rs.getString("ciudad"));
				nombreEquipo.setConferencia(rs.getString("conferencia"));
				nombreEquipo.setDivision(rs.getString("division"));
			}
						
		} catch (SQLException e) {
			e.printStackTrace();
			Logs lg = new Logs();
			lg.EscrituraFichero(e);
		}
		
		return nombreEquipo;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Equipo> findAll() {
		/* Devuelvo un ArrayList de equipos */
		
		ArrayList<Equipo> equipos = new ArrayList<Equipo>();
		
		try {
			
			sql = "SELECT * FROM equipos";
			ps = conn.prepareStatement(sql);	
			rs = ps.executeQuery();
			
			equipos = new ArrayList<Equipo>();
			
			while(rs.next()) {
				
				Equipo equipo = new Equipo();
				
				equipo.setNombre(rs.getString("nombre"));
				equipo.setCiudad(rs.getString("ciudad"));
				equipo.setConferencia(rs.getString("conferencia"));
				equipo.setDivision(rs.getString("division"));
				
				equipos.add(equipo);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			Logs lg = new Logs();
			lg.EscrituraFichero(e);
		}
		
		return equipos;
		
	}

	/**
	 * {@inheritDoc}
	 */
	
	@Override
	public boolean crearEquipo(Equipo eq) {

		boolean resultado = false;
		
		try {
					
			sql = "INSERT INTO Equipos values (?, ?, ?, ?)";
			ps = conn.prepareStatement(sql);	
			
			ps.setString(1, eq.getNombre());
			ps.setString(2, eq.getCiudad());
			ps.setString(3, eq.getConferencia());
			ps.setString(4, eq.getDivision());
			
			resultado = ps.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
			Logs lg = new Logs();
			lg.EscrituraFichero(e);
		}
		
		return resultado;
		
	}

	/**
	 * {@inheritDoc}
	 */
	
	@Override
	public boolean cambioDivision(Equipo eq) {
		
		boolean resultado = false;
		int filas = 0;
		Equipo equipo = findbyID(eq.getNombre());
		
		if (equipo != null && !eq.getDivision().equals(equipo.getDivision()) && eq.getCiudad().equals(equipo.getCiudad()) && eq.getConferencia().equals(equipo.getConferencia())) {
			sql = "UPDATE Equipos set division = ? where nombre = ?";
			
			try {
				ps = conn.prepareStatement(sql);
				ps.setString(1, eq.getDivision());
				ps.setString(2, eq.getNombre());
				
				filas = ps.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
				Logs lg = new Logs();
				lg.EscrituraFichero(e);
			}
			
		}
		
		if (filas > 0) {
			resultado = true;
		}
		
		return resultado;
		
	}

	/**
	 * {@inheritDoc}
	 */
	
	@Override
	public int eliminarEquipo(String nombre) {
		
		int filas = 0;
					
			try {
				
				sql = "set foreign_key_checks = 0";
				ps = conn.prepareStatement(sql);
				ps.executeUpdate();
				
				sql = "DELETE FROM Equipos WHERE nombre = ?";
				ps = conn.prepareStatement(sql);
				ps.setString(1, nombre);
				filas = ps.executeUpdate();
				
				sql = "set foreign_key_checks = 1";
				ps = conn.prepareStatement(sql);
				ps.executeUpdate();
			
				filas = 1;
				
			} catch (SQLException e) {
				e.printStackTrace();
				Logs lg = new Logs();
				lg.EscrituraFichero(e);
			}
		
		return filas;
		
	}
	
}