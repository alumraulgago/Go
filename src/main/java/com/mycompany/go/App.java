package com.mycompany.go;

import java.util.Optional;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;



public class App extends Application {
    
    Stage stage;
    private Go go;
    
    @Override
    public void start(Stage stage) {
        //Creamos el panel principal:
        this.stage = stage;
        this.go = new Go();
        Tablero tablero = new Tablero(stage, go);
        
      
        
        HBox hBox = new HBox(tablero.getGridTablero());
        hBox.setAlignment(Pos.CENTER);
        
        VBox root = new VBox();
        root.getChildren().add(hBox);
        root.setAlignment(Pos.CENTER);
        Scene scene = new Scene(root, 900, 700);  
        
        
        stage.setTitle("GO");
        stage.setScene(scene);
        stage.show();
        
        
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Elección de jugador");
        alert.setHeaderText(null);
        alert.setContentText("Elija un jugador");
        
        ButtonType botonJugador1 = new ButtonType("Jugador 1");
        ButtonType botonJugador2 = new ButtonType("Jugador 2");
        ButtonType botonCancelar = new ButtonType("Cancelar", ButtonBar.ButtonData.CANCEL_CLOSE);
        
        alert.getButtonTypes().setAll(botonJugador1, botonJugador2, botonCancelar);
        
        Optional<ButtonType> result = alert.showAndWait();
        if(result.get() == botonJugador1){
            go.jugador = '1';
        } else if (result.get() == botonJugador2){
            go.jugador = '2';
        } else if (result.get() == botonCancelar){
            stage.close();
        }
    
        
    }

    public static void main(String[] args) {
        launch();
    }

}