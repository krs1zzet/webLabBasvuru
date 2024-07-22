const apiKey = 'cf8356c94dab41b8a362bf92fc638bfc'; // News API anahtarınızı buraya ekleyin

async function searchNews() {
    const query = document.getElementById('query').value;
    const date = document.getElementById('date').value;
    const url = `https://newsapi.org/v2/everything?q=${query}&from=${date}&sortBy=publishedAt&apiKey=${apiKey}`;

    try {
        const response = await fetch(url);
        const data = await response.json();
        displayNews(data.articles);
    } catch (error) {
        console.error('Error fetching news:', error);
    }
}

function displayNews(articles) {
    const newsContainer = document.getElementById('news-container');
    newsContainer.innerHTML = '';

    articles.forEach(article => {
        const newsItem = document.createElement('div');
        newsItem.className = 'news-item';

        const image = article.urlToImage ? `<img src="${article.urlToImage}" alt="News Image">` : '';

        newsItem.innerHTML = `
            ${image}
            <h3>${article.title}</h3>
            <p>${article.description || 'No description available'}</p>
            <a href="${article.url}" target="_blank">Read full article</a>
        `;

        newsContainer.appendChild(newsItem);
    });
}
