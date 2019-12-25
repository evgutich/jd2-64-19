package by.it.academy.scientific_activity.publications;

import java.util.List;
import java.util.Objects;

public class Monograph extends Publication {

    private Integer printRun;
    private Integer pages;

    public Monograph() {
    }

    public Monograph(Long id, String type, String title, String edition, List<String> authors, Integer printRun, Integer pages) {
        super(id, "Monograph", type, title, edition, authors);
        this.printRun = printRun;
        this.pages = pages;
    }

    public Integer getPrintRun() {
        return printRun;
    }

    public void setPrintRun(Integer printRun) {
        this.printRun = printRun;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Monograph monograph = (Monograph) o;
        return Objects.equals(printRun, monograph.printRun) &&
                Objects.equals(pages, monograph.pages);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), printRun, pages);
    }

    @Override
    public String toString() {
        return "Monograph{" +
                "printRun=" + printRun +
                ", pages=" + pages +
                "} " + super.toString();
    }
}
