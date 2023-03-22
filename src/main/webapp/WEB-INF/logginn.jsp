<!DOCTYPE html>
<html>
  <head>
    <title>Logg inn</title>
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
    <h1>Logg inn</h1>
    <div class="container">
      <form method="post" action="logginn" onsubmit="return validateForm()">
        <label for="username">Mobil:</label>
        <input type="text" name="username" id="username" /><br />
        <span id="username-error" class="error"></span>
        <label for="password">Passord:</label>
        <input type="password" name="password" id="password" /><br />
        <span id="password-error" class="error"></span>
        <input type="submit" value="Logg inn" />
      </form>
      <form method="post">
        <a href="registrering">registrering</a>
      </form>
    </div>
    <script>
      function validateForm() {
        var username = document.getElementById("username");
        var password = document.getElementById("password");
        var usernameError = document.getElementById("username-error");
        var passwordError = document.getElementById("password-error");
        var isValid = true;

        // Sjekk om brukernavn er fylt ut
        if (username.value.trim() == "") {
          usernameError.innerHTML = "Vennligst fyll ut brukernavn";
          isValid = false;
        } else {
          usernameError.innerHTML = "";
        }

        // Sjekk om passord er fylt ut
        if (password.value.trim() == "") {
          passwordError.innerHTML = "Vennligst fyll ut passord";
          isValid = false;
        } else {
          passwordError.innerHTML = "";
        }

        return isValid;
      }
    </script>

    <p>${msg}</p>
  </body>
</html>
