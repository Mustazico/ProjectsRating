<!DOCTYPE html>
<html>
  <head>
    <title>registrering</title>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <style>
      body {
        background-color: #f2f2f2;
        font-family: Arial, sans-serif;
      }
      h1 {
        text-align: center;
        margin-top: 50px;
      }
      .container {
        max-width: 500px;
        margin: 0 auto;
        background-color: #fff;
        padding: 50px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
      }
      label {
        display: block;
        margin-bottom: 10px;
        font-weight: bold;
      }
      input[type="text"],
      input[type="password"] {
        width: 100%;
        padding: 10px;
        border: 1px solid #ccc;
        border-radius: 3px;
        margin-bottom: 20px;
      }
      input[type="submit"] {
        background-color: #4caf50;
        color: #fff;
        border: none;
        padding: 10px 20px;
        border-radius: 3px;
        cursor: pointer;
        transition: background-color 0.3s ease-in-out;
      }
      input[type="submit"]:hover {
        background-color: #3e8e41;
      }
      .error {
        color: red;
        font-size: 0.8em;
        margin-top: 5px;
      }
    </style>
  </head>
  <body>
    <h1>Registrering</h1>
      <form method="post" action="/registrering">
        <label for="username">Brukernavn:</label>
        <input type="text" name="username" id="username" title="Brukernavn m� v�re 4 bokstaver" 
        required pattern="^[a-zA-Z ]{3,40}$" 
        placeholder= "Fyll inn brukernavn" required="required"/><br />
        <label for="mail">E-Mail:</label>
        <input type="text" name="mail" id="mail" title="Epost m� inneholde @"
        placeholder="Fyll inn eposten din" required="required"/><br />
        <label for="username">Telefonnr:</label>
        <input type="text" name="tlf" id="tlf" title="Tlf-nr kan kun v�re 8 siffer"
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
        <button type="submit">Fullf�r registrering</button>
        </form>
    <p>${msg}</p>
    
     <script src="registreringscheck.js" defer></script>
  </body>
</html>
