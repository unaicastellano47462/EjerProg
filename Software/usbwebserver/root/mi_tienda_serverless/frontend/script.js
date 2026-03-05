async function cargarProductos() {
  let respuesta = await fetch("../functions/getProductos.php");
  let productos = await respuesta.json();
  let html = "<h2>Productos</h2>";
  productos.forEach(p => {
    html += `<div class="producto">
      <h3>${p.nombre}</h3>
      <p>Precio: $${p.precio}</p>
      <button onclick="agregarCarrito('${p.nombre}')">Agregar al carrito</button>
    </div>`;
  });
  document.getElementById("productos").innerHTML = html;
}

async function agregarCarrito(nombre) {
  await fetch("../functions/addCarrito.php", {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify({ producto: nombre })
  });
  alert(nombre + " agregado al carrito");
}

async function verCarrito() {
  let respuesta = await fetch("../functions/addCarrito.php");
  let carrito = await respuesta.json();
  let html = "<h2>Carrito</h2><ul>";
  carrito.forEach(item => {
    html += `<li>${item}</li>`;
  });
  html += "</ul>";
  document.getElementById("carrito").innerHTML = html;
}

cargarProductos();