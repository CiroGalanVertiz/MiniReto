/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juego2;

/**
 *
 * @author dam103
 */
public class GeneradorSudoku {
    private Sudoku sudoku;

    public GeneradorSudoku() {
        sudoku = new Sudoku();
    }

    public Sudoku generar(int dificultad) {
        sudoku.resolver(0, 0);

        // dificultad: 30 fácil, 40 medio, 50 difícil
        sudoku.eliminarNumeros(dificultad);

        return sudoku;
    }
}

    

