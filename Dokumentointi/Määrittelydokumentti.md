# Vaatimusmäärittely

## Sovelluksen tarkoitus
Sovellus on pasianssi-peli, jossa käyttäjä aluksi valitsee luvun 1 ja 13 välillä.
Tämän jälkeen hän luettelee luvut yhdestä annettuun lukuun asti, toistaen kunnes koko
korttipakka on käyty läpi. Samalla kun jokainen luku luetellaan, nostetaan ylin kortti 
pakasta. Jos kortin arvo vastaa samalla lueteltua lukua, peli on hävitty. Esimerkiksi jos
luvuksi valitaan 5, luetellaan 1,2,3,4,5,1,2,3,4,5,1,2... kunnes pakka on loppu. Esimerkki häviöstä 
on jos esimerkiksi nostetaan kortti jonka arvo on 4 samalla kun luetellaan luku 4 lukujonosta. 

## Käyttöliittymäluonnos ja toiminnallisuus
Sovelluksessa on viisi eri näkymää.

![alt text](https://github.com/hagstr/Ohjelmistotekniikka/blob/master/laskarit/IMG_0784.JPG)

 **Alkunäkymässä** on otsikkona pelin nimi, sekä kenttä johon käyttäjä
syöttää luvun välillä 1-13. Kentän alla on aloita-nappi joka aloittaa pelin, ja mikäli käyttäjä syöttää epäkelvon luvun, järjestelmä ilmoittaa tästä. Näkymän yläreunasta löytyy myös i-nappi, jota painamalla pelin ohjeet avautuvat. 

**Ohjenäkymässä** kerrotaan tarkemmin pelin säännöistä, sekä annetaan esimerkki pelin pelaamisesta. 

**Pelinäkymässä** lukee ylimpänä jäljellä oleva korttimäärä ja alhaalla näkyy lueteltava luku. 
Näkymän keskiosassa on kaksi korttipakkaa, joista oikeanpuoleisessa on kuvapuoli ylöspäin ja toisessa alaspäin.
Pakassa jossa on kuvapuoli ylöspäin näkyy viimeksi nostettu kortti. Uusi kortti nostetaan klikkaamalla vasenta pakkaa.

**Häviönäkymässä** näkyy korttimäärä, häviökortti sekä lueteltu luku pelin loppuessa. Näkymästä löytyy
"Pelaa uudestaan"-nappi, jota painamalla pääsee ensimmäiseen näkymään ja voi halutessaan pelata uudestaan. 

**Voittonäkymä** ilmestyy jos pääsee pakan loppuun. Tästäkin näkymästä löytyy
"Pelaa uudestaan"-nappi.

## Jatkokehitysiedoita 
* Mahdollisuus käyttäjätunnuksen luomiseen, jolloin voi tallentaa tilastoa pelatuista peleistä, esim. voisi
nähdä millä annetulla luvulla voittaa useimmiten. 
