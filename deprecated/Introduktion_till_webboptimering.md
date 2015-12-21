#DEPRECATED: Introduktion till webboptimering
Detta dokument v�gleder informat�rer och utvecklare f�r hur webbplatser, vanliga och mobila, ska prestera och utv�rderas f�r att h�lla en acceptabel teknisk kvalitet gentemot bes�karen.

##Anledningar att optimera en webbplats
###Allt fler ansluter via mobil uppkoppling
![](https://github.com/Vastra-Gotalandsregionen/oppna-program/wiki/bilder/UI/analytics-anslutningshastighet.png)
 
I och med mobilt bredband, smarta telefoner och surfplattor har den mobila trafiken till webbplatser �kat. Ovan ser du utvecklingen f�r mobila anv�ndare p� [vard.vgregion.se](http://vard.vgregion.se ) fr�n 1:a januari 2010 till 31:a juli 2011.
*1 900* mobila bes�kare i januari 2010 v�xte till *12 500* mobila bes�kare p� ett och ett halvt �r. Vissa av dessa ansluter troligen via Wifi som ofta �r snabbare �n en vanlig mobil uppkoppling. Dock har Google Analytics �ven en vy de kallar f�r mobile carriers.
En mobil uppkoppling skiljer sig p� flera s�tt j�mf�rt med de internet-uppkopplingar m�nga av oss har hemma och p� jobbet. Dels �r de mycket l�ngsammare och har dessutom st�rre problem med m�nga samtidiga nerladdningar av filer. Exempelvis �r det vanligt att det tar en bra stund innan bes�karen ser designen p� en webbplats om det �r m�nga bildfiler som ska h�mtas.
Det �r inte ovanligt med 0,2 sekunders latens, allts� f�rdr�jning innan faktisk information kan skickas, eller mer p� ett mobilt bredband. 
Enligt [www.bredbandskollen.se](http://www.bredbandskollen.se ) har svenska folket under augusti 2011 en latens p� mellan 0,13 till 0,65 sekunder beroende p� leverant�r och abonnemang.

Beroende p� vilken webbl�sare som anv�nds har man varierande antal samtidiga anslutningar till en webbplats f�r att h�mta filer.
Som ett f�renklat r�kneexempel kan vi ta [www.vgregion.se](http://www.vgregion.se ) som har 18 bilder, 3 stilmallar, 10 javascript och HTML-koden f�r startsidan � 32 filer allt som allt. L�t s�ga att latensen �r 0,2 sekunder i genomsnitt och att webbl�saren kan hantera 3 samtidiga anslutningar.

 Formel: _(antal filer multiplicerat med latens) / antal samtidiga anslutningar = v�ntetid i sekunder utan informations�verf�ring_

 Exempel: (32 multiplicerat med 0,2 ) / 3 = 2,1 sekunder

S�g att man d� sl�r ihop stilmallarna till en enda, lyckas sammanfoga n�gra bilder till att bli 10 och kombinerar javascript till 3 filer, d� blir det ist�llet 1 sekund i v�ntetid p� alla filer som ska f�ras �ver.
F�rutom v�ntetiden m�ste man l�gga till tiden det tar att f�ra �ver filerna.
Som skr�ckexempel kan Telenors �ldre 3G-abonnemangs prestanda under augusti n�mnas. F�r dessa kunder �r det 7 sekunder i v�ntetid utan �verf�rda filer. Samma kunder skulle ha 3,3 sekunder i v�ntetid om [www.vgregion.se](http://www.vgregion.se ) kunde optimera startsidan till att bara skicka 15 filer totalt.

![](https://github.com/Vastra-Gotalandsregionen/oppna-program/wiki/bilder/UI/slowcop-timeline.png)

P� bilden ovan finns en tidslinje till h�ger som visar i vilken ordning filer laddas ner fr�n en webbplats. Kan man optimera en webbplats till att anv�nda f�rre filer kommer k�n med filer bli kortare och man sparar in tid f�r att visa webbplatsen i sin helhet f�r en bes�kare.
Med andra ord beh�ver webbplats�gare se till att de allt fler mobila bes�karna f�r en snabb upplevelse av webbplatser de bes�ker, ett arbete som �ven gynnar de med snabb uppkoppling. 
Detta g�ller f�rst�s �ven f�r intran�t s� medarbetarna f�r ett effektivt st�d.

##Snabbare sidladdning ger n�jdare bes�kare
![](https://github.com/Vastra-Gotalandsregionen/oppna-program/wiki/bilder/UI/vgregion.se-smushit.png)

Att webbsidan laddas in s� snabbt som m�jligt �r viktigt �ven om man inte upplever n�gra problem i dagsl�get. Servermilj�n kan st�ta p� prestandaproblem, det kan uppst� en krissituation som ger l�ngsam anslutning i hela landet och om d� en bes�kare ansluter via en mobiltelefon kommer det garanterat inte bli en snabb upplevelse.
Optimerar man p� f�rhand kan det bli lindrigare n�r olyckan v�l �r framme.
###Bilder
Bilden ovan visar optimeringspotentialen f�r bilderna som visas p� [www.vgregion.se](http://www.vgregion.se ), n�stan 34 % kan sk�ras bort utan att bilderna f�r n�mnv�rt s�mre bildkvalitet.

###Stilmallar och javascript
Ofta kan trafik sparas p� stilmallar och javascript genom s� kallad minifiering. Minifiering inneb�r att alla on�diga mellanrum, tomma rader med mera tas bort fr�n filer som ska skickas till bes�karna.
Dessutom s� anv�nds m�nga javascript- och CSS-filer vilket skapar en on�dig trafikstockning p� v�g till bes�karen. Oftast r�cker det med en stilmall och ett f�tal javascript-filer.

###Sl� samman bilder till CSS sprites
En annan sak att �verv�ga �r att sl� samman flera bildfiler till en genom en teknik kallad CSS sprites. Att skicka en st�rre fil g�r oftast fortare �n att skicka massor med sm�. Sprites anv�nds frekvent f�r formgivningsbilder som knappar, sm� ikoner och bakgrundsbilder.
En webbl�sare har begr�nsat med samtidiga nerladdningar av filer och d� �r det att f�redra att det inte blir en l�ng k� med designbilder n�r de gemensamt kan laddas ner parallellt med annat material.

##Sparad bandbredd �r sparade pengar
De flesta filerna p� en webbplats uppdateras inte speciellt ofta, om ens n�gonsin, efter att de v�l publicerats. Exempelvis bilder, stilmallar och javascript uppdateras v�ldigt s�llan.
Genom att l�ta webbplatsen instruera webbl�saren om dessa filers b�st f�re-datum beh�ver inte alla filer skickas med vid varje ny anslutning till webbplatsen � detta har potential att spara mycket trafik f�r servern och ge snabbare sidladdning f�r bes�karen.
Om webbservern dessutom komprimerar filerna innan de skickas �ver till bes�karen s� sparas �nnu mer tid och bandbredd. Ofta kan stilmallarna och javascripten p� en webbplats komprimeras med tiotals procent och i vissa fall med 95%. 

##Snabba webbplatser �r en f�rdel inom s�kmotoroptimering
![](https://github.com/Vastra-Gotalandsregionen/oppna-program/wiki/bilder/UI/analytics-anslutningshastighet.png)
 
Google har sedan 2009 fokuserat p� prestanda genom en vy �ver prestanda i Googles Verktyg f�r Webbansvariga. I nya versionen av Google Analytics finns ett �nnu b�ttre st�d (se bild ovan) f�r att utv�rdera webbplatsers prestanda sett fr�n faktiska bes�kares upplevelse.
Ut�ver detta jobbar de p� att webbutvecklare ska optimera webbplatser genom att kontrollera webbplatser via Google Page Speed s� inga on�diga misstag drabbar bes�karna.
Google har f�r vana att inte s�ga speciellt mycket om vad som g�r att en sida kommer h�gt i s�kresultatsidorna, mer �n att det ska l�na sig att ha en h�g kvalitet. Det �r ingen vild gissning att en h�gpresterande webbplats har en klar f�rdel.

##Beskriv informationen korrekt och hj�lp bes�karen mer
![](https://github.com/Vastra-Gotalandsregionen/oppna-program/wiki/bilder/UI/microformat.png)

Det finns m�nga nyttor med att semantiskt beskriva informationen p� en webbplats. Ett exempel finns i bilden ovan d�r bes�karen vid en Google-s�kning f�r ut�kad v�gledning fr�n sidorna som listas bland s�ktr�ffarna.
En annan nytta med samma l�sning �r att bes�karen v�l inne p� n�gon av dessa sidor kan importera respektive evenemang till sin egen kalender i datorn.
Dessa instruktioner till s�kmotorerna och webbl�sarna beh�ver inte p�verka en webbsidas utseende.
Det finns ett flertal typer av information som kan beskrivas, exempelvis:
 * Kalenderh�ndelser
 * Kontaktinformation
 * Geografisk plats
 * Recensioner

Flertalet av de st�rsta s�kmotorerna har g�tt samman om [www.schema.org](http://www.schema.org ) som en standard f�r att beskriva den data som publiceras och hj�lpa webbplats�gare att g�ra r�tt.
 
##Verktyg f�r utv�rdering
Nedan finner du exempel p� verktyg f�r att f� en bild �ver f�rb�ttringspotential under utvecklingsfasen eller optimering av en befintlig webbplats.
###Google Webmaster Tools
![](https://github.com/Vastra-Gotalandsregionen/oppna-program/wiki/bilder/UI/webmaster-tools-prestanda.png)
 
 �nskv�rt referensv�rde: 1,5 sekunder eller mindre.

Google Webmaster Tools har en vy f�r en webbplats prestanda och en �versikt f�r utvecklingen �ver tid av tiden det tar att ladda in sidor. I somliga fall kompletteras grafen med en lista med sidor och hur l�ng tid de tar att ladda in.

###Google Analytics
![](https://github.com/Vastra-Gotalandsregionen/oppna-program/wiki/bilder/UI/google-page-speed.png)

 �nskv�rt referensv�rde: 1,5 sekunder eller mindre.

Den nya versionen av Google Analytics har en vy f�r anslutningshastighet. D�r kan man dels se utveckling �ver tid och �ven sortera fram en lista med de l�ngsammaste sidorna. V�rt att t�nka p� �r att sidor kan av naturlig anledning ha olika tyngd och d�rmed ta olika tid att ladda hem.
Som alltid med Google Analytics �r det fr�mst trenden som �r intressant och till viss del att f� fram en lista p� sidor som i detta fallet kanske kan optimeras.

###Google Page Speed
![](https://github.com/Vastra-Gotalandsregionen/oppna-program/wiki/bilder/UI/google-page-speed.png)

K�rs l�mpligen i Google Chrome men finns �ven som webbl�sartill�gg f�r Firefox.

 �nskv�rt referensv�rde: 90/100 eller mer (med till�ggets standardinst�llningar).

Detta till�gg tittar p� ett flertal faktorer f�r att snabba upp en webbsida. Klickar man p� respektive rubrik f�r man listor p� problem och vad som f�resl�s som l�sning.

###YSlow fr�n Yahoo!
![](https://github.com/Vastra-Gotalandsregionen/oppna-program/wiki/bilder/UI/yslow.png)

Till�gg f�r Firefox.

 �nskv�rt referensv�rde: Grade B, eller minst 85/100.

YSlow ger betyg mellan A till F p� ett flertal olika bed�mningsgrunder och ett �vergripande betyg. F�rutom att lista vilka resurser som anv�nds, statistik om cache-hantering s� finns ocks� en del verktyg f�r att utv�rdera om bilder kan optimeras eller om det g�r att minifiera stilmallar och javascript. 

###Slowcop.com
![](https://github.com/Vastra-Gotalandsregionen/oppna-program/wiki/bilder/UI/slowcop.png)
![](https://github.com/Vastra-Gotalandsregionen/oppna-program/wiki/bilder/UI/slowcop-timeline.png)
![](https://github.com/Vastra-Gotalandsregionen/oppna-program/wiki/bilder/UI/slowcop-issues.png)

Slowcop ger en sammanst�llning �ver potentiella prestandaproblem och ett betyg, 78/100 i exemplet till h�ger.

 �nskv�rt referensv�rde: 95/100 eller mer.

H�r f�r man reda p� antalet filer som laddas hem, total storlek p� nerladdning och tiden det tar att ladda hem allt material f�r Slowcop.
Strax under visas en tidslinje upp �ver den k� av filer som beh�ver laddas hem f�r att visa webbsidan. 
Denna k� ska f�rst�s vara s� kort som m�jligt.
Det �r �ven v�rt att kontrollera andelen av lila f�rg stapeln d� det kan indikera servertekniska problem att f� iv�g informationen till bes�karen.
D�refter kommer en lista med problem upp sorterat efter hur allvarligt problemet �r. Respektive rubrik kan man klicka p� f�r mer detaljer om �nskv�rda �tg�rder.
 
###lori (Life-of-request info)
![](https://github.com/Vastra-Gotalandsregionen/oppna-program/wiki/bilder/UI/lori.png)

Lori �r ett till�gg f�r Firefox f�r att se laddningstid p� en webbplats. Den l�mpar sig b�de f�r utvecklare och n�r best�llaren verifierar en levererad webbapplikation. 

 �nskv�rt referensv�rde: 0.2 s, 2.0 s och 800KB eller mindre.

F�r varje sidvisning visar den informationen markerad med orange i ovan bild, n�mligen fr�n v�nster:
 * Tiden innan den f�rsta datan tas emot fr�n webbservern. Det indikerar tiden f�r n�r webbl�saren ges chansen att b�rja presentera n�got f�r bes�karen.
 * Tid det tog innan sidan var presenterad fullst�ndigt, allts� sidladdningstid.
 * Storleken p� allt material som beh�vs f�r att presentera sidan.
 * Antalet f�rfr�gningar till filer. Detta v�rde f�r g�rna vara l�gt, men har dock visat sig lite otillf�rlitligt och inte l�ngre s�rskilt relevant.

T�nk p� att v�rdena avspeglar hur din webbl�sare �r konfigurerar. Bland annat h�nder det att det f�rsta v�rdet �r noll d� sidan h�mtades fr�n den lokala cachen.
