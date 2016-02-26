# Testausdokumentti

N�in alkuun sellainen maininta, ett� peli lagaa/p�tkii jostain tuntemattomasta syyst� laitoksen koneilla. Olen testannut peli� kolmella eri omalla l�pp�rill�, joista surkein on noin 9 vuotta vanha, ja py�rii kaikilla t�ysin ongelmitta gameloopin m��rittelem�t 60 FPS. Koodikatselmoinnissakaan ei tullut mit��n mainintaa siit�, ett� peli olisi p�tkinyt.

Automaattinen testaus (JUnit) kattaa luokat "Avaruusalus", "Meteoroidi", "Ohjus", "Elamapaketti", "Avaruustaistelu",
"ObjektienPoistaja", "ObjektienSiirtaja" ja "ObjektienTarkastaja".

Automaattinen testaus ei kata luokkia "Kayttoliittyma", "MenuValikko", "NappaimistonKuuntelija", "Piirtoalusta" 
ja "TiedostojenKasittelija".

"Kayttoliittyma" on testattu k�ynnist�m�ll� ohjelma ja katsomalla, ett� kaikki n�ytt�� silt� niin kuin pit��kin
ja ett� k�ytt�liittym�lle luodaan komponentit oikein, eli piirtoalusta ja n�pp�imist�nkuuntelija, jotka toimivat/n�ytt�v�t peliss� silt� niin kuin pit��kin.

"MenuValikko" on Swingill� tehty. Testasin, ett� jokainen valikon JButton vie oikeaan paikkaan:

* "Aloita peli" painike k�ynnist�� uuden Avaruustaistelu pelin.
* "Ohjeet" painike asettaa valikon JPanelin n�kyvyyden falseksi ja asettaa ohjeet JPanelin n�kyvyyden trueksi.
* "Enn�tykset" painike asettaa valikon JPanelin n�kyvyyden falseksi ja asettaa enn�tykset JPanelin n�kyvyyden trueksi. Lis�ksi se p�ivitt�� enn�tysten pisteet.
* "Lopeta peli" painike kutsuu komentoa System.exit(0), joka sulkee ohjelman.
* Ohjeet ja enn�tykset JPanelien "Takaisin valikkoon" painike asettaa ohjeet/enn�tykset JPanelin n�kyvyyden falseksi ja valikon n�kyvyyden trueksi.

"N�pp�imist�nKuuntelija" on testattu k�sin pelaamalla peli�, ja katsomalla ett� liikkuminen ja ohjusten ampuminen toimii niinkuin luokassa on m��ritelty. Lis�ksi valikkoon paluu toimii my�s moitteitta pelin p��tytty�.

"Piirtoalusta" on testattu k�sin pelaamalla peli�. Objektit piirtyv�t ja p�ivittyv�t oikein. Pisteet ja el�m�t piirtyv�t oikein peliruudun yl�laitaan, sek� lopetusikkuna piirtyy oikein.

"TiedostojenKasittelija" on testattu k�sin pelaamalla peli�. Tiedostojenk�sittelij� osaa antaa kuvatiedostot oikein Avaruusalukselle ja El�m�paketille. Lis�ksi pelin lopussa enn�tyspisteiden vertailu ennatykset.txt tiedostoon onnistuu ja p�ivittyy hyvin.