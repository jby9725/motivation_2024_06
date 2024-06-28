package org.koreait;

public class Article {
    private int id;
    private String body;
    private String source;

    public Article(int id, String body, String source) {
        this.id = id;
        this.body = body;
        this.source = source;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public int getId() {
        return this.id;
    }

    public String getBody() {
        return this.body;
    }

    public String getSource() {
        return this.source;
    }

}