package by.it.academy.scientific_activity.servlet;

import by.it.academy.scientific_activity.publications.Monograph;
import by.it.academy.scientific_activity.publications.Publication;
import by.it.academy.scientific_activity.service.MonographService;
import by.it.academy.scientific_activity.service.MonographServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/publicationList")
public class PublicationListServlet extends HttpServlet {

    private MonographService publicationService = MonographServiceImpl.getService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Monograph> allMonographs = publicationService.getAllMonograph();
        req.setAttribute("publicationList", allMonographs);
        req.getRequestDispatcher("/WEB-INF/jsp/publication/publication-list.jsp")
                .forward(req, resp);
    }
}
