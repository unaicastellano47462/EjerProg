async function cargarProductos() {
    let respuesta = await fetch("../negocio/productos.php");
    let productos = await respuesta.json();

    let contenedor = document.getElementById("productos");
    productos.forEach(p => {
        let div = document.createElement("div");
        div.className = "producto";
        div.innerHTML = `
            <h2>${p.nombre}</h2>
            <p>Precio: $${p.precio}</p>
            <button onclick="agregarCarrito('${p.nombre}')">Agregar al carrito</button>
        `;
        contenedor.appendChild(div);
    });
}

function agregarCarrito(nombre) {
    let carrito = document.getElementById("carrito");
    let item = document.createElement("li");
    item.textContent = nombre;
    carrito.appendChild(item);
}

cargarProductos();