package by.it.academy.scientific_activity.service;

import by.it.academy.scientific_activity.publications.Monograph;
import by.it.academy.scientific_activity.publications.Publication;

import java.util.List;

public interface MonographService {

    List<Monograph> getAllMonograph();

    Monograph addNewMonograph(Monograph monograph);
    void deleteMonograph(Long id);
    Monograph updateMonograph(Monograph monograph);
}
