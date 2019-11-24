package game;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class GameStoneScissorsPaper {
    public static void main(String[] args) throws IOException {
            System.out.println("Игра камень, ножницы, бумага");
            Scanner sc = new Scanner(System.in);
            System.out.println("Сделайте свой выбор: 1-Камень  2-Ножницы  3-Бумага");
            int userMove = sc.nextInt();
            System.out.println("Введите кол-во игр готовых сыграть");
            int count = sc.nextInt();
            System.out.println();

            // loop game
            while(count > 0) {
                Choice choiceUser = getChoice(userMove);
                System.out.println("ЮЗЕР ВЫБРАЛ - " + choiceUser);

            // to quit execution of the program if 'q' is pressed
            String exit = sc.nextLine();
            if(exit.equals("q")) {
//                results("input some text here to be saved!");
                break;
            }

            // choice of computer to make a move
            double compChoice = Math.random();
            int compChoiceS;
            Choice compMove;
            System.out.println("compChoice = " + compChoice);
            if (compChoice < 0.33) {
                System.out.println("Выбор компа - Камень");
                compMove = Choice.STONE;
                compChoiceS = 1;
            } else if (compChoice > 0.67) {
                System.out.println("Выбор компа - Бумага");
                compMove = Choice.PAPER;
                compChoiceS = 3;
            } else {
                System.out.println("Выбор компа - Ножницы");
                compMove = Choice.SCISSORS;
                compChoiceS = 2;
            }



            // determine who is the winner
//            checker(compChoiceS, userMove);
                System.out.println(winnerChecker(compMove, choiceUser));
                count--;

            }

    }

    private static String winnerChecker(Choice compMove, Choice choiceUser) {
        String win = null;
        if (compMove.equals(choiceUser)){
            win = "Ничья";
        } else if (compMove.equals(Choice.STONE) && choiceUser.equals(Choice.SCISSORS)){
            win = "Выиграл Компьютер :(";
        } else if (compMove.equals(Choice.PAPER) && choiceUser.equals(Choice.STONE)){
            win = "Выиграл Компьютер :(";
        } else if (compMove.equals(Choice.STONE) && choiceUser.equals(Choice.PAPER)){
            win = "Вы Выиграли! :)";
        } else if (compMove.equals(Choice.PAPER) && choiceUser.equals(Choice.SCISSORS)){
            win = "Вы Выиграли! :)";
        } else if (compMove.equals(Choice.SCISSORS) && choiceUser.equals(Choice.PAPER)){
            win = "Выиграл Компьютер :(";
        } else if (compMove.equals(Choice.SCISSORS) && choiceUser.equals(Choice.STONE)) {
            win = "Вы Выиграли! :)";
        }
        return win;
    }

    private static void test() {
        String[][] array ={
            {"DRAW","COMP","USER"},
            {"USER","DRAW","COMP"},
            {"COMP", "USER", "DRAW"},
        };

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {

            }
        }
    }

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
                default:
                    throw new IOException("Такая цифра " + userMove + " игрой не поддерживается");
            }

    }

    private static void results(String sd) {
        System.currentTimeMillis();
        try {
            String path = "./resources";
            String content = "";

            Files.write(Paths.get(path), content.getBytes());

            // encoding
            // Files.write(Paths.get(path), content.getBytes(StandardCharsets.UTF_8));

            // extra options
            // Files.write(Paths.get(path), content.getBytes(),
            //		StandardOpenOption.CREATE, StandardOpenOption.APPEND);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private static void checker(int compChoiceS, int userChoice) {
            if(compChoiceS ==1 && userChoice ==1 || compChoiceS ==2 && userChoice ==2 || compChoiceS ==3 && userChoice ==3){
                System.out.println("Ничья");
            }if (compChoiceS == 1 && userChoice == 2){
                System.out.println("Выиграл Компьютер :(");
            }if (compChoiceS == 1 && userChoice == 3){
                System.out.println("Вы Выиграли! :)");
            }if (compChoiceS == 2 && userChoice == 1){
                System.out.println("Вы Выиграли! :)");
            }if (compChoiceS == 2 && userChoice == 3){
                System.out.println("Выиграл Компьютер :(");
            }if (compChoiceS == 3 && userChoice == 2){
                System.out.println("Вы Выиграли! :)");
            }if (compChoiceS == 3 && userChoice == 1){
                System.out.println("Выиграл Компьютер :(");
            }
        }
    }

