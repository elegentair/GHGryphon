const website = "https://6aea96643d3dd3d37be6cb9a.mockapi.io/api/v1"
function showHello(){
// //   getPerson();
    document.getElementById("ans").innerText = "hello";
};
let all_users = [];

async function getPerson() {
    const response = await fetch(`${website}/users`);
    all_users = await response.json();
    // document.getElementById('ans').innerText = all_users;
    for (let user of all_users) {
        document.getElementById('ans').innerText += `\n${user["name"]}`;
    }
        // console.log(response);
    //document.getElementById('output').innerText = data["name"];
    //document.getElementById('description').innerText = data["phone"];
};
