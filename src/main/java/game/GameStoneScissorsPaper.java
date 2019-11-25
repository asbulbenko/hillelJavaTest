package game;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.MessageFormat;
import java.util.Date;
import java.util.Scanner;

public class GameStoneScissorsPaper {
    public static void main(String[] args) throws IOException {
            System.out.println("Игра камень, ножницы, бумага");
            Scanner sc = new Scanner(System.in);
            System.out.println("Введите кол-во игр готовых сыграть");
            int count = sc.nextInt();

            StringBuilder strResults = new StringBuilder();

            // loop game
            for(int i=0; i < count; i++) {
                System.out.println("Сделайте свой выбор: 1-Камень  2-Ножницы  3-Бумага");
                int userMove = sc.nextInt();
                Choice choiceUser = getChoice(userMove);
                System.out.println("ЮЗЕР ВЫБРАЛ - " + choiceUser);

                // choice of computer to make a move
                Choice compMove = getCompChoice();

                // determine who is the winner
                GameResults gameResults = new GameResults();
                System.out.println(gameResults.getResults(compMove, choiceUser));

                // appending new results into strResults
                String stringResults = "Резуьтат игры №" + (i+1) + " " + System.currentTimeMillis() + " -- " + gameResults.getResults(compMove, choiceUser) + System.lineSeparator();
                strResults = strResults.append(stringResults);
            }

        results(strResults);

    }
    // выбор компьютера
    private static Choice getCompChoice() {
        double compChoice = Math.random();
        Choice compMove;
        System.out.println("compChoice = " + compChoice);
        if (compChoice < 0.33) {
            System.out.println("Выбор компа - Камень");
            compMove = Choice.STONE;
        } else if (compChoice > 0.67) {
            System.out.println("Выбор компа - Бумага");
            compMove = Choice.PAPER;
        } else {
            System.out.println("Выбор компа - Ножницы");
            compMove = Choice.SCISSORS;
        }
        return compMove;
    }

    // выбор пользователя
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
//                case 0:
//                    System.exit(1);
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

