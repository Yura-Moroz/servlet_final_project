const texts = [
    "The world is on the verge of destruction!",
    "Invaders are close! You're the last chance to save this universe!",
    "You should use a secret weapon against them. But before you can use it, you must accept the challenge.",
    "Solve these problems, and only if you succeed, you will be able to defeat the enemies!",
    "Let's get acquainted and Let's go!"
];

let i = 0;
let j = 0;
const speed = 60; // Speed of typing

function typeWriter() {
    if (i < texts.length) {
        let container = document.getElementById('text' + (i + 1) + '-container');
        let cursor = container.nextElementSibling; // Get the cursor next to the text container

        // Clear the container and reset the cursor position
        if (j < texts[i].length) {
            container.innerHTML += texts[i].charAt(j);
            j++;
            cursor.style.display = 'inline-block'; // Ensure cursor is visible
            setTimeout(typeWriter, speed);
        } else {
            j = 0;
            i++;
            cursor.style.display = 'none'; // Hide cursor after the entire text is typed
            setTimeout(typeWriter, 500); // Delay before typing the next paragraph
        }
    } else {
        document.querySelector('.form-section').style.display = 'flex'; // Show the form after typing is done
    }
}

// Start typing effect on page load
window.onload = typeWriter;
