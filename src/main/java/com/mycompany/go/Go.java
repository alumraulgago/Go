package com.mycompany.go;




public class Go {
    public final char[][] matrizTablero = new char[19][19];
    public char jugador = '1';
    private Tablero tablero;
    
    public static final char JUGADOR_1 = '1';
    public static final char JUGADOR_2 = '2';
    public static final char NO_JUGADOR = '0';
    
    public Go() {
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
    
    public int getJugadorJugando() {
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
    
    
    public int cambiarJugador() {
        System.out.println("Ha colocado el jugador: " + jugador);
        if(jugador == JUGADOR_1) {
            jugador = JUGADOR_2;
        } else {
            jugador = JUGADOR_1;
        }
        return jugador;
    }
   

    
}
