package org.koreait.motivation.entity;

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

    public void showArticle() {

        if (this.getSource().length() > 7) { // source의 길이가 너무 길 때 축약.
            System.out.printf(" %5d \t// %10s // %3s\n", this.getId(), this.getSource().substring(0, 5) + "...", this.getBody());
        } else {
            System.out.printf(" %5d \t// %10s // %3s\n", this.getId(), this.getSource(), this.getBody());
        }
    }
}