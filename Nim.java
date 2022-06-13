package Ejercicio004;

import java.util.Scanner;

public class Nim {
	

	public static void main(String[] args) {
		int a = 3, b = 4, c = 5; // pila A, pila B, pila C
		Controlador controlador = new Controlador();
		Scanner scan = new Scanner(System.in);
		String nombre;
		String opcion;
		int cantidad;
		
		// pregunta los nombre de los jugadores.
		System.out.print("Jugado 1, ingrese su nombre: " );
		nombre = scan.next();
		controlador.addJugador(nombre);
		
		System.out.print("Jugado 2, ingrese su nombre: " );
		nombre = scan.next();
		controlador.addJugador(nombre);
		
		// inicio del juego
		while(true) {
			
			System.out.printf("\nA: %d\tB: %d\tC: %d\n\n", a, b, c);
			
			nombre = controlador.turnoActual();
			
			if(a + b + c == 0) { // pregunta si aun existe contenedores.
				System.out.printf("%s, ya no queda contadores, asi que... Ganaste!\n", nombre);
				return;
			}
			
			System.out.printf("%s , elija una pila: ", nombre);
			opcion = scan.next();//.charAt(0);
			opcion = opcion.toUpperCase();
			
			System.out.printf("Cuantos quitara de la pila %s: ", opcion);
			cantidad = scan.nextInt();
			
			switch(opcion) {
			case "A":
				if( !(cantidad > 0 && cantidad <= a) ) {
					System.out.println("Cantidad introducida invalida.");
					controlador.repetirTurno(); // para que en la siguiente iteracion sea nuevamente el turno del jugador actual.
					break;
				}
				a -= cantidad;
				break;
			case "B":
				if( !(cantidad > 0 && cantidad <= b) ) {
					System.out.println("Cantidad introducida invalida.");
					controlador.repetirTurno(); // para que en la siguiente iteracion sea nuevamente el turno del jugador actual.
					break;
				}
				b -= cantidad;
				break;
			case "C":
				if( !(cantidad > 0 && cantidad <= c) ) {
					System.out.println("Cantidad introducida invalida.");
					controlador.repetirTurno(); // para que en la siguiente iteracion sea nuevamente el turno del jugador actual.
					break;
				}
				c -= cantidad;
				break;
			default:
				System.out.println("La opcion no es valida.");
			}
			
		}
		
	}

}
