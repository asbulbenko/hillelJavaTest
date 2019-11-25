package game;

import java.util.HashMap;
import java.util.Map;

public class GameResults {
    private Map <Choice, Map<Choice,String>> map = new HashMap<>();

    public GameResults() {
        stoneMapInit();
        scissorsMapInit();
        paperMapInit();
    }

    private void stoneMapInit() {
        Map<Choice,String> stone = new HashMap<>();
        stone.put(Choice.SCISSORS, "Компьютер выиграл");
        stone.put(Choice.PAPER, "Вы выиграли");
        map.put(Choice.STONE, stone);

    }

    private void paperMapInit() {
        Map<Choice,String> paper = new HashMap<>();
        paper.put(Choice.SCISSORS, "Вы выиграли");
        paper.put(Choice.STONE, "Компьютер выиграл");
        map.put(Choice.PAPER, paper);

    }

    private void scissorsMapInit() {
        Map<Choice,String> scissors = new HashMap<>();
        scissors.put(Choice.STONE, "Вы выиграли");
        scissors.put(Choice.PAPER, "Компьютер выиграл");
        map.put(Choice.SCISSORS, scissors);
    }

    public String getResults(Choice compMove, Choice userMove) {
        if(compMove == userMove){
            return "Ничья";
        }
        return map.get(compMove).get(userMove);
    }
}
