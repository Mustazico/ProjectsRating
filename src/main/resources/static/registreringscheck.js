var check = function() {
    if (document.getElementById("password").value ==
        document.getElementById("confirm_password").value) {
        document.getElementById("message").style.color = "green";
        document.getElementById("message").innerHTML = "passordene er lik";
    } else {
        document.getElementById("message").style.color = "red";
        document.getElementById("message").innerHTML = "passordene er ikke like";
    }
}


let timeout;
let passord = document.getElementById("password");
let styrkeBar = document.getElementById("StrengthDisp");
let sterktPassord = new RegExp("(?=.{14,})");
let mediumPassord = new RegExp("(?=.{8,13})");

function StrengthChecker(PasswordParameter) {
    if (sterktPassord.test(PasswordParameter)) {
        styrkeBar.style.backgroundColor = "green"; 
        styrkeBar.textContent = "Sterk";
    } else if (mediumPassord.test(PasswordParameter)) {
        styrkeBar.style.backgroundColor = "yellow";
        styrkeBar.textContent = "Medium";
    } else {
        styrkeBar.style.backgroundColor = "red";
        styrkeBar.textContent = "Svak";
    }
}


passord.addEventListener("input", () => {
    styrkeBar.style.display = "block";
    clearTimeout(timeout);
    timeout = setTimeout(() => StrengthChecker(passord.value), 500);
    if (passord.value.length !== 0) {
        styrkeBar.style.display != "block";
    } else {
        styrkeBar.style.display = "none";
    }
});