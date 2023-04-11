<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html> 
    <head>
        <%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <script type="text/javascript" src="apicall.js"></script>
        <link rel="icon" type="image/x-icon" href="./favicon.ico">
        <link rel="stylesheet" href="personside.css" />
        <link rel="stylesheet" href="./bootstrap.min.css" />
        <link rel="stylesheet" href="style.css" />
        <title>Forside</title>
        </head>
    <body>
        <div class="header">
            <h1>Portfolio side</h1>
            <p>De beste ingeniørdene i Bergen by</p>
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
            <h1>Hils på gjengen</h1>
            <img class=introbilde src="./gruppeBilde(ute).jpg">
            <p>
            Vi er en gjeng med dataingeniørder som studerer
            sammen på Høgskulen på Vestlandet. Prosjektet våres
            er å lære å jobbe sammen i team og benytte oss av utviklingsmetoder. Vi bestemte oss for å
            opprette en nettside hvor vi kan vise fram egenskapene våres og
            evne til å utforde våres egne kunnskaper.
            Denne nettsiden er laget ganske mer avansert en det som er planlagt
            for studie og målet er at den skal kunne være god og brukbar i ettertid.
            </p>
            <br>
            <p>
            Som bruker på denne nettsiden kan du klikke på et av våres navn for å
            få opp en beskrivelse av den personen og en liste av deres prosjekter,
            hvis du er ekstra engasjert kan du til og med gi en vurdering på personen,
            slik at vi kan forbedre oss selv og sortere prosjektene slik at de beste kommer
            først.                   
            </p>
			<p>${msg} </p>
            <br>
           
           
           
            <section id="portfolio">
                <div class="container">
                    <div class="row justify-content-center">
                    <c:set value="0" var="x"></c:set>
                        <c:forEach var = "i"  items="${lenker}" varStatus="status">
                        	<!--Html for kortet til prosjektet-->
                        	<c:if test = "${(x % 3) == 3}">
                    </div>
                    <div class="row justify-content-center">
                        	</c:if>
                        	<div class="col-md-4">
                            	<div class="portfolio-item">
                                	<a data-bs-target="#${x}" class="portfolio-link" data-bs-toggle="modal">
                                    	<div class="portfolio-hover">
                                        	<div class="portfolio-hover-content">
                                            	<i class="fa fa-plus fa-3x"></i>
                                        	</div>
                                    	</div>
                                    	<img id="img" src="https://raw.githubusercontent.com/${githubBrukernavn[status.index]}/${githubRepo[status.index]}/main/profil.jpg" alt="banner" class="img-fluid">
                                	</a>
                                	<div class="portfolio-caption">
                                    	<h4>${githubRepo[status.index]}</h4>
                                    	<p class="text-muted">${brukernavn[x]}</p>
                                	</div>
                                	<%
                                		String rolle = (String)session.getAttribute("rolle");
                                		if(rolle != null && rolle.equals("Admin")) {
                                	%> 
                                	<form method="post" action="slettpost">
                                		<input type="hidden" name="id" value="${prosjektId[status.index]}" />
                                		<input type="submit" value="Slett" name="slett"/>
                                	</form>
                                	
                                	<%
                                		}
                                	%>
                            	</div>
                        	</div>
                        	<c:set value="${x+1}" var="x"></c:set>
                      </c:forEach>
                    </div>
                </div>
                <%
                                String rolle = (String)session.getAttribute("rolle");
                                if(rolle != null && rolle.equals("Admin")) {
                                	%>
                                	<form method="post" action ="leggtilpost">
                                		<label for="brukerid">Brukerid</label> 
                                		<input type="text" name="brukerid" id="brukerid" />
                                		<br>
                                		<label for="tittel">Tittel</label> 
                                		<input type="text" name="tittel" id="tittel" />
                                		<br>
                                		<label for="prosjektlink">Prosjektlink</label> 
                                		<input type="text" name="prosjektlink" id="prosjektlink" />
                                		<input type="submit" value="Legg til" name="leggtil">
                                	</form>
                                	<%
                                }
                                %>
            </section>


            <c:set value="0" var="x"></c:set>
            <c:forEach var = "i"  items="${lenker}" varStatus="status">
            <!--Dette er seksjonen til modal-->
            <div class="portfolio-modal modal fade" id="${x}" tabindex="-1" role="dialog" aria-hidden="true">
                <div class="modal-dialog modal-fullscreen">
                    <div class="modal-content">
                        <div class="close-modal" data-bs-dismiss="modal">
                            <div class="lr">
                                <div class="rl">
                                </div>
                            </div>
                        </div>
                        <div class="container">
                            <div class="modal-body">
                                <div class="row">
                                    <h2>${githubRepo[status.index]}</h2>
                                </div>
                                <div class="row">
                                    <p class="item-intro text-muted">Intro tekst</p>
                                </div>
                                <div class="row">
                                    <img id="img" src="https://raw.githubusercontent.com/${githubBrukernavn[status.index]}/${githubRepo[status.index]}/main/profil.jpg" alt="prosjekt bilde" class="img-fluid">

                                </div>
                                <div class="row">
                                    <c:out value="${api[status.index]}"/> 
                                    <p>
                                </div>
                                <!-- Stemmesystem-->
                                <div class="row justify-content-md-between">
                                                <div class="rate">
                                                <input type="radio" id="star5" name="rate" value="5" />
                                                <label for="star5" title="text">5 stars</label>
                                                <input type="radio" id="star4" name="rate" value="4" />
                                                <label for="star4" title="text">4 stars</label>
                                                <input type="radio" id="star3" name="rate" value="3" />
                                                <label for="star3" title="text">3 stars</label>
                                                <input type="radio" id="star2" name="rate" value="2" />
                                                <label for="star2" title="text">2 stars</label>
                                                <input type="radio" id="star1" name="rate" value="1" />
                                                <label for="star1" title="text">1 star</label>
                                                </div>
                                </div>
                                <div class="row justify-content-md-between">
                                    <div class="col-md-3">
                                        <h4>Dato: Juli 2022</li>
                                    </div>
                                    <div class="col-md-3">
                                        <h4>${brukernavn}</li>
                                    </div>
                                    <div class="col-md-3">
                                        <h4>Kategori: Grafisk</li>
                                    </div>
                                </div>
                                <hr>
                                <br>
                                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <c:set value="${x+1}" var="x"></c:set>
                                    </c:forEach>
           
           
           
           
           
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
                    <div><b>Studenter</b><a href="./landingpage">Hjem</a><a href="./logginn">Logg inn</a><a href="./registrering">Registrer deg</a></div>
                    <div></div>
                </div>
                <div>
                    <p>©2023 Kenneth</p>
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
    <script src="./boostrap.bundle.min.js"></script>
    <script src="./altBilde.js"></script>
</html>
