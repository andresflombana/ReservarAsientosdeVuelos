package servlets;

import mundo.AdministradorVuelos;
import mundo.Vuelo;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

public class ListarVuelosServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Obtener el contexto de la aplicación y el administrador de vuelos
        ServletContext context = getServletContext();
        AdministradorVuelos administradorVuelos = (AdministradorVuelos) context.getAttribute("vuelos");

        // Obtener la lista de vuelos
        List<Vuelo> vuelos = administradorVuelos.obtenerVuelos();

        // Pasar la lista de vuelos al JSP
        request.setAttribute("vuelos", vuelos);

        // Redirigir a la página JSP que muestra los vuelos
        RequestDispatcher dispatcher = request.getRequestDispatcher("/listarVuelos.jsp");
        dispatcher.forward(request, response);
    }
}
