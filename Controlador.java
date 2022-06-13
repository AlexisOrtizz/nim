package Ejercicio004;

import java.util.ArrayList;


public class Controlador {
	
	public class Jugador {
		private String nombre;
		
		public Jugador(String nombre) {
			this.nombre = nombre;
		}
		
		public String getNombre() {
			return nombre;
		}
		
	}
	
	private ArrayList<Jugador> jugadores;
	private int turnoJugador;
	
	public Controlador() {
		jugadores = new ArrayList<Jugador>();
		turnoJugador = 0;
	}
	
	public int getLongitud() {
		/* cantidad de jugadores */
		return jugadores.size();
	}
	
	public void addJugador(String nombre) {
		/* agrega un nuevo jugador */
		jugadores.add(new Jugador(nombre));
	}
	
	public String turnoActual() {
		/* retorna el nombre del jugador a quien le pertene el turno */
		String nombre;
		
		if(turnoJugador == 0) {
			turnoJugador = 1;
			nombre = jugadores.get(0).getNombre();
		} else {
			nombre = jugadores.get(turnoJugador-1).getNombre();
		}
		
		turnoJugador++;
		
		if(turnoJugador > getLongitud()) { // forma circular los turnos
			turnoJugador = 1;
		}
		
		return nombre;
	}
	
	public void repetirTurno() {
		/* repite el turno del jugador anterior en caso de que haya un error */
		turnoJugador--;
		
		if(turnoJugador < 1) { // en caso de que el actual sea el primero.
			turnoJugador = getLongitud();
		}
	}
	
	
}