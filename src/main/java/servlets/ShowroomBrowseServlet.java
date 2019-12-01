package servlets;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import dao.DAO;
import entities.Showroom;
import services.ShowroomService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.UUID;

public class ShowroomBrowseServlet extends HttpServlet {

    private static ShowroomService showroomService = ShowroomService.getInstance();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doGet");
        HttpSession session = request.getSession();
        RequestDispatcher dispatcher = request.getRequestDispatcher("showroomBrowsePage.jsp");
        session.setAttribute("showrooms", showroomService.getAllShowrooms());
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getReader().readLine();
        Showroom showroom = showroomService.getShowroomById(UUID.fromString(id));
        showroomService.deleteShworoom(showroom);
    }

}
