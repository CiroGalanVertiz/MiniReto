/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repaso.mavenproject1;

import java.util.Scanner;

/**
 *
 * @author damloe05
 */
public class Juego {

    private Laberinto laberinto;
    private Scanner scanner;

    public Juego() {
        scanner = new Scanner(System.in);
    }

    /*public void iniciar() {
        int opcion;

        /*do {
            mostrarMenu();
            opcion = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcion) {
                case 1:
                    jugar();
                    break;
                case 2:
                    mostrarInstrucciones();
                    break;
                case 3:
                    System.out.println("Gracias por jugar 👋");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 3);
    }

    private void jugar() {
        laberinto = new Laberinto();
        laberinto.inicializar();

        while (!laberinto.verificarVictoria()) {
            laberinto.mostrar();
            System.out.print("Mover (W/A/S/D): ");
            char movimiento = scanner.nextLine().toUpperCase().charAt(0);
            laberinto.moverJugador(movimiento);
        }

        laberinto.mostrar();
        System.out.println("🎉 ¡Has llegado a la salida!");
    }

    private void mostrarMenu() {
        System.out.println("\n===== JUEGO DEL LABERINTO =====");
        System.out.println("1. Jugar");
        System.out.println("2. Instrucciones");
        System.out.println("3. Salir");
        System.out.print("Elige una opción: ");
    }

    private void mostrarInstrucciones() {
        System.out.println("\nINSTRUCCIONES:");
        System.out.println("W = Arriba");
        System.out.println("S = Abajo");
        System.out.println("A = Izquierda");
        System.out.println("D = Derecha");
        System.out.println("Llega a la salida (S) para ganar.");
    }*/
}
