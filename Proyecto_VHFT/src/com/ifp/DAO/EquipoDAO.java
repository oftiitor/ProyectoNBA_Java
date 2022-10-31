package com.ifp.DAO;

import java.util.List;

import com.ifp.modelo.Equipo;

/**
 * 
 * @author Víctor Henry Fall Turrientes
 * @version 1.0.0
 *
 */

public interface EquipoDAO {

	/**
	 * 
	 * @param nombreEquipo - Recibe por parámetro el nombre del equipo con el que posteriormente mostrará por pantalla toda la información del mismo.
	 * @return Equipo - Devuelve un objeto Equipo en el cuál encontraremos el nombre, la ciudad, la conferencia y la división del equipo.
	 */
	
	Equipo findbyID(String nombreEquipo);
	
	/**
	 * 
	 * @return List<Equipo> - Devuelve un listado de todos los equipos disponibles en la base de datos.
	 */
	
	List<Equipo> findAll();
	
	/**
	 * 
	 * @param eq - Recibe por parámetro un objeto de tipo Equipo y lo inserta en la base de datos.
	 * @return boolean - Devuelve true si el nuevo equipo se ha insertado correctamente o false, si por el contrario, el equipo no se ha insertado correctamente en la base de datos.
	 */
	
	boolean crearEquipo(Equipo eq);
	
	/**
	 * 
	 * @param eq - Recibe por parámetro un objeto de tipo Equipo el cual ya debe existir en la base de datos. Se actualiza el valor de la columna de división por el nuevo valor que haya introducido el usuario.
	 * @return boolean - Devuelve true si la división del equipo se ha actualizado correctamente o false, si por el contrario, la división del equipo no se ha actualizado correctamente.
	 */
	
	boolean cambioDivision(Equipo eq);
	
	/**
	 * 
	 * @param nombre - Recibe por parámetro el nombre de un equipo que seguidamente será eliminado de la base de datos.
	 * @return int - Devuelve el número 1 si el equipo se ha eliminado correctamente de la base de datos, o devuelve 0 si el equipo no se ha eliminado correctamente de la base de datos.
	 */
	
	int eliminarEquipo(String nombre);
	
}