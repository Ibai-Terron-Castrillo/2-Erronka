$(document).ready(function() {
    let currentPage = 1;

    function loadNews(page) {
        $.ajax({
            url: 'KargatuBerriak.php?page=1',
            type: 'GET',
            data: { page: page },
            dataType: 'json',
            success: function(data) {
                if (data.length > 0) {
                    data.forEach(function(news) {
                        $('#news-container').append(`
                            <div class="news-item">
                                <h3>${news.title}</h3>
                                <p>${news.description}</p>
                                <img src="${news.image_url}" alt="" style="width:100%;">
                            </div>
                        `);
                    });
                } else {
                    $('#load-more').hide();
                }
            },
            error: function() {
                alert('Ezin izan dira kargatu berriak.');
            }
        });
    }

    loadNews(currentPage);

    $('#load-more').click(function() {
        currentPage++;
        loadNews(currentPage);
    });

    let currentPageShop = 1;

    function loadShop(page) {
        $.ajax({
            url: 'KargatuProduktuak.php?page=1',
            type: 'GET',
            data: { page: page },
            dataType: 'json',
            success: function(data) {
                if (data.length > 0) {
                    data.forEach(function(produktuak) {
                        let productHtml = `
                            <div class="prod-item">
                                <h3>${produktuak.ProduktuIzena}</h3>
                                <p>Mota: ${produktuak.ProduktuMota}</p>
                                <p>Egoera: ${produktuak.ProduktuEgoera}</p>
                                <p>Prezioa: ${produktuak.ProduktuPrezioa}€</p>
                                <p>Stock: ${produktuak.ProduktuKantitatea}</p>
                                <img src="${produktuak.ProduktuIruId}" alt="" style="width:100%;">`;

                        if (isLoggedIn === 'true') {
                            productHtml += `
                                <button class="erosaski" onclick="window.location.href='';">
                                    Erosi
                                </button>
                                <button class="erosaski" onclick="window.location.href='';">
                                    Saskira gehitu
                                </button>
                            `;
                        }

                        productHtml += `</div>`; 

                        $('#prod-container').append(productHtml);
                    });
                } else {
                    $('#load-more-prod').hide();
                }
            },
            error: function() {
                alert('Ezin izan dira kargatu produktuak.');
            }
        });
    }

    loadShop(currentPageShop);

    $('#load-more-prod').click(function() {
        currentPageShop++;
        loadShop(currentPageShop);
    });
});
function openNav() {
    document.getElementById("mySidebar").style.width = "75%";
}

function closeNav() {
    document.getElementById("mySidebar").style.width = "0";
}

//If media query changes this will let us to have the sidebar in the expected status
var mediaqueryList = window.matchMedia("(min-width: 759px)");
mediaqueryList.addListener(function (EventoMediaQueryList) {
    if (EventoMediaQueryList.matches) {
        document.getElementById("mySidebar").style.width = "100%";
    } else {
        document.getElementById("mySidebar").style.width = "0";
    }
});

function openLogin() {
    document.getElementById("login").style.width = "75%";
}

function closeLogin() {
    document.getElementById("login").style.width = "0";
}

var mediaqueryList = window.matchMedia("(min-width: 759px)");
mediaqueryList.addListener(function (EventoMediaQueryList) {
    if (EventoMediaQueryList.matches) {
        document.getElementById("login").style.width = "100%";
    } else {
        document.getElementById("login").style.width = "0";
    }
});