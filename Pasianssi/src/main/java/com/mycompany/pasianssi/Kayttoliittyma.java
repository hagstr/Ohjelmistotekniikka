
package com.mycompany.pasianssi;

import java.awt.Image;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Kayttoliittyma extends Application{
    Scene aloitusScene;
    Scene peliScene;
    Scene voittoScene;
    Scene havioScene;
    
    public void start(Stage ikkuna) {
//        Pelinäkymä
        VBox sisalto = new VBox(20);
        sisalto.setPadding(new Insets(20));
        
        HBox ylaTeksti = new HBox(20);
        ylaTeksti.setPadding(new Insets(20));
        Label korttiTeksti = new Label("Kortteja jäljellä:");
        TextField korttejaJaljella = new TextField();
        ylaTeksti.getChildren().addAll(korttiTeksti, korttejaJaljella);
        
        HBox kortit = new HBox(50);
        Image pakka = new Image();
        Image kortti = new Image();
        
        sisalto.getChildren().addAll(ylaTeksti);
        
        peliScene = new Scene(300, 250);
        
        voittoScene = new Scene(300, 250);
        
        havioScene = new Scene(300, 250);

//      Alkunäkymä
        BorderPane main = new BorderPane();
        VBox aloitus = new VBox(20);
        aloitus.setPadding(new Insets(20));
        Button aloitaNappi = new Button("Aloita peli");              
        Label syotaLuku = new Label("Syöta luku 1-13");
        TextField input = new TextField("");
        
        aloitaNappi.setOnAction(e -> {
            int luku = Integer.valueOf(input.getText());
            ikkuna.setScene(peliScene);
        });
        
        aloitus.getChildren().addAll(aloitaNappi, syotaLuku, input);
        main.setCenter(aloitus);
        aloitusScene = new Scene(main, 300, 250);
        
        
        ikkuna.setTitle("Pasianssi");
        ikkuna.setScene(aloitusScene);
        ikkuna.show();
    }        
    
    
    
    public static void main(String[] args) {
        launch(args);
    }
}
