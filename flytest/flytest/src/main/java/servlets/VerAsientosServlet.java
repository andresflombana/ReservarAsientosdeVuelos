package servlets;

import mundo.Vuelo;
import mundo.AdministradorVuelos;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

public class VerAsientosServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String codigoVuelo = request.getParameter("codigoVuelo");

        // Obtener el contexto de la aplicación
        ServletContext context = getServletContext();
        AdministradorVuelos administradorVuelos = (AdministradorVuelos) context.getAttribute("vuelos");

        // Obtener el vuelo por código
        Vuelo vuelo = administradorVuelos.obtenerVuelo(codigoVuelo);

        if (vuelo != null) {
            request.setAttribute("vuelo", vuelo);
        }

        // Redirigir al JSP para ver los asientos
        RequestDispatcher dispatcher = request.getRequestDispatcher("/verAsientos.jsp");
        dispatcher.forward(request, response);
    }
}
