package by.it.academy.scientific_activity.servlet;

import by.it.academy.scientific_activity.service.PublicationService;
import by.it.academy.scientific_activity.service.PublicationServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet (urlPatterns = "/publicationDelete")
public class PublicationDeleteServlet extends HttpServlet {

    private PublicationService publicationService = PublicationServiceImpl.getService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.valueOf(req.getParameter("id"));
        publicationService.deletePublication(id);
        resp.sendRedirect(req.getContextPath() + "/publicationList");
    }
}
