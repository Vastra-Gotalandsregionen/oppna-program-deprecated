#DEPRECATED: Riktlinjer för webboptimering

##Introduktion
Detta dokument vägleder informatörer och utvecklare för hur webbplatser, vanliga och mobila, ska prestera för att hålla en acceptabel teknisk kvalitet gentemot besökaren.
Målet med webboptimering är att få en webbplats att upplevas som snabb och funktionell för besökare, sökmotorer med flera.
Det som avses i detta dokument är de delar av webbplatser/webbapplikationer som en vanlig besökare använder, alltså inte zoner för superanvändare eller systemadministratörer.
Här listas dels krav på webbplatser men också rekommendationer, se rutorna med färgad bakgrund. De krav som en webbplats inte klarar av att leva upp till ska dokumenteras och förklaras för aktuell webbplatsansvarig.
###Laddningstid
 ####Krav:
 En webbsida ska inte ta mer än 2 sekunder att ladda ner, redaktionellt material exkluderat, vid första besöket för en användare som sitter på en fast uppkoppling jämförbar med 8 Mbit/s ADSL.

Att en webbplats laddas in snabbt är viktigt för besökarens upplevelse, men använder besökaren en mobil uppkoppling kan även en normalt sett snabb webbplats bli alldeles för långsam.
Förutom överföringshastigheten skiljer sig även anslutningstiden mellan en fast och en mobil internetuppkoppling.
För en aktuell jämförelse av hur svenska folkets internetuppkopplingar beter sig kan man besöka www.bredbandskollen.se och gå in på statistik.
Nedan är data från 2011 för olika typer av uppkopplingar baserat på de tio största leverantörerna inom respektive typ. Hastigheten är ett genomsnitt för att ladda ner små och stora filer, svarstiden är hur lång tid det tar innan någon data börjar skickas.
| *Typ av uppkoppling* | *Nedladdningshastighet* | *Svarstid (latens)* |
| --- | --- | --- |
| 6-8 Mbit/s ADSL | 4,4-5,3 Mbit/s | 0,04-0,07 sekunder |
| 384 Kbit/s 3G | 0,07-0,31 Mbit/s | 0,2-0,9 sekunder |
| Upp till 3 Mbit/s 3G | 0,67-2,1 Mbit/s | 0,14-0,3 sekunder |

Till detta måste man också tänka på att webbservern kommer att fördröja uppkopplingen. Tabellen ovan innebär att det för en besökare med första generationen av 3G-uppkoppling tar nästan en sekund innan den kan ta emot en fil. Är det då många filer finns det både begränsningar på hur många anslutningar som kan återanvändas och vad överföringshastigheten mäktar med.
Det kan med andra ord ta flera minuter att ladda in en sida som använder några javascript-bibliotek, flertalet CSS-filer, några bilder och mycket text om sidan inte optimerats.
Anvisningarna i detta dokument har potential att göra en webbplats betydligt snabbare både för vanliga besökare och de med mobil uppkoppling.
##HTML-kod
 ####Krav:
 HTML-koden ska bara innehålla det som behövs för att fungera.

Att hålla koden så ren som möjligt minskar mängden data som skickas och bidrar till en bättre upplevelse för besökaren. 
Exempel på material som inte ska finnas i HTML-koden är taggar med kommentarer eller bort-kommenterad kod. Dessa kommentarer stödjer ofta utvecklare i deras arbete och får gärna finnas i utvecklingsprojektet, men de tillför inget för besökaren och ska inte vara med i en produktionsmiljö.
 
###Microformats, Schema.org och semantisk märkning
 ####Krav:
 Strukturerad information ska märkas upp i enlighet med gällande semantisk praxis, exempelvis med hjälp av Microformats eller Schema.org

Finns det exempelvis kalenderhändelser, kontaktinformation eller recensioner lagrad på lämpligt sätt i webbplatsens system så ska dessa märkas upp enligt en semantisk standard.
Semantiska standarder som rekommenderas finns att läsa på [www.schema.org](http://www.schema.org ) och [www.microformats.org](http://www.microformats.org ) 
##CSS
###Antal stilmallar
 ####Krav:
 Använd endast en stilmall på webbplatsen.

Om inte annat är specificerat ska hela webbplatsen bara använda en och samma stilmall. Utskriftsversion och den för skärmläge får samsas i stilmallen med hjälp av så kallade media-queries om inte annat indikeras vid beställningen eller finns motstridiga krav.
###Inline-CSS i HTML-koden
 ####Krav:
 Ingen CSS-kod ska finnas inkluderat i HTML-koden.

Förutom att det underlättar att skilja på form och innehåll genom att separera CSS och HTML så bidrar formgivningskod i HTML till större filer. Filer som tar längre tid att ladda ner jämfört med respektive sidas HTML-kod och en, webbläsar-cachad, stilmall som inte ens skickas med om en ny undersida ska visas.
###Minifiering av CSS
 ####Krav:
 CSS-filer ska inte innehålla onödiga mellanrum, radbrytningar, kommentarer etc.

Om en CSS-fil fungerar utan onödiga mellanrum, kommentarer och radbrytningar kan man spara en hel del data som måste skickas till besökaren av webbplatsen.
Många använder YUI Compressor eller Firefix-tillägget YSlow för detta – se [YUI compressor](http://developer.yahoo.com/yui/compressor/ ) för mer information.

##Javascript
###Använd CDN
 ####Krav:
 Använd lämpligt Content Delivery Network för javascript-bibliotek som exempelvis jQuery.

Att använda ett Content Delivery Network för javascript innebär ett flertal oftast positiva saker för besökaren, nämligen att:
 * Ett CDN är ofta, eller har potential till att vara, snabbare än vanliga webbplatser på att skicka filer.
 * Eventuellt behöver inte besökaren ladda hem filen från CDN då denne nyligen var inne på en annan webbplats som använder samma fil från samma CDN.
 * Beroende på hur ett CDN används kan en anslutning till den egna webbplatsen frigöras.

Det rekommenderas att följa gällande praxis på området för vilket CDN man använder och vilken version av javascript-biblioteket man väljer. Exempelvis finns valen för jQuery hos Googles CDN att köra med den senaste versionen av jQuery 1.6, alternativt direkt peka ut att det är just jQuery 1.6.2 som ska användas.
Som vägledning i valet är att göra som majoriteten av webbplatser som besökaren rimligtvis nyligen besökt – det ökar chansen för att filen redan är i webbläsarens cache och inte behöver laddas ner.
Att tänka på är att om sidans adress eller innehåll kan bestå av känsliga uppgifter bör man istället överväga att använda ett CDN man själv kontrollerar.
###Antal javascript-filer
 ####Krav:
 En webbplats ska inte ha mer än en javascript-fil utöver script som hämtas från etablerade CDN, annonsnätverk eller statistiktjänster.

För webbutvecklare och under testfasen av en webbapplikation är det smidigt att separera ett eventuellt flertal av använda javascript-filer. Dock är det bättre för en, särskilt mobilt uppkopplad, besökare om det laddas ner så få filer som möjligt.
Rekommendationen är att överväga olika tekniker för att slå samman flera javascript-filer till en enda. I Visual Studio kan man exempelvis göra detta som ett byggskript när en kodpublicering skapas.
###Javascript ska refereras
 ####Krav:
 Javascript ska inte ligga i HTML-koden, det ska aktiveras från HTML-kod men funktioner ska finnas i externa filer.

Förutom att det underlättar att skilja på funktion och innehåll genom att separera javascript och HTML så bidrar javascript i HTML till större filer. Filer som tar längre tid att ladda ner jämfört med respektive sidas HTML-kod och en av webbläsaren cachad extern javascript-fil när en ny undersida ska visas.
 
###Minifiering av javascript
 ####Krav:
 Javascript-filer ska inte innehålla onödiga mellanrum, radbrytningar, kommentarer etc.

Om en javascript-fil fungerar utan onödiga mellanrum, kommentarer och radbrytningar kan man spara en hel del data som måste skickas till besökaren av webbplatsen.
YUI Compressor eller Firefix-tillägget YSlow kan hjälpa till med att skapa en sådan fil – se [YUI compressor](http://developer.yahoo.com/yui/compressor/ ) för mer information.

##Bilder
###Inte dynamisk omskalning av storlek
 ####Krav:
 Bilder som skickas till besökaren ska inte vid förfrågan skalas om innan de skickas. Inte heller omskalning med hjälp av CSS eller HTML är en lösning på annat än avvikelser.

Det finns tre varianter av att skala om bilder vid varje sidvisning som bör undvikas: 
 1.  Ett bildhanteringssystem som skalar om en bild innan den skickas.
 1.  Skicka en stor bild till besökaren och göra den mindre stor med CSS.
 1.  Stor bild skickas och skalas ner med HTML-attribut.
Den första kan fungera om den tekniska lösningen innehåller en effektiv cache, annars lägger man på onödig väntetid innan bilden kan skickas. Tvåan och trean är aldrig en bra idé då det innebär att en onödigt trögladdad bild skickas till varje besökare.
Dock är det ok med _overflow: hidden;_ och att sätta en övre gräns för bilder storlek inom ett element via CSS.
###Kombinera formgivningsbilder
 ####Krav:
 CSS sprites ska övervägas för bilder som inte är av redaktionell natur, exempelvis knappar, logotyper, bakgrunder etc.

Många moderna webbplatser är rikligt formgivna med ikoner, egendesignade knappar och andra bilder.
Ofta går det att åtminstone halvera antalet bilder på sidan genom att slå ihop flera filer till en större. Vinsten är att en större fil så gott som alltid går snabbare att ladda hem än flera filer som tillsammans är lika stora.
För att utföra detta kan man antingen manuellt skapa bilderna i bildbehandlingsprogram eller ge tjänster som [Spriteme.org](http://www.spriteme.org ) en chans att skapa bild/CSS åt en.
###Bilder ska optimeras
 ####Krav:
 En bildfil ska inte vara onödigt stor. Leverantören av en webbapplikation ansvarar för att optimering görs på bilder som följer med designen.

![](https://github.com/Vastra-Gotalandsregionen/oppna-program/wiki/bilder/UI/vgregion.se-smushit.png)

Nästan alla webbplatser har bilder som kan göras mindre utan en kvalitetsförlust som går att se med blotta ögat. Särskilt bilder som har med formgivningen att göra behöver testas för sin filstorlek då de återkommer på de flesta undersidorna på en webbplats.
Ett bra verktyg för detta är Yahoos Smush.it som lämpligen körs via Firefox-tillägget YSlow – där kollar den alla bilder som används på en undersida.

##Cache och komprimering
###Expiration date
 ####Krav:
 Standardinställningen ska vara att samtliga filer har ett utgångsdatum på 30 dagar. Undantag görs för filer som troligen kommer uppdateras under den tiden.

Expiration date används för att tala om för webbläsaren vilka filer den ska ladda ner och hur länge de filerna anses vara aktuella. Om denna funktion används korrekt kommer färre filer skickas till besökaren och ge en snabbare upplevelse. Dessutom sparar man bandbredd till servern och det i sig kan ge bättre prestanda vid trafiktoppar.

###ETags
 ####Krav:
 ETags ska beaktas om webbplatsen drivs på flera olika webbservrar.

ETags är en form av signatur för att identifiera en fil. Det är främst ett sätt att försöka undvika problem när webbplatsen ligger i en skalbar miljö istället för en enskild webbserver

###Komprimera statiska och dynamiska filer
 ####Krav:
 Alla filer som skickas från webbservern ska vara i ett komprimerat format.

GZip är en populär komprimeringslösning för både öppna och proprietära webbservrar. Cirka 70% av storleken på text-baserade filer är möjlig att spara in och cirka 90% av dagens webbläsare (enligt Yahoo) stödjer denna typ av komprimering.
 
##Verktyg för att utvärdera optimering
###YSlow
![](https://github.com/Vastra-Gotalandsregionen/oppna-program/wiki/bilder/UI/yslow.png)

[://addons.mozilla.org/en-US/firefox/addon/yslow/ YSlow](https) är ett tillägg till webbläsaren Firefox. Med YSlow får man en översikt för merparten av de tekniska aspekterna på en webbplats genom ett betyg på A – F per problemområde.
Ett övergripande betyg och ett nummer för jämförelse - Grade D och 69/100 i exemplet ovan.
Under fliken Tools finns verktyg för att minifiera javascript och CSS, Smush.it för optimering av bilder och annat nyttigt.

###Google Page Speed 
![](https://github.com/Vastra-Gotalandsregionen/oppna-program/wiki/bilder/UI/page-speed-goteborg-se.png)

[Google Page Speed](http://code.google.com/speed/page-speed/download.html ) finns som tillägg till Firefox och Google Chrome, dock rekommenderas man köra den i Chrome för bästa tillförlitlighet.
Detta verktyg ger ett page speed score och listar eventuella problemområden på detaljnivå.

###lori (Life-of-request info)
![](https://github.com/Vastra-Gotalandsregionen/oppna-program/wiki/bilder/UI/lori.png)

[://addons.mozilla.org/en-US/firefox/addon/lori-life-of-request-info/ Lori](https) är ett tillägg för Firefox för att se laddningstid på en webbplats. Den lämpar sig både för utvecklare och när beställaren verifierar en levererad webbapplikation. 
För varje sidvisning visar den informationen markerad med orange i ovan bild, nämligen från vänster:
 * Tiden innan den första datan tas emot från webbservern. Det indikerar tiden för när webbläsaren ges chansen att börja presentera något för besökaren.
 * Tid det tog innan sidan var presenterad fullständigt, alltså sidladdningstid.
 * Storleken på allt material som behövs för att presentera sidan.
 * Antalet förfrågningar till filer. Detta värde får gärna vara lågt, men har dock visat sig lite otillförlitligt och inte längre särskilt relevant.

###Slowcop.com
![](https://github.com/Vastra-Gotalandsregionen/oppna-program/wiki/bilder/UI/slowcop.png)

[Slowcop](http://www.slowcop.com ) försöker ge en sammanställning och kombinerar faktorer från Google Page Speed med en tidslinje över filer som laddas ner. Mycket bra verktyg även för de som inte är speciellt tekniskt lagda eller om man gärna undviker tillägg i webbläsaren.
