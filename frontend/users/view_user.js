// const website = "https://6aea96643d3dd3d37be6cb9a.mockapi.io/api/v1"
// function showHello(){
// // //   getPerson();
//     document.getElementById("ans").innerText = "hello";
// };
// let all_users = [];

// async function getPerson() {
//     const response = await fetch(`${website}/users`);
//     all_users = await response.json();
//     for (let user of all_users) {
//     document.getElementById("ans").innerHTML +=
//       `<div class='user_card' data-id='${user["id"]}'>
//         <img src='${user["avatar"]}' alt='${user["name"]}' width='100' height='100'>
//         // <p>${user["name"]} ${user["email"]}</p>
//         // <a class='card_edit_button' href='edit_user.html?id=${user["id"]}'>Edit</a>
//       </div>`;

//   }
//     // document.getElementById('ans').innerText = all_users;
//     // for (let user of all_users) {
//     //     document.getElementById('ans').innerText += `\n${user["name"] + user["email"]}`;
//     // }
//         // console.log(response);
//     //document.getElementById('output').innerText = data["name"];
//     //document.getElementById('description').innerText = data["phone"];
// };
// window.addEventListener("load", getPerson);