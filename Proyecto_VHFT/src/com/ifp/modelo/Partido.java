package com.ifp.modelo;

/**
 * 
 * @author Víctor Henry Fall Turrientes
 * @version 1.0.0
 *
 */

public class Partido {

	/**
	 * Declaramos las variables privadas que tendrán todos los partidos de la base de datos.
	 */
	
	private int codigo, puntos_local, puntos_visitante;
	private String equipo_local, equipo_visitante, temporada;
	
	/**
	 * 
	 */
	public Partido() {
		super();
	}

	/**
	 * 
	 * @param equipo_local - Recibe por parámetro el equipo local.
	 * @param equipo_visitante - Recibe por parámetro el equipo visitante.
	 */
	public Partido(String equipo_local, String equipo_visitante) {
		super();
		this.equipo_local = equipo_local;
		this.equipo_visitante = equipo_visitante;
	}

	/**
	 * 
	 * @param codigo - Recibe por parámetro el código del partido.
	 * @param equipo_local - Recibe por parámetro el equipo local del partido.
	 * @param equipo_visitante - Recibe por parámetro el equipo visitante del partido.
	 * @param puntos_local - Recibe por parámetro los puntos del equipo local.
	 * @param puntos_visitante - Recibe por parámetro los puntos del equipo visitante.
	 * @param temporada - Recibe por parámetro la temporada del partido.
	 */
	public Partido(int codigo, String equipo_local, String equipo_visitante, int puntos_local, int puntos_visitante, String temporada) {
		super();
		this.codigo = codigo;
		this.puntos_local = puntos_local;
		this.puntos_visitante = puntos_visitante;
		this.equipo_local = equipo_local;
		this.equipo_visitante = equipo_visitante;
		this.temporada = temporada;
	}

	/**
	 * 
	 * @return int 
	 */
	public int getCodigo() {
		return codigo;
	}

	/**
	 * 
	 * @param codigo
	 */
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	/**
	 * 
	 * @return int
	 */
	public int getPuntos_local() {
		return puntos_local;
	}

	/**
	 * 
	 * @param puntos_local
	 */
	public void setPuntos_local(int puntos_local) {
		this.puntos_local = puntos_local;
	}

	/**
	 * 
	 * @return int
	 */
	public int getPuntos_visitante() {
		return puntos_visitante;
	}

	/**
	 * 
	 * @param puntos_visitante
	 */
	public void setPuntos_visitante(int puntos_visitante) {
		this.puntos_visitante = puntos_visitante;
	}

	/**
	 * 
	 * @return String
	 */
	public String getEquipo_local() {
		return equipo_local;
	}

	/**
	 * 
	 * @param equipo_local
	 */
	public void setEquipo_local(String equipo_local) {
		this.equipo_local = equipo_local;
	}

	/**
	 * 
	 * @return String
	 */
	public String getEquipo_visitante() {
		return equipo_visitante;
	}

	/**
	 * 
	 * @param equipo_visitante
	 */
	public void setEquipo_visitante(String equipo_visitante) {
		this.equipo_visitante = equipo_visitante;
	}

	/**
	 * 
	 * @return String
	 */
	public String getTemporada() {
		return temporada;
	}

	/**
	 * 
	 * @param temporada
	 */
	public void setTemporada(String temporada) {
		this.temporada = temporada;
	}

	/**
	 * El método ToString sirve para mostrar por pantalla los datos que previamente se hayan introducido / modificado en la clase.
	 */
	@Override
	public String toString() {
		return "Partido:\n · Código: " + codigo + "\n · Equipo Local: " + equipo_local + "\n\t - Puntos equipo local: " + puntos_local + "\n · Equipo Visitante: " + equipo_visitante +  "\n\t - Puntos equipo visitante: " + puntos_visitante +  "\n · Temporada: " + temporada + "\n";
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
		result = prime * result + codigo;
		result = prime * result + ((equipo_local == null) ? 0 : equipo_local.hashCode());
		result = prime * result + ((equipo_visitante == null) ? 0 : equipo_visitante.hashCode());
		result = prime * result + puntos_local;
		result = prime * result + puntos_visitante;
		result = prime * result + ((temporada == null) ? 0 : temporada.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Partido))
			return false;
		Partido other = (Partido) obj;
		if (codigo != other.codigo)
			return false;
		if (equipo_local == null) {
			if (other.equipo_local != null)
				return false;
		} else if (!equipo_local.equals(other.equipo_local))
			return false;
		if (equipo_visitante == null) {
			if (other.equipo_visitante != null)
				return false;
		} else if (!equipo_visitante.equals(other.equipo_visitante))
			return false;
		if (puntos_local != other.puntos_local)
			return false;
		if (puntos_visitante != other.puntos_visitante)
			return false;
		if (temporada == null) {
			if (other.temporada != null)
				return false;
		} else if (!temporada.equals(other.temporada))
			return false;
		return true;
	}
	
}