package com.ifp.modelo;

import java.util.ArrayList;

/**
 * 
 * @author Víctor Henry Fall Turrientes
 * @version 1.0.0
 *
 */

public class Jugador {

	/**
	 * Declaramos las variables privadas que tendrán todos los jugadores de la base de datos.
	 * Y, a parte, un ArrayList de estadísticas donde se almacenarán todas las estadísticas de cada jugador.
	 */
	
	private int codigo, peso;
	private String nombre, procedencia, altura, posicion;
	private Equipo equipo;
	private ArrayList<Estadistica> estadisticas;
	
	/**
	 * Creamos el pertinente constructor vacío.
	 */
	
	public Jugador() {
		super();
	}

	/**
	 * 
	 * @param codigo - Recibe por parámetro el código de un jugador y le da dicho valor a la variable "codigo" de la clase.
	 * @param peso - Recibe por parámetro el peso de un jugador y le da dicho valor a la variable "peso" de la clase.
	 * @param nombre - Recibe por parámetro el nombre de un jugador y le da dicho valor a la variable "nombre" de la clase.
	 * @param procedencia - Recibe por parámetro la procedencia de un jugador y le da dicho valor a la variable "procedencia" de la clase.
	 * @param altura - Recibe por parámetro la altura de un jugador y le da dicho valor a la variable "altura" de la clase.
	 * @param posicion - Recibe por parámetro la posición de un jugador y le da dicho valor a la variable "posicion" de la clase.
	 * @param equipo - Recibe por parámetro el equipo de un jugador y le da dicho valor a la variable "equipo" de la clase.
	 */
	
	public Jugador(int codigo, int peso, String nombre, String procedencia, String altura, String posicion, Equipo equipo) {
		super();
		this.codigo = codigo;
		this.peso = peso;
		this.nombre = nombre;
		this.procedencia = procedencia;
		this.altura = altura;
		this.posicion = posicion;
		this.equipo = equipo;
	}

	/**
	 * 
	 * @return int - Devuelve la variable que almacena el código del jugador.
	 */
	
	public int getCodigo() {
		return codigo;
	}

	/**
	 * 
	 * @param codigo - Recibe por parámetro el código de un jugador y le cambia el valor de la variable global por el nuevo valor introducido.
	 */
	
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	/**
	 * 
	 * @return int - Devuelve la variable que almacena el peso del jugador.
	 */
	
	public int getPeso() {
		return peso;
	}

	/**
	 * 
	 * @param peso - Recibe por parámetro el peso de un jugador y le cambia el valor de la variable global por el nuevo valor introducido.
	 */
	
	public void setPeso(int peso) {
		this.peso = peso;
	}

	/**
	 * 
	 * @return String - Devuelve la variable que almacena el nombre del jugador.
	 */
	
	public String getNombre() {
		return nombre;
	}

	/**
	 * 
	 * @param nombre - Recibe por parámetro el nombre de un jugador y le cambia el valor de la variable global por el nuevo valor introducido.
	 */
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * 
	 * @return String - Devuelve la variable que almacena la procedencia del jugador.
	 */
	
	public String getProcedencia() {
		return procedencia;
	}

	/**
	 * 
	 * @param procedencia - Recibe por parámetro la procedencia de un jugador y le cambia el valor de la variable global por el nuevo valor introducido.
	 */
	
	public void setProcedencia(String procedencia) {
		this.procedencia = procedencia;
	}

	/**
	 * 
	 * @return String - Devuelve la variable que almacena la altura del jugador.
	 */
	
	public String getAltura() {
		return altura;
	}

	/**
	 * 
	 * @param altura - Recibe por parámetro la altura de un jugador y le cambia el valor de la variable global por el nuevo valor introducido.
	 */
	
	public void setAltura(String altura) {
		this.altura = altura;
	}

	/**
	 * 
	 * @return String - Devuelve la variable que almacena la posición del jugador.
	 */
	
	public String getPosicion() {
		return posicion;
	}

	/**
	 * 
	 * @param posicion - Recibe por parámetro la posición de un jugador y le cambia el valor de la variable global por el nuevo valor introducido.
	 */
	
	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}

	/**
	 * 
	 * @return Equipo - Devuelve la variable que almacena el nombre del equipo.
	 */
	
	public Equipo getEquipo() {
		return equipo;
	}

	/**
	 * 
	 * @param equipo - Recibe por parámetro un objeto de tipo Equipoy le cambia el valor de la variable global por el nuevo valor introducido.
	 */
	
	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}

	/**
	 * 
	 * @return ArrayList<Estadistica> - Devuelve un listado de las estadísticas de cada jugador.
	 */
	
	public ArrayList<Estadistica> getEstadisticas() {
		return estadisticas;
	}

	/**
	 * 
	 * @param estadisticas - Recibe por parámetro un listado de todas las estadísticas de cada jugador y le cambia el valor de la variable global por el nuevo valor introducido.
	 */
	
	public void setEstadisticas(ArrayList<Estadistica> estadisticas) {
		this.estadisticas = estadisticas;
	}
	
	/**
	 * El método ToString sirve para mostrar por pantalla los datos que previamente se hayan introducido / modificado en la clase.
	 */
	@Override
	public String toString() {
		return "Jugador:\n · Código: " + codigo + "\n · Nombre: " + nombre + "\n · Peso: " + peso + "\n · Procedencia: " + procedencia + "\n · Altura: " + altura + "\n · Posición: " + posicion + "\n\nEquipo: \n" + equipo + "\n*******************************\n\n";
	}

	/**
	 * Los métodos HashCode y Equals sirven para comparar objetos más fácil y rápidamente en estructuras Hash. 
	 * Cuando se comparan dos objetos en estructuras de tipo hash primero se invoca al método hashcode el cuál si devuelve diferente hash no seguirá comparando puesto que los objetos serán distintos.
	 * Pero, en el caso que los objetos compartan el mismo hashcode, pasará a realizar el método equals el cuál revisará al detalle si se cumple la igualdad.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((altura == null) ? 0 : altura.hashCode());
		result = prime * result + codigo;
		result = prime * result + ((equipo == null) ? 0 : equipo.hashCode());
		result = prime * result + ((estadisticas == null) ? 0 : estadisticas.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + peso;
		result = prime * result + ((posicion == null) ? 0 : posicion.hashCode());
		result = prime * result + ((procedencia == null) ? 0 : procedencia.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Jugador))
			return false;
		Jugador other = (Jugador) obj;
		if (altura == null) {
			if (other.altura != null)
				return false;
		} else if (!altura.equals(other.altura))
			return false;
		if (codigo != other.codigo)
			return false;
		if (equipo == null) {
			if (other.equipo != null)
				return false;
		} else if (!equipo.equals(other.equipo))
			return false;
		if (estadisticas == null) {
			if (other.estadisticas != null)
				return false;
		} else if (!estadisticas.equals(other.estadisticas))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (peso != other.peso)
			return false;
		if (posicion == null) {
			if (other.posicion != null)
				return false;
		} else if (!posicion.equals(other.posicion))
			return false;
		if (procedencia == null) {
			if (other.procedencia != null)
				return false;
		} else if (!procedencia.equals(other.procedencia))
			return false;
		return true;
	}
	
	
	
}