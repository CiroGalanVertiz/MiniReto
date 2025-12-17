/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package juego2;

/**
 *
 * @author dam103
 */
public class Juego2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        GeneradorSudoku generador = new GeneradorSudoku();

        Sudoku sudoku = generador.generar(40); // Cambia dificultad aquí

        System.out.println("🎯 Sudoku generado automáticamente:");
        sudoku.mostrar();
    }
}

  