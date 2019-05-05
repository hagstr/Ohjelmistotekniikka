package pasianssi.ui;

import pasianssi.domain.Sovelluslogiikka;
import pasianssi.domain.Kortit;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class Kayttoliittyma extends Application {
    
    Sovelluslogiikka peli;
    Scene aloitusScene;
    Scene peliScene;
    Scene voittoScene;
    Scene havioScene;
    Scene ohjeScene;
    Kortit kortit;       
    int luku;    
    Text nro;
    TextField input;
    Text korttejaJaljella;
    Image uusiKortti;
    ImageView nostettuKortti;
    ImageView kopio = new ImageView();    
    Text cardsLeft = new Text();
    Text havioTeksti = new Text();
    

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
        Text korttiTeksti = new Text("Kortteja jäljellä:");
        korttiTeksti.setFont(Font.font("Times New Roman", 30));
        korttejaJaljella = new Text(kortit.getKortit().size()+"");
        korttejaJaljella.setFont(Font.font("Times New Roman", FontWeight.BOLD, 30));
        korttejaJaljella.setFill(Color.RED);
        ylaTeksti.getChildren().addAll(korttiTeksti, korttejaJaljella);
        ylaTeksti.setAlignment(Pos.CENTER);
        
        HBox vierekkaisetKortit = new HBox(50);
        Button pakkaNappi = new Button();
        ImageView pakka = new ImageView(new Image(getClass().getResourceAsStream("/PNG/pakka.png")));   
        pakka.setFitHeight(300);
        pakka.setPreserveRatio(true);
        pakkaNappi.setGraphic(pakka);
        nostettuKortti = new ImageView(); 
        nostettuKortti.setFitHeight(300);
        nostettuKortti.setPreserveRatio(true);
        vierekkaisetKortit.getChildren().addAll(pakkaNappi, nostettuKortti);
        vierekkaisetKortit.setAlignment(Pos.CENTER);
        
        pakkaNappi.setOnAction(e -> {
            if(kortit.onkoKorttejaJaljella()) {                
                String tiedosto = kortit.nostaKortti();
                uusiKortti = new Image(getClass().getResourceAsStream(tiedosto));
                nostettuKortti.setImage(uusiKortti);   
                kopio.setImage(uusiKortti);              
                
                //hävio
                if(tiedosto.matches("/PNG/" + peli.getLuku() + "H" + ".png") ||
                        tiedosto.matches("/PNG/" + peli.getLuku() + "D" + ".png") ||
                        tiedosto.matches("/PNG/" + peli.getLuku() + "C" + ".png") ||
                        tiedosto.matches("/PNG/" + peli.getLuku() + "S" + ".png")) {                                  
                    havioTeksti.setText("Hävisit pelin kun lueteltiin luku: " + peli.getLuku());
                    cardsLeft.setText("Pakassa oli jäljellä " + (kortit.getKortit().size()) + " korttia");
                    nollaa();                    
                    ikkuna.setScene(havioScene);
                } else {
                    nro.setText(peli.getLuku()+"");
                    korttejaJaljella.setText(kortit.getKortit().size()+"");
                    peli.paivitaLuku();                    
                }
            
            //voitto    
            } else {
                nollaa();                
                ikkuna.setScene(voittoScene);
            }
        });
        
        HBox alaTeksti = new HBox(20);
        Text jarjestysLuku = new Text("Järjestyksessä oleva luku: ");
        jarjestysLuku.setFont(Font.font("Times New Roman", 30));
        nro = new Text("");
        nro.setFont(Font.font("Times New Roman", FontWeight.BOLD, 30));
        nro.setFill(Color.RED);
        alaTeksti.getChildren().addAll(jarjestysLuku, nro);
        alaTeksti.setAlignment(Pos.CENTER);
        
        sisalto.getChildren().addAll(ylaTeksti, vierekkaisetKortit, alaTeksti);
        peliScene = new Scene(sisalto, 800, 600);
        
     
//        voittoScene
        VBox voittoTekstit = new VBox();
        voittoTekstit.setPadding(new Insets(40));
        voittoTekstit.setAlignment(Pos.CENTER);        
        Text voittoTeksti = new Text("Onneksi olkoon, voitit pelin!");
        voittoTeksti.setFont(Font.font("Times New Roman", 20));        
        Button uusiPeli = new Button("Uusi peli");
        uusiPeli.setFont(Font.font("Times New Roman", 20));
        
        uusiPeli.setOnAction(e -> {
            ikkuna.setScene(aloitusScene);
        });
        
        voittoTekstit.getChildren().addAll(voittoTeksti, uusiPeli);
        voittoScene = new Scene(voittoTekstit, 800, 600);


//        havioScene
        VBox havioTekstit = new VBox();
        havioTekstit.setSpacing(10);
        havioTekstit.setPadding(new Insets(40));
        havioTekstit.setAlignment(Pos.CENTER); 
        havioTeksti.setFont(Font.font("Times New Roman", 20));          
        cardsLeft.setFont(Font.font("Times New Roman", 20));  
        Button uusiPeli2 = new Button("Uusi peli");
        uusiPeli2.setFont(Font.font("Times New Roman", 20));
        
        uusiPeli2.setOnAction(e -> {
            ikkuna.setScene(aloitusScene);
        });
        
        HBox vierekkaisetKortit2 = new HBox(50);       
        ImageView pakka2 = new ImageView(new Image(getClass().getResourceAsStream("/PNG/pakka.png")));   
        pakka2.setFitHeight(300);
        pakka2.setPreserveRatio(true);        
        kopio.setFitHeight(300);
        kopio.setPreserveRatio(true);
        vierekkaisetKortit2.getChildren().addAll(pakka2, kopio);
        vierekkaisetKortit2.setAlignment(Pos.CENTER);
        
        havioTekstit.getChildren().addAll(havioTeksti, vierekkaisetKortit2, cardsLeft, uusiPeli2);
        havioScene = new Scene(havioTekstit, 800, 600);
        
        //Ohjescene
        BorderPane ohjeet = new BorderPane();
        ohjeet.setPadding(new Insets(20));
        Button exit = new Button("x");
        
        exit.setOnAction(e -> {
            ikkuna.setScene(aloitusScene);
        });
        
        Label ohjeLabel = new Label("Pelin ohjeet:");
        ohjeLabel.setFont(Font.font("Times New Roman", 30));
        Text ohjeTeksti = new Text("Pasianssipelin idea on toistuvasti luetella lukuja yhdestä itse valitsemaansa lukuun, ja joka luvun \n"
                + "kohdalla nostaa kortti pakasta klikkaamalla pakan kuvaa. Jos luku vastaa kortin arvoa, on \n"
                + "peli hävitty. Jos taas pääsee pakan loppuun, on pelaaja voittanut pelin. \n"
                + "Erityiskorttien arvot: J = 11    Q = 12    K = 13    A = 1 \n\n"
                + "Esimerkki: \n"
                + "Pelaaja valitsee luvun 5. Tällöin luetellaan 1, 2, 3, 4, 5, 1, 2, 3 jne. Jos pelaaja esimerkiksi nostaa \n"
                + "kortin jonka arvo on 4 samalla kun luetellaan luku 4, on peli loppu.");
        ohjeTeksti.setFont(Font.font("Times New Roman", 20));        
        ohjeet.setTop(exit);
        VBox instr = new VBox();        
        instr.setSpacing(20);
        instr.getChildren().addAll(ohjeLabel, ohjeTeksti);
        ohjeet.setCenter(instr);
        ohjeScene = new Scene(ohjeet, 800, 600);

//      Alkunäkymä
        BorderPane main = new BorderPane();       
        main.setPadding(new Insets(40));
        VBox aloitus = new VBox(20);
        aloitus.setPadding(new Insets(20));
        Text pelinNimi = new Text("Pasianssi");                       
        pelinNimi.setFont(Font.font("Times New Roman", 50));
        Button aloitaNappi = new Button("Aloita peli");
        aloitaNappi.setFont(Font.font("Times New Roman", 20));
        Text syotaLuku = new Text("Syöta luku 1-13");
        syotaLuku.setFont(Font.font("Times New Roman", 20));
        Text epaKelpo = new Text("");
        epaKelpo.setFont(Font.font("Times New Roman", 15));
        epaKelpo.setFill(Color.RED);
        input = new TextField("");
        input.setFont(Font.font("Times New Roman", 15));
        
        HBox ylaSymbolit = new HBox();  
        ImageView hertta = new ImageView(new Image(getClass().getResourceAsStream("/PNG/heart.png"))); 
        ImageView pata = new ImageView(new Image(getClass().getResourceAsStream("/PNG/spade.png"))); 
        hertta.setFitHeight(40);
        hertta.setPreserveRatio(true);
        pata.setFitHeight(40);
        pata.setPreserveRatio(true);
        ylaSymbolit.getChildren().addAll(hertta, pata);
        ylaSymbolit.setSpacing(600);
        
        
        HBox alaSymbolit = new HBox();
        ImageView ruutu = new ImageView(new Image(getClass().getResourceAsStream("/PNG/diamond.png"))); 
        ImageView risti = new ImageView(new Image(getClass().getResourceAsStream("/PNG/club.png"))); 
        ruutu.setFitHeight(40);
        ruutu.setPreserveRatio(true);
        risti.setFitHeight(40);
        risti.setPreserveRatio(true);
        alaSymbolit.getChildren().addAll(risti, ruutu);
        alaSymbolit.setSpacing(600);
        
        aloitaNappi.setOnAction(e -> {
            try{
                int inputLuku = Integer.parseInt(input.getText());
            }catch (NumberFormatException ex) { 
                epaKelpo.setText("Vääränlainen syöte, syötä luku");
            }
            if(input.getText().equals("")) {
                epaKelpo.setText("Syötä luku");
            }
            luku = Integer.valueOf(input.getText());
            if(peli.epakelpoLuku(luku)) {
                epaKelpo.setText(luku + " on epäkelpo luku");
            } else {
                epaKelpo.setText("");
                peli.setArvo(luku);            
                ikkuna.setScene(peliScene);                
            }
        });
        
                
        Button ohjeNappi = new Button("i");
        
        ohjeNappi.setOnAction(e -> {
            ikkuna.setScene(ohjeScene);
        });
        
        aloitus.getChildren().addAll(ylaSymbolit, pelinNimi, syotaLuku, input, epaKelpo, aloitaNappi, alaSymbolit);
        aloitus.setAlignment(Pos.CENTER);
        main.setCenter(aloitus);
        main.setTop(ohjeNappi);
        aloitusScene = new Scene(main, 800, 600);
        
        
        ikkuna.setTitle("Pasianssi");
        ikkuna.setScene(aloitusScene);
        ikkuna.show();
    }      
    
    /**
    * Metodi nollaa pelin kun peli loppuu (joko voittoon tai häviöön)
    * 
    */
    public void nollaa() {
        input.setText("");        
        peli.lukuYkkoseksi();       
        nro.setText("");        
        kortit.uusiPakka();        
        nostettuKortti.setImage(null);
        korttejaJaljella.setText(kortit.getKortit().size()+"");
        kortit.setIndeksi();
    }
    
    
    public static void main(String[] args) {
        launch(args);
    }

}
