<!DOCTYPE html>
<html>
<head>
<title>Logg inn</title>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="stylesheet" href="./logginn.css" />
</head>
<body>
	<h1>Logg inn</h1>
	<div class="container">
		<form method="post" action="logginn" onsubmit="return validateForm()">
			<label for="username">Mobil:</label> <input type="text"
				name="username" id="username" /><br /> <span id="username-error"
				class="error"></span> <label for="password">Passord:</label> <input
				type="password" name="password" id="password" /><br /> <span
				id="password-error" class="error"></span> 
				<input type="submit" value="Logg inn" />
		</form>
		<div class="registrer">
			<form method="post">
				<a href="registrering">Har du enda ikke registrert deg på siden
					vår for å stemme enda? </a>
			</form>
		</div>
	</div>

	<p>${msg}</p>
</body>
</html>
