package game;

import java.io.*;
import java.util.Scanner;

public class GameStoneScissorsPaper {
    public static void main(String[] args) throws IOException {
        System.out.println("Игра камень, ножницы, бумага");
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите кол-во игр готовых сыграть");
        int count = sc.nextInt();

        // init results
        GameResults gameResults = new GameResults();
        StringBuilder strResults = new StringBuilder();

        // loop game
        for (int i = 0; i < count; i++) {
            System.out.println("Сделайте свой выбор: 1-Камень  2-Ножницы  3-Бумага или 0 - для выхода из игры");
            int userMove = sc.nextInt();
            Choice choiceUser = getChoice(userMove);

            if (choiceUser != null) {
                // choice of computer to make a move
                Choice compMove = getCompChoice();
                System.err.println("Компьютер выбрал - " + compMove);
                // determine who is the winner
                String results = gameResults.getResults(compMove, choiceUser);
                // print some results into console
                System.out.println(results);

                // appending new results into strResults
                String stringResults = "Результат игры №" + (i + 1) + " " + System.currentTimeMillis() + " -- " + results + System.lineSeparator();
                strResults = strResults.append(stringResults);
            }else {
                break;
            }
        }
        // write results to file
        results(strResults);
    }

    // computer move in game
    private static Choice getCompChoice() {
        double compChoice = Math.random();
        Choice compMove;
        if (compChoice < 0.33) {
            compMove = Choice.STONE;
        } else if (compChoice > 0.67) {
            compMove = Choice.PAPER;
        } else {
            compMove = Choice.SCISSORS;
        }
        return compMove;
    }

    // user move in game
    private static Choice getChoice(int userMove) throws IOException {
        switch (userMove) {
            case 1:
                System.out.println("Ваш выбор - Камень");
                return Choice.STONE;
            case 2:
                System.out.println("Ваш выбор - Ножницы");
                return Choice.SCISSORS;
            case 3:
                System.out.println("Ваш выбор - Бумага");
                return Choice.PAPER;
            case 0:
                return null;
            default:
                throw new IOException("Такая цифра " + userMove + " игрой не поддерживается");
        }
    }

    private static void results(StringBuilder str) throws IOException {
        System.currentTimeMillis();
        PrintWriter writer = new PrintWriter("resultOfTheGame.txt", "UTF-8");
        writer.append(str);
        writer.close();
    }


}

