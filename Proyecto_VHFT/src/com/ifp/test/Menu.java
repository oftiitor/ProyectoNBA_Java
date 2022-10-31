 package com.ifp.test;

import java.util.ArrayList;
import java.util.Scanner;

import com.ifp.DAO.EquipoDAO;
import com.ifp.DAO.EquipoDAOImplMySQL;
import com.ifp.DAO.EstadisticaDAO;
import com.ifp.DAO.EstadisticaDAOImplMySQL;
import com.ifp.DAO.JugadorDAO;
import com.ifp.DAO.JugadorDAOImplMySQL;
import com.ifp.DAO.PartidoDAO;
import com.ifp.DAO.PartidoDAOImplMySQL;
import com.ifp.modelo.Equipo;
import com.ifp.modelo.Jugador;

/**
 * 
 * @author Víctor Henry Fall Turrientes
 * @version 1.0.0
 *
 */

public class Menu {

	static Teclado tc = new Teclado();
	static Scanner sc = new Scanner (System.in);
	static boolean salir;
	static EquipoDAO equipo = new EquipoDAOImplMySQL();
	static JugadorDAO jugador = new JugadorDAOImplMySQL();
	static EstadisticaDAO estadistica = new EstadisticaDAOImplMySQL();
	static PartidoDAO partido = new PartidoDAOImplMySQL();
	
		public int Menu() {
		
		System.out.println("·········· MENÚ PRINCIPAL ··········");
		System.out.println("| 1. Información de Equipos.       |");
		System.out.println("| 2. Información de Jugadores.     |");
		System.out.println("| 3. Información de Estadísticas.  |");
		System.out.println("| 4. Información de Partidos.      |");
		System.out.println("····································");
		System.out.println();
		System.out.println("Elija una de las 4 anteriores opciones:");
		
		int opc = tc.numerosEnteros();
		return opc;
		
	}

	public void switchMenu() {
		
		do {
		
			int opc = Menu();
			
			switch (opc) {
			
				case 1:
					
					System.out.println("Seleccione una de las siguientes opciones:");
					System.out.println();
					System.out.println("1. Buscar un equipo.");
					System.out.println("2. Listar todos los equipos disponibles.");
					System.out.println("3. Añadir un nuevo equipo.");
					System.out.println("4. Cambiar de división uno de los equipos disponibles.");
					System.out.println("5. Eliminar un equipo.");
					System.out.println();
					System.out.println("Elija una de las 5 opciones anteriores:");
					
					int opcEquipo = tc.numerosEnteros();
					
					switch (opcEquipo) {
						
						case 1:
							System.out.println("Introduzca el nombre del equipo que desea buscar:");
							String equipoBuscado = sc.nextLine();
							System.out.println(equipo.findbyID(equipoBuscado));
						break;
						
						case 2:
							ArrayList<Equipo> equipos = (ArrayList<Equipo>) equipo.findAll();
							
							for (Equipo eq : equipos) {
								System.out.println(eq);
							}
							
						break;
							
						case 3:
							System.out.println("Introduzca el nombre del nuevo equipo:");
							String nombreEquipo = sc.nextLine();
							System.out.println("Introduzca la ciudad del equipo:");
							String ciudadEquipo = sc.nextLine();
							System.out.println("Introduzca la conferencia del equipo:");
							String conferenciaEquipo = sc.nextLine();
							System.out.println("Introduzca la división del equipo:");
							String divisionEquipo = sc.nextLine();
							equipo.crearEquipo(new Equipo(nombreEquipo, ciudadEquipo, conferenciaEquipo, divisionEquipo));
						break;
						
						case 4:
							System.out.println("Seleccione el equipo al que desea cambiar la división:");
							String equipoCambioDivision = sc.nextLine();
							System.out.println("Seleccione la nueva división del equipo:");
							String nuevaDivision = sc.nextLine();
							
							Equipo equipo2 = null;
							equipo2 = new Equipo(equipoCambioDivision, equipo2.getCiudad(), equipo2.getConferencia(), nuevaDivision);
							equipo.cambioDivision(equipo2);
						break;
						
						case 5:
							System.out.println("Seleccione el equipo que desea eliminar:");
							String equipoEliminado = sc.nextLine();
							equipo.eliminarEquipo(equipoEliminado);
						break;
		
						default:
							System.out.println("La opción seleccionada no corresponde con ninguna opción válida.");
						break;
						
					}
					
				break;
				
				case 2:
					
					System.out.println("Seleccione una de las siguientes opciones:");
					System.out.println();
					System.out.println("1. Buscar un jugador.");
					System.out.println("2. Listar todos los jugadores disponibles.");
					System.out.println("3. Listar todos los jugadores de un equipo en concreto.");
					System.out.println("4. Añadir un nuevo jugador.");
					System.out.println("5. Cambiar de equipo a un jugador.");
					System.out.println("6. Cambiar el peso de un jugador.");
					System.out.println("7. Eliminar a un jugador.");
					System.out.println();
					System.out.println("Elija una de las 7 opciones anteriores:");
					
					int opcJugador = tc.numerosEnteros();
					
					switch (opcJugador) {
						
						case 1:
							System.out.println("Introduzca el código del jugador que desea buscar:");
							int jugadorBuscado = sc.nextInt();
							System.out.println(jugador.findbyID(jugadorBuscado));
						break;
						
						case 2:
							ArrayList<Jugador> jugadores = (ArrayList<Jugador>) jugador.findAll();
							
							for (Jugador jug : jugadores) {
								System.out.println(jug);
							}
							
						break;
							
						case 3:
							System.out.println("Introduzca el nombre del equipo:");
							String nombreEquipo = sc.nextLine();
							System.out.println(jugador.findbyTeams(nombreEquipo));
						break;
						
						case 4:
							System.out.println("Introduzca el nombre del nuevo jugador:");
							String nombreNuevoJugador = sc.nextLine();
							System.out.println("Introduzca la procedencia del jugador:");
							String procedenciaJugador = sc.nextLine();
							System.out.println("Introduzca la altura del jugador:");
							String alturaJugador = sc.nextLine();
							System.out.println("Introduzca el peso del jugador:");
							int pesoJugador = sc.nextInt();
							System.out.println("Introduzca la posición del jugador:");
							String posicionJugador = sc.nextLine();
							System.out.println("Introduzca el equipo del jugador:");
							String equipoJugador = sc.nextLine();
							
							Equipo eq = new Equipo();
							int contador = 613;
							jugador.crearJugador(new Jugador(contador + 1, pesoJugador, nombreNuevoJugador, procedenciaJugador, alturaJugador, posicionJugador, new Equipo(equipoJugador, eq.getCiudad(), eq.getConferencia(), eq.getDivision())));
							
						break;
						
						case 5:
							System.out.println("Introduzca el nombre del jugador:");
							String nombreJugador = sc.nextLine();
							System.out.println("Introduzca el nuevo equipo del jugador:");
							String nuevoEquipo = sc.nextLine();
							
							Equipo eq2 = new Equipo();
							Jugador ju = new Jugador();
							jugador.ficharJugador(new Jugador(ju.getCodigo(), ju.getPeso(), nombreJugador, ju.getProcedencia(), ju.getAltura(), ju.getPosicion(), new Equipo(nuevoEquipo, eq2.getCiudad(), eq2.getConferencia(), eq2.getDivision())));
						break;
						
						case 6:
							System.out.println("Introduzca el nombre del jugador:");
							String nombreJugador2 = sc.nextLine();
							System.out.println("Introduzca el nuevo peso del jugador:");
							int nuevoPeso = sc.nextInt();
							
							Equipo eq3 = new Equipo();
							Jugador ju2 = new Jugador();
							jugador.pruebasFisicasJugador(new Jugador(ju2.getCodigo(), nuevoPeso, nombreJugador2, ju2.getProcedencia(), ju2.getAltura(), ju2.getPosicion(), new Equipo(eq3.getNombre(), eq3.getCiudad(), eq3.getConferencia(), eq3.getDivision())));
						break;
						
						case 7:
							System.out.println("Seleccione el código del jugador que desea eliminar:");
							int jugadorEliminado = sc.nextInt();
							jugador.retirarJugador(jugadorEliminado);
						break;
		
						default:
							System.out.println("La opción seleccionada no corresponde con ninguna opción válida.");
						break;
						
					}
					
				break;
				
				case 3:
					
					System.out.println("Seleccione una de las siguientes opciones:");
					System.out.println();
					System.out.println("1. Mostrar las estadísticas de un jugador.");
					System.out.println("2. Listar las estadísticas de todos los jugadores de un mismo país.");
					System.out.println("3. Listar las estadísticas de todos los jugadores de un mismo equipo.");
					System.out.println("4. Mostrar la media de puntos por partido de un jugador.");
					System.out.println("5. Mostrar la media de asistencias por partido de un jugador.");
					System.out.println("6. Mostrar la media de tapones por partido de un jugador.");
					System.out.println("7. Mostrar la media de rebotes por partido de un jugador.");
					System.out.println();
					System.out.println("Elija una de las 7 opciones anteriores:");
					
					int opcEstadisticas = tc.numerosEnteros();
					
					switch (opcEstadisticas) {
						
						case 1:
							System.out.println("Seleccione el código del jugador del que desea saber sus estadísticas:");
							int codigoJugador = sc.nextInt();
							System.out.println(estadistica.findbyID(codigoJugador));
						break;
						
						case 2:
							System.out.println("Seleccione el país del que desea saber sus estadísticas:");
							String paisEstadisticas = sc.nextLine();
							System.out.println(estadistica.findbyCountry(paisEstadisticas));
						break;
							
						case 3:
							System.out.println("Seleccione el equipo del que desea saber sus estadísticas:");
							String equipoEstadisticas = sc.nextLine();
							System.out.println(estadistica.findByEquipo(equipoEstadisticas));
						break;
						
						case 4:
							System.out.println("Seleccione el jugador del que desea saber la media de puntos por partido:");
							String nombreJugadorMediaPPP = sc.nextLine();
							Jugador ju3 = new Jugador();
							Equipo eq4 = new Equipo();
							System.out.println(estadistica.mediaPuntosPartido(new Jugador(ju3.getCodigo(), ju3.getPeso(), nombreJugadorMediaPPP, ju3.getProcedencia(), ju3.getAltura(), ju3.getPosicion(), new Equipo(eq4.getNombre(), eq4.getCiudad(), eq4.getConferencia(), eq4.getDivision()))));							
						break;
						
						case 5:
							System.out.println("Seleccione el jugador del que desea saber la media de asistencias por partido:");
							String nombreJugadorMediaAPP = sc.nextLine();
							Jugador ju4 = new Jugador();
							Equipo eq5 = new Equipo();
							System.out.println(estadistica.mediaAsistencias(new Jugador(ju4.getCodigo(), ju4.getPeso(), nombreJugadorMediaAPP, ju4.getProcedencia(), ju4.getAltura(), ju4.getPosicion(), new Equipo(eq5.getNombre(), eq5.getCiudad(), eq5.getConferencia(), eq5.getDivision()))));			
						break;
						
						case 6:
							System.out.println("Seleccione el jugador del que desea saber la media de tapones por partido:");
							String nombreJugadorMediaTPP = sc.nextLine();
							Jugador ju5 = new Jugador();
							Equipo eq6 = new Equipo();
							System.out.println(estadistica.mediaTapones(new Jugador(ju5.getCodigo(), ju5.getPeso(), nombreJugadorMediaTPP, ju5.getProcedencia(), ju5.getAltura(), ju5.getPosicion(), new Equipo(eq6.getNombre(), eq6.getCiudad(), eq6.getConferencia(), eq6.getDivision()))));
						break;
						
						case 7:
							System.out.println("Seleccione el jugador del que desea saber la media de rebotes por partido:");
							String nombreJugadorMediaRPP = sc.nextLine();
							Jugador ju6 = new Jugador();
							Equipo eq7 = new Equipo();
							System.out.println(estadistica.mediaRebotes(new Jugador(ju6.getCodigo(), ju6.getPeso(), nombreJugadorMediaRPP, ju6.getProcedencia(), ju6.getAltura(), ju6.getPosicion(), new Equipo(eq7.getNombre(), eq7.getCiudad(), eq7.getConferencia(), eq7.getDivision()))));
						break;
		
						default:
							System.out.println("La opción seleccionada no corresponde con ninguna opción válida.");
						break;
						
					}
					
				break;
				
				case 4:
					
					System.out.println("Seleccione una de las siguientes opciones:");
					System.out.println();
					System.out.println("1. Visualizar datos del partido.");
					System.out.println("2. Mostrar media de puntos.");
					System.out.println("3. Mostrar media de asistencias.");
					System.out.println("4. Mostrar media de tapones.");
					System.out.println("5. Mostrar media de rebotes.");
					System.out.println("6. Mostrar media de puntos del equipo local.");
					System.out.println("7. Mostrar media de puntos del equipo visitante.");
					System.out.println("8. Mostrar el porcentaje de victorias.");
					System.out.println();
					System.out.println("Elija una de las 8 opciones anteriores:");
					
					int opcPartido = tc.numerosEnteros();
					
					switch (opcPartido) {
						
						case 1:
							
						break;
						
						case 2:
							
						break;
							
						case 3:
							
						break;
						
						case 4:
							
						break;
						
						case 5:
							
						break;
						
						case 6:
							
						break;
						
						case 7:
							
						break;
						
						case 8:
							
						break;
		
						default:
							System.out.println("La opción seleccionada no corresponde con ninguna opción válida.");
						break;
						
					}
					
				break;
		
				default:
					System.out.println("La opción seleccionada no corresponde con ninguna opción válida.");
				break;
			
				}
			
		} while (!salir);
	}
}