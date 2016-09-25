package servlet;

import DAO.DAOUsuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Usuario;
import utilidades.DBUtil;

public class Registrar extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Registrar</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Registrar at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idUsuario = request.getParameter("idUsuario");
        String nombreUsuario = request.getParameter("nombreUsuario");
        String password = request.getParameter("password");
        String genero = request.getParameter("genero");
        String[] hobbies = request.getParameterValues("hobbies");
        String pais = request.getParameter("pais");
        String[] idiomas = request.getParameterValues("idiomas");

        response.setContentType("text/html");
        PrintWriter salida = response.getWriter();

        salida.println("<h1>Usuario Registrado</h1>");

        salida.println("<p>Nombre Usuario: " + nombreUsuario + "</p>");
        salida.println("<p>Password: " + password + "</p>");
        salida.println("<p>Genero: " + genero + "</p>");

        salida.println("<p>Hobbies:");
        for (int i = 0; i < hobbies.length; i++) {
            if (i < hobbies.length - 1) {
                salida.println(hobbies[i] + ", ");
            } else {
                salida.println(hobbies[i]);
            }
        }
        salida.println(" </p>");

        salida.println("<p>País: " + pais + "</p>");

        salida.println("<p>Idiomas:");
        for (int i = 0; i < idiomas.length; i++) {
            if (i < idiomas.length - 1) {
                salida.println(idiomas[i] + ", ");
            } else {
                salida.println(idiomas[i]);
            }
        }
        salida.println(" </p>");

        DAO.DAOUsuario daoUsuario = new DAOUsuario();
        
        Usuario usuario = new Usuario(Integer.parseInt(idUsuario), nombreUsuario, password, genero,  pais);
        daoUsuario.agregarUsuario(usuario);   
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
