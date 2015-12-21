



#DEPRECATED: Riktlinjer f�r mobila webbplatser

##Sammanfattning
_Riktlinjer f�r utveckling av webbl�sningar som �r anpassade f�r anv�ndning p� mobiltelefoner och andra enheter med liten sk�rm eller peksk�rm._

_Dokumentets m�lgrupp best�r i f�rsta hand av utvecklare med gr�nssnittsinriktning som beh�ver r�d och riktlinjer vid utveckling av webbaserade l�sningar f�r mobila enheter._

##Inledning
I stort g�ller samma riktlinjer som vid gr�nssnittsutveckling f�r desktopdatorer, det vill s�ga f�lj webbstandarder, bygg tillg�ngligt och separera struktur, presentation och beteende med hj�lp av progressive enhancement.

Ut�ver detta finns n�gra saker man beh�ver t�nka p� f�r att f� gr�nssnitt som fungerar bra n�r anv�ndaren har en liten sk�rm och/eller interagerar via peksk�rm i st�llet f�r mus eller tangentbord.

##Sk�rmstorlek
N�r det g�ller sk�rmstorlek f�r den typ av mobila enheter som ing�r i dagens m�lgrupp varierar den fr�n 320 x 480 pixlar upp till 1024 x 768 pixlar beroende p� enhet och rotation.

Det som �r gemensamt �r att anv�ndaren inte kan �ndra f�nsterstorleken p� sin webbl�sare, utan den tar upp hela sk�rmytan.

F�r att s� l�ngt det g�r undvika att webbl�saren sj�lv anpassar inneh�llet till den tillg�ngliga ytan genom att zooma ut kan man v�lja tv� v�gar: flexibel bredd eller Media Queries.

###Flexibel bredd
Genom att undvika att s�tta fasta bredder f�r man en layout som sj�lv anpassar sig efter den tillg�ngliga ytan. F�rdelen �r att den fungerar �verallt. Nackdelen �r att man kan f� en v�ldigt ihoptryckt layout p� smala displayer och v�ldigt l�nga textrader p� breda displayer.

###Media Queries
En teknik som ger st�rre m�jlighet till anpassning f�r olika bredder �r CSS-modulen [Media Queries](http://www.w3.org/TR/css3-mediaqueries/ ), som st�ds av de webbl�sare som anv�nds i de flesta moderna smartphones. Med hj�lp av Media Queries kan man byta layout drastiskt vid olika f�nsterbredder, vilket g�r att man till exempel kan byta fr�n en enspaltslayout p� en iPhone i st�ende l�ge till en trespaltslayout p� en iPad i liggande l�ge.

Man kan ocks� kombinera media queries med flexibel bredd f�r att optimera layouten f�r bredder som ligger mellan de fasta steg man anpassar f�r (vilket �r vanligt med desktopwebbl�sare).

L�mpliga bredder att kontrollera sin layout vid n�r man anv�nder Media Queries �r f�ljande:

  * 320px (iPhone, iPod Touch i st�ende l�ge)
  * 480px (iPhone, iPod Touch i liggande l�ge)
  * 768px (iPad i st�ende l�ge)
  * 1024px (iPad i liggande l�ge)

Ut�ver det �r det l�mpligt att bygga layouten s� att den fungerar bra �ven vid andra m�tt, men dessa �r fasta m�tt som ber�r de aktuella m�lplattformarna.

##Peksk�rmar

###St�rre tr�ffytor
N�r man anv�nder enheter med peksk�rm har man inte samma finkontroll av var man "klickar" eftersom det inte finns n�gon muspekare och en fingertopp ger en betydligt st�rre tr�ffyta �n en muspekare. D�rf�r �r det bra att g�ra klick/tr�ffytor st�rre s� de blir enklare att tr�ffa och inte l�gga dem f�r n�ra varandra f�r att minska risken att man trycker p� fel yta.

###Undvik hover/mouseover
�ven om det finns visst st�d f�r att hantera CSS och !JavaScript som p� en desktopdator aktiveras n�r man f�r muspekaren �ver ett element �r det bra att f�rs�ka undvika den typen av interaktion, eller �tminstone inte g�ra sig beroende av att den fungerar. Det g�ller s�rskilt "mystery meat"-interaktion, det vill s�ga inneh�ll som inte avsl�jas f�rr�n man f�r muspekaren �ver ett element.

##Bandbredd
Om anv�ndarna f�rv�ntas anv�nda en l�sning huvudsakligen via mobilanslutning, allts� inte via Wi-fi, f�r man t�nka p� att uppkopplingen kan vara betydligt l�ngsammare. D�rf�r �r det extra viktigt att h�lla nere filstorlekar och antalet HTTP-anrop f�r att snabba upp l�sningen.

##Teknologier
Webbl�sarna i moderna smartphones har v�l utbyggt st�d f�r nya webbtekniker som [HTML5](http://www.w3.org/TR/html5/ ) och CSS 3. D�rf�r kan man anv�nda dem f�r att tillf�ra funktionalitet och design p� ett mer effektivt s�tt. En f�ruts�ttning �r att man anv�nder HTML5 och CSS 3 p� ett s�tt som g�r att grundfunktionaliteten �nd� finns i webbl�sare som inte har st�d f�r dem.

###HTML5
�ven om specifikationen f�r HTML5 inte �r helt klar �nnu � den har inte uppn�tt W3C-statusen "Recommendation" � �r den s�pass mogen att det allra mesta som �r implementerat av webbl�sare kan anv�ndas s� l�nge man tar h�jd f�r vad som h�nder n�r st�d saknas.

###CSS 3
CSS 3 �r inte en homogen specifikation utan best�r av ett antal olika moduler som �r olika mogna och olika v�l implementerade. Exempel p� moduler som redan nu har brett webbl�sarst�d, s�rskilt n�r det g�ller moderna smartphones, �r:

  * [Selectors Level 3](http://www.w3.org/TR/css3-selectors/ )
  * [CSS Color Module Level 3](http://www.w3.org/TR/css3-color/ )
  * [CSS Backgrounds and Borders Module Level 3](http://www.w3.org/TR/css3-background/ )
  * [Media Queries](http://www.w3.org/TR/css3-mediaqueries/ )
  * [CSS Text Level 3](http://www.w3.org/TR/css3-text/ )

##�vrigt
CSS-egenskapen `position:fixed` st�ds inte p� samma s�tt i iOS 4 och �ldre som i desktopwebbl�sare. Att implementera samma funktion d�r kr�ver JavaScript och �r i dagsl�get inte helt tillf�rlitligt. Om man anv�nder en design som kr�ver fasta element b�r man d�rf�r vara extra noga med att testa implementationen. St�d f�r `position:fixed` finns i iOS 5.

##Aktuella webbl�sare
I nul�get �r den huvudsakliga mobila m�lgruppen s�dana som �r baserade p� 
[WebKit](http://en.wikipedia.org/wiki/WebKit ). Dit h�r iPhone, iPad, iPod, Android med flera. Detta �r den grupp av mobila webbl�sare som kvalitetss�kring sker mot i f�rsta hand. Andra webbl�sare som Opera Mini och Opera Mobile kan vara aktuella beroende p� m�lgrupp.

##Testmilj�er

Under utveckling �r det som ger s�krast resultat att testa i en riktig milj�, allts� p� en mobil enhet. Om man inte har tillg�ng till s�dana finns mjukvarul�sningar f�r b�de iOS och Android.

  * [Xcode 4 f�r Mac OS X och iOS](http://developer.apple.com/xcode/index.php )
  * [Android Emulator](http://developer.android.com/guide/developing/tools/emulator.html )

##Referenser
  1.  HTML5: http://www.w3.org/TR/html5/
  1.  CSS 2.1: http://www.w3.org/TR/CSS21/
  1.  CSS 3: http://www.w3.org/TR/CSS21/
  1.  !WebKit: http://en.wikipedia.org/wiki/WebKit
  1.  Media Queries: http://www.w3.org/TR/css3-mediaqueries/
