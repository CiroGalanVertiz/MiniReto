/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package juegosudoku;

import java.util.Scanner;

/**
 *
 * @author Ana
 */
public class JuegoSudoku {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Sudoku juego = new Sudoku();
        juego.generarSudoku();
        Scanner teclado = new Scanner(System.in);

        boolean salir = false;
        
        while (!salir) {
            System.out.println("\n=== MENÚ DE SUDOKU ===");
            System.out.println("1. Mostrar tablero");
            System.out.println("2. Ingresar número");
            System.out.println("3. Salir");
            System.out.print("Elige una opción: ");
            int opcion = teclado.nextInt();

            switch (opcion) {
                case 1:
                    //Mostramos el tablero actual
                    juego.imprimirTablero();
                    break;

                case 2:
                    System.out.print("Fila (1-9): ");
                    int fila = teclado.nextInt();
                    System.out.print("Columna (1-9): ");
                    int col = teclado.nextInt();
                    System.out.print("Número (1-9): ");
                    int num = teclado.nextInt();

                    if (!juego.ingresarNumero(fila - 1, col - 1, num)) {
                        System.out.println("Movimiento inválido");
                    } else {
                        System.out.println("Número ingresado correctamente");
                    }
                    // Comprobamos que el Sudoku está completo
                    if (juego.estaCompleto()) {
                        System.out.println("¡Felicidades! Sudoku completado");
                        salir = true;
                    }
                    break;

                case 3:
                    salir = true;
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }
        }

        teclado.close();

    }

  
}
