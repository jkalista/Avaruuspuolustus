# Testausdokumentti

Näin alkuun sellainen maininta, että peli lagaa/pätkii jostain tuntemattomasta syystä laitoksen koneilla. Olen testannut peliä kolmella eri omalla läppärillä, joista surkein on noin 9 vuotta vanha, ja pyörii kaikilla täysin ongelmitta gameloopin määrittelemät 60 FPS. Koodikatselmoinnissakaan ei tullut mitään mainintaa siitä, että peli olisi pätkinyt.

Automaattinen testaus (JUnit) kattaa luokat "Avaruusalus", "Meteoroidi", "Ohjus", "Elamapaketti", "Avaruustaistelu",
"ObjektienPoistaja", "ObjektienSiirtaja" ja "ObjektienTarkastaja".

Automaattinen testaus ei kata luokkia "Kayttoliittyma", "MenuValikko", "NappaimistonKuuntelija", "Piirtoalusta" 
ja "TiedostojenKasittelija".

"Kayttoliittyma" on testattu käynnistämällä ohjelma ja katsomalla, että kaikki näyttää siltä niin kuin pitääkin
ja että käyttöliittymälle luodaan komponentit oikein, eli piirtoalusta ja näppäimistönkuuntelija, jotka toimivat/näyttävät pelissä siltä niin kuin pitääkin.

"MenuValikko" on Swingillä tehty. Testasin, että jokainen valikon JButton vie oikeaan paikkaan:

* "Aloita peli" painike käynnistää uuden Avaruustaistelu pelin.
* "Ohjeet" painike asettaa valikon JPanelin näkyvyyden falseksi ja asettaa ohjeet JPanelin näkyvyyden trueksi.
* "Ennätykset" painike asettaa valikon JPanelin näkyvyyden falseksi ja asettaa ennätykset JPanelin näkyvyyden trueksi. Lisäksi se päivittää ennätysten pisteet.
* "Lopeta peli" painike kutsuu komentoa System.exit(0), joka sulkee ohjelman.
* Ohjeet ja ennätykset JPanelien "Takaisin valikkoon" painike asettaa ohjeet/ennätykset JPanelin näkyvyyden falseksi ja valikon näkyvyyden trueksi.

"NäppäimistönKuuntelija" on testattu käsin pelaamalla peliä, ja katsomalla että liikkuminen ja ohjusten ampuminen toimii niinkuin luokassa on määritelty. Lisäksi valikkoon paluu toimii myös moitteitta pelin päätyttyä.

"Piirtoalusta" on testattu käsin pelaamalla peliä. Objektit piirtyvät ja päivittyvät oikein. Pisteet ja elämät piirtyvät oikein peliruudun ylälaitaan, sekä lopetusikkuna piirtyy oikein.

"TiedostojenKasittelija" on testattu käsin pelaamalla peliä. Tiedostojenkäsittelijä osaa antaa kuvatiedostot oikein Avaruusalukselle ja Elämäpaketille. Lisäksi pelin lopussa ennätyspisteiden vertailu ennatykset.txt tiedostoon onnistuu ja päivittyy hyvin.