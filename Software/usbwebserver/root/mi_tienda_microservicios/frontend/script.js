async function cargarProductos() {
    let respuesta = await fetch("../servicio_productos/productos.php");
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

async function agregarCarrito(nombre) {
    let respuesta = await fetch("../servicio_carrito/carrito.php", {
        method: "POST",
        headers: {"Content-Type": "application/json"},
        body: JSON.stringify({ producto: nombre })
    });

    let carrito = await respuesta.json();
    let lista = document.getElementById("carrito");
    lista.innerHTML = "";
    carrito.forEach(item => {
        let li = document.createElement("li");
        li.textContent = item;
        lista.appendChild(li);
    });
}

cargarProductos();