package com.company;

public class DocumentEntity {
    private int id;
    private String title;
    private String context;

    public DocumentEntity() {
    }

    public DocumentEntity(int id, String title, String context) {
        this.id = id;
        this.title = title;
        this.context = context;
    }

    public int getId() {
        return id;
    }

    public DocumentEntity setId(int id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public DocumentEntity setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getContext() {
        return context;
    }

    public DocumentEntity setContext(String context) {
        this.context = context;
        return this;
    }
}
