package com.mycompany.pasianssi;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;


public class MainApp extends Application {

    Scene aloitusScene;
    Scene peliScene;
    Scene voittoScene;
    Scene havioScene;
    Kortit kortit;
    
    @Override
    public void init() {
        
    }
    
    public void start(Stage ikkuna) throws Exception {
        kortit = new Kortit();
        
//        Pelinäkymä
        VBox sisalto = new VBox(20);
        sisalto.setPadding(new Insets(40));
        
        HBox ylaTeksti = new HBox(20);
        ylaTeksti.setPadding(new Insets(20));
        Label korttiTeksti = new Label("Kortteja jäljellä:");
        Label korttejaJaljella = new Label("52");
        ylaTeksti.getChildren().addAll(korttiTeksti, korttejaJaljella);
        
        HBox vierekkaisetKortit = new HBox(50);
        ImageView pakka = new ImageView(new Image(getClass().getResourceAsStream("/PNG/pakka.png")));   
        pakka.setFitHeight(300);
        pakka.setPreserveRatio(true);
        ImageView kortti = kortit.nostaKortti(); 
        kortti.setFitHeight(300);
        kortti.setPreserveRatio(true);
        vierekkaisetKortit.getChildren().addAll(pakka, kortti);
        
        HBox alaTeksti = new HBox(20);
        Label jarjestysLuku = new Label("Järjestyksessä oleva luku");
        Label nro = new Label("1");
        alaTeksti.getChildren().addAll(jarjestysLuku, nro);
        
        sisalto.getChildren().addAll(ylaTeksti, vierekkaisetKortit, alaTeksti);
        peliScene = new Scene(sisalto, 600, 500);
        
     
//        voittoScene



//        havioScene



//      Alkunäkymä
        BorderPane main = new BorderPane();
        main.setPadding(new Insets(40));
        VBox aloitus = new VBox(20);
        aloitus.setPadding(new Insets(20));
        Label pelinNimi = new Label("Pasianssi");
        Button aloitaNappi = new Button("Aloita peli");              
        Label syotaLuku = new Label("Syöta luku 1-13");
        TextField input = new TextField("");
        Text ohjeet = new Text("ohjeet");        
        
        aloitaNappi.setOnAction(e -> {
            int luku = Integer.valueOf(input.getText());
            ikkuna.setScene(peliScene);
        });
        
        aloitus.getChildren().addAll(pelinNimi, syotaLuku, input, aloitaNappi);
        main.setCenter(aloitus);
        main.setBottom(ohjeet);
        aloitusScene = new Scene(main, 600, 500);
        
        
        ikkuna.setTitle("Pasianssi");
        ikkuna.setScene(aloitusScene);
        ikkuna.show();
    }        
    
    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
