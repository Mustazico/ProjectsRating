<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
        <%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <link rel="stylesheet" href="./personside.css"/>
        <link rel="stylesheet" href="./style.css"/>
        <link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">

        <link rel="stylesheet" href="./rating.css"/>
        <title>portfolio</title>
    </head>
    <body>
        <div class="header">
        <br>
        <br>
            <p>Velkommen til Ingienørdene</p>
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
            <center>
                <h1>${brukernavn}</h1>
                <img class="profil" src=${profilbilde} alt="Loading picture...">
                <br>
                <br>
                <hr class="solid">
                <br>
                    <c:out value = "${bio}"/>
                <p> Velkommen til min portfolio. Under ser dere alle mine fantastiske prosjekter! </p>
                <br>
            </center>
            <c:set value="0" var="x"></c:set>
            <br>
            <br>

                <c:forEach var = "i"  items="${lenker}" varStatus="status">
                <c:set value="${x+1}" var="x"></c:set>
                <!--Html for kortet til prosjektet-->

                <c:if test = "${x == 3}">
                <c:set value="0" var="x"></c:set>
                <br>
                </c:if>
                
                <c:set value="https://raw.githubusercontent.com/" var="bilde">
                </c:set>
                <section id="portfolio">
                    <div class="row">
                        <div class="portfolio-item">
                            <a href="#${x}" class="portfolio-link" data-toggle="modal">
                                <div class="portfolio-hover">
                                    <div class="portfolio-hover-content">
                                        <i class="fa fa-plus fa-3x"></i>
                                    </div>
                                </div>
                                <img src="https://raw.githubusercontent.com/${githubBrukernavn[status.index]}/${githubRepo[status.index]}/main/profil.jpg" class="img-responsive" alt="">
                            </a>
                            <div class="portfolio-caption">
                                <h4>${i}</h4>
                                <p class="text-muted">${brukernavn}</p>
                            </div>
                        </div>
                        <div class="col-md-4 col-sm-6 portfolio-item">
                        </div>
                    </div>
                </section>

                <!--Dette er seksjonen til modal-->
                <div class="portfolio-modal modal fade" id="${x}" tabindex="-1" role="dialog" aria-hidden="true">
                    <div class="modal-content">
                        <div class="close-modal" data-dismiss="modal">
                            <div class="lr">
                                <div class="rl">
                                </div>
                            </div>
                        </div>
                        <div class="container">
                            <div class="row">
                                <div class="col-lg-8 col-lg-offset-2">
                                    <div class="modal-body">
                                        <h2>Project Name</h2>
                                        <p class="item-intro text-muted">Lorem ipsum dolor sit amet consectetur.</p>
                                        <!--  Gammel, tar vare på den i tilfelle jeg trenger senere  <img class="img-responsive" src="https://unsplash.imgix.net/uploads%2F1411419068566071cef10%2F7562527b?q=75&w=1080&h=1080&fit=max&fm=jpg&auto=format&s=240c45655f09c546232a6f106688e502" alt="">-->
                                        <img class="img-responsive" src="https://raw.githubusercontent.com/${githubBrukernavn[status.index]}/${githubRepo[status.index]}/main/profil.jpg" alt="">
                                        <c:out value="${api[status.index]}"/> 
                                        <p>
                                        <ul class="list-inline">
                                            <li>Date: July 2014</li>
                                            <li>Client: Round Icons</li>
                                            <li>Category: Graphic Design</li>
                                        </ul>
                                        <button type="button" class="btn btn-primary" data-dismiss="modal"><i class="fa fa-times"></i> Close Project</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                </c:forEach>
            <article>
                <center>
<!--         HER LIGGER RATINGEN       	
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
       -->
					<br>
					<br>                  
                </center>
            </article>
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
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.4/jquery.min.js" integrity="sha512-pumBsjNRGGqkPzKHndZMaAG+bir374sORyzM3uulLV14lN5LyykqNk8eEeUlUkB3U0M4FApyaHraT65ihJhDpQ==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>

</html>
