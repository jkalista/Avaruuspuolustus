# Aiheen kuvaus ja rakenne

## Avaruuspuolustus

**Aihe:** Avaruuspuolustus on peli, jossa pelaaja ohjaa avaruusalusta x-akselin suuntaisesti kuvaruudun alareunassa ja pyrkii tuhoamaan mahdollisimman monta y-akselin suuntaisesti ylh��lt� p�in tulevaa liikkuvaa meteoroidia ampumalla. Pelaaja ei saa osua meteoroideihin tai p��st�� viitt� (5) meteoroidia ohitseen, muuten peli p��ttyy. Pelaajalla on siis el�m�pisteet, ja jokaisesta ohi p��stetyst� meteoroidista menett�� yhden (1) el�m�pisteen. Jos pelaaja taas osuu meteoroidiin, niin peli loppuu suoraan. Jokaista tuhottua meteoroidia kohden pelaaja saa yhden (1) pisteen. Pelaaja voi palauttaa avaruusaluksen el�m�pisteit� ker��m�ll� punaisella ristill� varustettuja el�m�paketteja.

**K�ytt�j�t:** Pelaaja

**Pelaajan toiminnot:** Alla listatut toiminnot tulevat olemaan lopullisessa versiossa, kunhan graafinen k�ytt�liittym� on tehty ("Menu" -valikosta pelaaja p��see valitsemaan toiminnot "Aloita peli" (Aloittaa uuden pelin), "Ohjeet" (Avaa ikkunan, jossa ohjeet peli� varten) ja "Lopeta peli" (Sulkee pelin).)

* Pelin aloittaminen.
 * Peliss� pelaaja voi liikkua ja ampua ohjuksia n�pp�imist�� k�ytt�m�ll�.
* Ohjeiden lukeminen.
* Pelin lopettaminen.

**Rakenne:** Avaruuspuolus projektin "Main" -luokka luo ensin "Avaruuspuolustus" -luokasta ilmentym�n, jonka j�lkeen luodaan "K�ytt�liittym�" -luokasta ilmentym�, joka saa parametriksi t�m�n Avaruuspuolustuksen. K�ytt�liittym�ss� luodaan pelille frame ja siihen lis�t��n komponentit "Piirtoalusta" ja "N�pp�imist�nKuuntelija". T�m� n�pp�imist�nkuuntelija saa parametrikseen Avaruuspuolustukselta "Pelaaja" -luokan ilmentym�n "getPelaaja" -metodilla. Kun k�ytt�liittym� on luonut piirtoalustan, niin se asetetaan "Main" -luokassa Avaruuspuolustus pelille "setPiirtoalusta" -metodilla. "Main" -luokassa ruvetaan py�ritt�m��n Avaruuspuolustuksen GameLooppia, joka siirt�� pelaajaa ja sen tuntemia ohjuksia sek� meteoroideja. Piirtoalustan uudelleenpiirtoa kutsutaan aina jokaisen GameLoopin lopussa. Pelaaja saa tiedostojenk�sittelij�lt� BufferedImagena avaruusaluksen kuvan.

**Luokkakaavio:**

![Luokkakaavio](https://github.com/jkalista/Avaruuspuolustus/blob/master/Dokumentointi/luokkakaaviot/LuokkakaavioVko5.JPG)

**Sekvenssikaaviot:**

* Pelaajan avaruusalus ampuu kaksi ohjusta, jotka lis�t��n avaruusaluksen ohjuksia sis�lt�v��n listaan. ObjektienSiirtaja liikuttaa kaikkia listassa olevia ohjuksia.
![SekvenssikaavioYksi](https://github.com/jkalista/Avaruuspuolustus/blob/master/Dokumentointi/sekvenssikaaviot/ohjustenAmpuminenJaNiidenLiike.JPG)

* ObjektienTarkastaja tarkastaa pelin jatkumista tapauksissa, jossa avaruusaluksen el�m�pisteet ovat 5 ja 0.
![SekvenssikaavioKaksi](https://github.com/jkalista/Avaruuspuolustus/blob/master/Dokumentointi/sekvenssikaaviot/tarkastetaanPelinJatkumista.JPG)

* Uuden pelin k�ynnist�minen.
![SekvenssikaavioKolme](https://github.com/jkalista/Avaruuspuolustus/blob/master/Dokumentointi/sekvenssikaaviot/uudenPelinKaynnistys.JPG)