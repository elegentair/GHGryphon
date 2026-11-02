async function doSomething() {
  try {
    const response = await fetch('https://jsonplaceholder.typicode.com/posts/1');
    const data = await response.json();
    console.log(data);
    document.getElementById('output').innerText = JSON.stringify(data, null, 2);
  } catch (error) {
    console.error('Fetch error:', error);
  }
}