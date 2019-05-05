# Pasianssipeli

Sovellus on pasianssipeli jossa pelaaja luettelee lukuja 1-13 välillä samalla läpi käyden kokonaisen korttipakan. Jos pelajaa luettelee luvun joka on samalla nostetun kortin arvo, on peli hävitty. Jos pelaaja taas pääsee kortin loppuun saakka, on peli sen sijaan voitettu. 


## Dokumentaatio

* [Työaikakirjanpito](https://github.com/hagstr/Ohjelmistotekniikka/blob/master/Dokumentointi/Ty%C3%B6aikakirjanpito.md)

* [Määrittelydokumentti](https://github.com/hagstr/Ohjelmistotekniikka/blob/master/Dokumentointi/M%C3%A4%C3%A4rittelydokumentti.md)

* [Arkkitehtuuridokumentti](https://github.com/hagstr/Ohjelmistotekniikka/blob/master/Dokumentointi/arkkitehtuuri.md)

* [Käyttöohjeet](https://github.com/hagstr/Ohjelmistotekniikka/blob/master/Dokumentointi/Instructions.md)


## Releaset
* [Ensimmäinen release (Viikko 5)](https://github.com/hagstr/Ohjelmistotekniikka/releases/tag/viikko5)
* [Toinen release (Viikko 6)](https://github.com/hagstr/Ohjelmistotekniikka/releases/tag/viikko6)


## Komentorivitoiminnot

### Testaaminen

Testaaminen hoituu komennolla
```
mvn test
```
ja testikattavuuden voi tarkistaa luomalla siitä raportti jonka voi tarkistaa tiedostosta target/site/jacoco/index.html. Raportin luominen onnistuu kommennolla
```
mvn jacoco:report
```

### jarin generointi suorittamista varten

Voit luoda suoritettavan jar-tiedoston kommennolla
```
mvn package
```
Tiedosto löytyy target hakemistosta ja löytyy nimellä Pasianssi-1.0-SNAPSHOT.jar


### Checkstyle

Mahdollisia Checkstyle-virheitä voi tarkistaa suorittamalla komento
```
mvn jxr:jxr checkstyle:checkstyle
```
ja tämän jälkeen avaamalla tiedosto target/site/checkstyle.html omalla selaimellaan.


### JavaDoc

JavaDoc luodaan komennolla
```
mvn javadoc:javadoc
```
ja sen voi nähdä selaimellaan avaamalla tiedosto target/site/apidocs/index.html





