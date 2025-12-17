/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repaso.mavenproject1;

import java.util.Random;

/**
 *
 * @author damloe05
 */
public class Laberinto {

    private char[][] mapa;
    private int filas = 7;
    private int columnas = 7;

    private int jugadorX;
    private int jugadorY;
    private int salidaX;
    private int salidaY;

    private Random random = new Random();

    public void inicializar() {
        mapa = new char[filas][columnas];

        // GENERAR LABERINTO ALEATORIO CON DOS FOR
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {

                // Bordes siempre paredes
                if (i == 0 || i == filas - 1 || j == 0 || j == columnas - 1) {
                    mapa[i][j] = '|';
                } else {
                    // Interior aleatorio (30% paredes)
                    mapa[i][j] = (random.nextInt(100) < 30) ? '|' : ' ';
                }
            }
        }

        // Posición inicial del jugador
        jugadorX = 1;
        jugadorY = 1;
        mapa[jugadorX][jugadorY] = 'J';

        // Posición aleatoria de la salida
        do {
            salidaX = random.nextInt(filas - 2) + 1;
            salidaY = random.nextInt(columnas - 2) + 1;
        } while (mapa[salidaX][salidaY] == '#' || (salidaX == jugadorX && salidaY == jugadorY));

        mapa[salidaX][salidaY] = 'S';
    }

    public void mostrar() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.print(mapa[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void moverJugador(char direccion) {
        int nuevaX = jugadorX;
        int nuevaY = jugadorY;

        switch (direccion) {
            case 'W':
                nuevaX--;
                break;
            case 'S':
                nuevaX++;
                break;
            case 'A':
                nuevaY--;
                break;
            case 'D':
                nuevaY++;
                break;
            default:
                System.out.println("Movimiento inválido.");
                return;
        }

        if (movimientoValido(nuevaX, nuevaY)) {
            mapa[jugadorX][jugadorY] = ' ';
            jugadorX = nuevaX;
            jugadorY = nuevaY;
            mapa[jugadorX][jugadorY] = 'J';
        }
    }

    private boolean movimientoValido(int x, int y) {
        return mapa[x][y] != '#';
    }

    public boolean verificarVictoria() {
        return jugadorX == salidaX && jugadorY == salidaY;
    }
}
