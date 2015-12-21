#DEPRECATED: Riktlinjer f�r webboptimering

##Introduktion
Detta dokument v�gleder informat�rer och utvecklare f�r hur webbplatser, vanliga och mobila, ska prestera f�r att h�lla en acceptabel teknisk kvalitet gentemot bes�karen.
M�let med webboptimering �r att f� en webbplats att upplevas som snabb och funktionell f�r bes�kare, s�kmotorer med flera.
Det som avses i detta dokument �r de delar av webbplatser/webbapplikationer som en vanlig bes�kare anv�nder, allts� inte zoner f�r superanv�ndare eller systemadministrat�rer.
H�r listas dels krav p� webbplatser men ocks� rekommendationer, se rutorna med f�rgad bakgrund. De krav som en webbplats inte klarar av att leva upp till ska dokumenteras och f�rklaras f�r aktuell webbplatsansvarig.
###Laddningstid
 ####Krav:
 En webbsida ska inte ta mer �n 2 sekunder att ladda ner, redaktionellt material exkluderat, vid f�rsta bes�ket f�r en anv�ndare som sitter p� en fast uppkoppling j�mf�rbar med 8 Mbit/s ADSL.

Att en webbplats laddas in snabbt �r viktigt f�r bes�karens upplevelse, men anv�nder bes�karen en mobil uppkoppling kan �ven en normalt sett snabb webbplats bli alldeles f�r l�ngsam.
F�rutom �verf�ringshastigheten skiljer sig �ven anslutningstiden mellan en fast och en mobil internetuppkoppling.
F�r en aktuell j�mf�relse av hur svenska folkets internetuppkopplingar beter sig kan man bes�ka www.bredbandskollen.se och g� in p� statistik.
Nedan �r data fr�n 2011 f�r olika typer av uppkopplingar baserat p� de tio st�rsta leverant�rerna inom respektive typ. Hastigheten �r ett genomsnitt f�r att ladda ner sm� och stora filer, svarstiden �r hur l�ng tid det tar innan n�gon data b�rjar skickas.
| *Typ av uppkoppling* | *Nedladdningshastighet* | *Svarstid (latens)* |
| --- | --- | --- |
| 6-8 Mbit/s ADSL | 4,4-5,3 Mbit/s | 0,04-0,07 sekunder |
| 384 Kbit/s 3G | 0,07-0,31 Mbit/s | 0,2-0,9 sekunder |
| Upp till 3 Mbit/s 3G | 0,67-2,1 Mbit/s | 0,14-0,3 sekunder |

Till detta m�ste man ocks� t�nka p� att webbservern kommer att f�rdr�ja uppkopplingen. Tabellen ovan inneb�r att det f�r en bes�kare med f�rsta generationen av 3G-uppkoppling tar n�stan en sekund innan den kan ta emot en fil. �r det d� m�nga filer finns det b�de begr�nsningar p� hur m�nga anslutningar som kan �teranv�ndas och vad �verf�ringshastigheten m�ktar med.
Det kan med andra ord ta flera minuter att ladda in en sida som anv�nder n�gra javascript-bibliotek, flertalet CSS-filer, n�gra bilder och mycket text om sidan inte optimerats.
Anvisningarna i detta dokument har potential att g�ra en webbplats betydligt snabbare b�de f�r vanliga bes�kare och de med mobil uppkoppling.
##HTML-kod
 ####Krav:
 HTML-koden ska bara inneh�lla det som beh�vs f�r att fungera.

Att h�lla koden s� ren som m�jligt minskar m�ngden data som skickas och bidrar till en b�ttre upplevelse f�r bes�karen. 
Exempel p� material som inte ska finnas i HTML-koden �r taggar med kommentarer eller bort-kommenterad kod. Dessa kommentarer st�djer ofta utvecklare i deras arbete och f�r g�rna finnas i utvecklingsprojektet, men de tillf�r inget f�r bes�karen och ska inte vara med i en produktionsmilj�.
 
###Microformats, Schema.org och semantisk m�rkning
 ####Krav:
 Strukturerad information ska m�rkas upp i enlighet med g�llande semantisk praxis, exempelvis med hj�lp av Microformats eller Schema.org

Finns det exempelvis kalenderh�ndelser, kontaktinformation eller recensioner lagrad p� l�mpligt s�tt i webbplatsens system s� ska dessa m�rkas upp enligt en semantisk standard.
Semantiska standarder som rekommenderas finns att l�sa p� [www.schema.org](http://www.schema.org ) och [www.microformats.org](http://www.microformats.org ) 
##CSS
###Antal stilmallar
 ####Krav:
 Anv�nd endast en stilmall p� webbplatsen.

Om inte annat �r specificerat ska hela webbplatsen bara anv�nda en och samma stilmall. Utskriftsversion och den f�r sk�rml�ge f�r samsas i stilmallen med hj�lp av s� kallade media-queries om inte annat indikeras vid best�llningen eller finns motstridiga krav.
###Inline-CSS i HTML-koden
 ####Krav:
 Ingen CSS-kod ska finnas inkluderat i HTML-koden.

F�rutom att det underl�ttar att skilja p� form och inneh�ll genom att separera CSS och HTML s� bidrar formgivningskod i HTML till st�rre filer. Filer som tar l�ngre tid att ladda ner j�mf�rt med respektive sidas HTML-kod och en, webbl�sar-cachad, stilmall som inte ens skickas med om en ny undersida ska visas.
###Minifiering av CSS
 ####Krav:
 CSS-filer ska inte inneh�lla on�diga mellanrum, radbrytningar, kommentarer etc.

Om en CSS-fil fungerar utan on�diga mellanrum, kommentarer och radbrytningar kan man spara en hel del data som m�ste skickas till bes�karen av webbplatsen.
M�nga anv�nder YUI Compressor eller Firefix-till�gget YSlow f�r detta � se [YUI compressor](http://developer.yahoo.com/yui/compressor/ ) f�r mer information.

##Javascript
###Anv�nd CDN
 ####Krav:
 Anv�nd l�mpligt Content Delivery Network f�r javascript-bibliotek som exempelvis jQuery.

Att anv�nda ett Content Delivery Network f�r javascript inneb�r ett flertal oftast positiva saker f�r bes�karen, n�mligen att:
 * Ett CDN �r ofta, eller har potential till att vara, snabbare �n vanliga webbplatser p� att skicka filer.
 * Eventuellt beh�ver inte bes�karen ladda hem filen fr�n CDN d� denne nyligen var inne p� en annan webbplats som anv�nder samma fil fr�n samma CDN.
 * Beroende p� hur ett CDN anv�nds kan en anslutning till den egna webbplatsen frig�ras.

Det rekommenderas att f�lja g�llande praxis p� omr�det f�r vilket CDN man anv�nder och vilken version av javascript-biblioteket man v�ljer. Exempelvis finns valen f�r jQuery hos Googles CDN att k�ra med den senaste versionen av jQuery 1.6, alternativt direkt peka ut att det �r just jQuery 1.6.2 som ska anv�ndas.
Som v�gledning i valet �r att g�ra som majoriteten av webbplatser som bes�karen rimligtvis nyligen bes�kt � det �kar chansen f�r att filen redan �r i webbl�sarens cache och inte beh�ver laddas ner.
Att t�nka p� �r att om sidans adress eller inneh�ll kan best� av k�nsliga uppgifter b�r man ist�llet �verv�ga att anv�nda ett CDN man sj�lv kontrollerar.
###Antal javascript-filer
 ####Krav:
 En webbplats ska inte ha mer �n en javascript-fil ut�ver script som h�mtas fr�n etablerade CDN, annonsn�tverk eller statistiktj�nster.

F�r webbutvecklare och under testfasen av en webbapplikation �r det smidigt att separera ett eventuellt flertal av anv�nda javascript-filer. Dock �r det b�ttre f�r en, s�rskilt mobilt uppkopplad, bes�kare om det laddas ner s� f� filer som m�jligt.
Rekommendationen �r att �verv�ga olika tekniker f�r att sl� samman flera javascript-filer till en enda. I Visual Studio kan man exempelvis g�ra detta som ett byggskript n�r en kodpublicering skapas.
###Javascript ska refereras
 ####Krav:
 Javascript ska inte ligga i HTML-koden, det ska aktiveras fr�n HTML-kod men funktioner ska finnas i externa filer.

F�rutom att det underl�ttar att skilja p� funktion och inneh�ll genom att separera javascript och HTML s� bidrar javascript i HTML till st�rre filer. Filer som tar l�ngre tid att ladda ner j�mf�rt med respektive sidas HTML-kod och en av webbl�saren cachad extern javascript-fil n�r en ny undersida ska visas.
 
###Minifiering av javascript
 ####Krav:
 Javascript-filer ska inte inneh�lla on�diga mellanrum, radbrytningar, kommentarer etc.

Om en javascript-fil fungerar utan on�diga mellanrum, kommentarer och radbrytningar kan man spara en hel del data som m�ste skickas till bes�karen av webbplatsen.
YUI Compressor eller Firefix-till�gget YSlow kan hj�lpa till med att skapa en s�dan fil � se [YUI compressor](http://developer.yahoo.com/yui/compressor/ ) f�r mer information.

##Bilder
###Inte dynamisk omskalning av storlek
 ####Krav:
 Bilder som skickas till bes�karen ska inte vid f�rfr�gan skalas om innan de skickas. Inte heller omskalning med hj�lp av CSS eller HTML �r en l�sning p� annat �n avvikelser.

Det finns tre varianter av att skala om bilder vid varje sidvisning som b�r undvikas: 
 1.  Ett bildhanteringssystem som skalar om en bild innan den skickas.
 1.  Skicka en stor bild till bes�karen och g�ra den mindre stor med CSS.
 1.  Stor bild skickas och skalas ner med HTML-attribut.
Den f�rsta kan fungera om den tekniska l�sningen inneh�ller en effektiv cache, annars l�gger man p� on�dig v�ntetid innan bilden kan skickas. Tv�an och trean �r aldrig en bra id� d� det inneb�r att en on�digt tr�gladdad bild skickas till varje bes�kare.
Dock �r det ok med _overflow: hidden;_ och att s�tta en �vre gr�ns f�r bilder storlek inom ett element via CSS.
###Kombinera formgivningsbilder
 ####Krav:
 CSS sprites ska �verv�gas f�r bilder som inte �r av redaktionell natur, exempelvis knappar, logotyper, bakgrunder etc.

M�nga moderna webbplatser �r rikligt formgivna med ikoner, egendesignade knappar och andra bilder.
Ofta g�r det att �tminstone halvera antalet bilder p� sidan genom att sl� ihop flera filer till en st�rre. Vinsten �r att en st�rre fil s� gott som alltid g�r snabbare att ladda hem �n flera filer som tillsammans �r lika stora.
F�r att utf�ra detta kan man antingen manuellt skapa bilderna i bildbehandlingsprogram eller ge tj�nster som [Spriteme.org](http://www.spriteme.org ) en chans att skapa bild/CSS �t en.
###Bilder ska optimeras
 ####Krav:
 En bildfil ska inte vara on�digt stor. Leverant�ren av en webbapplikation ansvarar f�r att optimering g�rs p� bilder som f�ljer med designen.

![](https://github.com/Vastra-Gotalandsregionen/oppna-program/wiki/bilder/UI/vgregion.se-smushit.png)

N�stan alla webbplatser har bilder som kan g�ras mindre utan en kvalitetsf�rlust som g�r att se med blotta �gat. S�rskilt bilder som har med formgivningen att g�ra beh�ver testas f�r sin filstorlek d� de �terkommer p� de flesta undersidorna p� en webbplats.
Ett bra verktyg f�r detta �r Yahoos Smush.it som l�mpligen k�rs via Firefox-till�gget YSlow � d�r kollar den alla bilder som anv�nds p� en undersida.

##Cache och komprimering
###Expiration date
 ####Krav:
 Standardinst�llningen ska vara att samtliga filer har ett utg�ngsdatum p� 30 dagar. Undantag g�rs f�r filer som troligen kommer uppdateras under den tiden.

Expiration date anv�nds f�r att tala om f�r webbl�saren vilka filer den ska ladda ner och hur l�nge de filerna anses vara aktuella. Om denna funktion anv�nds korrekt kommer f�rre filer skickas till bes�karen och ge en snabbare upplevelse. Dessutom sparar man bandbredd till servern och det i sig kan ge b�ttre prestanda vid trafiktoppar.

###ETags
 ####Krav:
 ETags ska beaktas om webbplatsen drivs p� flera olika webbservrar.

ETags �r en form av signatur f�r att identifiera en fil. Det �r fr�mst ett s�tt att f�rs�ka undvika problem n�r webbplatsen ligger i en skalbar milj� ist�llet f�r en enskild webbserver

###Komprimera statiska och dynamiska filer
 ####Krav:
 Alla filer som skickas fr�n webbservern ska vara i ett komprimerat format.

GZip �r en popul�r komprimeringsl�sning f�r b�de �ppna och propriet�ra webbservrar. Cirka 70% av storleken p� text-baserade filer �r m�jlig att spara in och cirka 90% av dagens webbl�sare (enligt Yahoo) st�djer denna typ av komprimering.
 
##Verktyg f�r att utv�rdera optimering
###YSlow
![](https://github.com/Vastra-Gotalandsregionen/oppna-program/wiki/bilder/UI/yslow.png)

[://addons.mozilla.org/en-US/firefox/addon/yslow/ YSlow](https) �r ett till�gg till webbl�saren Firefox. Med YSlow f�r man en �versikt f�r merparten av de tekniska aspekterna p� en webbplats genom ett betyg p� A � F per problemomr�de.
Ett �vergripande betyg och ett nummer f�r j�mf�relse - Grade D och 69/100 i exemplet ovan.
Under fliken Tools finns verktyg f�r att minifiera javascript och CSS, Smush.it f�r optimering av bilder och annat nyttigt.

###Google Page Speed 
![](https://github.com/Vastra-Gotalandsregionen/oppna-program/wiki/bilder/UI/page-speed-goteborg-se.png)

[Google Page Speed](http://code.google.com/speed/page-speed/download.html ) finns som till�gg till Firefox och Google Chrome, dock rekommenderas man k�ra den i Chrome f�r b�sta tillf�rlitlighet.
Detta verktyg ger ett page speed score och listar eventuella problemomr�den p� detaljniv�.

###lori (Life-of-request info)
![](https://github.com/Vastra-Gotalandsregionen/oppna-program/wiki/bilder/UI/lori.png)

[://addons.mozilla.org/en-US/firefox/addon/lori-life-of-request-info/ Lori](https) �r ett till�gg f�r Firefox f�r att se laddningstid p� en webbplats. Den l�mpar sig b�de f�r utvecklare och n�r best�llaren verifierar en levererad webbapplikation. 
F�r varje sidvisning visar den informationen markerad med orange i ovan bild, n�mligen fr�n v�nster:
 * Tiden innan den f�rsta datan tas emot fr�n webbservern. Det indikerar tiden f�r n�r webbl�saren ges chansen att b�rja presentera n�got f�r bes�karen.
 * Tid det tog innan sidan var presenterad fullst�ndigt, allts� sidladdningstid.
 * Storleken p� allt material som beh�vs f�r att presentera sidan.
 * Antalet f�rfr�gningar till filer. Detta v�rde f�r g�rna vara l�gt, men har dock visat sig lite otillf�rlitligt och inte l�ngre s�rskilt relevant.

###Slowcop.com
![](https://github.com/Vastra-Gotalandsregionen/oppna-program/wiki/bilder/UI/slowcop.png)

[Slowcop](http://www.slowcop.com ) f�rs�ker ge en sammanst�llning och kombinerar faktorer fr�n Google Page Speed med en tidslinje �ver filer som laddas ner. Mycket bra verktyg �ven f�r de som inte �r speciellt tekniskt lagda eller om man g�rna undviker till�gg i webbl�saren.
