package com.mycompany.go;


import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;


public final class Tablero {
    private final GridPane gridTablero = new GridPane();
    private Go go;
    
    private final double TAM_CASILLA = 35;
    private final double TAM_FICHA = 30;
    
    public Tablero(){
        this.nuevaPartida();
    }
    
    public GridPane getGridTablero(){
        return gridTablero;
    }
    
    public void nuevaPartida() {
        this.go = new Go();
        this.mostrarCuadrado();
    }
    
    public void mostrarCuadrado() {
        for(int y=0; y<19; y++) {
            for(int x=0; x<19; x++){
                crearCasilla(x, y);
            }
        }
    }
    
    private void crearCasilla(int x, int y) {
        Rectangle casilla = new Rectangle(TAM_CASILLA, TAM_CASILLA, Color.GRAY);
        casilla.setStroke(Color.BLACK); // Línea divisoria de las casillas
        gridTablero.add(casilla, x, y);
        casilla.setOnMouseClicked((MouseEvent mouseEvent) -> {
            clicCasilla(x, y);
        });
    }
    
    private void clicCasilla(int x, int y) {
        this.crearFicha(x, y);
        go.matrizTablero[x][y] = go.jugador;
        go.mostrarTablero();
        System.out.print(go.matrizTablero[x][y] + " ");
        System.out.println("Casilla: " + x + "," + y);
        go.cambiarJugador();
    }
    
    private void crearFicha(int x, int y) {
        Circle circle = new Circle(TAM_FICHA / 2);
        GridPane.setHalignment(circle, HPos.CENTER);
        GridPane.setValignment(circle, VPos.CENTER);
        int jugador = go.getJugadorJugando();
        //char jugador = go.getJugadorEnCadaCasilla(x, y);
        switch(jugador) {
             case Go.JUGADOR_1:
                circle.setFill(Color.BLACK);
                break;
            case Go.JUGADOR_2:
                circle.setFill(Color.WHITE);
                break;
        }
        gridTablero.add(circle, x, y); 
    }
}

