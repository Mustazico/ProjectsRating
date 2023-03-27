<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html> 
    <head>
        <%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <script type="text/javascript" src="apicall.js"></script>
        <link rel="stylesheet" href="personside.css" />
        <link rel="stylesheet" href="style.css" />
        <title>portfolio</title>
    </head>
    <body>
        <div class="header">
            <h1>Portfolio side</h1>
            <p>De beste ingenerdene i bergen by</p>
        <div id="navbar">
            <c:choose>
            <c:when test = "${brukernavn == 'Petter Tesdal'}">
            <a class="active" href="personsside/petter">Petter</a> 
            </c:when>
            <c:otherwise>
            <a href="personsside/petter">Petter</a> 
            </c:otherwise>
            </c:choose>
            <c:choose>
            <c:when test = "${brukernavn == 'Fredrik Enes'}">
            <a class="active" href="personsside/fredrik">Fredrik</a> 
            </c:when>
            <c:otherwise>
            <a href="personsside/fredrik">Fredrik</a> 
            </c:otherwise>
            </c:choose>
            <c:choose>
            <c:when test = "${brukernavn == 'Kristoffer Fjeldstad Madsen'}">
            <a class="active" href="personsside/kristoffer">Kristoffer</a> 
            </c:when>
            <c:otherwise>
            <a href="personsside/kristoffer">Kristoffer</a> 
            </c:otherwise>
            </c:choose>
            <c:choose>
            <c:when test = "${brukernavn == 'Trym Birkelund Gallefoss'}">
            <a class="active" href="personsside/trym">Trym</a> 
            </c:when>
            <c:otherwise>
            <a href="personsside/trym">Trym</a> 
            </c:otherwise>
            </c:choose>
            <c:choose>
            <c:when test = "${brukernavn == 'Oskar Windelstad'}">
            <a class="active" href="personsside/oskar">Oskar</a> 
            </c:when>
            <c:otherwise>
            <a href="personsside/oskar">Oskar</a> 
            </c:otherwise>
            </c:choose>
            <c:choose>
            <c:when test = "${brukernavn == 'Torben Lund'}">
            <a class="active" href="personsside/torben">Torben</a> 
            </c:when>
            <c:otherwise>
            <a href="personsside/torben">Torben</a> 
            </c:otherwise>
            </c:choose>
            <c:choose>
            <c:when test = "${brukernavn == 'Eirik Sangiorgi Brakstad'}">
            <a class="active" href="personsside/eirik">Eirik</a> 
            </c:when>
            <c:otherwise>
            <a href="personsside/eirik">Eirik</a> 
            </c:otherwise>
            </c:choose>
            <c:choose>
            <c:when test = "${brukernavn == 'Eirik Flisram Lavik'}">
            <a class="active" href="personsside/eirikl">Eirik L</a> 
            </c:when>
            <c:otherwise>
            <a href="personsside/eirikl">Eirik L</a> 
            </c:otherwise>
            </c:choose>
        </div>
        </div>

        <div class="content">
            <h1>Show readme</h1>
            <h1>Hils på gjengen</h1>
            <img class=introbilde src="./gruppebilde.jpeg">
            <p>
            Vi er en gjeng med dataingienører som har studert
            sammen på "haugskolen på vestlandet". Som et av våres prosjekt
            var å lære å jobbe sammen i en gruppe, og vi bestemte oss for å
            opprette en nettside hvor vi kunne vise fram egenskapene våres og
            evne til å utforde våres egne kunnskaper.
            Denne nettsiden er laget ganske mer avansert en det som er planlagt
            for studie og målet er at den skal kunne være god og brukbar i langtid etterpå.
            </p>
            <br>
            <p>
            Som bruker på denne nettsiden kan du klikke på et av våres navn for å
            få opp en beskrivelse av den personen og en liste av deres prosjekter,
            hvis du er ekstra engasjert kan du tilogmed gi en vurdering på de,
            slik at vi kan forbedre oss selv og sortere prosjektene slik at de beste kommer
            først.                   
            </p>
            <p>The navbar will stick to the top when you reach its scroll position.</p>
            <table>
                <tbody>
                    <tr>
                        <th align="left">ID</th>
                        <th align="left">Brukernavn</th>
                        <th align="left">Epost</th>
                        <th align="left">Mobil</th>
                        <th align="left">Passord</th>
                        <th align="left">Salt</th>
                        <th align="left">Rolle</th>
                    </tr>

                    <c:forEach var="brukere" items="${brukere}">
                    <tr>
                        <td>${brukere.brukernavn}</td>
                        <td>${brukere.epost}</td>
                        <td>${brukere.mobil}</td>
                        <td>${brukere.passord}</td>
                        <td>${brukere.salt}</td>
                        <td>${brukere.rolle}</td>
                    </tr>
                    </c:forEach>
                </tbody>
            </table>

            ${api}
            <p>${prosjekt}</p>
            <br>
            <br>
            <br>
        </div>
        <div class="footer">
            <div class="bubbles">
                <div class="bubble" style="--size:5.71482867975346rem; --distance:7.251197384000923rem; --position:61.04907339975787%; --time:3.4540556554978026s; --delay:-3.702443117512738s;"></div>
                <div class="bubble" style="--size:5.392816414736889rem; --distance:9.304907238648225rem; --position:87.99033648641573%; --time:2.8071423589503737s; --delay:-2.878898098389632s;"></div>
                <div class="bubble" style="--size:3.862303912641324rem; --distance:7.623907746269599rem; --position:62.861363967139795%; --time:3.4217828065013176s; --delay:-3.852721636385527s;"></div>
                <div class="bubble" style="--size:2.694063880849389rem; --distance:8.672756392977167rem; --position:77.42295078882222%; --time:2.0241575462713794s; --delay:-2.4182273236134386s;"></div>
                <div class="bubble" style="--size:4.39005836548532rem; --distance:7.010603145475773rem; --position:17.857945539717957%; --time:3.885162954054496s; --delay:-3.551387789589599s;"></div>
                <div class="bubble" style="--size:2.0015541161958685rem; --distance:8.45695655737801rem; --position:87.89604660102566%; --time:2.6248076064168884s; --delay:-2.446792050236641s;"></div>
                <div class="bubble" style="--size:5.267845466598925rem; --distance:9.189879961679718rem; --position:5.404186515336484%; --time:3.220262833062049s; --delay:-3.1272347162531924s;"></div>
                <div class="bubble" style="--size:5.137317070165499rem; --distance:9.031432916425867rem; --position:79.73543993986331%; --time:3.89804338455083s; --delay:-3.8021714253603425s;"></div>
                <div class="bubble" style="--size:3.6146008727013372rem; --distance:9.014347674465203rem; --position:96.30398546068702%; --time:2.5317562662258326s; --delay:-3.8520393994274857s;"></div>
                <div class="bubble" style="--size:2.3976052709422087rem; --distance:6.643415386440676rem; --position:19.623449313286013%; --time:2.4776952688356144s; --delay:-2.05250597263393s;"></div>
            </div>
            <div class="content2">
                <div>
                    <div><b>Studenter</b><a href="#">Petter</a><a href="#">Fredrik</a><a href="#">Kristoffer</a><a href="#">Oskar</a><a href="#">Eirik</a><a href="#">Eirik</a><a href="#">Trym</a><a href="#">Torben</a></div>
                    <div></div>
                </div>
                <div>
                    <p>©2023 syke</p>
                </div>
            </div>
        </div>
        <svg style="position:fixed; top:100vh">
            <defs>
            <filter id="blob">
            <feGaussianBlur in="SourceGraphic" stdDeviation="10" result="blur"></feGaussianBlur>
            <feColorMatrix in="blur" mode="matrix" values="1 0 0 0 0  0 1 0 0 0  0 0 1 0 0  0 0 0 19 -9" result="blob"></feColorMatrix>
            </filter>
            </defs>
        </svg>
    </body>

    <script type = "text/javascript" src="./sticky.js"></script>
</html>
