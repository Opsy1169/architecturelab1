package servlets;

import dao.DAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Servlet2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DAO.createAndSaveCar();
        System.out.println("doGet");
        RequestDispatcher dispatcher = request.getRequestDispatcher("second.jsp");
        request.setAttribute("s", "from doGet");
        dispatcher.forward(request, response);
    }
}
