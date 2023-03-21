<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html> 
<head>
	<script type="text/javascript" src="apicall.js"></script>
	<link rel="stylesheet" href="style.css" />
	<script type="text/javascript" src="./sticky.js"></script>
	<meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        
    </head>
    <body>
        <div class="header">
            <h2>Scroll Ned</h2>
            <p>Velkommen til Ingienoslashrdene</p>
        </div>
        <div id="navbar">
            <a class="active" href="javascript:void(0)">Petter</a> 
            <a href="javascript:void(0)">Fredrik</a> 
            <a href="javascript:void(0)">Kristoffer</a> 
            <a href="javascript:void(0)">Trym</a>
            <a href="javascript:void(0)">Oskar</a>
            <a href="javascript:void(0)">Torben</a>
            <a href="javascript:void(0)">Eirik</a>
            <a href="javascript:void(0)">Benjamin</a>
            <a href="javascript:void(0)">Eirik</a>
            <a href="javascript:void(0)">Logg inn</a>
        </div>

<body>

<img src="Vietnam Bakgrunn.jpg" alt="Vietnam" />


	<h1>Show readme</h1>
	<div id="readme-container"></div>

    <h1>Hallaaaaaaaaaaaaien</h1>
        <div class="content">
            <h3>Test</h3>
            <p>The navbar will stick to the top when you reach its scroll position.</p>
        </div>
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
                            <td>${brukere.id}</td>
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
    </body>
    <script type = "text/javascript" src="./sticky.js"></script>
</html>
