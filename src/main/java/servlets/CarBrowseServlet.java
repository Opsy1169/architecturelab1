package servlets;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import dao.DAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class CarBrowseServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doGet");
        HttpSession session = request.getSession();
        RequestDispatcher dispatcher = request.getRequestDispatcher("carBrowsePage.jsp");
        session.setAttribute("car", DAO.getAllCars());
//        request.setAttribute("car", DAO.getAllCars());
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

//        JsonObject jsonObject = new Gson().fromJson(request.getReader(), JsonObject.class);
//        String foo = jsonObject.get("id").getAsString();
//        String s = request.getParameter("id");
//        HttpSession session = request.getSession();
//        session.setAttribute("task", task);
//        resp.sendRedirect("/web_war_exploded/result");
//        int a = 2;
    }
}
