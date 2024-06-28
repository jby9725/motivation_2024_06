package org.koreait;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    private Scanner sc;

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
                System.out.print("motivation : ");
                String motivation = sc.nextLine();
                System.out.print("source : ");
                String source = sc.nextLine();

                articles.add(new Article(++lastID, motivation, source));

                System.out.printf("%d번 motivation이 등록되었습니다.\n", lastID);
            } else if (cmd.equals("list")) {
                showAllMotivation();
            }
        }

    }

    public void showAllMotivation() {
        System.out.println("== motivation list ==");
        System.out.println("id \t//  motivation\t// source");

        for (int i = articles.size() - 1; i >= 0; i--) {
            Article article = articles.get(i);
            System.out.printf(" %d \t// %s\t// %s\n", article.getId(), article.getMotivation(), article.getSource());
        }

    }
}

class Article {
    private int id;
    private String motivation;
    private String source;

    public Article(int id, String motivation, String source) {
        this.id = id;
        this.motivation = motivation;
        this.source = source;
    }

    public int getId() {
        return this.id;
    }

    public String getMotivation() {
        return this.motivation;
    }

    public String getSource() {
        return this.source;
    }
}