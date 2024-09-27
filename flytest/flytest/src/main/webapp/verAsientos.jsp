<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="navbar.jsp" %>

<html>
<head>
    <title>Asientos del Vuelo</title>
    <!-- Enlace a Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
    <div class="container mt-5">
        <h2 class="mb-4">Asientos del Vuelo ${vuelo.codigoVuelo}</h2>
        <table class="table table-bordered table-striped">
            <thead class="thead-dark">
                <tr>
                    <th>Número</th>
                    <th>Estado</th>
                    <th>Pasajero</th>
                    <th>Acciones</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="asiento" items="${vuelo.asientos}">
                    <tr>
                        <td>${asiento.numero}</td>
                        <td>
                            <c:choose>
                                <c:when test="${asiento.reservado}">Reservado</c:when>
                                <c:otherwise>Disponible</c:otherwise>
                            </c:choose>
                        </td>
                        <td>${asiento.nombrePasajero}</td>
                        <td>
                            <c:choose>
                                <c:when test="${asiento.reservado}">
                                    Reservado
                                </c:when>
                                <c:otherwise>
                                    <form action="ReservarAsientoServlet" method="get" style="display:inline;">
                                        <input type="hidden" name="codigoVuelo" value="${vuelo.codigoVuelo}" />
                                        <input type="hidden" name="numeroAsiento" value="${asiento.numero}" />
                                        <button type="submit" class="btn btn-success btn-sm">Reservar</button>
                                    </form>
                                </c:otherwise>
                            </c:choose>
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
