package org.koreait;

import org.koreait.motivation.entity.Article;

import java.util.*;
// import java.util.ArrayList;
// import java.util.List;
// import java.util.Scanner;

public class App {

    private Scanner sc;

    // private Map<Integer, Article> articles = new HashMap<Integer, Article>(); // 맵 이용하려면 바꿀게 너무 많다..
    private List<Article> articles = new ArrayList<Article>();
    public static int lastID = 0;

    public App(Scanner sc) {
        this.sc = sc;
    }

    public void run() {
        System.out.println("== motivation execution ==");

        while (true) {
            System.out.print("command) ");
            String cmd = sc.nextLine().trim(); // 섬세

            if (cmd.equals("exit")) {
                System.out.println("== motivation end ==");
                break;
            } else if (cmd.isEmpty()) {
                System.out.println("명령어 입력해주세요.");
                continue;
            }

            if (cmd.equals("add")) {
                System.out.print("body : ");
                String body = sc.nextLine();
                System.out.print("source : ");
                String source = sc.nextLine();

                articles.add(new Article(++lastID, body, source));
                System.out.printf("%d번 motivation이 등록되었습니다.\n", lastID);

            } else if (cmd.equals("list")) {
                showAllMotivations();
            }
        }

    }

    public void showAllMotivations() {
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