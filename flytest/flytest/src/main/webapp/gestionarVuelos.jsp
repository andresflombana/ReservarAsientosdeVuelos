<html>
<head>
    <title>Gestión de Vuelos</title>
</head>
<body>
    <h1>Gestión de Vuelos</h1>

    <!-- Formulario para crear vuelo -->
    <h2>Crear Nuevo Vuelo</h2>
    <form method="post" action="crearVuelo">
        <label>Código del Vuelo:</label>
        <input type="text" name="codigoVuelo" required /><br>
        <label>Salida:</label>
        <input type="text" name="salida" required /><br>
        <label>Llegada:</label>
        <input type="text" name="llegada" required /><br>
        <label>Fecha (YYYY-MM-DD):</label>
        <input type="date" name="fecha" required /><br>
        <label>Cantidad de Asientos:</label>
        <input type="number" name="cantidadAsientos" required /><br>
        <button type="submit">Crear Vuelo</button>
    </form>

    <!-- Lista de vuelos -->
    <h2>Lista de Vuelos</h2>
    <table border="1">
        <tr>
            <th>Código</th>
            <th>Salida</th>
            <th>Llegada</th>
            <th>Fecha</th>
            <th>Asientos</th>
            <th>Acciones</th>
        </tr>
        <c:forEach var="vuelo" items="${vuelos}">
            <tr>
                <td>${vuelo.codigoVuelo}</td>
                <td>${vuelo.salida}</td>
                <td>${vuelo.llegada}</td>
                <td>${vuelo.fecha}</td>
                <td>${vuelo.asientos.size()}</td>
                <td>
                    <!-- Ver Asientos -->
                    <form action="verAsientos" method="get" style="display:inline;">
                        <input type="hidden" name="codigoVuelo" value="${vuelo.codigoVuelo}" />
                        <button type="submit">Ver Asientos</button>
                    </form>

                    <!-- Editar vuelo -->
                    <form action="actualizarVuelo.jsp" method="get" style="display:inline;">
                        <input type="hidden" name="codigoVuelo" value="${vuelo.codigoVuelo}" />
                        <button type="submit">Editar</button>
                    </form>

                    <!-- Eliminar vuelo -->
                    <form action="eliminarVuelo" method="post" style="display:inline;">
                        <input type="hidden" name="codigoVuelo" value="${vuelo.codigoVuelo}" />
                        <button type="submit">Eliminar</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>

    <!-- Si se selecciona un vuelo para ver los asientos -->
    <c:if test="${vuelo != null}">
        <h2>Asientos del Vuelo ${vuelo.codigoVuelo}</h2>
        <table border="1">
            <tr>
                <th>Número</th>
                <th>Estado</th>
                <th>Pasajero</th>
                <th>Acciones</th>
            </tr>
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
                                <form action="liberarAsiento" method="post" style="display:inline;">
                                    <input type="hidden" name="codigoVuelo" value="${vuelo.codigoVuelo}" />
                                    <input type="hidden" name="numeroAsiento" value="${asiento.numero}" />
                                    <button type="submit">Liberar</button>
                                </form>
                            </c:when>
                            <c:otherwise>
                                <form action="reservarAsiento.jsp" method="get" style="display:inline;">
                                    <input type="hidden" name="codigoVuelo" value="${vuelo.codigoVuelo}" />
                                    <input type="hidden" name="numeroAsiento" value="${asiento.numero}" />
                                    <button type="submit">Reservar</button>
                                </form>
                            </c:otherwise>
                        </c:choose>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
</body>
</html>
