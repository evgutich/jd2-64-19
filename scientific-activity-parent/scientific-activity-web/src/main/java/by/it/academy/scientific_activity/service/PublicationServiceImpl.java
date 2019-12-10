package by.it.academy.scientific_activity.service;

import by.it.academy.scientific_activity.publications.Monograph;
import by.it.academy.scientific_activity.publications.Publication;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PublicationServiceImpl implements PublicationService {

    private static final PublicationService INSTANCE = new PublicationServiceImpl();

    private final List<Publication> publications;

    public PublicationServiceImpl() {
        publications = new ArrayList<>();
        publications.add(new Monograph(1L, "digital", "Chemical work", "TIME", new ArrayList<>(Arrays.asList("Ivanov", "Petrov")), 100, 20));
        publications.add(new Monograph(2L, "print", "Biological work", "VAK", new ArrayList<>(Arrays.asList("Smirnov", "Sobolev")), 50, 10));
    }

    public static PublicationService getService() {
        return INSTANCE;
    }

    @Override
    public List<Publication> getAllPublications() {
        return publications;
    }

    @Override
    public void addNewPublication(Publication publication) {
        publication.setId((long) publications.size() + 1);
        publications.add(publication);
    }

    @Override
    public void deletePublication(Long id) {
        for (Publication publication : publications) {
            if (publication.getId().equals(id)) {
                publications.remove(publication);
            }
        }
    }

    @Override
    public void updatePublication(Publication publication) {
        for (Publication publ : publications){
            if (publ.getId().equals(publication.getId())){
                publ.setForm(publication.getForm());
                publ.setType(publication.getType());
                publ.setTitle(publication.getTitle());
                publ.setEdition(publication.getEdition());
                publ.setAuthors(publication.getAuthors());
                publ.setEntryDate(LocalDate.now());
            }
        }
    }
}
