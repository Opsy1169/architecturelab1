package servlets;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.sun.org.apache.xpath.internal.operations.Bool;
import dao.DAO;
import entities.Car;
import services.CarService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.UUID;

public class CarEditServlet extends HttpServlet {

    private CarService carService = CarService.getInstance();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String idToEdit = req.getParameter("id");
        Car car = null;
        RequestDispatcher dispatcher = req.getRequestDispatcher("carEditPage.jsp");
        if(idToEdit != null) {
            car = carService.getCarById(UUID.fromString(idToEdit));
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
        Integer doorCount = Integer.parseInt(req.getParameter("doorCount") == null ? "" : req.getParameter("doorCount"));
        String modelCode = req.getParameter("modelCode") == null ? "" : req.getParameter("modelCode");
        Boolean isElectrocar = extractCheckBoxValue(req.getParameter("isElectrocar"));
        String description = req.getParameter("description") == null ? "" : req.getParameter("description");
        if(id.isEmpty()){
            car = new Car();
            car.setId(UUID.randomUUID());
            carService.fillCarFields(car, model, manufacturer, doorCount, modelCode, isElectrocar, description);
            carService.saveCar(car);
        } else {
            car = carService.getCarById(UUID.fromString(id));
            carService.fillCarFields(car, model, manufacturer, doorCount, modelCode, isElectrocar, description);
            carService.updateCar(car);
        }
        resp.sendRedirect("/architecturelab1_war_exploded/carbrowse");
    }

    private Boolean extractCheckBoxValue(String value){
        return value != null && value.equals("on");
    }


}
