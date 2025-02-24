const menu = document.querySelector('.hamburguesa');
const navegacion = document.querySelector('.navegacion');
const imagenes = document.querySelectorAll('img');
const btnTodos = document.querySelector('.todos');
const btnHamburguesa = document.querySelector('.btn-hamburguesa');
const btnPasta = document.querySelector('.pastas');
const btnPizza = document.querySelector('.pizzas');
const btnPostres = document.querySelector('.postres');
const contenedorPlatillos = document.querySelector('.platillos');
const enlaces = document.querySelectorAll('.navegacion a');

let overlay;


enlaces.forEach(enlace => {
    enlace.addEventListener('click', () => {
        navegacion.classList.add('ocultar');  // Cerrar el menú
        if (overlay) {
            overlay.remove();                 // Eliminar el overlay
        }
        const btnCerrar = document.querySelector('.btn-cerrar');
        if (btnCerrar) {
            btnCerrar.remove();               // Eliminar el botón de cierre
        }
    });
});

document.addEventListener('DOMContentLoaded', () => {
    eventos();
    platillos();
});

const eventos = () => {
    menu.addEventListener('click', abrirMenu);
}

const abrirMenu = () => {
    navegacion.classList.remove('ocultar');
    botonCerrar();
}

const botonCerrar = () => {
    const btnCerrar = document.createElement('p');
    const overlay = document.createElement('div');
    overlay.classList.add('pantalla-completa');
    const body = document.querySelector('body');
    if (document.querySelectorAll('.pantalla-completa').length > 0) return;
    body.appendChild(overlay);
    btnCerrar.textContent = 'x';
    btnCerrar.classList.add('btn-cerrar');

    navegacion.appendChild(btnCerrar);
    cerrarMenu(btnCerrar, overlay);
}

const observer = new IntersectionObserver((entries, observer) => {
    entries.forEach(entry => {
        if (entry.isIntersecting) {
            const imagen = entry.target;
            imagen.src = imagen.dataset.src;
            observer.unobserve(imagen);
        }
    });
});

imagenes.forEach(imagen => {

    observer.observe(imagen);
});

const cerrarMenu = (boton, overlay) => {
    boton.addEventListener('click', () => {
        navegacion.classList.add('ocultar');
        overlay.remove();
        boton.remove();
    });

    overlay.onclick = function () {
        overlay.remove();
        navegacion.classList.add('ocultar');
        boton.remove();
    }
}

const platillos = () => {
    let platillosArreglos = [];
    const platillos = document.querySelectorAll('.platillo');

    platillos.forEach(platillo => platillosArreglos = [...platillosArreglos, platillo]);

    const hamburguesa = platillosArreglos.filter(platillo => platillo.getAttribute('data-platillo') === 'hamburguesa');
    const pastas = platillosArreglos.filter(platillo => platillo.getAttribute('data-platillo') === 'pasta');
    const pizzas = platillosArreglos.filter(platillo => platillo.getAttribute('data-platillo') === 'pizza');
    const postres = platillosArreglos.filter(platillo => platillo.getAttribute('data-platillo') === 'postre');

    mostrarPlatillos(hamburguesa, pastas, pizzas, postres, platillosArreglos);
}

const mostrarPlatillos = (hamburguesa, pastas, pizzas, postres, todos) => {
    btnHamburguesa.addEventListener('click', () => {
        limpiarHtml(contenedorPlatillos);
        hamburguesa.forEach(hamburguesa => contenedorPlatillos.appendChild(hamburguesa));
    });

    btnPasta.addEventListener('click', () => {
        limpiarHtml(contenedorPlatillos);
        pastas.forEach(pasta => contenedorPlatillos.appendChild(pasta));
    });

    btnPizza.addEventListener('click', () => {
        limpiarHtml(contenedorPlatillos);
        pizzas.forEach(pizza => contenedorPlatillos.appendChild(pizza));
    });

    btnPostres.addEventListener('click', () => {
        limpiarHtml(contenedorPlatillos);
        postres.forEach(postre => contenedorPlatillos.appendChild(postre));
    });

    btnTodos.addEventListener('click', () => {
        limpiarHtml(contenedorPlatillos);
        todos.forEach(platillo => contenedorPlatillos.appendChild(platillo));
    });
}

const limpiarHtml = (contenedor) => {
    while (contenedor.firstChild) {
        contenedor.removeChild(contenedor.firstChild);
    }
}





document.getElementById('btn-suscribirse').addEventListener('click', function (event) {
    event.preventDefault();
    
    const correo = document.getElementById('correo-suscripcion').value;
    console.log("Correo ingresado:", correo);

    if (!correo) {
        alert('Por favor, ingresa un correo válido.');
        return;
    }

    fetch('php/suscribirse.php', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({ correo: correo }),
    })
    .then(response => response.text())  // Cambiar a .text() para inspeccionar la respuesta
    .then(data => {
        console.log("Respuesta del servidor:", data);
        try {
            const jsonData = JSON.parse(data);  // Intenta convertirlo en JSON
            if (jsonData.success) {
                alert('¡Suscripción exitosa!');
            } else {
                alert('Error al suscribir. Intenta de nuevo.');
            }
        } catch (error) {
            console.error("Error al analizar el JSON:", error);
        }
    })
    .catch(error => console.error('Error en la solicitud:', error));
    
    });

