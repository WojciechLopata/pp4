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
    }).then(response => response.json());
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
(() => {
console.log("It works");
const productList= document.querySelector("#productList")
console.log("my products");
getProducts()
.then(products=> {products
.map(p=> createProductComponent(p))
.map(el => initializeAddToCartHandler(el))
.forEach(el => productList.appendChild(el));

    });
   })();


