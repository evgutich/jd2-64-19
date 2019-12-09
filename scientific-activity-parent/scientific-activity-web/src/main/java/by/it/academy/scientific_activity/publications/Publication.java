package by.it.academy.scientific_activity.publications;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public abstract class Publication {

    private Long id;
    private String type;
    private String form;
    private String title;
    private String edition;
    private List<String> authors;
    private LocalDate entryDate;

    public Publication() {
    }

    public Publication(Long id, String form, String type, String title, String edition, List<String> authors) {
        this.id = id;
        this.form = form;
        this.type = type;
        this.title = title;
        this.edition = edition;
        this.authors = authors;
        this.entryDate = LocalDate.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    public LocalDate getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(LocalDate entryDate) {
        this.entryDate = entryDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Publication that = (Publication) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(type, that.type) &&
                Objects.equals(form, that.form) &&
                Objects.equals(title, that.title) &&
                Objects.equals(edition, that.edition) &&
                Objects.equals(authors, that.authors) &&
                Objects.equals(entryDate, that.entryDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, form, title, edition, authors, entryDate);
    }

    @Override
    public String toString() {
        return "Publication{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", form='" + form + '\'' +
                ", title='" + title + '\'' +
                ", edition='" + edition + '\'' +
                ", authors=" + authors +
                ", entryDate=" + entryDate +
                '}';
    }
}
