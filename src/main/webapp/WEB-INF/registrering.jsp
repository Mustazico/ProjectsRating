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
        <input type="text" name="username" id="username" /><br />
        <label for="mail">E-Mail:</label>
        <input type="text" name="mail" id="mail" /><br />
        <label for="username">Telefonnr:</label>
        <input type="text" name="tlf" id="ltf" /><br />
        <span id="tlf-error" class="error"></span>
        <label for="password">Passord:</label>
        <input type="password" name="password" id="password" /><br />
        <label for="password2">Gjenta passord:</label>
        <input type="password" name="password2" id="password2" /><br />
        <span id="password-error" class="error"></span>
        <button type="submit">Fullfør registrering</button>
        </form>
    <p>${msg}</p>
  </body>
</html>
