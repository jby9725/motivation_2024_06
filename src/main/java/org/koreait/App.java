package org.koreait;

import org.koreait.motivation.controller.MotivationController;
import org.koreait.system.controller.SystemController;

public class App {
    byte system_status = 1;
    // 리팩토링 이후 : 컨트롤러들에게 기능을 실행하라고 전달 (길안내)

    public App() {

    }

    public void run() {
        System.out.println("== motivation execution ==");

        SystemController systemController = new SystemController();
        MotivationController motivationController = new MotivationController();

        while (system_status == 1) {
            System.out.print("command) ");
            String cmd = Container.getScanner().nextLine().trim(); // 섬세
            // passing class
            RequestProcesser rp = new RequestProcesser(cmd);

            if (cmd.isEmpty()) {
                System.out.println("명령어 입력해주세요.");
                continue;
            }

            switch (rp.getActionMethod()) {
                case "exit":
                    systemController.exit();
                    system_status = 0;
                    break;
                case "add":
                    motivationController.add();
                    break;
                case "list":
                    motivationController.list();
                    break;
                case "delete":
                    System.out.println(rp.getActionMethod());
                    System.out.println(rp.getParams("id"));
                    System.out.println(rp.getParams("source"));
                    System.out.println(rp.getParams("motivation"));
//                    motivationController.delete();
                    break;
                default:
                    System.out.println("사용할 수 없는 명령어입니다.");
                    break;
            }

//            if (rp.getActionMethod().equals("exit")) {
//                systemController.exit();
//                break;
//            } else if (cmd.isEmpty()) {
//                System.out.println("명령어 입력해주세요.");
//                continue;
//            }
        }
    }
}