# Projekat Dizajn Softvera

Ovaj projekat je deo kursa Dizajn Softvera na Računarskom fakultetu. Projekat je podeljen u tri kontrolne tačke (KT1, KT2, KT3), pri čemu svaka tačka ima specifične zadatke i zahteve koje je potrebno ispuniti.

## Sadržaj

- [Instalacija](#instalacija)
- [Korišćenje](#korišćenje)
- [Struktura Projekta](#struktura-projekta)
- [Zahtevi](#zahtevi)
  - [Opšti Zahtevi](#opšti-zahtevi)
  - [KT1 Zahtevi](#kt1-zahtevi)
  - [KT2 Zahtevi](#kt2-zahtevi)
  - [KT3 Zahtevi](#kt3-zahtevi)
- [Autor](#autor)

## Instalacija

Da biste pokrenuli ovaj projekat, pratite sledeće korake:

1. Klonirajte repozitorijum:
   ```bash
   git clone https://github.com/vas-repozitorijum/projekat.git
   ```
2. Uđite u direktorijum projekta:
    ```bash
    cd projekat
    ```
3. Kompajlirajte projekat koristeći Maven ili Gradle (primer za Maven):
    ```bash
    mvn clean install
    ```

## Korišćenje

1. Pokrenite aplikaciju:
    ```bash
    java -jar target/projekat-1.0-SNAPSHOT.jar
    ```
2. Aplikacija će se otvoriti u novom prozoru.


## Struktura Projekta

Projekat je organizovan na sledeći način:

```css
Copy code
projekat/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── rs/
│   │   │       └── raf/
│   │   │           ├── controller/
│   │   │           ├── model/
│   │   │           └── view/
│   │   └── resources/
│   └── test/
├── assets/
│   └── images/
├── docs/
└── pom.xml
```
- src/: Glavni izvorni kod aplikacije.
- assets/: Statički resursi kao što su slike i stilovi.
- docs/: Dokumentacija projekta.
` pom.xml: Maven konfiguracioni fajl

## Zahtevi
### Opšti Zahtevi
- Redovni komitovi na GitHubu (iskomentarisani i ravnomerni).
- Obavezan README fajl sa imenom, prezimenom i brojem indeksa.
- PD Projekat sa potrebnim modelima korektno postavljen na repozitorijum.
- MVC, Observer i Singleton šabloni moraju biti korišćeni u aplikaciji.
### KT1 Zahtevi
- Implementirati zadatke sa vežbi.
- Implementirati stablo u levom panelu koristeći JTree.
- Omogućiti dodavanje, izmenu i brisanje čvorova u stablu.
- Implementirati tabove za svaku prezentaciju sa panelima za svaki slajd.
- Implementirati komponentu za rukovanje izuzecima i greškama koristeći SimpleFactory i MVC+O.
### KT2 Zahtevi
- Implementirati zadatke iz 11. nedelje vežbi.
- Definisati postojanje Slota kao “placeholder-a” za budući sadržaj.
- Implementirati State šablon za kontrolu prezentacije.
- Omogućiti deljenje prezentacija između projekata.
- Omogućiti serijalizaciju projekata koristeći Javinu serijalizaciju.
### KT3 Zahtevi
- Implementirati zadatke iz 15. nedelje vežbi.
- Omogućiti prikaz slajdova u Slideshow režimu rada.
- Implementirati mehanizam za serijalizaciju Workspace-a.
- Implementirati obradu tekstualnog sadržaja u modelu slota sa setom tagova.
## Autor
Petar Stamenić
