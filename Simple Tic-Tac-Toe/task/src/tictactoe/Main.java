package tictactoe;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        char[][] poleArray = new char[3][3];

        inputData(poleArray);

    }

    private static void checkStaus(char[][] poleArray) {

        int countX = 0;
        int countO = 0;
        boolean statusX = false;
        boolean statusO = false;
        StringBuilder result = new StringBuilder("Draw");

        // Count X,Y,_
        for (int i = 0; i < poleArray.length; i++) {
            for (int j = 0; j < poleArray[i].length; j++) {

                if (poleArray[i][j] == 'O') {
                    countO++;
                } else if (poleArray[i][j] == 'X') {
                    countX++;
                }
            }
        }

        // Check Win X
        if ((poleArray[0][0] == 'X' && poleArray[0][1] == 'X' && poleArray[0][2] == 'X')
                || (poleArray[1][0] == 'X' && poleArray[1][1] == 'X' && poleArray[1][2] == 'X')
                || (poleArray[2][0] == 'X' && poleArray[2][1] == 'X' && poleArray[2][2] == 'X')

                || (poleArray[0][0] == 'X' && poleArray[1][0] == 'X' && poleArray[2][0] == 'X')
                || (poleArray[0][1] == 'X' && poleArray[1][1] == 'X' && poleArray[2][1] == 'X')
                || (poleArray[0][2] == 'X' && poleArray[1][2] == 'X' && poleArray[2][2] == 'X')

                || (poleArray[0][0] == 'X' && poleArray[1][1] == 'X' && poleArray[2][2] == 'X')
                || (poleArray[0][2] == 'X' && poleArray[1][1] == 'X' && poleArray[2][0] == 'X')
        ) statusX = true;

        // Check Win O
        if ((poleArray[0][0] == 'O' && poleArray[0][1] == 'O' && poleArray[0][2] == 'O')
                || (poleArray[1][0] == 'O' && poleArray[1][1] == 'O' && poleArray[1][2] == 'O')
                || (poleArray[2][0] == 'O' && poleArray[2][1] == 'O' && poleArray[2][2] == 'O')

                || (poleArray[0][0] == 'O' && poleArray[1][0] == 'O' && poleArray[2][0] == 'O')
                || (poleArray[0][1] == 'O' && poleArray[1][1] == 'O' && poleArray[2][1] == 'O')
                || (poleArray[0][2] == 'O' && poleArray[1][2] == 'O' && poleArray[2][2] == 'O')

                || (poleArray[0][0] == 'O' && poleArray[1][1] == 'O' && poleArray[2][2] == 'O')
                || (poleArray[0][2] == 'O' && poleArray[1][1] == 'O' && poleArray[2][0] == 'O')
        ) statusO = true;


        // Check Impossible: error queue or 2win
        if (countX >= countO + 2 || countO >= countX + 2 || statusX && statusO) {
            result.replace(0, result.length(), "Impossible");
        } else if (statusX) {
            result.replace(0, result.length(), "X wins");
        } else if (statusO) {
            result.replace(0, result.length(), "O wins");
        } else if (countX + countO < 9) {
            result.replace(0, result.length(), "Game not finished");
        }

        // Result
        System.out.print(result);
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