package servlets;

import entities.Car;
import services.cars.CarService;
import services.cars.CarServiceImpl;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.UUID;

public class CarBrowseServlet extends HttpServlet {


    @EJB(beanName = "CarService")
    private CarService carService;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doGet");
        HttpSession session = request.getSession();
        RequestDispatcher dispatcher = request.getRequestDispatcher("carBrowsePage.jsp");
        session.setAttribute("car", carService.getAllCars());
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getReader().readLine();
        Car car = carService.getCarById(UUID.fromString(id));
        carService.deleteCar(car);
    }
}
