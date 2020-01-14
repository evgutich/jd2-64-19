package by.it.academy.scientific_activity.publications;

import java.time.LocalDate;
import java.util.Objects;

public abstract class Publication {

    private Long id;
    private String type;
    private String form;
    private String title;
    private String edition;
    private Long authorId;
    private LocalDate entryDate;

    public Publication() {
    }

    public Publication(Long id, String form, String type, String title, String edition, Long author_id, LocalDate entryDate) {
        this.id = id;
        this.form = form;
        this.type = type;
        this.title = title;
        this.edition = edition;
        this.authorId = author_id;
        this.entryDate = entryDate;
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

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
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
                Objects.equals(authorId, that.authorId) &&
                Objects.equals(entryDate, that.entryDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, form, title, edition, authorId, entryDate);
    }

    @Override
    public String toString() {
        return "Publication{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", form='" + form + '\'' +
                ", title='" + title + '\'' +
                ", edition='" + edition + '\'' +
                ", author_id=" + authorId +
                ", entryDate=" + entryDate +
                '}';
    }
}
