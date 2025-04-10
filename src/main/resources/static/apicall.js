const userAction = async() => {
	const response = await fetch("https://api.github.com/repos/javascript-tutorial/en.javascript.info/commits");
	const myJson = await response.json();
	const priceElement = document.getElementById("price");
	
	const con = JSON.stringify(myJson[0].url);
	
	priceElement.textContent=`${con}`;

}

function fetchReadme() {
	const brukernavn = "";
	const repo = "";
	
	
	fetch(`https://api.github.com/repos/${brukernavn}/${repo}/contents/README.md`, {
		headers: {
		
		}
	}).then(response => response.json())
	.then(data => {
		//dekoder Base64 content. 
		const content = atob(data.content);
		
		const modifiedContent = content.split("\n") //Setter inn en ny linje der det kommer et nytt sett med strings inn. 
        .map((line) => line.replace(/^#+\s*|\*\*|\>/g	, "")) //fjerne alle '#', > og ** på starten av hver nye linje
        .join("<br>");
		
		const readMeContainer = document.getElementById("readme-container");
		readMeContainer.innerHTML = modifiedContent; 
	})
	
}


window.onload = fetchReadme;