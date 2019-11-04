package servlets;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import dao.DAO;
import entities.Car;
import entities.Showroom;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.UUID;

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
        String id = request.getReader().readLine();
        Car car = DAO.getCarById(UUID.fromString(id));
        DAO.deleteEntity(car);
    }
}
