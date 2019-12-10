package by.it.academy.scientific_activity.service;

import by.it.academy.scientific_activity.publications.Publication;

import java.util.List;

public interface PublicationService {

    List<Publication> getAllPublications();

    void addNewPublication(Publication publication);
    void deletePublication(Long id);
    void updatePublication(Publication publication);
}
