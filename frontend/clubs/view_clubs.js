const API_ORIGIN = "127.0.0.1:7070";
const API_URL = `${API_ORIGIN}/api`;

let all_clubs = [];

async function fetchClubs() {
  const response = await fetch(`${API_URL}/clubs`);
  all_clubs = await response.json();
  console.log(all_clubs);
  for (let club of all_clubs) {
    document.getElementById("clubs").innerHTML +=
      `<div class='club_card' data-id='${club[id]}'>
        <img src='${club["thumbnail"]}' alt='${club["name"]}'>
        <h3>${club["name"]}</h3>
        <p>${club["description"]}</p>
        <div style="display: flex; gap: 16px;">
        <a class='card_edit_button' href='edit_club.html?id=${club["id"]}'>Edit</a>
        <a class='card_edit_button' href='../users/view_user.html?id=${club["id"]}'>Club Members</a>
        </div>
      </div>`;
  }

  document.getElementById("clubs").innerHTML +=
    `<a href='new_club.html' class='club_card add_card' aria-label='Create a new club'>
      <span class='plus'>+</span>
      <span class='add_label'>Add a new club</span>
    </a>`;
}

document.getElementById("clubs").addEventListener("click", (event) => {
  const card = event.target.closest(".club_card[data-id]");
  if (!card || event.target.closest(".card_edit_button")) return;
  window.location.href = `club.html?id=${card.dataset.id}`;
});

fetchClubs();
