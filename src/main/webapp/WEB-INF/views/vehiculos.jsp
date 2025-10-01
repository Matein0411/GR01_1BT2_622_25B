<%@ page contentType="text/html; charset=UTF-8" language="java" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <!DOCTYPE html>
        <html>

        <head>
            <meta charset="UTF-8" />
            <title>Vehículos</title>
            <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;600&display=swap" rel="stylesheet">
            <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
            <script defer src="${pageContext.request.contextPath}/resources/js/app.js"></script>
        </head>

        <body>
            <header class="topbar">
                <h1 class="brand">Taller Mecánico - Vehículos</h1>
                <nav>
                    <a class="btn btn-light" href="${pageContext.request.contextPath}/vehiculos/nuevo">+ Nuevo Vehículo</a>
                    <a class="btn btn-primary" href="${pageContext.request.contextPath}/usuarios">Usuarios</a>
                </nav>
            </header>

            <main class="container">
                <section class="controls">
                    <input id="searchVehicles" class="search" placeholder="Buscar por placa, marca o usuario..." />
                    <div class="decor">
                        <button class="icon-btn" aria-label="Buscar" style="background:#FDE68A!important;border:1px solid rgba(0,0,0,0.08);">
                    <svg width="28" height="28" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg" style="display:block;">
                        <circle cx="11" cy="11" r="6" stroke="#0b1220" stroke-width="1.6" fill="none" />
                        <path d="M20 20l-3.5-3.5" stroke="#0b1220" stroke-width="1.6" stroke-linecap="round" fill="none" />
                    </svg>
                </button>
                    </div>
                </section>

                <section id="vehiclesList" class="grid">
                    <c:forEach var="v" items="${vehiculos}">
                        <article class="card vehicle" data-placa="${v.placa}" data-marca="${v.marca}" data-usuario="${v.usuario != null ? v.usuario.nombre : ''}">
                            <div class="card-top">
                                <div class="vehicle-plate">${v.placa}</div>
                                <h3 class="card-title">${v.marca} ${v.modelo}</h3>
                            </div>
                            <div class="card-body">
                                <p><strong>Año:</strong> ${v.anio}</p>
                                <p><strong>Dueño:</strong> ${v.usuario != null ? v.usuario.nombre : 'Sin asignar'}</p>
                                <p class="small muted">ID: ${v.id}</p>
                            </div>
                        </article>
                    </c:forEach>
                </section>
            </main>

            <footer class="footer">Listado leído desde la base de datos </footer>
        </body>

        </html>