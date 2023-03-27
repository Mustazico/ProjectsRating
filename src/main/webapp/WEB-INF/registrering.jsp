<!DOCTYPE html>
<html>
  <head>
    <title>Registrering</title>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="./registrering.css" />
    
    
  </head>
  <body>
    <h1>Registrering</h1>
    <div class="container">
      <form method="post" action="/registrering">
        <label for="username">Brukernavn:</label>
        <input type="text" name="username" id="username" title="Brukernavn må være 4 bokstaver" 
        required pattern="^[a-zA-Z ]{3, 40}$" 
        placeholder= "Fyll inn brukernavn" required="required"/><br />
        <label for="mail">E-Mail:</label>
        <input type="text" name="mail" id="mail" title="Epost må inneholde @"
        placeholder="Fyll inn eposten din" required="required"/><br />
        <label for="username">Telefonnr:</label>
        <input type="text" name="tlf" id="tlf" title="Tlf-nr kan kun være 8 siffer"
        placeholder="Fyll inn telefonnummeret ditt" required="required"
        required pattern="^\d{8}$" /><br />
        <span id="tlf-error" class="error"></span>
        <label for="password">Passord:</label>
        <input name="passord"
                id="password" type="password" required pattern=".{8,}" 
                title="Passordet ma vaere minst 8 tegn"
                placeholder="Velg et passord" required="required" onkeyup='check();' /> 
                <span id="StrengthDisp" class="badge displayBadge"></span>
        <label for="password2">Gjenta passord:</label>
        <input
                type="password" name="confirm_password"
                id="confirm_password" required pattern=".{8,}" 
                title="Passordet ma samsvare med passordet." placeholder="Gjenta passord" 
                required="required" onkeyup='check();' /> 
                <span
                id='message'></span>
        <br>
        <br>
        <input type="submit" value="Registrer deg" />
        </form>
        <br>
        <a href="logginn">Har du allerede registrert deg? Trykk her. </a>
    	<p>${msg}</p>
    	</div>
    
     <script src="registreringscheck.js" defer></script>
  </body>
</html>
