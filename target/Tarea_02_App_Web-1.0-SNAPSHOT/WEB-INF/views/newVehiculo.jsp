<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8" />
    <title>Nuevo Vehículo</title>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;600&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
</head>

<body class="form-page">
    <main class="form-container">
        <h2>Crear Vehículo</h2>
        <form class="card form-card" action="${pageContext.request.contextPath}/vehiculos/nuevo" method="post">
            <label>Placa</label>
            <input type="text" name="placa" required>

            <label>Marca</label>
            <input type="text" name="marca">

            <label>Modelo</label>
            <input type="text" name="modelo">

            <label>Año</label>
            <input type="number" name="anio">

            <label>Usuario</label>
            <select name="usuarioId" required>
                <c:forEach var="u" items="${usuarios}">
                    <option value="${u.id}">${u.nombre} (${u.correo})</option>
                </c:forEach>
            </select>

            <div class="form-actions">
                <button class="btn btn-primary" type="submit">Guardar</button>
                <a class="btn btn-light" href="${pageContext.request.contextPath}/vehiculos">Volver</a>
            </div>
        </form>
    </main>
</body>

</html>