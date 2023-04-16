<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
        <%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <link rel="icon" type="image/x-icon" href="./favicon.ico">
        <link rel="stylesheet" href="./bootstrap.min.css"/>
        <link rel="stylesheet" href="./personside.css"/>
        <link rel="stylesheet" href="./style.css"/>
        <link rel="stylesheet" href="./rating.css"/>
        <title>${brukernavn}</title>
    </head>
    <body>
        <div class="header">
            <h1>Portfolioside</h1>
            <p>De beste ingeniørdene i Bergen By</p>
        </div>
        <nav class="navbar navbar-expand-lg sticky-top navbar-light" style="background-color: #62C3D6">
            <ul class="navbar-nav justify-content-center" id="navbar">
                <li class="nav-item">
                    <c:choose>
                    <c:when test = "${brukernavn == 'Petter Tesdal'}">
                    <a class="active" href="personsside/petter">Petter</a> 
                    </c:when>
                    <c:otherwise>
                    <a href="personsside/petter">Petter</a> 
                    </c:otherwise>
                    </c:choose>
                </li>
                <li class="nav-item">
                    <c:choose>
                    <c:when test = "${brukernavn == 'Fredrik Enes'}">
                    <a class="active" href="personsside/fredrik">Fredrik</a> 
                    </c:when>
                    <c:otherwise>
                    <a href="personsside/fredrik">Fredrik</a> 
                    </c:otherwise>
                    </c:choose>
                </li>
                <li class="nav-item">
                    <c:choose>
                    <c:when test = "${brukernavn == 'Kristoffer Fjeldstad Madsen'}">
                    <a class="active" href="personsside/kristoffer">Kristoffer</a> 
                    </c:when>
                    <c:otherwise>
                    <a href="personsside/kristoffer">Kristoffer</a> 
                    </c:otherwise>
                    </c:choose>
                </li>
                <li class="nav-item">
                    <c:choose>
                    <c:when test = "${brukernavn == 'Trym Birkelund Gallefoss'}">
                    <a class="active" href="personsside/trym">Trym</a> 
                    </c:when>
                    <c:otherwise>
                    <a href="personsside/trym">Trym</a> 
                    </c:otherwise>
                    </c:choose>
                </li>
                <li class="nav-item">
                    <c:choose>
                    <c:when test = "${brukernavn == 'Oskar Windelstad'}">
                    <a class="active" href="personsside/oskar">Oskar</a> 
                    </c:when>
                    <c:otherwise>
                    <a href="personsside/oskar">Oskar</a> 
                    </c:otherwise>
                    </c:choose>
                </li>
                <li class="nav-item">
                    <c:choose>
                    <c:when test = "${brukernavn == 'Torben Lund'}">
                    <a class="active" href="personsside/torben">Torben</a> 
                    </c:when>
                    <c:otherwise>
                    <a href="personsside/torben">Torben</a> 
                    </c:otherwise>
                    </c:choose>
                </li>
                <li class="nav-item">
                    <c:choose>
                    <c:when test = "${brukernavn == 'Eirik Sangiorgi Brakstad'}">
                    <a class="active" href="personsside/eirik">Eirik</a> 
                    </c:when>
                    <c:otherwise>
                    <a href="personsside/eirik">Eirik</a> 
                    </c:otherwise>
                    </c:choose>
                </li>
                <li class="nav-item">
                    <c:choose>
                    <c:when test = "${brukernavn == 'Eirik Flisram Lavik'}">
                    <a class="active" href="personsside/eirikl">Eirik L</a> 
                    </c:when>
                    <c:otherwise>
                    <a href="personsside/eirikl">Eirik L</a> 
                    </c:otherwise>
                    </c:choose>
                </li>
            </ul>
        </nav>

        <div class="content">
        
            <center>
			<%
                                String role = (String)session.getAttribute("rolle");
                                if(role != null && role.equals("Admin")) {
                                	%>
			<form method="post" action="synkroniser">
				<input type="submit" value="Synkroniser Readme nå" name="synk">
			</form>
			<%
			}
			%>

			<h1>${brukernavn}</h1>
                <img class="profil" src=${profilbilde} alt="Loading picture...">
                <br>
                <br>
                <hr class="solid">
                <br>
                <c:out value = "${bio}"/>
                <br>
            </center>
            <c:set value="0" var="x"></c:set>
            <br>
            <c:set value="https://raw.githubusercontent.com/" var="bilde"></c:set>
            <section id="portfolio">
                <div class="container">
                    <div class="row justify-content-center">
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
                                            <p> &#11088 ${gjsnittrating[status.index]} / 5.0</p>
                                        </div>
                                    </div>
                                    <img id="img" src="https://raw.githubusercontent.com/${githubBrukernavn[status.index]}/${githubRepo[status.index]}/main/profil.jpg" alt="banner" class="img-fluid">
                                </a>
                                <div class="portfolio-caption">
                                    <h4>${githubRepo[status.index]}</h4>
                                    <p class="text-muted">${brukernavn}</p>
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
                                	<div class="input">
                                		<label for="brukerid">Brukerid</label> 
                                		<input type="text" name="brukerid" id="brukerid" />
                                		<label for="tittel">Tittel</label> 
                                		<input type="text" name="tittel" id="tittel" />
                                		<label for="prosjektlink">Prosjektlink</label> 
                                		<input type="text" name="prosjektlink" id="prosjektlink" />
                                		<br>
                                		<br>
                                		<input type="submit" value="Legg til" name="leggtil">
                                	</div>
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
                        <div class="close-modal my-close-btn" data-bs-dismiss="modal">
                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <div class="container">
                            <div class="modal-body">
                                <div class="row">
                                	<div class="row justify-content-md-center">
                                    	<h2>${githubRepo[status.index]}</h2>
                                    </div>
                                </div>
                                <div class="row">
                                    <img id="img" src="https://raw.githubusercontent.com/${githubBrukernavn[status.index]}/${githubRepo[status.index]}/main/profil.jpg" alt="prosjekt bilde" class="img-fluid">

                                </div>
                                <div class="row justify-content-md-center">
                                    <c:out value="${api[status.index]}"/> 
                                    <p>
                                </div>
                                <!-- Stemmesystem-->
                                <div class="row justify-content-md-between">
                                    <form method="post" action="stemmer">
                                                <div class="rate">
									            <input type="hidden" name="id" value="${prosjektId[status.index]}" />
											    <input type="radio" id="star5${x}" name="rate" value="5" <c:set var="checked5" value="${stjernerGitt.contains('5')}"/><c:if test="${checked5}">checked</c:if> />
											    <label for="star5${x}" title="text">5 stars</label>
											    <input type="radio" id="star4${x}" name="rate" value="4" <c:set var="checked4" value="${stjernerGitt.contains('4')}"/><c:if test="${checked4}">checked</c:if> />
											    <label for="star4${x}" title="text">4 stars</label>
											    <input type="radio" id="star3${x}" name="rate" value="3" <c:set var="checked3" value="${stjernerGitt.contains('3')}"/><c:if test="${checked3}">checked</c:if> />
											    <label for="star3${x}" title="text">3 stars</label>
											    <input type="radio" id="star2${x}" name="rate" value="2" <c:set var="checked2" value="${stjernerGitt.contains('2')}"/><c:if test="${checked2}">checked</c:if> />
											    <label for="star2${x}" title="text">2 stars</label>
											    <input type="radio" id="star1${x}" name="rate" value="1" <c:set var="checked1" value="${stjernerGitt.contains('1')}"/><c:if test="${checked1}">checked</c:if> />
											    <label for="star1${x}" title="text">1 star</label>
        								</div>
                                        <input type="hidden" id="person" name="person" value="${id}" />

                                                <input type="submit" value="stem" name="Stemme">
                                    </form>
                                </div>
                                
                                
                                <div class="row justify-content-md-center">
                                    <div class="col-md-3">
                                        <h4>${brukernavn}</h4>
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
                    <p>©2023</p>
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
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.4/jquery.min.js" integrity="sha512-pumBsjNRGGqkPzKHndZMaAG+bir374sORyzM3uulLV14lN5LyykqNk8eEeUlUkB3U0M4FApyaHraT65ihJhDpQ==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
    <script src="./bootstrap.bundle.min.js"></script>
    <script src="./altBilde.js"></script>

</html>
