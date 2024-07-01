package org.koreait.motivation.service;

import org.koreait.Container;
import org.koreait.RequestProcesser;
import org.koreait.motivation.entity.Article;

import java.util.ArrayList;
import java.util.List;


public class MotivationService {

    private int lastID;
    private List<Article> articles;

    public MotivationService() {
        lastID = 0;
        articles = new ArrayList<>();
    }

    public int doAdd(String body, String source) {
        int id = lastID + 1;

        Article article = new Article(id, body, source);
        articles.add(article);

        lastID = id; // 방금 만들어진 새 article의 id로 갱신

        return id;
    }

    public void showList() {
        if (articles.size() == 0) {
            System.out.println("등록된 motivation 없음");
            return;
        }
        System.out.println("== motivation list ==");
        System.out.printf("  id   //   source   //   body  \n");
        System.out.println("=".repeat(35));

        for (int i = articles.size() - 1; i >= 0; i--) {
            Article article = articles.get(i);

            if (article.getSource().length() > 7) {
                System.out.printf("   %d  //    %s    //    %s  \n", article.getId(), article.getSource().substring(0, 5) + "...", article.getBody());
                continue;
            }

            System.out.printf("   %d  //    %s     //    %s  \n", article.getId(), article.getSource(), article.getBody());
        }
    }

    public int doDelete(RequestProcesser processer) {
        int id;

        try {
            id = Integer.parseInt(processer.getParams("id"));
        } catch (NumberFormatException e) {
            return -1;
        }

        Article article = findById(id);

        if (article == null) {
            return -2;
        }

        articles.remove(article);

        return id;
    }

    public int doEdit(RequestProcesser processer) {
        int id;

        try {
            id = Integer.parseInt(processer.getParams("id"));
        } catch (NumberFormatException e) {
            return -1;
        }

        Article article = findById(id);

        if (article == null) {
            return -2;
        }

        // 불러온 article의 인스턴스변수에 접근
        System.out.println("body(기존) : " + article.getBody());
        System.out.println("source(기존) : " + article.getSource());

        System.out.print("body : ");
        String body = Container.getScanner().nextLine();
        System.out.print("source : ");
        String source = Container.getScanner().nextLine();

        // 불러온 article의 인스턴스변수 수정
        article.setBody(body);
        article.setSource(source);

        return id;
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