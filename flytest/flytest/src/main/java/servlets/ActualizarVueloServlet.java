package servlets;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import mundo.AdministradorVuelos;

public class ActualizarVueloServlet extends HttpServlet {
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
        String nuevoCodigoVuelo = request.getParameter("nuevoCodigoVuelo");
        String salida = request.getParameter("salida");
        String llegada = request.getParameter("llegada");
        String fechaString = request.getParameter("fecha");
        String nuevaCantidadAsientosString = request.getParameter("CantidadAsientos");

        // Validar si nuevaCantidadAsientos no es nulo ni vacío
        int nuevaCantidadAsientos = 0;
        if (nuevaCantidadAsientosString != null && !nuevaCantidadAsientosString.isEmpty()) {
            try {
                nuevaCantidadAsientos = Integer.parseInt(nuevaCantidadAsientosString);
            } catch (NumberFormatException e) {
                e.printStackTrace();
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "El valor de la cantidad de asientos no es válido.");
                return;
            }
        } else {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "El valor de la cantidad de asientos no puede estar vacío.");
            return;
        }

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date fecha = null;
        try {
            fecha = formatter.parse(fechaString);
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "El formato de la fecha es incorrecto.");
            return;
        }

        administradorVuelos.actualizarVuelo(codigoVuelo, nuevoCodigoVuelo, salida, llegada, fecha, nuevaCantidadAsientos);

        response.sendRedirect("index.jsp");
    }
}
