package servlets;

import mundo.Vuelo;
import mundo.AdministradorVuelos;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CrearVueloServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Obtener los parámetros del vuelo
        String codigoVuelo = request.getParameter("codigoVuelo");
        String salida = request.getParameter("salida");
        String llegada = request.getParameter("llegada");
        String fechaString = request.getParameter("fecha");
        int cantidadAsientos = Integer.parseInt(request.getParameter("cantidadAsientos"));

        // Parsear la fecha
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date fecha = null;
        try {
            fecha = formatter.parse(fechaString);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Crear el nuevo vuelo
        Vuelo vuelo = new Vuelo(codigoVuelo, salida, llegada, fecha, cantidadAsientos);

        // Obtener el contexto de la aplicación y el administrador de vuelos
        ServletContext context = getServletContext();
        AdministradorVuelos administradorVuelos = (AdministradorVuelos) context.getAttribute("vuelos");

        if (administradorVuelos == null) {
            administradorVuelos = new AdministradorVuelos();
        }

        // Agregar el vuelo al administrador
        administradorVuelos.agregarVuelo(vuelo);

        // Guardar el administrador actualizado en el contexto
        context.setAttribute("vuelos", administradorVuelos);

        // Redirigir a la página principal
        response.sendRedirect("index.jsp");
    }
}
