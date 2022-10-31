package com.ifp.DAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ifp.modelo.Estadistica;
import com.ifp.modelo.Jugador;
import com.ifp.utilidades.Logs;

/**
 * 
 * @author Víctor Henry Fall Turrientes
 * @version 1.0.0
 *
 */

public class EstadisticaDAOImplMySQL extends AbstractDAOImpl implements EstadisticaDAO {

	/**
	 * {@inheritDoc}
	 */
	
	@Override
	public List<Estadistica> findbyID(int codigoJugador) {
		
		ArrayList<Estadistica> estadisticas = new ArrayList<Estadistica>();
		
		try {
						
			sql = "SELECT * FROM Estadisticas where jugador = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, codigoJugador);;
			
			rs = ps.executeQuery();
		
			while(rs.next()) {
				
				Estadistica estadistica = new Estadistica();
				
				estadistica.setTemporada(rs.getString("temporada"));
				estadistica.setJugador(rs.getInt("jugador"));
				estadistica.setPuntos_por_partido(rs.getDouble("puntos_por_partido"));
				estadistica.setAsistencias_por_partido(rs.getDouble("asistencias_por_partido"));
				estadistica.setTapones_por_partido(rs.getDouble("tapones_por_partido"));
				estadistica.setRebotes_por_partido(rs.getDouble("rebotes_por_partido"));
				
				estadisticas.add(estadistica);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			Logs lg = new Logs();
			lg.EscrituraFichero(e);
		}
		
		return estadisticas;
	}

	/**
	 * {@inheritDoc}
	 */
	
	@Override
	public List<Estadistica> findbyCountry(String pais) {

		ArrayList<Estadistica> estadisticas = new ArrayList<Estadistica>();
		
		try {
						
			sql = "SELECT * FROM estadisticas, jugadores where jugador in (select codigo from jugadores, estadisticas where procedencia = ? and jugadores.codigo = estadisticas.jugador) and jugadores.codigo = estadisticas.jugador";
			ps = conn.prepareStatement(sql);
			ps.setString(1, pais);;
			
			rs = ps.executeQuery();
		
			while(rs.next()) {
				
				Estadistica estadistica = new Estadistica();
				
				estadistica.setTemporada(rs.getString("temporada"));
				estadistica.setJugador(rs.getInt("jugador"));
				estadistica.setPuntos_por_partido(rs.getDouble("puntos_por_partido"));
				estadistica.setAsistencias_por_partido(rs.getDouble("asistencias_por_partido"));
				estadistica.setTapones_por_partido(rs.getDouble("tapones_por_partido"));
				estadistica.setRebotes_por_partido(rs.getDouble("rebotes_por_partido"));
				
				estadisticas.add(estadistica);
				
			}
			
			} catch (SQLException e) {
				e.printStackTrace();
				Logs lg = new Logs();
				lg.EscrituraFichero(e);
			}
			
			return estadisticas;
	}

	/**
	 * {@inheritDoc}
	 */
	
	@Override
	public List<Estadistica> findByEquipo(String nombreEquipo) {
		
		ArrayList<Estadistica> estadisticas = new ArrayList<Estadistica>();
		
		try {
						
			sql = "SELECT estadisticas.* FROM estadisticas, jugadores where jugadores.codigo = estadisticas.jugador and jugadores.Nombre_equipo = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, nombreEquipo);;
			
			rs = ps.executeQuery();
		
			while(rs.next()) {
				
				Estadistica estadistica = new Estadistica();
				
				estadistica.setTemporada(rs.getString("temporada"));
				estadistica.setJugador(rs.getInt("jugador"));
				estadistica.setPuntos_por_partido(rs.getDouble("puntos_por_partido"));
				estadistica.setAsistencias_por_partido(rs.getDouble("asistencias_por_partido"));
				estadistica.setTapones_por_partido(rs.getDouble("tapones_por_partido"));
				estadistica.setRebotes_por_partido(rs.getDouble("rebotes_por_partido"));
				
				estadisticas.add(estadistica);
				
			}
			
			} catch (SQLException e) {
				e.printStackTrace();
				Logs lg = new Logs();
				lg.EscrituraFichero(e);
			}
			
			return estadisticas;
	}

	/**
	 * {@inheritDoc}
	 */
	
	@Override
	public double mediaPuntosPartido(Jugador j) {
		
		double resultado = 0;
		
		try {
			
			sql = "select round(avg(puntos_por_partido), 3) as MediaPuntos from estadisticas where jugador = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, j.getCodigo());;
			
			rs = ps.executeQuery();
			
			if (rs.next()) {
				resultado = rs.getDouble("MediaPuntos");
			}
			
		} catch (Exception e) {
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
	public double mediaAsistencias(Jugador j) {
		
		double resultado = 0;
		
		try {
			
			sql = "select round(avg(asistencias_por_partido), 3) as MediaAsistencias from estadisticas where jugador = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, j.getCodigo());;
			
			rs = ps.executeQuery();
			
			if (rs.next()) {
				resultado = rs.getDouble("MediaAsistencias");
			}
			
		} catch (Exception e) {
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
	public double mediaTapones(Jugador j) {
		
		double resultado = 0;
		
		try {
			
			sql = "select round(avg(tapones_por_partido), 3) as MediaTapones from estadisticas where jugador = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, j.getCodigo());;
			
			rs = ps.executeQuery();
			
			if (rs.next()) {
				resultado = rs.getDouble("MediaTapones");
			}
			
		} catch (Exception e) {
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
	public double mediaRebotes(Jugador j) {
		
		double resultado = 0;
		
		try {
			
			sql = "select round(avg(rebotes_por_partido), 3) as MediaRebotes from estadisticas where jugador = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, j.getCodigo());;
			
			rs = ps.executeQuery();
			
			if (rs.next()) {
				resultado = rs.getDouble("MediaRebotes");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			Logs lg = new Logs();
			lg.EscrituraFichero(e);
		}
		
		return resultado;
	}
	
}