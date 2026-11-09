const website = "https://6aea96643d3dd3d37be6cb9a.mockapi.io/api/v1"
document.addEventListener("DOMContentLoaded", function () {
  getPerson();
});
let all_clubs = []

async function getPerson() {
    const response = await fetch(`${website}/clubs`);
    all_clubs = await response.json();
  const output = document.getElementById('club');
  for (const club of all_clubs) {
    const card = document.createElement('div');
    card.className = 'club_card';
    card.dataset.id = club.id;
    const image = document.createElement('img');
    image.src = club.thumbnail;
    image.alt = club.name;
    image.style.width = '150px';
    image.style.height = '150px';
    image.style.objectFit = 'cover';
    const heading = document.createElement('h3');
    heading.textContent = club.name;
    const description = document.createElement('p');
    description.textContent = club.description;
    const editLink = document.createElement('a');
    editLink.className = 'class_edit_button';
    editLink.href = `edit_club.html?id=${encodeURIComponent(club.id)}`;
    editLink.textContent = 'Edit';
    card.append(image, heading, description, editLink);
    output.append(card);
    }
}
console.log('hello')