package servlets;

import mundo.Asiento;
import mundo.Vuelo;
import mundo.AdministradorVuelos;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

public class ReservarAsientoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Obtener los parámetros del vuelo y asiento
        String codigoVuelo = request.getParameter("codigoVuelo");
        int numeroAsiento = Integer.parseInt(request.getParameter("numeroAsiento"));

        // Pasar los datos al JSP para ingresar el nombre
        request.setAttribute("codigoVuelo", codigoVuelo);
        request.setAttribute("numeroAsiento", numeroAsiento);

        // Redirigir al JSP para ingresar el nombre del pasajero
        RequestDispatcher dispatcher = request.getRequestDispatcher("/reservarAsiento.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Obtener los parámetros enviados desde el formulario
        String codigoVuelo = request.getParameter("codigoVuelo");
        int numeroAsiento = Integer.parseInt(request.getParameter("numeroAsiento"));
        String nombrePasajero = request.getParameter("nombrePasajero");

        // Obtener la lista de vuelos desde el contexto de la aplicación
        ServletContext context = getServletContext();
        AdministradorVuelos administradorVuelos = (AdministradorVuelos) context.getAttribute("vuelos");

        // Buscar el vuelo por código
        Vuelo vuelo = administradorVuelos.obtenerVuelo(codigoVuelo);

        // Obtener el asiento por número
        if (vuelo != null) {
            Asiento asiento = vuelo.getAsientos().get(numeroAsiento - 1);

            // Reservar el asiento si no está ya reservado
            if (!asiento.isReservado()) {
                asiento.reservar(nombrePasajero);
            }
        }

        // Redirigir de vuelta a la página de asientos
        response.sendRedirect("VerAsientosServlet?codigoVuelo=" + codigoVuelo);
    }
}
