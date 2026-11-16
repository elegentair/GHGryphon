const website = "https://6aea96643d3dd3d37be6cb9a.mockapi.io/api/v1";
const clubsContainer = document.getElementById("clubs");
const clubsStatus = document.getElementById("clubs-status");

async function getPerson() {
  let clubs;

  try {
    const response = await fetch(`${website}/clubs`);
    if (!response.ok) {
      throw new Error(`Club request failed with status ${response.status}`);
    }

    clubs = await response.json();
    if (
      !Array.isArray(clubs) ||
      clubs.some(
        (club) =>
          !club ||
          (typeof club.id !== "string" && typeof club.id !== "number") ||
          typeof club.name !== "string"
      )
    ) {
      throw new Error("The clubs response has an unexpected format");
    }
  } catch (error) {
    console.error("Could not load clubs:", error);
    clubsStatus.textContent = "Could not load clubs. Please try again later.";
    return;
  }

  renderClubs(clubs);
  clubsStatus.textContent = clubs.length === 0 ? "No clubs found yet." : "";
}

function renderClubs(clubs) {
  const cards = document.createDocumentFragment();

  for (const club of clubs) {
    const id = encodeURIComponent(String(club.id));
    const card = document.createElement("article");
    card.className = "club_card";

    const clubLink = document.createElement("a");
    clubLink.className = "club_card_link";
    clubLink.href = `club.html?id=${id}`;

    if (typeof club.thumbnail === "string" && club.thumbnail.length > 0) {
      const image = document.createElement("img");
      image.src = club.thumbnail;
      image.alt = "";
      image.loading = "lazy";
      clubLink.append(image);
    }

    const title = document.createElement("h3");
    title.textContent = club.name;
    clubLink.append(title);

    const description = document.createElement("p");
    description.textContent =
      typeof club.description === "string" ? club.description : "";
    clubLink.append(description);

    const editLink = document.createElement("a");
    editLink.className = "card_edit_button";
    editLink.href = `edit_club.html?id=${id}`;
    editLink.textContent = "Edit";

    card.append(clubLink, editLink);
    cards.append(card);
  }

  const addCard = document.createElement("a");
  addCard.href = "new_club.html";
  addCard.className = "club_card add_card";
  addCard.setAttribute("aria-label", "Create a new club");

  const plus = document.createElement("span");
  plus.className = "plus";
  plus.textContent = "+";

  const addLabel = document.createElement("span");
  addLabel.className = "add_label";
  addLabel.textContent = "Add a new club";

  addCard.append(plus, addLabel);
  cards.append(addCard);
  clubsContainer.replaceChildren(cards);
}

getPerson();
