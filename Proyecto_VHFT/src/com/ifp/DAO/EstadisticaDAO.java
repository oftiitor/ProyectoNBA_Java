package com.ifp.DAO;

import java.util.List;

import com.ifp.modelo.Estadistica;
import com.ifp.modelo.Jugador;

/**
 * 
 * @author Víctor Henry Fall Turrientes
 * @version 1.0.0
 *
 */

public interface EstadisticaDAO {

	/**
	 * 
	 * @param codigoJugador - Recibe por parámetro el código de un jugador del que posteriormente mostrará por pantalla todas las estadísticas de dicho jugador.
	 * @return List<Estadistica> - Devuelve un listado de todas las estadísticas disponibles para el jugador recibido por parámetro.
	 */
	
	List<Estadistica> findbyID(int codigoJugador);
	
	/**
	 * 
	 * @param pais - Recibe por parámetro un país cualquiera del que se obtendrán y se mostrarán todos los jugadores de ese mismo país.
	 * @return List<Estadistica> - Devuelve un listado de todas las estadísticas del país introducido por parámetro.
	 */
	
	List<Estadistica> findbyCountry(String pais); 
	
	/**
	 * 
	 * @param nombre - Recibe por parámetro el nombre de un equipo y devuelve todas las estadísticas disponibles para dicho equipo.
	 * @return List<Estadistica> - Devuelve un listado de todas las estadísticas del equipo que se ha introducido por parámetro.
	 */
	
	List<Estadistica> findByEquipo(String nombre);
	
	/**
	 * 
	 * @param j - Recibe por parámetro un objeto de tipo Jugador el se usará para sacar la media de puntos que realiza dicho jugador cada partido.
	 * @return double - Devuelve la media de puntos por partido del jugador introducido por parámetro.
	 */
	
	double mediaPuntosPartido(Jugador j);
	
	/**
	 * 
	 * @param j - Recibe por parámetro un objeto de tipo Jugador el se usará para sacar la media de asistencias que realiza dicho jugador cada partido.
	 * @return double - Devuelve la media de asistencias por partido del jugador introducido por parámetro.
	 */
	
	double mediaAsistencias(Jugador j);
	
	/**
	 * 
	 * @param j - Recibe por parámetro un objeto de tipo Jugador el se usará para sacar la media de tapones que realiza dicho jugador cada partido.
	 * @return double - Devuelve la media de tapones por partido del jugador introducido por parámetro.
	 */
	
	double mediaTapones(Jugador j);
	
	/**
	 * 
	 * @param j - Recibe por parámetro un objeto de tipo Jugador el se usará para sacar la media de rebotes que realiza dicho jugador cada partido.
	 * @return double - Devuelve la media de rebotes por partido del jugador introducido por parámetro.
	 */
	
	double mediaRebotes(Jugador j);
	
}