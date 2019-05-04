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
syöttää luvun välillä 1-13. Kentän alla on aloita-nappi joka aloittaa pelin, ja näkymän alareunasta
löytyvät pelin säännöt. Mikäli käyttäjä syöttää epäkelvon luvun, järjestelmä ilmoittaa tästä. 

**Toisessa** näkymässä lukee ylimpänä jäljellä oleva korttimäärä ja alhaalla näkyy lueteltava luku. 
Näkymän keskiosassa on kaksi korttipakkaa, joista oikeanpuoleisessa on kuvapuoli ylöspäin ja toisessa alaspäin.
Pakassa jossa on kuvapuoli ylöspäin näkyy viimeksi nostettu kortti. Jos pääsee pakan loppuun, eli
voittaa, niin vasemmanpuoleinen pakka katoaa (sillä kortit ovat loppu).

**Kolmas** näkymä on joko voitto-ruutu tai häviö-ruutu, joka ilmestyy pelinn loputtua. Näkymistä löytyy
"Uudestaan?"-nappi, jota painamalla pääsee ensimmäiseen näkymään ja voi halutessaan pelata uudestaan. 

**Ohjenäkymä** löytyy myös sovelluksesta, ja siellä kerrotaan tarkemmin pelin säännöistä. 

## Jatkokehitysiedoita 
* Mahdollisuus käyttäjätunnuksen luomiseen, jolloin voi tallentaa tilastoa pelatuista peleistä, esim. voisi
nähdä millä annetulla luvulla voittaa useimmiten. 
