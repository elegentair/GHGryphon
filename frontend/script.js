const website = "https://6aea96643d3dd3d37be6cb9a.mockapi.io/api/v1"
document.addEventListener("DOMContentLoaded", function () {
  getPerson();
});


async function getPerson() {
  try {
    const allclubs = await fetch(`${website}/users`);
    console.log(allclubs)
    //document.getElementById('output').innerText = data["name"];
    //document.getElementById('description').innerText = data["phone"];
  } catch (error) {
    console.error('Fetch error:', error);
  }
}