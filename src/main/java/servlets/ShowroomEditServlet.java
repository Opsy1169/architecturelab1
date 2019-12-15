package servlets;

import entities.Showroom;
import services.showrooms.ShowroomService;
import services.util.UtilService;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.UUID;

public class ShowroomEditServlet extends HttpServlet {

    @EJB(beanName = "ShowroomService")
    private ShowroomService showroomService;

    @EJB(beanName = "UtilService")
    private UtilService utilService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String idToEdit = req.getParameter("id");
        Showroom showroom = null;
        RequestDispatcher dispatcher = req.getRequestDispatcher("showroomEditPage.jsp");
        if(idToEdit != null) {
            showroom = showroomService.getShowroomById(UUID.fromString(idToEdit));
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
        Integer capacity = utilService.parseIntegerFromString(req.getParameter("capacity") == null ? "" : req.getParameter("capacity"));
        if(id.isEmpty()){
            showroom = new Showroom();
            showroom.setId(UUID.randomUUID());
            showroomService.fillShowroomFields(showroom, name, address, capacity);
            showroomService.saveShowroom(showroom);
        } else {
            showroom = showroomService.getShowroomById(UUID.fromString(id));
            showroomService.fillShowroomFields(showroom, name, address, capacity);
            showroomService.updateShowroom(showroom);
        }
        resp.sendRedirect("/architecturelab1_war_exploded/showroombrowse");
    }


}
