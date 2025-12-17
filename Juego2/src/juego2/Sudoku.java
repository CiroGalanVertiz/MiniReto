/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juego2;

import java.util.Random;

/**
 *
 * @author dam103
 */
public class Sudoku {
    private int[][] tablero;
    public static final int TAM = 9;

    public Sudoku() {
        tablero = new int[TAM][TAM];
    }

    public int[][] getTablero() {
        return tablero;
    }

    public boolean esValido(int fila, int col, int num) {
        for (int i = 0; i < TAM; i++) {
            if (tablero[fila][i] == num || tablero[i][col] == num)
                return false;
        }

        int f = (fila / 3) * 3;
        int c = (col / 3) * 3;

        for (int i = f; i < f + 3; i++)
            for (int j = c; j < c + 3; j++)
                if (tablero[i][j] == num)
                    return false;

        return true;
    }

    public boolean resolver(int fila, int col) {
        if (fila == TAM) return true;

        int sigFila = (col == TAM - 1) ? fila + 1 : fila;
        int sigCol = (col + 1) % TAM;

        if (tablero[fila][col] != 0)
            return resolver(sigFila, sigCol);

        int[] nums = mezclarNumeros();

        for (int num : nums) {
            if (esValido(fila, col, num)) {
                tablero[fila][col] = num;
                if (resolver(sigFila, sigCol))
                    return true;
                tablero[fila][col] = 0;
            }
        }
        return false;
    }

    private int[] mezclarNumeros() {
        int[] nums = {1,2,3,4,5,6,7,8,9};
        Random rand = new Random();
        for (int i = 0; i < nums.length; i++) {
            int j = rand.nextInt(nums.length);
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
        return nums;
    }

    public void eliminarNumeros(int cantidad) {
        Random rand = new Random();
        while (cantidad > 0) {
            int f = rand.nextInt(TAM);
            int c = rand.nextInt(TAM);
            if (tablero[f][c] != 0) {
                tablero[f][c] = 0;
                cantidad--;
            }
        }
    }

    public void mostrar() {
        System.out.println("\n+-------+-------+-------+");
        for (int i = 0; i < TAM; i++) {
            System.out.print("| ");
            for (int j = 0; j < TAM; j++) {
                System.out.print(tablero[i][j] == 0 ? ". " : tablero[i][j] + " ");
                if ((j + 1) % 3 == 0) System.out.print("| ");
            }
            System.out.println();
            if ((i + 1) % 3 == 0)
                System.out.println("+-------+-------+-------+");
        }
    }
}

    
