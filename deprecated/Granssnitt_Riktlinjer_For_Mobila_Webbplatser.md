



#DEPRECATED: Riktlinjer för mobila webbplatser

##Sammanfattning
_Riktlinjer för utveckling av webblösningar som är anpassade för användning på mobiltelefoner och andra enheter med liten skärm eller pekskärm._

_Dokumentets målgrupp består i första hand av utvecklare med gränssnittsinriktning som behöver råd och riktlinjer vid utveckling av webbaserade lösningar för mobila enheter._

##Inledning
I stort gäller samma riktlinjer som vid gränssnittsutveckling för desktopdatorer, det vill säga följ webbstandarder, bygg tillgängligt och separera struktur, presentation och beteende med hjälp av progressive enhancement.

Utöver detta finns några saker man behöver tänka på för att få gränssnitt som fungerar bra när användaren har en liten skärm och/eller interagerar via pekskärm i stället för mus eller tangentbord.

##Skärmstorlek
När det gäller skärmstorlek för den typ av mobila enheter som ingår i dagens målgrupp varierar den från 320 x 480 pixlar upp till 1024 x 768 pixlar beroende på enhet och rotation.

Det som är gemensamt är att användaren inte kan ändra fönsterstorleken på sin webbläsare, utan den tar upp hela skärmytan.

För att så långt det går undvika att webbläsaren själv anpassar innehållet till den tillgängliga ytan genom att zooma ut kan man välja två vägar: flexibel bredd eller Media Queries.

###Flexibel bredd
Genom att undvika att sätta fasta bredder får man en layout som själv anpassar sig efter den tillgängliga ytan. Fördelen är att den fungerar överallt. Nackdelen är att man kan få en väldigt ihoptryckt layout på smala displayer och väldigt långa textrader på breda displayer.

###Media Queries
En teknik som ger större möjlighet till anpassning för olika bredder är CSS-modulen [Media Queries](http://www.w3.org/TR/css3-mediaqueries/ ), som stöds av de webbläsare som används i de flesta moderna smartphones. Med hjälp av Media Queries kan man byta layout drastiskt vid olika fönsterbredder, vilket gör att man till exempel kan byta från en enspaltslayout på en iPhone i stående läge till en trespaltslayout på en iPad i liggande läge.

Man kan också kombinera media queries med flexibel bredd för att optimera layouten för bredder som ligger mellan de fasta steg man anpassar för (vilket är vanligt med desktopwebbläsare).

Lämpliga bredder att kontrollera sin layout vid när man använder Media Queries är följande:

  * 320px (iPhone, iPod Touch i stående läge)
  * 480px (iPhone, iPod Touch i liggande läge)
  * 768px (iPad i stående läge)
  * 1024px (iPad i liggande läge)

Utöver det är det lämpligt att bygga layouten så att den fungerar bra även vid andra mått, men dessa är fasta mått som berör de aktuella målplattformarna.

##Pekskärmar

###Större träffytor
När man använder enheter med pekskärm har man inte samma finkontroll av var man "klickar" eftersom det inte finns någon muspekare och en fingertopp ger en betydligt större träffyta än en muspekare. Därför är det bra att göra klick/träffytor större så de blir enklare att träffa och inte lägga dem för nära varandra för att minska risken att man trycker på fel yta.

###Undvik hover/mouseover
ƒven om det finns visst stöd för att hantera CSS och !JavaScript som på en desktopdator aktiveras när man för muspekaren över ett element är det bra att försöka undvika den typen av interaktion, eller åtminstone inte göra sig beroende av att den fungerar. Det gäller särskilt "mystery meat"-interaktion, det vill säga innehåll som inte avslöjas förrän man för muspekaren över ett element.

##Bandbredd
Om användarna förväntas använda en lösning huvudsakligen via mobilanslutning, alltså inte via Wi-fi, får man tänka på att uppkopplingen kan vara betydligt långsammare. Därför är det extra viktigt att hålla nere filstorlekar och antalet HTTP-anrop för att snabba upp lösningen.

##Teknologier
Webbläsarna i moderna smartphones har väl utbyggt stöd för nya webbtekniker som [HTML5](http://www.w3.org/TR/html5/ ) och CSS 3. Därför kan man använda dem för att tillföra funktionalitet och design på ett mer effektivt sätt. En förutsättning är att man använder HTML5 och CSS 3 på ett sätt som gör att grundfunktionaliteten ändå finns i webbläsare som inte har stöd för dem.

###HTML5
ƒven om specifikationen för HTML5 inte är helt klar ännu ñ den har inte uppnått W3C-statusen "Recommendation" ñ är den såpass mogen att det allra mesta som är implementerat av webbläsare kan användas så länge man tar höjd för vad som händer när stöd saknas.

###CSS 3
CSS 3 är inte en homogen specifikation utan består av ett antal olika moduler som är olika mogna och olika väl implementerade. Exempel på moduler som redan nu har brett webbläsarstöd, särskilt när det gäller moderna smartphones, är:

  * [Selectors Level 3](http://www.w3.org/TR/css3-selectors/ )
  * [CSS Color Module Level 3](http://www.w3.org/TR/css3-color/ )
  * [CSS Backgrounds and Borders Module Level 3](http://www.w3.org/TR/css3-background/ )
  * [Media Queries](http://www.w3.org/TR/css3-mediaqueries/ )
  * [CSS Text Level 3](http://www.w3.org/TR/css3-text/ )

##÷vrigt
CSS-egenskapen `position:fixed` stöds inte på samma sätt i iOS 4 och äldre som i desktopwebbläsare. Att implementera samma funktion där kräver JavaScript och är i dagsläget inte helt tillförlitligt. Om man använder en design som kräver fasta element bör man därför vara extra noga med att testa implementationen. Stöd för `position:fixed` finns i iOS 5.

##Aktuella webbläsare
I nuläget är den huvudsakliga mobila målgruppen sådana som är baserade på 
[WebKit](http://en.wikipedia.org/wiki/WebKit ). Dit hör iPhone, iPad, iPod, Android med flera. Detta är den grupp av mobila webbläsare som kvalitetssäkring sker mot i första hand. Andra webbläsare som Opera Mini och Opera Mobile kan vara aktuella beroende på målgrupp.

##Testmiljöer

Under utveckling är det som ger säkrast resultat att testa i en riktig miljö, alltså på en mobil enhet. Om man inte har tillgång till sådana finns mjukvarulösningar för både iOS och Android.

  * [Xcode 4 för Mac OS X och iOS](http://developer.apple.com/xcode/index.php )
  * [Android Emulator](http://developer.android.com/guide/developing/tools/emulator.html )

##Referenser
  1.  HTML5: http://www.w3.org/TR/html5/
  1.  CSS 2.1: http://www.w3.org/TR/CSS21/
  1.  CSS 3: http://www.w3.org/TR/CSS21/
  1.  !WebKit: http://en.wikipedia.org/wiki/WebKit
  1.  Media Queries: http://www.w3.org/TR/css3-mediaqueries/
