function agregarCarrito(nombre) {
    let carrito = document.getElementById("carrito");
    let item = document.createElement("li");
    item.textContent = nombre;
    carrito.appendChild(item);
}