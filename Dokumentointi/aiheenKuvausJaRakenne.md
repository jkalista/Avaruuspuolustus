# Aiheen kuvaus ja rakenne

## Avaruustaistelu

**Aihe:** Avaruustaistelu on peli, jossa pelaaja ohjaa avaruusalusta x-akselin suuntaisesti kuvaruudun alareunassa ja pyrkii tuhoamaan mahdollisimman monta y-akselin suuntaisesti ylhäältä päin liikkuvaa meteoroidia ampumalla. Pelaaja ei saa osua meteoroideihin tai päästää meteoroideja ohitseen niin, että elämäpisteet menevät nollaan, muuten peli päättyy. Pelaajalla on siis elämäpisteet, ja jokaisesta ohi päästetystä meteoroidista menettää yhden (1) elämäpisteen. Jos pelaaja taas osuu meteoroidiin, niin peli loppuu suoraan. Jokaista tuhottua meteoroidia kohden pelaaja saa yhden (1) pisteen. Pelaaja voi palauttaa avaruusaluksen elämäpisteitä keräämällä punaisella ristillä varustettuja elämäpaketteja.

**Käyttäjät:** Pelaaja

**Pelaajan toiminnot:** Alla on listattuna toiminnot ("Menu" -valikosta pelaaja pääsee valitsemaan toiminnot "Aloita peli" (Aloittaa uuden pelin), "Ohjeet" (Avaa ikkunan, jossa ohjeet peliä varten), "Ennätykset" (Avaa ikkunan, jossa parhaat pisteet) ja "Lopeta peli" (Sulkee pelin).)

* Pelin aloittaminen.
 * Pelissä pelaaja voi liikkua ja ampua ohjuksia näppäimistöä käyttämällä.
* Ohjeiden lukeminen.
* Ennätyspisteiden lukeminen.
* Pelin lopettaminen.

**Rakenne:** Projektitiedostossa on "Main" -luokka ja Swingillä tehty "MenuValikko" -luokka, josta saa käynnistettyä pelin. Jätin "Main" -luokan sen takia, että siitä pääsee suoraan peliin, joka nopeuttaa hieman käsin testaamista ynnä muuta sellaista. "MenuValikko" -luokan "Aloita peli" -JButton ajaa siis oleellisesti saman asian, kuin "Main" -luokan koodi.

Avaruuspuolus projektin "Main" -luokka luo ensin "Avaruustaistelu" -luokasta ilmentymän (joka luo pelaajan avaruusaluksen, listat pelissä olevista meteoroideista ja elämäpaketeista, kaksi timeriä uusien objektien luomiseen, peliKaynnissa booleanin, randomin objektien paikan arvontaan, objektiensiirtajan, objektienpoistajan ja objektientarkastajan), jonka jälkeen luodaan "Kayttoliittyma" -luokasta ilmentymä, joka saa parametriksi tämän avaruustaistelun. Käyttöliittymässä luodaan pelille jFrame ja siihen lisätään komponentit "Piirtoalusta" ja "NappaimistonKuuntelija". Tämä näppäimistönkuuntelija saa parametreikseen avaruustaistelun ja jframen. Näppäimistönkuuntelija hakee avaruustaistelulta pelaajan ohjaaman avaruusaluksen "getAvaruusalus" -metodilla, jolloin avaruusalusta voidaan liikuttaa näppäimistön näppäimillä. JFrame voidaan myös luonnollisesti sulkea määritellyllä näppäimellä käyttämällä "dispose" -komentoa, kun se on annettu näppäimistönkuuntelijalle parametrina.

Piirtoalusta saa myös parametrikseen avaruustaistelun, sillä sitä kautta se saa piirrettäväkseen kaikki avaruustaisteluun liittyvät objektit get-metodien avulla. Kun käyttöliittymä on luonut piirtoalustan, niin se asetetaan "Main" -luokassa aiemmin luodulle avaruustaistelu pelille "setPiirtoalusta" -metodilla. "Main" -luokassa ruvetaan pyörittämään Avaruuspuolustuksen GameLooppia, joka siirtää avaruusalusta ja sen tuntemia ohjuksia, elämäpaketteja sekä meteoroideja objektiensiirtajan avulla. Lisäksi objektientarkastaja ja -poistaja tarkastavat jokaisessa loopissa objektien yhteentörmäykset ja niiden perusteella poistamiset. Piirtoalustan uudelleenpiirtoa kutsutaan aina jokaisen GameLoopin lopussa.

Avaruusalus saa tiedostojenkäsittelijältä BufferedImagena avaruusaluksen kuvan, Elämäpaketti taas saa elämäpaketin kuvan. Lisäksi tiedostojenkäsittelijä tarkistaa pelin loputtua, että riittävätkö saadut pisteet ennätyslistalle, ja muokkaa tarvittaessa ennätyspisteitä sen mukaan.

**Luokkakaavio:**

![Luokkakaavio](https://github.com/jkalista/Avaruuspuolustus/blob/master/Dokumentointi/luokkakaaviot/LuokkakaavioVko6.JPG)

**Sekvenssikaaviot:**

* Pelaajan avaruusalus ampuu kaksi ohjusta, jotka lisätään avaruusaluksen ohjuksia sisältävään listaan. ObjektienSiirtaja liikuttaa kaikkia listassa olevia ohjuksia.
![SekvenssikaavioYksi](https://github.com/jkalista/Avaruuspuolustus/blob/master/Dokumentointi/sekvenssikaaviot/ohjustenAmpuminenJaNiidenLiike.JPG)

* ObjektienTarkastaja tarkastaa pelin jatkumista tapauksissa, jossa avaruusaluksen elämäpisteet ovat 5 ja 0.
![SekvenssikaavioKaksi](https://github.com/jkalista/Avaruuspuolustus/blob/master/Dokumentointi/sekvenssikaaviot/tarkastetaanPelinJatkumista.JPG)

* Uuden pelin käynnistäminen.
![SekvenssikaavioKolme](https://github.com/jkalista/Avaruuspuolustus/blob/master/Dokumentointi/sekvenssikaaviot/uudenPelinKaynnistys.JPG)