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
//----------------------------------------------------------------------------------------------------------------------------
let currentPageShop = 1;
let cart = JSON.parse(localStorage.getItem('cart')) || {}; // Cargar carrito desde localStorage

function loadShop(page) {
    $.ajax({
        url: 'KargatuProduktuak.php',
        type: 'GET',
        data: { page: page },
        dataType: 'json',
        success: function(data) {
            if (data.length > 0) {
                data.forEach(function(produktuak) {
                    let productHtml = `
                        <div class="prod-item" data-id="${produktuak.ProduktuId}">
                            <h3>${produktuak.ProduktuIzena}</h3>
                            <p>Mota: ${produktuak.ProduktuMota}</p>
                            <p>Egoera: ${produktuak.ProduktuEgoera}</p>
                            <p>Prezioa: ${produktuak.ProduktuPrezioa}€</p>
                            <p>Stock: ${produktuak.ProduktuKantitatea}</p>
                            <img src="${produktuak.ProduktuIruId}" alt="" style="width:100%;">`;

                    if (isLoggedIn === 'true') {
                        productHtml += `
                            <button class="erosaski" onclick="buyNow(${produktuak.ProduktuId})">
                                Erosi
                            </button>
                            <button class="erosaski add-to-cart" data-id="${produktuak.ProduktuId}" data-name="${produktuak.ProduktuIzena}">
                                Saskira gehitu
                            </button>
                        `;
                    }

                    productHtml += `</div>`; 
                    $('#prod-container').append(productHtml);
                });

                // Agregar evento a los botones de añadir al carrito
                $('.add-to-cart').click(function() {
                    let productId = $(this).data('id');
                    let productName = $(this).data('name');
                    addToCart(productId, productName);
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

// Actualizar el icono de la cesta
function updateCartIcon() {
    let totalItems = Object.values(cart).reduce((acc, item) => acc + item.quantity, 0);
    $('#cart-count').text(totalItems);
}

// Mostrar el carrito en el desplegable
function showCartDropdown() {
    let cartList = $('#cart-items');
    cartList.empty();

    if (Object.keys(cart).length === 0) {
        cartList.append('<li>Saskia hutsik dago</li>');
    } else {
        Object.keys(cart).forEach(productId => {
            let item = cart[productId];
            cartList.append(`
                <li>
                    ${item.name} x${item.quantity}
                    <button class="remove-from-cart" data-id="${productId}"><i class='fas fa-minus'></i></button>
                </li>
            `);
        });

        // Botón para vaciar el carrito completamente
        cartList.append(`
            <li>
                <button id="clear-cart" class="clear-cart">🗑️ Saskia garbitu</button>
            </li>
        `);

        // Evento para eliminar productos
        $('.remove-from-cart').off('click').on('click', function() { 
            let productId = $(this).data('id');
            removeFromCart(productId);
        });

        // Evento para vaciar todo el carrito
        $('#clear-cart').off('click').on('click', clearCart);
    }

    $('#cart-dropdown').toggle();
}

function addToCart(productId, productName) {
    if (!cart[productId]) {
        cart[productId] = { name: productName, quantity: 0 };
    }
    cart[productId].quantity++;
    localStorage.setItem('cart', JSON.stringify(cart));
    updateCartIcon();
    showCartDropdown(); // Para actualizar la lista
}

function removeFromCart(productId) {
    if (cart[productId]) {
        cart[productId].quantity--;
        if (cart[productId].quantity <= 0) {
            delete cart[productId]; // Eliminar del objeto
        }
        localStorage.setItem('cart', JSON.stringify(cart));
        updateCartIcon();
        showCartDropdown(); // Refrescar la lista del carrito
    }
}

// Nueva función para vaciar todo el carrito
function clearCart() {
    cart = {}; // Vaciar el objeto
    localStorage.removeItem('cart'); // Eliminar del almacenamiento local
    updateCartIcon();
    showCartDropdown(); // Refrescar la lista del carrito
}

function goToCheckout() {
    window.location.href = `checkout.php?cart=${encodeURIComponent(JSON.stringify(cart))}`;
}

// Event Listeners
$('#cart-icon').click(showCartDropdown);
$('#checkout-button').click(goToCheckout);

// Inicializar icono de cesta
updateCartIcon();

function buyNow(productId) {
    window.location.href = `checkout.php?product=${productId}`;
}

loadShop(currentPageShop);

$('#load-more-prod').click(function() {
    currentPageShop++;
    loadShop(currentPageShop);
});

//----------------------------------------------------------------------------------------------------------------------------
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