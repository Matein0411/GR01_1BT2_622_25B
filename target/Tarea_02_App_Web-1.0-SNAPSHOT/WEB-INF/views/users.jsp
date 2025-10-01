<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8" />
    <title>Usuarios</title>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;600&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
    <script defer src="${pageContext.request.contextPath}/resources/js/app.js"></script>
</head>

<body>
    <header class="topbar">
        <h1 class="brand">Taller - Usuarios</h1>
        <nav>
            <a class="btn btn-light" href="${pageContext.request.contextPath}/usuarios/nuevo">+ Nuevo Usuario</a>
            <a class="btn btn-primary" href="${pageContext.request.contextPath}/vehiculos">Vehículos</a>
        </nav>
    </header>

    <main class="container">
        <section class="controls">
            <input id="searchUsers" class="search" placeholder="Buscar por nombre o correo..." />
            <div class="decor">
                <!-- figura decorativa -->
                <svg width="120" height="60" viewBox="0 0 120 60" fill="none" xmlns="http://www.w3.org/2000/svg">
                    <rect x="0" y="0" width="120" height="60" rx="12" fill="#FDE68A"/>
                </svg>
            </div>
        </section>

        <section id="usersList" class="grid">
            <c:forEach var="u" items="${usuarios}">
                <article class="card" data-name="${u.nombre}" data-email="${u.correo}">
                    <div class="card-top">
                        <div class="avatar">${u.nombre.substring(0,1).toUpperCase()}</div>
                        <h3 class="card-title">${u.nombre}</h3>
                    </div>
                    <div class="card-body">
                        <p><strong>Correo:</strong> ${u.correo}</p>
                        <p><strong>Tel:</strong> ${u.telefono}</p>
                        <p class="small muted">ID: ${u.id}</p>
                    </div>
                </article>
            </c:forEach>
        </section>
    </main>

    <footer class="footer">Listado leído desde la base de datos mediante Hibernate</footer>
</body>

</html>