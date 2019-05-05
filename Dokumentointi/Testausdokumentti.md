# Testausdokumentti

## Yksikkö- ja integraatiotestaus
### Sovelluslogiikka
Pakkauksen pasianssi.domain sovelluslogiikkaa testataan testiluokkien SovelluslogiikkaTest ja KortitTest avulla, jotka testaavat Sovelluslogiikan metodien ja 
toiminnalisuuksien toimintaa.

### Testauskattavuus
Kun käyttöliittymä jätetään pois on sovelluksen testien rivikattavuus 95% ja haarautumakattavuus 90%. 
![alt_text](https://github.com/hagstr/Ohjelmistotekniikka/blob/master/Dokumentointi/Screen%20Shot%202019-05-05%20at%2018.32.39.png)
Käyttöliittymän testauskattavuus näkyy tässä jostain syystä, vaikka se pom.xml:ssä kuitenkin on exclude:attu. 

Ainoa asia joka jäi testaamatta on, että epakelpoLuku() palauttaa false jos luku on hyväksyttävä, eli 1-13 välillä.

### Järjestelmätestaus
Järjestelmätestaus suoritettiin sovellukselle automaattisesti. 

### Asennus
Sovellus on ladattu koneelle OSX-käyttjärjestelmää käyttäen, sekä koneella josta sovellus löytyy ennestään että koneella jolla peliä ei ollut ennen pelattu. Asennus onnistui molemmilla tavoilla. Myös Windowsilla sovelluksen avaaminen ja pelaaminen onnistuu hyvin. 

### Toiminnallisuudet
Pelin kaikkia toiminnallisuuksia on testattu, ja ne vastaavat määrittelydokumentissä esiteltyjä toiminnallisuuksia. Myös virheellisi syötteitä
on testattu, kuten negatiivisten lukujen syöttäminen tekstikenttään.
