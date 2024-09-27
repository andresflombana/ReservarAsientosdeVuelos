<%@ include file="navbar.jsp" %>
<html>
<head>
    <title>Editar Vuelo</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container">
        <h2>Editar Vuelo</h2>
        <form method="post" action="ActualizarVueloServlet">
            <input type="hidden" name="codigoVuelo" value="${vuelo.codigoVuelo}" />
            <div class="form-group">
                <label>Salida:</label>
                <input type="text" class="form-control" name="salida" value="${vuelo.salida}" required />
            </div>
            <div class="form-group">
                <label>Llegada:</label>
                <input type="text" class="form-control" name="llegada" value="${vuelo.llegada}" required />
            </div>
            <div class="form-group">
                <label>Fecha (YYYY-MM-DD):</label>
                <input type="date" class="form-control" name="fecha" value="${vuelo.fecha}" required />
            </div>
            <button type="submit" class="btn btn-primary">Actualizar Vuelo</button>
        </form>
    </div>
</body>
</html>
