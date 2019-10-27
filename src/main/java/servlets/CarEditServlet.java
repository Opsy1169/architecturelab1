package servlets;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import dao.DAO;
import entities.Car;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.UUID;

public class CarEditServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        req.getParameter("id");
//        String foo = jsonObject.get("id").getAsString();
        HttpSession session = req.getSession();
        String s = req.getParameter("id");
        RequestDispatcher dispatcher = req.getRequestDispatcher("carEditPage.jsp");
        Car car = DAO.getCarById(UUID.fromString(s));
        session.setAttribute("car", car);
        dispatcher.forward(req, resp);
    }
}
