package org.koreait.motivation.controller;

import org.koreait.motivation.entity.Article;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Motivation 관련 기능을 구현한 클래스
public class MotivationController {

    private List<Article> articles;
    // private Map<Integer, Article> articles = new HashMap<Integer, Article>(); // 맵 이용하려면 바꿀게 너무 많다..
    public static int lastID;
    Scanner sc;

    public MotivationController(Scanner sc) {
        this.sc = sc;
        lastID = 0;
        articles = new ArrayList<>();
    }

    public void add() {
        System.out.print("body : ");
        String body = sc.nextLine();
        System.out.print("source : ");
        String source = sc.nextLine();

        articles.add(new Article(++lastID, body, source));
        System.out.printf("%d번 motivation이 등록되었습니다.\n", lastID);

    }

    public void list() {

        System.out.println("== motivation list ==");
        System.out.println("     id //     source // body");
        System.out.println("=".repeat(40));

        if (articles.isEmpty()) {
            System.out.println("등록된 motivation이 없습니다.");
        } else {
            for (int i = articles.size() - 1; i >= 0; i--) {
                Article article = articles.get(i);
                article.showArticle();
                // System.out.printf(" %5d \t// %10s // %3s\n", this.getId(), this.getSource(), this.getBody());
            }
        }
    }
}
