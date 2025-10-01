<%@ page contentType="text/html; charset=UTF-8" language="java" %>
    <!DOCTYPE html>
    <html>

    <head>
        <meta charset="UTF-8" />
        <title>Nuevo Usuario</title>
        <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;600&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
    </head>

    <body class="form-page">
        <main class="form-container">
            <h2>Crear Usuario</h2>
            <form class="card form-card" action="${pageContext.request.contextPath}/usuarios/nuevo" method="post">
                <label>Nombre</label>
                <input type="text" name="nombre" required>

                <label>Correo</label>
                <input type="email" name="correo" required>

                <label>Teléfono</label>
                <input type="text" name="telefono" required>

                <div class="form-actions">
                    <button class="btn btn-primary" type="submit">Guardar</button>
                    <a class="btn btn-light" href="${pageContext.request.contextPath}/usuarios">Volver</a>
                </div>
            </form>
        </main>
    </body>

    </html>