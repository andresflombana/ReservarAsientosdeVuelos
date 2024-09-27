<%@ include file="navbar.jsp" %>
<html>
<head>
    <title>Crear Vuelo</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container">
        <h2>Crear Nuevo Vuelo</h2>
        <form method="post" action="CrearVueloServlet">
            <div class="form-group">
                <label>Código del Vuelo:</label>
                <input type="text" class="form-control" name="codigoVuelo" required />
            </div>
            <div class="form-group">
                <label>Salida:</label>
                <input type="text" class="form-control" name="salida" required />
            </div>
            <div class="form-group">
                <label>Llegada:</label>
                <input type="text" class="form-control" name="llegada" required />
            </div>
            <div class="form-group">
                <label>Fecha (YYYY-MM-DD):</label>
                <input type="date" class="form-control" name="fecha" required />
            </div>
            <div class="form-group">
                <label>Cantidad de Asientos:</label>
                <input type="number" class="form-control" name="cantidadAsientos" required />
            </div>
            <button type="submit" class="btn btn-primary">Crear Vuelo</button>
        </form>
    </div>
</body>
</html>
