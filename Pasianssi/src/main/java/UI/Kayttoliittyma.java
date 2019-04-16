package UI;

import com.mycompany.pasianssi.Sovelluslogiikka;
import Pakka.Kortit;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
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
import javax.swing.Icon;
import javax.swing.JButton;


public class Kayttoliittyma extends Application {
    
    Sovelluslogiikka peli;
    Scene aloitusScene;
    Scene peliScene;
    Scene voittoScene;
    Scene havioScene;
    Kortit kortit;   
    Stage ikkuna = new Stage();
    int luku;    
    Label nro;
    TextField input;
    Label korttejaJaljella;
    

    public Kayttoliittyma() {
        peli = new Sovelluslogiikka();      
        kortit = peli.getPakka();    
    }        
    
    public void start(Stage ikkuna) throws Exception {        
        
//        Pelinäkymä
        VBox sisalto = new VBox(20);
        sisalto.setPadding(new Insets(40));
        
        HBox ylaTeksti = new HBox(20);
        ylaTeksti.setPadding(new Insets(20));
        Label korttiTeksti = new Label("Kortteja jäljellä:");
        korttejaJaljella = new Label(kortit.getKortit().size()-1+"");
        ylaTeksti.getChildren().addAll(korttiTeksti, korttejaJaljella);
        
        HBox vierekkaisetKortit = new HBox(50);
        Button pakkaNappi = new Button();
        ImageView pakka = new ImageView(new Image(getClass().getResourceAsStream("/PNG/pakka.png")));   
        pakka.setFitHeight(300);
        pakka.setPreserveRatio(true);
        pakkaNappi.setGraphic(pakka);
        Image kortinKuva = new Image(getClass().getResourceAsStream(kortit.nostaKortti()));
        ImageView kortti = new ImageView(kortinKuva); 
        kortti.setFitHeight(300);
        kortti.setPreserveRatio(true);
        vierekkaisetKortit.getChildren().addAll(pakkaNappi, kortti);
        
        pakkaNappi.setOnAction(e -> {
            if(kortit.onkoKorttejaJaljella()) {                
                peli.paivitaLuku();
                nro.setText(peli.getLuku()+"");
                String tiedosto = kortit.nostaKortti();
                korttejaJaljella.setText(kortit.getKortit().size()+"");
                Image uusiKortti = new Image(getClass().getResourceAsStream(tiedosto));
                kortti.setImage(uusiKortti);   
                
                if(tiedosto.matches("/PNG/" + peli.getLuku() + "H" + ".png") ||
                        tiedosto.matches("/PNG/" + peli.getLuku() + "D" + ".png") ||
                        tiedosto.matches("/PNG/" + peli.getLuku() + "C" + ".png") ||
                        tiedosto.matches("/PNG/" + peli.getLuku() + "S" + ".png")) {
                    nollaa();
                    ikkuna.setScene(havioScene);
                }
                
            } else {
                nollaa();
                ikkuna.setScene(voittoScene);
            }
        });
        
        HBox alaTeksti = new HBox(20);
        Label jarjestysLuku = new Label("Järjestyksessä oleva luku: ");
        nro = new Label(peli.getLuku()+"");
        alaTeksti.getChildren().addAll(jarjestysLuku, nro);
        
        sisalto.getChildren().addAll(ylaTeksti, vierekkaisetKortit, alaTeksti);
        peliScene = new Scene(sisalto, 800, 600);
        
     
//        voittoScene
        VBox voittoTekstit = new VBox();
        voittoTekstit.setPadding(new Insets(40));
        voittoTekstit.setAlignment(Pos.CENTER);        
        Label voittoTeksti = new Label("Onneksi olkoon, voitit pelin!");
        Button uusiPeli = new Button("Uusi peli");
        
        uusiPeli.setOnAction(e -> {
            ikkuna.setScene(aloitusScene);
        });
        
        voittoTekstit.getChildren().addAll(voittoTeksti, uusiPeli);
        voittoScene = new Scene(voittoTekstit, 800, 600);


//        havioScene
        VBox havioTekstit = new VBox();
        havioTekstit.setPadding(new Insets(40));
        havioTekstit.setAlignment(Pos.CENTER);
        Label havioTeksti = new Label("Hävisit pelin");       //Lisää toiminto joka ilmoittaa montako korttia oli jäljellä
        havioTekstit.getChildren().addAll(havioTeksti, uusiPeli);
        havioScene = new Scene(havioTekstit, 800, 600);

//      Alkunäkymä
        BorderPane main = new BorderPane();
        main.setPadding(new Insets(40));
        VBox aloitus = new VBox(20);
        aloitus.setPadding(new Insets(20));
        Label pelinNimi = new Label("Pasianssi");
        Button aloitaNappi = new Button("Aloita peli");              
        Label syotaLuku = new Label("Syöta luku 1-13");
        input = new TextField("");
        Text ohjeet = new Text("ohjeet");        
        
        aloitaNappi.setOnAction(e -> {
            luku = Integer.valueOf(input.getText());
            peli.setArvo(luku);            
            ikkuna.setScene(peliScene);
        });
                
        
        aloitus.getChildren().addAll(pelinNimi, syotaLuku, input, aloitaNappi);
        main.setCenter(aloitus);
        main.setBottom(ohjeet);
        aloitusScene = new Scene(main, 800, 600);
        
        
        ikkuna.setTitle("Pasianssi");
        ikkuna.setScene(aloitusScene);
        ikkuna.show();
    }        
    
    public void nollaa() {
        input.setText("");
        peli.lukuYkkoseksi();
        nro.setText(peli.getLuku()+"");
        kortit.uusiPakka();
        korttejaJaljella.setText(kortit.getKortit().size()-1+"");
    }
    
    
    public static void main(String[] args) {
        launch(args);
    }

}
