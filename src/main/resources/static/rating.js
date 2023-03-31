// Get all the star input elements
const starInputs = document.querySelectorAll('input[name="rate"]');

// Loop through each star input element and add an event listener
starInputs.forEach((starInput) => {
  starInput.addEventListener('click', (event) => {
    // Get the rating value from the clicked star input
    const rating = event.target.value;
    
    // Send the rating to the server using an AJAX request
    // You'll need to implement this part yourself
  });
});
fetch('/stem', {
    method: 'POST',
    body: JSON.stringify({ rating: rating }),
    headers: {
      'Content-Type': 'application/json'
    }
  })
  .then((response) => {
    // Handle the response from the server
  })
  .catch((error) => {
    // Handle any errors
  });

  const xhr = new XMLHttpRequest();
xhr.open("POST", "/stem");
xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
xhr.onload = function() {
  if (xhr.status === 200) {
    console.log("Rating saved successfully");
    window.location.replace("/landingpage"); // Redirect to landing page
  } else {
    console.error("Failed to save rating");
  }
};
xhr.send(`brukerid=${brukernavn}&prosjektid=${prosjektId}&rating=${rating}`);

  
