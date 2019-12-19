package by.it.academy.scientific_activity.servlet;

import by.it.academy.scientific_activity.publications.Publication;
import by.it.academy.scientific_activity.service.PublicationService;
import by.it.academy.scientific_activity.service.PublicationServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/publicationList")
public class PublicationListServlet extends HttpServlet {

    private PublicationService publicationService = PublicationServiceImpl.getService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Publication> allPublications = publicationService.getAllPublications();
        req.setAttribute("publicationList", allPublications);
        req.getRequestDispatcher("/WEB-INF/jsp/publication-list.jsp")
                .forward(req, resp);
    }
}
