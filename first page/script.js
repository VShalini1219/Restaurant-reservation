function loadPosts() {
    fetch('https://jsonplaceholder.typicode.com/posts')
    .then((res) => res.json()).then(posts => {
        let output = '';
        posts.map(p => {
            document.getElementById('posts').innerHTML += `
                <h1>${p.title}</h1>
                <p>${p.body}</p>
            `;
            console.log(p.title);
        });
        // window.location.href = "http://www.w3schools.com";
    })
    .catch((err) => {
        console.log(err);
    });
}
