package org.koreait;

import org.koreait.motivation.controller.MotivationController;
import org.koreait.motivation.entity.Article;
import org.koreait.system.controller.SystemController;

import java.util.*;
// import java.util.ArrayList;
// import java.util.List;
// import java.util.Scanner;

public class App {
    // 리팩토링 이후 : 컨트롤러들에게 기능을 실행하라고 전달 (길안내)

    private Scanner sc;

    public App(Scanner sc) {
        this.sc = sc;
    }

    public void run() {
        System.out.println("== motivation execution ==");

        SystemController systemController = new SystemController();
        MotivationController motivationController = new MotivationController(sc);

        while (true) {
            System.out.print("command) ");
            String cmd = sc.nextLine().trim(); // 섬세

            if (cmd.equals("exit")) {
                systemController.exit();
                break;
            } else if (cmd.isEmpty()) {
                System.out.println("명령어 입력해주세요.");
                continue;
            }

            if (cmd.equals("add")) {
                motivationController.add();
            } else if (cmd.equals("list")) {
                motivationController.list();
            } else {
                System.out.println("올바른 명령어를 입력해주세요.");
            }
        }
    }
}