package edu.sfsu.classes.models;

public class Name {
    private String first;
    private String last;
    private String title;

    public Name(String first, String last, String title) {
        this.first = first;
        this.last = last;
        this.title = title;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
