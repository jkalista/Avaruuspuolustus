# Aiheen kuvaus ja rakenne

## Avaruustaistelu

**Aihe:** Avaruustaistelu on peli, jossa pelaaja ohjaa avaruusalusta x-akselin suuntaisesti kuvaruudun alareunassa ja pyrkii tuhoamaan mahdollisimman monta y-akselin suuntaisesti ylh��lt� p�in liikkuvaa meteoroidia ampumalla. Pelaaja ei saa osua meteoroideihin tai p��st�� meteoroideja ohitseen niin, ett� el�m�pisteet menev�t nollaan, muuten peli p��ttyy. Pelaajalla on siis el�m�pisteet, ja jokaisesta ohi p��stetyst� meteoroidista menett�� yhden (1) el�m�pisteen. Jos pelaaja taas osuu meteoroidiin, niin peli loppuu suoraan. Jokaista tuhottua meteoroidia kohden pelaaja saa yhden (1) pisteen. Pelaaja voi palauttaa avaruusaluksen el�m�pisteit� ker��m�ll� punaisella ristill� varustettuja el�m�paketteja.

**K�ytt�j�t:** Pelaaja

**Pelaajan toiminnot:** Alla on listattuna toiminnot ("Menu" -valikosta pelaaja p��see valitsemaan toiminnot "Aloita peli" (Aloittaa uuden pelin), "Ohjeet" (Avaa ikkunan, jossa ohjeet peli� varten), "Enn�tykset" (Avaa ikkunan, jossa parhaat pisteet) ja "Lopeta peli" (Sulkee pelin).)

* Pelin aloittaminen.
 * Peliss� pelaaja voi liikkua ja ampua ohjuksia n�pp�imist�� k�ytt�m�ll�.
* Ohjeiden lukeminen.
* Enn�tyspisteiden lukeminen.
* Pelin lopettaminen.

**Rakenne:** Projektitiedostossa on "Main" -luokka ja Swingill� tehty "MenuValikko" -luokka, josta saa k�ynnistetty� pelin. J�tin "Main" -luokan sen takia, ett� siit� p��see suoraan peliin, joka nopeuttaa hieman k�sin testaamista ynn� muuta sellaista. "MenuValikko" -luokan "Aloita peli" -JButton ajaa siis oleellisesti saman asian, kuin "Main" -luokan koodi.

Avaruuspuolus projektin "Main" -luokka luo ensin "Avaruustaistelu" -luokasta ilmentym�n (joka luo pelaajan avaruusaluksen, listat peliss� olevista meteoroideista ja el�m�paketeista, kaksi timeri� uusien objektien luomiseen, peliKaynnissa booleanin, randomin objektien paikan arvontaan, objektiensiirtajan, objektienpoistajan ja objektientarkastajan), jonka j�lkeen luodaan "Kayttoliittyma" -luokasta ilmentym�, joka saa parametriksi t�m�n avaruustaistelun. K�ytt�liittym�ss� luodaan pelille jFrame ja siihen lis�t��n komponentit "Piirtoalusta" ja "NappaimistonKuuntelija". T�m� n�pp�imist�nkuuntelija saa parametreikseen avaruustaistelun ja jframen. N�pp�imist�nkuuntelija hakee avaruustaistelulta pelaajan ohjaaman avaruusaluksen "getAvaruusalus" -metodilla, jolloin avaruusalusta voidaan liikuttaa n�pp�imist�n n�pp�imill�. JFrame voidaan my�s luonnollisesti sulkea m��ritellyll� n�pp�imell� k�ytt�m�ll� "dispose" -komentoa, kun se on annettu n�pp�imist�nkuuntelijalle parametrina.

Piirtoalusta saa my�s parametrikseen avaruustaistelun, sill� sit� kautta se saa piirrett�v�kseen kaikki avaruustaisteluun liittyv�t objektit get-metodien avulla. Kun k�ytt�liittym� on luonut piirtoalustan, niin se asetetaan "Main" -luokassa aiemmin luodulle avaruustaistelu pelille "setPiirtoalusta" -metodilla. "Main" -luokassa ruvetaan py�ritt�m��n Avaruuspuolustuksen GameLooppia, joka siirt�� avaruusalusta ja sen tuntemia ohjuksia, el�m�paketteja sek� meteoroideja objektiensiirtajan avulla. Lis�ksi objektientarkastaja ja -poistaja tarkastavat jokaisessa loopissa objektien yhteent�rm�ykset ja niiden perusteella poistamiset. Piirtoalustan uudelleenpiirtoa kutsutaan aina jokaisen GameLoopin lopussa.

Avaruusalus saa tiedostojenk�sittelij�lt� BufferedImagena avaruusaluksen kuvan, El�m�paketti taas saa el�m�paketin kuvan. Lis�ksi tiedostojenk�sittelij� tarkistaa pelin loputtua, ett� riitt�v�tk� saadut pisteet enn�tyslistalle, ja muokkaa tarvittaessa enn�tyspisteit� sen mukaan.

**Luokkakaavio:**

![Luokkakaavio](https://github.com/jkalista/Avaruuspuolustus/blob/master/Dokumentointi/luokkakaaviot/LuokkakaavioVko6.JPG)

**Sekvenssikaaviot:**

* Pelaajan avaruusalus ampuu kaksi ohjusta, jotka lis�t��n avaruusaluksen ohjuksia sis�lt�v��n listaan. ObjektienSiirtaja liikuttaa kaikkia listassa olevia ohjuksia.
![SekvenssikaavioYksi](https://github.com/jkalista/Avaruuspuolustus/blob/master/Dokumentointi/sekvenssikaaviot/ohjustenAmpuminenJaNiidenLiike.JPG)

* ObjektienTarkastaja tarkastaa pelin jatkumista tapauksissa, jossa avaruusaluksen el�m�pisteet ovat 5 ja 0.
![SekvenssikaavioKaksi](https://github.com/jkalista/Avaruuspuolustus/blob/master/Dokumentointi/sekvenssikaaviot/tarkastetaanPelinJatkumista.JPG)

* Uuden pelin k�ynnist�minen.
![SekvenssikaavioKolme](https://github.com/jkalista/Avaruuspuolustus/blob/master/Dokumentointi/sekvenssikaaviot/uudenPelinKaynnistys.JPG)