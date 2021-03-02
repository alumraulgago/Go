package com.mycompany.go;


public class Go {
    private final char[][] matrizTablero = new char[19][19];
    public char jugador = '1';
    
    public static final int JUGADOR_1 = '1';
    public static final int JUGADOR_2 = '2';
    public static final int NO_JUGADOR = '0';
    
    public void Go() {
        for(int y=0; y<19; y++) {
            for(int x=0; x<19; x++) {
                matrizTablero[x][y] = NO_JUGADOR;
            }
        }
        this.mostrarTablero();
    }
    
    public char getJugadorEnCadaCasilla(int x, int y) {
        return matrizTablero[x][y];
    }
    
    public char getJugadorJugando() {
        return jugador;
    }
    
    //Mostramos nuestro tablero por consola
    public void mostrarTablero() {
        System.out.println("Tablero: ");
        for(int y=0; y<19; y++) {
            for(int x=0; x<19; x++) {
                System.out.print(matrizTablero[x][y] + " ");
            }
            System.out.println();
        }
    }
    
//    public void ponerFicha() {
//        matrizTablero[x][y] = JUGADOR_1;
//    }
    
    public char cambiarJugador() {
        System.out.println("Jugador jugando: " + jugador);
        if(jugador == JUGADOR_1) {
            jugador = JUGADOR_2;
        } else {
            jugador = JUGADOR_1;
        }
        return jugador;
    }
}
