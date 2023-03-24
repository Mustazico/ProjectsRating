<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <link rel="stylesheet" href="./style.css" />
        <link rel="stylesheet" href="./personside.css"/>
        <title>Document</title>
    </head>
    <body>
        <div class="header">
            <h2>Scroll Ned</h2>
            <p>Velkommen til Ingienørdene</p>
        </div>
        <div id="navbar">
            <a class="active" href="personsside/petter">Petter</a> 
            <a href="personsside/fredrik">Fredrik</a> 
            <a href="personsside">Kristoffer</a> 
            <a href="personside">Trym</a>
            <a href="personside">Oskar</a>
            <a href="personside">Torben</a>
            <a href="personside">Eirik</a>
            <a href="personside">Benjamin</a>
            <a href="personside">Eirik</a>
            <a href="logginn">Logg inn</a>
        </div>

        <div class="content">
            <center>
                <h1>${brukernavn}</h1>
                <img class="profil" src=${profilbilde} alt="Loading picture...">
                  <p> Velkommen til min portfolio. Under ser der alle mine fantastiske prosjekter! </p>
            </center>
            <article>
                <center>
                    <c:forEach var = "i" items="${lenker}">
                    <c:out value = "${i}"/>
                    <br>
                    </c:forEach>
                </center>
            </article>
        </div>
    </body>
    <script type = "text/javascript" src="./sticky.js"></script>
</html>
