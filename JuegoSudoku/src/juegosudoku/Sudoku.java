/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juegosudoku;

import java.util.Random;

/**
 *
 * @author Ana
 */
public class Sudoku {
    private final int TAM = 9; // Tamaño del tablero 9x9
    private final int PISTAS = 40;// Número de pistas visibles
    private int[][] tablero = new int[TAM][TAM]; // Tablero del jugador
    private boolean[][] editable = new boolean[TAM][TAM];// Celdas editables
    private Random random = new Random();
    // Genera un Sudoku completo y coloca pistas iniciales

    public void generarSudoku() {
        rellenarTablero(0, 0); // Genera un Sudoku válido completo
        // Marcar todas las celdas inicialmente como editables
        for (int i = 0; i < TAM; i++) {
            for (int j = 0; j < TAM; j++) {
                editable[i][j] = true;
            }
        }
        int eliminados = TAM * TAM - PISTAS; // Número de celdas a dejar vacías
        while (eliminados > 0) {
            int f = random.nextInt(TAM);
            int c = random.nextInt(TAM);
            if (tablero[f][c] != 0) {
                tablero[f][c] = 0; // Vaciar la celda
                editable[f][c] = true; // Marcar como editable
                eliminados--;
            }
        }
        // Las celdas que quedaron con número no son editables
        for (int i = 0; i < TAM; i++) {
            for (int j = 0; j < TAM; j++) {
                if (tablero[i][j] != 0) {
                    editable[i][j] = false;
                }
            }
        }
    }

    // Método recursivo para rellenar el tablero usando backtracking
    private boolean rellenarTablero(int fila, int col) {
        if (fila == TAM) {
            return true; // Tablero completo
        }
        if (col == TAM) {
            return rellenarTablero(fila + 1, 0); // Pasar a siguiente fila
        }
        if (tablero[fila][col] != 0) {
            return rellenarTablero(fila, col + 1); // Saltar celda ya ocupada
        }
        int[] nums = generarNumerosAleatorios(); // Números del 1 al 9 en orden aleatorio
        for (int n : nums) {
            if (esValido(fila, col, n)) {
                tablero[fila][col] = n;
                if (rellenarTablero(fila, col + 1)) {
                    return true;
                }
                tablero[fila][col] = 0; // Backtracking
            }
        }
        return false;
    }
    // Genera un arreglo con números del 1 al 9 aleatorios
    private int[] generarNumerosAleatorios() {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        for (int i = 0; i < nums.length; i++) {
            int j = random.nextInt(nums.length);
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        return nums;
    }
    // Verifica si un número se puede colocar en la celda (fila, col)
    private boolean esValido(int fila, int col, int num) {
        // Verificar fila y columna
        for (int i = 0; i < TAM; i++) {
            if (tablero[fila][i] == num || tablero[i][col] == num) {
                return false;
            }
        }
        // Verificar subcuadro 3x3
        int inicioFila = (fila / 3) * 3;
        int inicioCol = (col / 3) * 3;
        for (int i = inicioFila; i < inicioFila + 3; i++) {
            for (int j = inicioCol; j < inicioCol + 3; j++) {
                if (tablero[i][j] == num) {
                    return false;
                }
            }
        }
        return true;
    }
    // Intentar ingresar un número en una celda editable
    public boolean ingresarNumero(int fila, int col, int num) {
        if (!editable[fila][col]) {
            return false; // No se puede sobrescribir pista
        }
        if (num < 1 || num > 9) {
            return false; // Número fuera de rango
        }
        if (!esValido(fila, col, num)) {
            return false; // Número inválido según reglas
        }
        tablero[fila][col] = num; // Colocar número
        return true;
    }
    // Verifica si el Sudoku está completo
    public boolean estaCompleto() {
        for (int i = 0; i < TAM; i++) {
            for (int j = 0; j < TAM; j++) {
                if (tablero[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }
    // Imprime el tablero en consola en formato ASCII
    public void imprimirTablero() {
        System.out.println("+-------+-------+-------+");
        for (int i = 0; i < TAM; i++) {
            System.out.print("| ");
            for (int j = 0; j < TAM; j++) {
                System.out.print((tablero[i][j] == 0 ? "." : tablero[i][j]) + " ");
                if ((j + 1) % 3 == 0) {
                    System.out.print("| ");
                }
            }
            System.out.println();
            if ((i + 1) % 3 == 0) {
                System.out.println("+-------+-------+-------+");
            }
        }
    }   
}