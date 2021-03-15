package com.mycompany.go;



import java.util.Optional;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


public final class Tablero {
    private final GridPane gridTablero = new GridPane();
    private Go go;
    Stage stage;
    
    private final double TAM_CASILLA = 35;
    private final double TAM_FICHA = 30;
    
    public Tablero(){
        this.nuevaPartida();
    }
    
    public GridPane getGridTablero(){
        return gridTablero;
   
   
    }
    
    public void nuevaPartida() {
        this.eleccionJugador();
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
    
    private void eleccionJugador(){
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Elección de jugador");
        alert.setHeaderText(null);
        alert.setContentText("Elija un jugador");
        
        ButtonType botonJugador1 = new ButtonType("Jugador 1");
        ButtonType botonJugador2 = new ButtonType("Jugador 2");
        ButtonType botonCancelar = new ButtonType("Cancelar", ButtonData.CANCEL_CLOSE);
        
        alert.getButtonTypes().setAll(botonJugador1, botonJugador2, botonCancelar);
        
        Optional<ButtonType> result = alert.showAndWait();
        if(result.get() == botonJugador1){
                
        } else if (result.get() == botonJugador2){
            
        } else if (result.get() == botonCancelar){
            stage.close();
        } 
    }
    
}