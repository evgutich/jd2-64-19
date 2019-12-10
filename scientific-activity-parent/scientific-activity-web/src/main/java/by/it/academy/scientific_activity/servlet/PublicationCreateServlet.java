package by.it.academy.scientific_activity.servlet;

import by.it.academy.scientific_activity.publications.Monograph;
import by.it.academy.scientific_activity.publications.Publication;
import by.it.academy.scientific_activity.service.PublicationService;
import by.it.academy.scientific_activity.service.PublicationServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@WebServlet(urlPatterns = "/publicationCreate")
public class PublicationCreateServlet extends HttpServlet {

    private PublicationService publicationService = PublicationServiceImpl.getService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/publicationCreate.jsp")
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String type = req.getParameter("type");
        String title = req.getParameter("title");
        String edition = req.getParameter("edition");
        List<String> authors = new ArrayList<>(Arrays.asList(req.getParameter("authors").split("\n")));
        String printRun = req.getParameter("printRun");
        String pages = req.getParameter("pages");

        Publication publication = new Monograph(null, type, title, edition, authors, Integer.valueOf(printRun), Integer.valueOf(pages));
        publicationService.addNewPublication(publication);

        resp.sendRedirect(req.getContextPath() + "/publicationList");
    }
}
