package by.it.academy.scientific_activity.servlet;

import by.it.academy.scientific_activity.service.MonographService;
import by.it.academy.scientific_activity.service.MonographServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet (urlPatterns = "/publicationDelete")
public class PublicationDeleteServlet extends HttpServlet {

    private MonographService publicationService = MonographServiceImpl.getService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        deletePublication(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        deletePublication(req, resp);
    }

    private void deletePublication (HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Long id = Long.valueOf(req.getParameter("id"));
        publicationService.deleteMonograph(id);
        resp.sendRedirect(req.getContextPath() + "/publicationList");
    }
}
