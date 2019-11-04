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
        HttpSession session = req.getSession();
        String idToEdit = req.getParameter("id");
        Car car = null;
        RequestDispatcher dispatcher = req.getRequestDispatcher("carEditPage.jsp");
        if(idToEdit != null) {
            car = DAO.getCarById(UUID.fromString(idToEdit));
        } else {
            car = new Car();
        }
        session.setAttribute("car", car);
        dispatcher.forward(req, resp);
    }

    protected  void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String id = req.getParameter("id");
        Car car = null;
        String model = req.getParameter("model") == null ? "" : req.getParameter("model");
        String manufacturer = req.getParameter("manufacturer") == null ? "" : req.getParameter("manufacturer");
        if(id.isEmpty()){
            car = new Car();
            car.setId(UUID.randomUUID());
            car.setModel(model);
            car.setManufacturer(manufacturer);
            DAO.saveEntity(car);
        } else {
            car = DAO.getCarById(UUID.fromString(id));
            car.setModel(model);
            car.setManufacturer(manufacturer);
            DAO.updateEntity(car);
        }
        resp.sendRedirect("/architecturelab1_war_exploded/carbrowse");
    }
}
