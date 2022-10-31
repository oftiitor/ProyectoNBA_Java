package com.ifp.DAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ifp.modelo.Equipo;
import com.ifp.modelo.Estadistica;
import com.ifp.modelo.Jugador;
import com.ifp.utilidades.Logs;

/**
 * 
 * @author Víctor Henry Fall Turrientes
 * @version 1.0.0
 *
 */

public class JugadorDAOImplMySQL extends AbstractDAOImpl implements JugadorDAO {

	/**
	 * {@inheritDoc}
	 */
	
	@Override
	public Jugador findbyID(int codigo) {
		
		Jugador jugador = new Jugador();
		
		try {
						
			sql = "SELECT * FROM jugadores where codigo = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, codigo);
			
			rs = ps.executeQuery();
						
			if(rs.next()) {
				jugador.setNombre(rs.getString("nombre"));
				jugador.setProcedencia(rs.getString("procedencia"));
				jugador.setAltura(rs.getString("altura"));
				jugador.setPeso(rs.getInt("peso"));
				jugador.setPosicion(rs.getString("posicion"));
				
				String nombreEquipo = rs.getString("nombre_equipo");
				EquipoDAOImplMySQL eq = new EquipoDAOImplMySQL();
				Equipo equipo = eq.findbyID(nombreEquipo);
				jugador.setEquipo(equipo);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			Logs lg = new Logs();
			lg.EscrituraFichero(e);
		}
		
		return jugador;
		
		
	}

	/**
	 * {@inheritDoc}
	 */
	
	@Override
	public List<Jugador> findAll() {
		
		ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
		
		try {
			
			sql = "SELECT * FROM jugadores";
			ps = conn.prepareStatement(sql);	
			rs = ps.executeQuery();
			
			jugadores = new ArrayList<Jugador>();
			
			while(rs.next()) {
				
				Jugador jugador = new Jugador();
				
				jugador.setCodigo(rs.getInt("codigo"));
				jugador.setNombre(rs.getString("nombre"));
				jugador.setPeso(rs.getInt("peso"));
				jugador.setProcedencia(rs.getString("procedencia"));
				jugador.setAltura(rs.getString("altura"));
				jugador.setPosicion(rs.getString("posicion"));
				
				String nombreEquipo = rs.getString("nombre_equipo");
				EquipoDAOImplMySQL eq = new EquipoDAOImplMySQL();
				Equipo equipo = eq.findbyID(nombreEquipo);
				
				jugador.setEquipo(equipo);
								
				jugadores.add(jugador);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			Logs lg = new Logs();
			lg.EscrituraFichero(e);
		}
		
		return jugadores;
	}

	/**
	 * {@inheritDoc}
	 */
	
	@Override
	public List<Jugador> findbyTeams(String nombreEquipo) {
		
		ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
		
		try {
					
			sql = "SELECT * FROM jugadores where jugadores.Nombre_equipo = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, nombreEquipo);
			
			rs = ps.executeQuery();

			jugadores = new ArrayList<Jugador>();
			
			while(rs.next()) {
				
				Jugador jugador = new Jugador();
				
				jugador.setCodigo(rs.getInt("codigo"));
				jugador.setNombre(rs.getString("nombre"));
				jugador.setPeso(rs.getInt("peso"));
				jugador.setProcedencia(rs.getString("procedencia"));
				jugador.setAltura(rs.getString("altura"));
				jugador.setPosicion(rs.getString("posicion"));
				
				EquipoDAOImplMySQL eq = new EquipoDAOImplMySQL();
				Equipo equipo = eq.findbyID(nombreEquipo);
				
				jugador.setEquipo(equipo);
								
				jugadores.add(jugador);
				
			}

		} catch (SQLException e) {
			e.printStackTrace();
			Logs lg = new Logs();
			lg.EscrituraFichero(e);
		}
		
		return jugadores;
	}

	/**
	 * {@inheritDoc}
	 */
	
	@Override
	public boolean crearJugador(Jugador j) {
		
		boolean resultado = false;
		
		try {
					
			sql = "INSERT INTO Jugadores values (?, ?, ?, ?, ?, ?, ?)";
			ps = conn.prepareStatement(sql);	
			
			ps.setInt(1, j.getCodigo());
			ps.setString(2, j.getNombre());
			ps.setString(3, j.getProcedencia());
			ps.setString(4, j.getAltura());
			ps.setInt(5, j.getPeso());
			ps.setString(6, j.getPosicion());
			ps.setString(7, j.getEquipo().getNombre());
			
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
	public boolean ficharJugador(Jugador j) {
		
		boolean resultado = false;
		int filas = 0;
		
		try {
			
			sql = "UPDATE Jugadores set nombre_equipo = ? where codigo = ?";
			ps = conn.prepareStatement(sql);	
			
			ps.setString(1, j.getEquipo().getNombre());
			ps.setInt(2, j.getCodigo());
			
			filas = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			Logs lg = new Logs();
			lg.EscrituraFichero(e);
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
	public boolean pruebasFisicasJugador(Jugador j) {
		
		boolean resultado = false;
		int filas = 0;
				
		try {
			
			sql = "UPDATE Jugadores set peso = ? where codigo = ?";
			ps = conn.prepareStatement(sql);	
			
			ps.setInt(1, j.getPeso());
			ps.setInt(2, j.getCodigo());
			
			filas = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			Logs lg = new Logs();
			lg.EscrituraFichero(e);
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
	public int retirarJugador(int codigo) {

		int filas = 0;
			
			try {
				
				sql = "set foreign_key_checks = 0";
				ps = conn.prepareStatement(sql);
				ps.executeUpdate();
				
				sql = "DELETE FROM Jugadores WHERE codigo = ?";
				ps = conn.prepareStatement(sql);
				ps.setInt(1, codigo);
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
			filas = 1;
		
		return filas;
	}

}
