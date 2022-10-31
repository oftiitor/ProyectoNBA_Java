package com.ifp.DAO;

import com.ifp.modelo.Equipo;
import com.ifp.modelo.Jugador;
import com.ifp.modelo.Partido;
import com.ifp.utilidades.Logs;

public class PartidoDAOImplMySQL extends AbstractDAOImpl implements PartidoDAO {

	@Override
	public void visualizarDatos(Partido partido) {
		
		System.out.println(partido);
		EquipoDAO equipo = new EquipoDAOImplMySQL();
		System.out.println(equipo.findbyID(partido.getEquipo_local()));

	}

	@Override
	public double mediaPuntos(Equipo equipo) {
		Equipo equipos = new Equipo();
		Jugador jugadores = new Jugador();
		
		
		
		return 0;
	}

	@Override
	public double mediaAsistencias(Equipo equipo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double mediaTapones(Equipo equipo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double mediaRebotes(Equipo equipo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double mediaPuntosLocal(Partido partido) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double mediaPuntosVisitante(Partido partido) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double porcentajeVictorias(Partido partido) {
		// TODO Auto-generated method stub
		return 0;
	}

}
