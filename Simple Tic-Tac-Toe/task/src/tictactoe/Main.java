package tictactoe;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        char[][] poleArray = new char[3][3];

        inputData(poleArray);

    }

    private static void checkStaus(char[][] poleArray) {

        int statusX = 0;
        int statusY = 0;

        for (int i = 0; i < poleArray.length; i++) {
            for (int j = 0; j < poleArray[i].length; j++) {
                if (poleArray[i][j] == 'O') {
                    statusY++;
                } else if (poleArray[i][j] == 'X') {
                    statusX++;
                }

            }

        }

        System.out.printf("X %d, Y %d", statusX, statusY);
    }

    private static void inputData(char[][] poleArray) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("> ");

        String input = scanner.next();

        if (input.length() == 9) {
            int countInput = 0;
            for (int i = 0; i < poleArray.length; i++)
                for (int j = 0; j < poleArray[i].length; j++) {
                    poleArray[i][j] = input.charAt(countInput++);
                }
        }

        printPole(poleArray);
    }

    private static void printPole(char[][] poleArray) {

        System.out.println("---------");

        for (char[] chars : poleArray) {
            System.out.print("| ");
            for (int j = 0; j < chars.length; j++) {
                System.out.printf("%c ", chars[j]);
                if (j == 2) {
                    System.out.println("|");
                }
            }

        }
        System.out.println("---------");
        checkStaus(poleArray);
    }


}