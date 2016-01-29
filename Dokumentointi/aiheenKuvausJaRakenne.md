# Aiheen kuvaus ja rakenne

## Avaruuspuolustus

**Aihe:** Avaruuspuolustus on peli, jossa pelaaja ohjaa avaruusalusta x-akselin suuntaisesti kuvaruudun alareunassa ja pyrkii tuhoamaan mahdollisimman monta y-akselin suuntaisesti ylhäältä päin tulevaa liikkuvaa objektia ampumalla. Pelaaja ei saa osua objekteihin tai päästää montaa objektia ohitseen, muuten peli päättyy. Pelaajalla tulee siis olemaan elämäpisteet, ja jokaisesta ohi päästetystä objektista menettää yhden elämäpisteen. Jos pelaaja taas osuu objektiin, niin peli loppuu suoraan. Riippuen siitä, kuinka paljon ohjelmointiin kerkeän käyttää aikaa, voisi peliin lisätä muun muassa hyödyketavaroita, jotka palauttaa elämäpisteitä.

**Käyttäjät:** Pelaaja

**Pelaajan toiminnot:** Alla listatut toiminnot tulevat olemaan lopullisessa versiossa, kunhan graafinen käyttöliittymä on tehty ("Menu" -valikosta pelaaja pääsee valitsemaan toiminnot "Aloita peli" (Aloittaa uuden pelin), "Ohjeet" (Avaa ikkunan, jossa ohjeet peliä varten) ja "Lopeta peli" (Sulkee pelin).)

* Pelin aloittaminen.
 * Pelissä pelaaja voi liikkua ja ampua näppäimistöä käyttämällä.
* Ohjeiden lukeminen.
* Pelin lopettaminen.

**Rakenne:** Avaruuspuolus projektin "Main" -luokka luo ensin "Avaruuspuolustus" -luokasta ilmentymän, jonka jälkeen luodaan "Käyttöliittymä" -luokasta ilmentymä, joka saa parametriksi tämän Avaruuspuolustuksen. Käyttöliittymässä luodaan pelille frame ja siihen lisätään komponentit "Piirtoalusta" ja "NäppäimistönKuuntelija". Tämä näppäimistönkuuntelija saa parametrikseen Avaruuspuolustukselta "Pelaaja" -luokan ilmentymän "getPelaaja" -metodilla. Kun käyttöliittymä on luonut piirtoalustan, niin se asetetaan "Main" -luokassa Avaruuspuolustus pelille "setPiirtoalusta" -metodilla. "Main" -luokassa ruvetaan pyörittämään Avaruuspuolustuksen GameLooppia, joka siirtää pelaajaa ja sen tuntemia ohjuksia. Piirtoalustan uudelleenpiirtoa kutsutaan aina jokaisen loopin lopussa.

**Luokkakaavio:**

![Alt text](/Avaruuspuolustus/Dokumentointi/luokkakaaviot/LuokkakaavioVko2.jpg)