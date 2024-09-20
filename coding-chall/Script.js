// Detect swipe gestures for navigation on touch devices
let touchstartX = 0;
let touchendX = 0;

const content = document.getElementById('content');

function handleGesture() {
    if (touchendX < touchstartX) {
        console.log('Swiped left'); // You can add custom logic to move to the next page (e.g. go to profile)
    }
    
    if (touchendX > touchstartX) {
        console.log('Swiped right'); // You can add custom logic to move to the previous page (e.g. go to home)
    }
}

content.addEventListener('touchstart', (e) => {
    touchstartX = e.changedTouches[0].screenX;
}, false);

content.addEventListener('touchend', (e) => {
    touchendX = e.changedTouches[0].screenX;
    handleGesture();
}, false);


document.querySelectorAll('nav ul li a').forEach(link => {
    link.addEventListener('click', (event) => {
        document.querySelectorAll('nav ul li a').forEach(navLink => navLink.classList.remove('active'));
        event.target.classList.add('active');
    });
});
