<!-- reservarAsiento.jsp -->
<%@ include file="navbar.jsp" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Reservar Asiento</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container">
        <h2 class="mt-5">Reservar Asiento</h2>
        <form method="post" action="ReservarAsientoServlet">
            <input type="hidden" name="codigoVuelo" value="${codigoVuelo}" />
            <input type="hidden" name="numeroAsiento" value="${numeroAsiento}" />

            <div class="form-group">
                <label>Nombre del Pasajero:</label>
                <input type="text" name="nombrePasajero" class="form-control" required />
            </div>

            <button type="submit" class="btn btn-primary">Reservar</button>
        </form>
    </div>
</body>
</html>
