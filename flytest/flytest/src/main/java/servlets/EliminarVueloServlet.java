package servlets;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import mundo.AdministradorVuelos;

public class EliminarVueloServlet extends HttpServlet {
    private AdministradorVuelos administradorVuelos;

    @Override
public void init() {
    ServletContext context = getServletContext();
    AdministradorVuelos adminVuelos = (AdministradorVuelos) context.getAttribute("vuelos");
    if (adminVuelos == null) {
        adminVuelos = new AdministradorVuelos();
        context.setAttribute("vuelos", adminVuelos);
    }
    administradorVuelos = adminVuelos;
}

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String codigoVuelo = request.getParameter("codigoVuelo");
        administradorVuelos.eliminarVuelo(codigoVuelo);

        response.sendRedirect("index.jsp");
    }
}
