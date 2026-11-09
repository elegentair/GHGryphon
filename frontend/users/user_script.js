const website = "https://6aea96643d3dd3d37be6cb9a.mockapi.io/api/v1"
document.addEventListener("DOMContentLoaded", function () {
//   getPerson();
});
let all_users = [];

async function getPerson() {
 
    const response = await fetch(`${website}/users`);
    
    console.log(response)
    //document.getElementById('output').innerText = data["name"];
    //document.getElementById('description').innerText = data["phone"];
}
