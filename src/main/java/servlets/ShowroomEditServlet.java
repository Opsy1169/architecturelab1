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

public class ShowroomEditServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String idToEdit = req.getParameter("id");
        Showroom showroom = null;
        RequestDispatcher dispatcher = req.getRequestDispatcher("showroomEditPage.jsp");
        if(idToEdit != null) {
            showroom = DAO.getShowroomById(UUID.fromString(idToEdit));
        } else {
            showroom = new Showroom();
        }
        session.setAttribute("showroom", showroom);
        dispatcher.forward(req, resp);
    }

    protected  void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String id = req.getParameter("id");
        Showroom showroom = null;
        String name = req.getParameter("name") == null ? "" : req.getParameter("name");
        String address = req.getParameter("address") == null ? "" : req.getParameter("address");
        if(id.isEmpty()){
            showroom = new Showroom();
            showroom.setId(UUID.randomUUID());
            showroom.setName(name);
            showroom.setAddress(address);
            DAO.saveEntity(showroom);
        } else {
            showroom = DAO.getShowroomById(UUID.fromString(id));
            showroom.setName(name);
            showroom.setAddress(address);
            DAO.updateEntity(showroom);
        }
        resp.sendRedirect("/architecturelab1_war_exploded/showroombrowse");
    }
}
