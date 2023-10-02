const a = 5;
let b=5;
const myFunction=(foo) =>{
console.log(foo);
}

(() => {
console.log("It works")
})();
const getProducts= () =>{
    return fetch("/api/products").then(response => response.json());

}
const initializeAddToCartHandler = (el) =>{
const btn= el.querySelector('button.product_add-to-cart');
btn.addEventListener('click',()=> {
addToCart(btn.getAttribute('data-product-id'))
   .then(refreshCurrentOffer())
});
return el;
}
const refreshCurrentOffer= () =>{
console.log(' i am going to refresh offer');
    const offerElement = document.querySelector('.cart');
    getCurrentOffer().then(offer =>{
    console.log(offer);
    offerElement.querySelector('.total').textContent=`${offer.total} PLN`;
    offerElement.querySelector('.itemsCount').textContent=`${offer.itemsCount} items`;
    });
}
const getCurrentOffer = () =>{
    return fetch("/api/get-current-offer").then(response => response.json());

}

const addToCart= (uuid) => {
    return fetch (`/api/add-to-cart/${uuid}`,{
    method: "Post",
    body: JSON.stringify({})
    });
}
const createHtmlElementFromString = (template) =>{
let tmpElement = document.createElement('div');
tmpElement.innerHTML= template.trim();
const elem = tmpElement.firstChild;
return elem;

}
const createProductComponent = (product) => {
const template = `
<li class="Product">
    <span> ${product.name} </span>
    <div>
        <span>${product.price}</span>

    </div>
    <button class="product_add-to-cart"
        data-product-id="${product.id}">
        Add to cart
    </button>
</li>
`;
return createHtmlElementFromString(template);
}


const initializeEcommerce = async () => {
    await refreshCurrentOffer();

    const productsList = document.querySelector('#productList');
    const products = await getProducts();
    console.log(products);
    products
        .map(p => createProductComponent(p))
        .map(productEl => initializeAddToCartHandler(productEl))
        .forEach(productEl => {
            productsList.appendChild(productEl)
        });

}

const acceptOfferBtn = document.querySelector('.acceptOffer');
console.log(acceptOfferBtn);
const checkoutLayerEl = document.querySelector('#checkout');
const checkoutForm = document.querySelector('#checkout form');

checkoutForm.addEventListener('submit', (e) => {
    e.preventDefault();

    const data = new FormData(checkoutForm);
    let request = {};
    for (let [key, value] of data) {
        request[key] = value;
    }

    fetch("/api/accept-offer", {
        method: 'POST',
        body: JSON.stringify(request),
        headers: {
            "Content-Type": "application/json",
        },
    })
        .then(r => r.json())
        .then(data => window.location.href = data.paymentUrl);
})

acceptOfferBtn.addEventListener('click', () => {
    console.log("checkout");
    console.log(acceptOfferBtn);
    checkoutLayerEl.classList.add('shown');
});

(() => {
    initializeEcommerce()
        .then(r => {});
})();


