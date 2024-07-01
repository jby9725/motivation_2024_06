package org.koreait.motivation.controller;

import org.koreait.Container;
import org.koreait.RequestProcesser;
import org.koreait.motivation.entity.Article;


import java.util.ArrayList;
import java.util.List;

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

    public void delete(RequestProcesser processer) {
        int id;

        try {
            id = Integer.parseInt(processer.getParams("id"));
        } catch (NumberFormatException e) {
            System.out.println("정수 입력 오류");
            return;
        }

        Article article = findById(id);

        if (article == null) {
            System.out.printf("%d번 motivation은 없습니다.\n", id);
            return;
        }

        articles.remove(article);
        System.out.printf("%d번 motivation이 삭제되었습니다.\n", id);


    }


    // 모티베이션 수정 메소드
    public void edit(RequestProcesser processer) {
        int id;

        try {
            id = Integer.parseInt(processer.getParams("id"));
        } catch (NumberFormatException e) {
            System.out.println("정수 입력 오류");
            return;
        }

        Article article = findById(id);

        if (article == null) {
            System.out.printf("%d번 motivation은 없습니다.\n", id);
            return;
        }

        // 수정 알고리즘......
        // 수정할 내용 입력...
        System.out.print("body : ");
        String body = Container.getScanner().nextLine();
        System.out.print("source : ");
        String source = Container.getScanner().nextLine();

        article.setBody(body);
        article.setSource(source);

        System.out.printf("%d번 motivation이 수정되었습니다.\n", id);

    }

    // 입력된 id와 일치하는 Article 찾기
    private Article findById(int id) {
        for (Article article : articles) {
            if (article.getId() == id) {
                return article;
            }
        }
        return null;

//        boolean isFound = false;
//
//        for (int i = 0; i < articles.size(); i++) {
//            if (articles.get(i).getId() == id) {
//                isFound = true;
//                articles.remove(i);
//                break;
//            }
//        }
//
//        if (!isFound) {
//            System.out.printf("%d번 motivation은 없습니다.\n", id);
//            return;
//        }
//
//        System.out.printf("%d번 motivation이 삭제되었습니다.\n", id);

    }

}
