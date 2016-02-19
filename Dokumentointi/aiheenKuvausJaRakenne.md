# Aiheen kuvaus ja rakenne

## Avaruuspuolustus

**Aihe:** Avaruuspuolustus on peli, jossa pelaaja ohjaa avaruusalusta x-akselin suuntaisesti kuvaruudun alareunassa ja pyrkii tuhoamaan mahdollisimman monta y-akselin suuntaisesti ylhäältä päin tulevaa liikkuvaa meteoroidia ampumalla. Pelaaja ei saa osua meteoroideihin tai päästää viittä (5) meteoroidia ohitseen, muuten peli päättyy. Pelaajalla on siis elämäpisteet, ja jokaisesta ohi päästetystä meteoroidista menettää yhden (1) elämäpisteen. Jos pelaaja taas osuu meteoroidiin, niin peli loppuu suoraan. Jokaista tuhottua meteoroidia kohden pelaaja saa yhden (1) pisteen. Pelaaja voi palauttaa avaruusaluksen elämäpisteitä keräämällä punaisella ristillä varustettuja elämäpaketteja.

**Käyttäjät:** Pelaaja

**Pelaajan toiminnot:** Alla listatut toiminnot tulevat olemaan lopullisessa versiossa, kunhan graafinen käyttöliittymä on tehty ("Menu" -valikosta pelaaja pääsee valitsemaan toiminnot "Aloita peli" (Aloittaa uuden pelin), "Ohjeet" (Avaa ikkunan, jossa ohjeet peliä varten) ja "Lopeta peli" (Sulkee pelin).)

* Pelin aloittaminen.
 * Pelissä pelaaja voi liikkua ja ampua ohjuksia näppäimistöä käyttämällä.
* Ohjeiden lukeminen.
* Pelin lopettaminen.

**Rakenne:** Avaruuspuolus projektin "Main" -luokka luo ensin "Avaruuspuolustus" -luokasta ilmentymän, jonka jälkeen luodaan "Käyttöliittymä" -luokasta ilmentymä, joka saa parametriksi tämän Avaruuspuolustuksen. Käyttöliittymässä luodaan pelille frame ja siihen lisätään komponentit "Piirtoalusta" ja "NäppäimistönKuuntelija". Tämä näppäimistönkuuntelija saa parametrikseen Avaruuspuolustukselta "Pelaaja" -luokan ilmentymän "getPelaaja" -metodilla. Kun käyttöliittymä on luonut piirtoalustan, niin se asetetaan "Main" -luokassa Avaruuspuolustus pelille "setPiirtoalusta" -metodilla. "Main" -luokassa ruvetaan pyörittämään Avaruuspuolustuksen GameLooppia, joka siirtää pelaajaa ja sen tuntemia ohjuksia sekä meteoroideja. Piirtoalustan uudelleenpiirtoa kutsutaan aina jokaisen GameLoopin lopussa. Pelaaja saa tiedostojenkäsittelijältä BufferedImagena avaruusaluksen kuvan.

**Luokkakaavio:**

![Luokkakaavio](https://github.com/jkalista/Avaruuspuolustus/blob/master/Dokumentointi/luokkakaaviot/LuokkakaavioVko5.JPG)

**Sekvenssikaaviot:**

* Pelaajan avaruusalus ampuu kaksi ohjusta, jotka lisätään avaruusaluksen ohjuksia sisältävään listaan. ObjektienSiirtaja liikuttaa kaikkia listassa olevia ohjuksia.
![SekvenssikaavioYksi](https://github.com/jkalista/Avaruuspuolustus/blob/master/Dokumentointi/sekvenssikaaviot/ohjustenAmpuminenJaNiidenLiike.JPG)

* ObjektienTarkastaja tarkastaa pelin jatkumista tapauksissa, jossa avaruusaluksen elämäpisteet ovat 5 ja 0.
![SekvenssikaavioKaksi](https://github.com/jkalista/Avaruuspuolustus/blob/master/Dokumentointi/sekvenssikaaviot/tarkastetaanPelinJatkumista.JPG)

* Uuden pelin käynnistäminen.
![SekvenssikaavioKolme](https://github.com/jkalista/Avaruuspuolustus/blob/master/Dokumentointi/sekvenssikaaviot/uudenPelinKaynnistys.JPG)