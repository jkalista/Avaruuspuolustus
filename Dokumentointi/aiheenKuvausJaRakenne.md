# Aiheen kuvaus ja rakenne

## Avaruuspuolustus

**Aihe:** Avaruuspuolustus on peli, jossa pelaaja ohjaa avaruusalusta x-akselin suuntaisesti kuvaruudun alareunassa ja pyrkii tuhoamaan mahdollisimman monta y-akselin suuntaisesti ylh��lt� p�in tulevaa liikkuvaa objektia ampumalla. Pelaaja ei saa osua objekteihin tai p��st�� montaa objektia ohitseen, muuten peli p��ttyy. Pelaajalla tulee siis olemaan el�m�pisteet, ja jokaisesta ohi p��stetyst� objektista menett�� yhden el�m�pisteen. Jos pelaaja taas osuu objektiin, niin peli loppuu suoraan. Riippuen siit�, kuinka paljon ohjelmointiin kerke�n k�ytt�� aikaa, voisi peliin lis�t� muun muassa hy�dyketavaroita, jotka palauttaa el�m�pisteit�.

**K�ytt�j�t:** Pelaaja

**Pelaajan toiminnot:** Alla listatut toiminnot tulevat olemaan lopullisessa versiossa, kunhan graafinen k�ytt�liittym� on tehty ("Menu" -valikosta pelaaja p��see valitsemaan toiminnot "Aloita peli" (Aloittaa uuden pelin), "Ohjeet" (Avaa ikkunan, jossa ohjeet peli� varten) ja "Lopeta peli" (Sulkee pelin).)

* Pelin aloittaminen.
 * Peliss� pelaaja voi liikkua ja ampua n�pp�imist�� k�ytt�m�ll�.
* Ohjeiden lukeminen.
* Pelin lopettaminen.

**Rakenne:** Avaruuspuolus projektin "Main" -luokka luo ensin "Avaruuspuolustus" -luokasta ilmentym�n, jonka j�lkeen luodaan "K�ytt�liittym�" -luokasta ilmentym�, joka saa parametriksi t�m�n Avaruuspuolustuksen. K�ytt�liittym�ss� luodaan pelille frame ja siihen lis�t��n komponentit "Piirtoalusta" ja "N�pp�imist�nKuuntelija". T�m� n�pp�imist�nkuuntelija saa parametrikseen Avaruuspuolustukselta "Pelaaja" -luokan ilmentym�n "getPelaaja" -metodilla. Kun k�ytt�liittym� on luonut piirtoalustan, niin se asetetaan "Main" -luokassa Avaruuspuolustus pelille "setPiirtoalusta" -metodilla. "Main" -luokassa ruvetaan py�ritt�m��n Avaruuspuolustuksen GameLooppia, joka siirt�� pelaajaa ja sen tuntemia ohjuksia. Piirtoalustan uudelleenpiirtoa kutsutaan aina jokaisen loopin lopussa.

**Luokkakaavio:**

![Alt text](/Avaruuspuolustus/Dokumentointi/luokkakaaviot/LuokkakaavioVko2.jpg)