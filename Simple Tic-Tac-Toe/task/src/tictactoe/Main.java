package tictactoe;

import java.util.Scanner;

public class Main {

    public static int superCount = 0;

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
//        System.out.println(result);

        if (countX + countO != 9) {
            selectHod(poleArray);
        } else System.out.print("X wins");
    }

    private static void selectHod(char[][] poleArray) {

        System.out.print("> ");

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        if (checkUserInput(input, poleArray)) {
            printPole(poleArray);
        } else selectHod(poleArray);

    }

    private static boolean checkUserInput(String input, char[][] poleArray) {
        String[] words = input.trim().split(" ");
        int index1;
        int index2;

        // Check on Length (whait 2 digit)
        if (words.length != 2) {
            System.out.println("You should enter numbers!");
            return false;
        } else
            // Check on Int
            if (words[0].matches("[-+]?\\d+") || words[1].matches("[-+]?\\d+")) {
                index1 = Integer.parseInt(words[0]);
                index2 = Integer.parseInt(words[1]);
            } else {
                System.out.println("You should enter numbers!");
                return false;
            }

        // Check on Range
        if (index1 < 1 || index1 > 3 || index2 < 1 || index2 > 3) {
            System.out.println("Coordinates should be from 1 to 3!");
            return false;
        }

        // Check Busy
        if (poleArray[index1 - 1][index2 - 1] != '_') {
            System.out.println("This cell is occupied! Choose another one!");
            return false;
        } else {
            poleArray[index1 - 1][index2 - 1] = 'X';
            return true;
        }
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
        superCount++;
        System.out.println("---------");
        if (superCount < 2) checkStaus(poleArray);
    }

}