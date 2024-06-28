package org.koreait;

import java.util.Scanner;

// 다른 클래스들이 마음대로 접근할 수 있는 전역 변수 공간
public class Container {
    private static Scanner scanner;

    // 공유 자원을 모아두는 공간 초기화
    public static void init() {
        scanner = new Scanner(System.in);
    }

    // 공유 자원 해제
    public static void close() {
        scanner.close();
    }

    // 공유 자원중 하나인 스캐너 가져오기
    public static Scanner getScanner() {
        return scanner;
    }
}
