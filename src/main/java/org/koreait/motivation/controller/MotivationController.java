package org.koreait.motivation.controller;

import org.koreait.Container;
import org.koreait.motivation.entity.Article;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Motivation 관련 기능을 구현한 클래스
public class MotivationController {

    private List<Article> articles;
    //private Map<Integer, Article> articles; // 맵 이용하려면 바꿀게 너무 많다..
    public static int lastID;

    public MotivationController() {
        lastID = 0;
        articles = new ArrayList<>(); // = new HashMap<Integer, Article>();//
    }

    public void add() {
        System.out.print("body : ");
        String body = Container.getScanner().nextLine();
        System.out.print("source : ");
        String source = Container.getScanner().nextLine();

        ++lastID;
        articles.add(new Article(lastID, body, source));
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

    public void delete(int id) { // id값을 가져온다는 것을 유의할 것.
        boolean isFound = false;

        for(int i = 0; i < articles.size(); i++) {
            if (articles.get(i).getId() == id) {
                isFound = true;
                articles.remove(i);
                break;
            }
        }

        if(!isFound) {
            System.out.printf("%d번 motivation은 없습니다.\n", id);
            return;
        }

        System.out.printf("%d번 motivation이 삭제되었습니다.\n", id);

    }
}
