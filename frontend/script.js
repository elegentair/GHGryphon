document.addEventListener("DOMContentLoaded", function () {
  doSomething();
});


async function doSomething() {
  try {
    const response = await fetch('https://jsonplaceholder.typicode.com/users/1');
    const data = await response.json();
    console.log(data["name"]);
    document.getElementById('output').innerText = data["name"];
    document.getElementById('description').innerText = data["phone"];
  } catch (error) {
    console.error('Fetch error:', error);
  }
}