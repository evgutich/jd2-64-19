package by.it.academy.scientific_activity.servlet;

import by.it.academy.scientific_activity.publications.Monograph;
import by.it.academy.scientific_activity.publications.Publication;
import by.it.academy.scientific_activity.service.MonographService;
import by.it.academy.scientific_activity.service.MonographServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@WebServlet(urlPatterns = "/publicationCreate")
public class PublicationCreateServlet extends HttpServlet {

    private static final Logger LOGGER = LoggerFactory.getLogger(PublicationCreateServlet.class);
    private MonographService publicationService = MonographServiceImpl.getService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/jsp/publication/publication-create.jsp")
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String courseId = req.getParameter("courseId");

        LOGGER.info("course id: {}", courseId);
        log("course id: " + courseId);

        String type = req.getParameter("type");
        String title = req.getParameter("title");
        String edition = req.getParameter("edition");
        String authorId = req.getParameter("authorId");
        List<String> authors = new ArrayList<>(Arrays.asList(req.getParameter("authors").split("\n")));
        String printRun = req.getParameter("printRun");
        String pages = req.getParameter("pages");

        Monograph monograph = new Monograph(null, type, title, edition, Long.valueOf(authorId), Integer.valueOf(printRun), Integer.valueOf(pages), LocalDate.now());
        publicationService.addNewMonograph(monograph);

        resp.sendRedirect(req.getContextPath() + "/publicationList");
    }
}
