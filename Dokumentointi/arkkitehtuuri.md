## Sovelluksen rakenne
Pasianssisovelluksessa on kaksi eri pakkausta: pasianssi.ui joka vastaa käyttöliittymästä ja pasianssi.domain joka vastaa sovelluslogiikasta. Pakkausrakenne näyttää tältä:

![alt text](https://github.com/hagstr/Ohjelmistotekniikka/blob/master/Dokumentointi/Rakenne%20(2).png)

## Käyttöliittymä
Pelin käyttöliittymä toteutetaan Kayttoliittyma-luokassa, joka löytyy pasianssi.ui paketista. Käyttöliittymään on luotu viisi eri näkymää, eli Sceneä, jotka asetetaan näkyville sovelluksen ikkunaan, eli Stageen, eri vaiheissa peliä. Näkymät ovat:

* Aloitusnäkymä
* Pelinäkymä
* Voittonäkymä
* Häviönäkymä
* Ohjenäkymä

Käyttöliittymä on vastuussa ainoastaan pelin näkymistä, ja itse pelin toimintoihin liittyvät metodit kutsutaan sovelluslogiikkaan liittyvistä luokista. Ainoa metodi joka ui:sta löytyy on nollaa()-metodi, joka kuitenkin sekin kutsuu toisten luokkien metodeja. Tämä metodi nollaa pelin alkuperäistilanteeseen kun peli loppuu, eli luo mm. uuden pakan ja asettaa lueteltavan luvun takaisin ykköseksi.

## Sovelluslogiikka
Sovelluslogiikka koostuu kahdesta eri luokasta: Sovelluslogiikka ja Kortit, jotka molemmat löytyvät pasianssi.domain paketista. Sovelluksen datamallista näkyy luokkien yhteys toisiinsa. 

![alt text](https://github.com/hagstr/Ohjelmistotekniikka/blob/master/Dokumentointi/Untitled%20Diagram%20(7).png)

Toiminnallisuudesta vastaa siis pääasiassa Sovelluslogiikka luokka, joka kutsuu Kortit-luokkkaa konstruktorissaan ja luo pelissä käytettävän korttipakan. Sovellusluokkaan-liittyviä metodeja löytyy kuitenkin myös Kortit-luokasta. 

Sovelluslogiikan tärkeimpiä metodeja, joita kutsutaan käyttöliittymästä, ovat muun muassa:
* paivitaLuku()
* nostaKortti()
* onkoKorttejaJaljella()
* uusiPakka()

## Päätoiminnallisuus
Kortinnostamisen toiminnallisuuslogiikka sekvennsikaaviona (olettaen että pakka on täysi ja peliä ei hävitä ekalla nostolla). 
![alt text](https://github.com/hagstr/Ohjelmistotekniikka/blob/master/Dokumentointi/IMG_0736.JPG)
