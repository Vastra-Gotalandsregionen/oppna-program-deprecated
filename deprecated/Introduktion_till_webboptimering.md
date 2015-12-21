#DEPRECATED: Introduktion till webboptimering
Detta dokument vägleder informatörer och utvecklare för hur webbplatser, vanliga och mobila, ska prestera och utvärderas för att hålla en acceptabel teknisk kvalitet gentemot besökaren.

##Anledningar att optimera en webbplats
###Allt fler ansluter via mobil uppkoppling
![](https://github.com/Vastra-Gotalandsregionen/oppna-program/wiki/bilder/UI/analytics-anslutningshastighet.png)
 
I och med mobilt bredband, smarta telefoner och surfplattor har den mobila trafiken till webbplatser ökat. Ovan ser du utvecklingen för mobila användare på [vard.vgregion.se](http://vard.vgregion.se ) från 1:a januari 2010 till 31:a juli 2011.
*1 900* mobila besökare i januari 2010 växte till *12 500* mobila besökare på ett och ett halvt år. Vissa av dessa ansluter troligen via Wifi som ofta är snabbare än en vanlig mobil uppkoppling. Dock har Google Analytics även en vy de kallar för mobile carriers.
En mobil uppkoppling skiljer sig på flera sätt jämfört med de internet-uppkopplingar många av oss har hemma och på jobbet. Dels är de mycket långsammare och har dessutom större problem med många samtidiga nerladdningar av filer. Exempelvis är det vanligt att det tar en bra stund innan besökaren ser designen på en webbplats om det är många bildfiler som ska hämtas.
Det är inte ovanligt med 0,2 sekunders latens, alltså fördröjning innan faktisk information kan skickas, eller mer på ett mobilt bredband. 
Enligt [www.bredbandskollen.se](http://www.bredbandskollen.se ) har svenska folket under augusti 2011 en latens på mellan 0,13 till 0,65 sekunder beroende på leverantör och abonnemang.

Beroende på vilken webbläsare som används har man varierande antal samtidiga anslutningar till en webbplats för att hämta filer.
Som ett förenklat räkneexempel kan vi ta [www.vgregion.se](http://www.vgregion.se ) som har 18 bilder, 3 stilmallar, 10 javascript och HTML-koden för startsidan ñ 32 filer allt som allt. Låt säga att latensen är 0,2 sekunder i genomsnitt och att webbläsaren kan hantera 3 samtidiga anslutningar.

 Formel: _(antal filer multiplicerat med latens) / antal samtidiga anslutningar = väntetid i sekunder utan informationsöverföring_

 Exempel: (32 multiplicerat med 0,2 ) / 3 = 2,1 sekunder

Säg att man då slår ihop stilmallarna till en enda, lyckas sammanfoga några bilder till att bli 10 och kombinerar javascript till 3 filer, då blir det istället 1 sekund i väntetid på alla filer som ska föras över.
Förutom väntetiden måste man lägga till tiden det tar att föra över filerna.
Som skräckexempel kan Telenors äldre 3G-abonnemangs prestanda under augusti nämnas. För dessa kunder är det 7 sekunder i väntetid utan överförda filer. Samma kunder skulle ha 3,3 sekunder i väntetid om [www.vgregion.se](http://www.vgregion.se ) kunde optimera startsidan till att bara skicka 15 filer totalt.

![](https://github.com/Vastra-Gotalandsregionen/oppna-program/wiki/bilder/UI/slowcop-timeline.png)

På bilden ovan finns en tidslinje till höger som visar i vilken ordning filer laddas ner från en webbplats. Kan man optimera en webbplats till att använda färre filer kommer kön med filer bli kortare och man sparar in tid för att visa webbplatsen i sin helhet för en besökare.
Med andra ord behöver webbplatsägare se till att de allt fler mobila besökarna får en snabb upplevelse av webbplatser de besöker, ett arbete som även gynnar de med snabb uppkoppling. 
Detta gäller förstås även för intranät så medarbetarna får ett effektivt stöd.

##Snabbare sidladdning ger nöjdare besökare
![](https://github.com/Vastra-Gotalandsregionen/oppna-program/wiki/bilder/UI/vgregion.se-smushit.png)

Att webbsidan laddas in så snabbt som möjligt är viktigt även om man inte upplever några problem i dagsläget. Servermiljön kan stöta på prestandaproblem, det kan uppstå en krissituation som ger långsam anslutning i hela landet och om då en besökare ansluter via en mobiltelefon kommer det garanterat inte bli en snabb upplevelse.
Optimerar man på förhand kan det bli lindrigare när olyckan väl är framme.
###Bilder
Bilden ovan visar optimeringspotentialen för bilderna som visas på [www.vgregion.se](http://www.vgregion.se ), nästan 34 % kan skäras bort utan att bilderna får nämnvärt sämre bildkvalitet.

###Stilmallar och javascript
Ofta kan trafik sparas på stilmallar och javascript genom så kallad minifiering. Minifiering innebär att alla onödiga mellanrum, tomma rader med mera tas bort från filer som ska skickas till besökarna.
Dessutom så används många javascript- och CSS-filer vilket skapar en onödig trafikstockning på väg till besökaren. Oftast räcker det med en stilmall och ett fåtal javascript-filer.

###Slå samman bilder till CSS sprites
En annan sak att överväga är att slå samman flera bildfiler till en genom en teknik kallad CSS sprites. Att skicka en större fil går oftast fortare än att skicka massor med små. Sprites används frekvent för formgivningsbilder som knappar, små ikoner och bakgrundsbilder.
En webbläsare har begränsat med samtidiga nerladdningar av filer och då är det att föredra att det inte blir en lång kö med designbilder när de gemensamt kan laddas ner parallellt med annat material.

##Sparad bandbredd är sparade pengar
De flesta filerna på en webbplats uppdateras inte speciellt ofta, om ens någonsin, efter att de väl publicerats. Exempelvis bilder, stilmallar och javascript uppdateras väldigt sällan.
Genom att låta webbplatsen instruera webbläsaren om dessa filers bäst före-datum behöver inte alla filer skickas med vid varje ny anslutning till webbplatsen ñ detta har potential att spara mycket trafik för servern och ge snabbare sidladdning för besökaren.
Om webbservern dessutom komprimerar filerna innan de skickas över till besökaren så sparas ännu mer tid och bandbredd. Ofta kan stilmallarna och javascripten på en webbplats komprimeras med tiotals procent och i vissa fall med 95%. 

##Snabba webbplatser är en fördel inom sökmotoroptimering
![](https://github.com/Vastra-Gotalandsregionen/oppna-program/wiki/bilder/UI/analytics-anslutningshastighet.png)
 
Google har sedan 2009 fokuserat på prestanda genom en vy över prestanda i Googles Verktyg för Webbansvariga. I nya versionen av Google Analytics finns ett ännu bättre stöd (se bild ovan) för att utvärdera webbplatsers prestanda sett från faktiska besökares upplevelse.
Utöver detta jobbar de på att webbutvecklare ska optimera webbplatser genom att kontrollera webbplatser via Google Page Speed så inga onödiga misstag drabbar besökarna.
Google har för vana att inte säga speciellt mycket om vad som gör att en sida kommer högt i sökresultatsidorna, mer än att det ska löna sig att ha en hög kvalitet. Det är ingen vild gissning att en högpresterande webbplats har en klar fördel.

##Beskriv informationen korrekt och hjälp besökaren mer
![](https://github.com/Vastra-Gotalandsregionen/oppna-program/wiki/bilder/UI/microformat.png)

Det finns många nyttor med att semantiskt beskriva informationen på en webbplats. Ett exempel finns i bilden ovan där besökaren vid en Google-sökning får utökad vägledning från sidorna som listas bland sökträffarna.
En annan nytta med samma lösning är att besökaren väl inne på någon av dessa sidor kan importera respektive evenemang till sin egen kalender i datorn.
Dessa instruktioner till sökmotorerna och webbläsarna behöver inte påverka en webbsidas utseende.
Det finns ett flertal typer av information som kan beskrivas, exempelvis:
 * Kalenderhändelser
 * Kontaktinformation
 * Geografisk plats
 * Recensioner

Flertalet av de största sökmotorerna har gått samman om [www.schema.org](http://www.schema.org ) som en standard för att beskriva den data som publiceras och hjälpa webbplatsägare att göra rätt.
 
##Verktyg för utvärdering
Nedan finner du exempel på verktyg för att få en bild över förbättringspotential under utvecklingsfasen eller optimering av en befintlig webbplats.
###Google Webmaster Tools
![](https://github.com/Vastra-Gotalandsregionen/oppna-program/wiki/bilder/UI/webmaster-tools-prestanda.png)
 
 ÷nskvärt referensvärde: 1,5 sekunder eller mindre.

Google Webmaster Tools har en vy för en webbplats prestanda och en översikt för utvecklingen över tid av tiden det tar att ladda in sidor. I somliga fall kompletteras grafen med en lista med sidor och hur lång tid de tar att ladda in.

###Google Analytics
![](https://github.com/Vastra-Gotalandsregionen/oppna-program/wiki/bilder/UI/google-page-speed.png)

 ÷nskvärt referensvärde: 1,5 sekunder eller mindre.

Den nya versionen av Google Analytics har en vy för anslutningshastighet. Där kan man dels se utveckling över tid och även sortera fram en lista med de långsammaste sidorna. Värt att tänka på är att sidor kan av naturlig anledning ha olika tyngd och därmed ta olika tid att ladda hem.
Som alltid med Google Analytics är det främst trenden som är intressant och till viss del att få fram en lista på sidor som i detta fallet kanske kan optimeras.

###Google Page Speed
![](https://github.com/Vastra-Gotalandsregionen/oppna-program/wiki/bilder/UI/google-page-speed.png)

Körs lämpligen i Google Chrome men finns även som webbläsartillägg för Firefox.

 ÷nskvärt referensvärde: 90/100 eller mer (med tilläggets standardinställningar).

Detta tillägg tittar på ett flertal faktorer för att snabba upp en webbsida. Klickar man på respektive rubrik får man listor på problem och vad som föreslås som lösning.

###YSlow från Yahoo!
![](https://github.com/Vastra-Gotalandsregionen/oppna-program/wiki/bilder/UI/yslow.png)

Tillägg för Firefox.

 ÷nskvärt referensvärde: Grade B, eller minst 85/100.

YSlow ger betyg mellan A till F på ett flertal olika bedömningsgrunder och ett övergripande betyg. Förutom att lista vilka resurser som används, statistik om cache-hantering så finns också en del verktyg för att utvärdera om bilder kan optimeras eller om det går att minifiera stilmallar och javascript. 

###Slowcop.com
![](https://github.com/Vastra-Gotalandsregionen/oppna-program/wiki/bilder/UI/slowcop.png)
![](https://github.com/Vastra-Gotalandsregionen/oppna-program/wiki/bilder/UI/slowcop-timeline.png)
![](https://github.com/Vastra-Gotalandsregionen/oppna-program/wiki/bilder/UI/slowcop-issues.png)

Slowcop ger en sammanställning över potentiella prestandaproblem och ett betyg, 78/100 i exemplet till höger.

 ÷nskvärt referensvärde: 95/100 eller mer.

Här får man reda på antalet filer som laddas hem, total storlek på nerladdning och tiden det tar att ladda hem allt material för Slowcop.
Strax under visas en tidslinje upp över den kö av filer som behöver laddas hem för att visa webbsidan. 
Denna kö ska förstås vara så kort som möjligt.
Det är även värt att kontrollera andelen av lila färg stapeln då det kan indikera servertekniska problem att få iväg informationen till besökaren.
Därefter kommer en lista med problem upp sorterat efter hur allvarligt problemet är. Respektive rubrik kan man klicka på för mer detaljer om önskvärda åtgärder.
 
###lori (Life-of-request info)
![](https://github.com/Vastra-Gotalandsregionen/oppna-program/wiki/bilder/UI/lori.png)

Lori är ett tillägg för Firefox för att se laddningstid på en webbplats. Den lämpar sig både för utvecklare och när beställaren verifierar en levererad webbapplikation. 

 ÷nskvärt referensvärde: 0.2 s, 2.0 s och 800KB eller mindre.

För varje sidvisning visar den informationen markerad med orange i ovan bild, nämligen från vänster:
 * Tiden innan den första datan tas emot från webbservern. Det indikerar tiden för när webbläsaren ges chansen att börja presentera något för besökaren.
 * Tid det tog innan sidan var presenterad fullständigt, alltså sidladdningstid.
 * Storleken på allt material som behövs för att presentera sidan.
 * Antalet förfrågningar till filer. Detta värde får gärna vara lågt, men har dock visat sig lite otillförlitligt och inte längre särskilt relevant.

Tänk på att värdena avspeglar hur din webbläsare är konfigurerar. Bland annat händer det att det första värdet är noll då sidan hämtades från den lokala cachen.
