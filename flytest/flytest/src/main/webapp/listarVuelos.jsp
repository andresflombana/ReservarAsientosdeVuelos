<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="navbar.jsp" %>

<html>
<head>
    <title>Lista de Vuelos</title>
    <!-- Enlace a Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
    <div class="container mt-5">
        <h2 class="mb-4">Lista de Vuelos</h2>
        <table class="table table-bordered table-striped">
            <thead class="thead-dark">
                <tr>
                    <th>Código</th>
                    <th>Salida</th>
                    <th>Llegada</th>
                    <th>Fecha</th>
                    <th>Asientos</th>
                    <th>Acciones</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="vuelo" items="${vuelos}">
                    <tr>
                        <td>${vuelo.codigoVuelo}</td>
                        <td>${vuelo.salida}</td>
                        <td>${vuelo.llegada}</td>
                        <td>${vuelo.fecha}</td>
                        <td>${vuelo.asientos.size()}</td>
                        <td>
                            <a href="VerAsientosServlet?codigoVuelo=${vuelo.codigoVuelo}" class="btn btn-info btn-sm">Ver Asientos</a>
                            <a href="editarVuelo.jsp?codigoVuelo=${vuelo.codigoVuelo}" class="btn btn-warning btn-sm">Editar</a>
                            <form action="EliminarVueloServlet" method="post" style="display:inline;">
                                <input type="hidden" name="codigoVuelo" value="${vuelo.codigoVuelo}">
                                <button type="submit" class="btn btn-danger btn-sm">Eliminar</button>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
    <!-- Enlace a Bootstrap JS (opcional, para funcionalidades interactivas) -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.0.7/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
