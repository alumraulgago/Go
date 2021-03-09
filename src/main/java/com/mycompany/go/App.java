package com.mycompany.go;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;



public class App extends Application {

    @Override
    public void start(Stage stage) {
        //Creamos el panel principal:
        Tablero tablero = new Tablero();
        
        HBox hBox = new HBox(tablero.getGridTablero());
        hBox.setAlignment(Pos.CENTER);
        
        VBox root = new VBox();
        root.getChildren().add(hBox);
        root.setAlignment(Pos.CENTER);
        Scene scene = new Scene(root, 900, 700);  
        
        stage.setTitle("GO");
        stage.setScene(scene);
        stage.show();
        
        
      
    }

    public static void main(String[] args) {
        launch();
    }

}