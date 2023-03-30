const images = document.querySelectorAll('img');
console.log("altBilde loaded");

images.forEach(img => {
    img.addEventListener('error', function handleError() {
        const defaultImage1 = "https://unsplash.imgix.net/uploads%2F1411419068566071cef10%2F7562527b?q=75&w=1080&h=1080&fit=max&fm=jpg&auto=format&s=240c45655f09c546232a6f106688e502";
        const defaultImage = "./banner.jpg"


        img.src = defaultImage;
        img.alt = 'default';
    });
});
