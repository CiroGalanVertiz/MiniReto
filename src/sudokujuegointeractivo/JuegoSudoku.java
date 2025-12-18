/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sudokujuegointeractivo;

import java.util.Random;

/**
 *
 * @author Ana
 */
public class JuegoSudoku {
    private final int TAMANIO = 9;// Tamaño del tablero
    private final int PISTAS = 40;// Número de pistas visibles
    // Tablero del jugador
    private int[][] tablero = new int[this.TAMANIO][this.TAMANIO];
    // Celdas que son editables
    private boolean[][] editable = new boolean[this.TAMANIO][this.TAMANIO];
    private Random random = new Random();
    // Generamos el sudoku completo y colocamos las pistas iniciales
    public void generarSudoku() {
        rellenarTablero(0, 0);// Generamos un sudoku válido completo
        // Marcar todas las celdas como no editables inicialmente
        for (int i = 0; i < TAMANIO; i++) {
            for (int j = 0; j < TAMANIO; j++) {
                editable[i][j] = true;
            }
        }
        int eliminados = TAMANIO * TAMANIO - PISTAS;// Número de celdas a dejar vacías
        while (eliminados > 0) {
            int fila = random.nextInt(TAMANIO);
            int columna = random.nextInt(TAMANIO);
            if (tablero[fila][columna] != 0) {
                tablero[fila][columna] = 0;//Vaciamos la celda
                editable[fila][columna] = true;//Marcamos esa celda como editable
                eliminados--;
            }
        }
        // Las celdas que quedaron con número no son editables
        for (int i = 0; i < TAMANIO; i++) {
            for (int j = 0; j < TAMANIO; j++) {
                if (tablero[i][j] != 0) {
                    editable[i][j] = false;
                }
            }
        }
    }
    
    private boolean rellenarTablero(int fila, int col) {
        if (fila == TAMANIO) {//Tablero completo
            return true;
        }
        if (col == TAMANIO) {
            return rellenarTablero(fila + 1, 0);
        }
        if (tablero[fila][col] != 0) {
            return rellenarTablero(fila, col + 1);
        }

        int[] nums = generarNumerosAleatorios();
        for (int n : nums) {
            if (esValido(fila, col, n)) {
                tablero[fila][col] = n;
                if (rellenarTablero(fila, col + 1)) {
                    return true;
                }
                tablero[fila][col] = 0;
            }
        }
        return false;
    }
    // Método para generar números del 1 al 9 aleatorios
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
    // Comprobamos si el número se puede colocar en la celda
    private boolean esValido(int fila, int col, int num) {
        for (int i = 0; i < TAMANIO; i++) {
            if (tablero[fila][i] == num || tablero[i][col] == num) {
                return false;
            }
        }
        // Comprobamos en la cuadrícula
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
    // Comprobamos que el número de puede ingresar en la celda editable
    public boolean ingresarNumero(int fila, int col, int num) {
        if (!editable[fila][col]) {// No se puede ingresar el número porque la celda no es editable
            return false;
        }
        if (num < 1 || num > 9) {// Número fuera de rango
            return false;
        }
        if (!esValido(fila, col, num)) {// Número no es válido según las reglas
            return false;
        }
        tablero[fila][col] = num;// Ingresamos el número
        return true;
    }
    // Comprobamos que el sudoku está completo
    public boolean estaCompleto() {
        for (int i = 0; i < TAMANIO; i++) {
            for (int j = 0; j < TAMANIO; j++) {
                if (tablero[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }
    // Imprimimos el tablero
    public void imprimirTablero() {
        System.out.println("+-------+-------+-------+");
        for (int i = 0; i < TAMANIO; i++) {
            System.out.print("| ");
            for (int j = 0; j < TAMANIO; j++) {
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
