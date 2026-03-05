let carrito = [];

async function cargarProductos() {
    let respuesta = await fetch("../api/productos.php");
    let productos = await respuesta.json();

    let html = "<h2>Productos</h2><div>";
    productos.forEach(p => {
        html += `
          <div class="producto">
            <h3>${p.nombre}</h3>
            <p>Precio: $${p.precio}</p>
            <button onclick="agregarCarrito('${p.nombre}')">Agregar al carrito</button>
          </div>
        `;
    });
    html += "</div>";
    document.getElementById("vista").innerHTML = html;
}

function mostrarCarrito() {
    let html = "<h2>Carrito</h2><ul>";
    carrito.forEach(item => {
        html += `<li>${item}</li>`;
    });
    html += "</ul>";
    document.getElementById("vista").innerHTML = html;
}

function mostrarSeccion(seccion) {
    if (seccion === "productos") {
        cargarProductos();
    } else if (seccion === "carrito") {
        mostrarCarrito();
    }
}

function agregarCarrito(nombre) {
    carrito.push(nombre);
    alert(nombre + " agregado al carrito");
}

mostrarSeccion("productos");