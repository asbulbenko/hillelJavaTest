import game.Choice;
import game.GameResults;
import org.junit.Test;


public class GameResultsTest {

    GameResults gameResults = new GameResults();

    @Test
    public void gameTest(){
        System.out.println(gameResults.getResults(Choice.STONE, Choice.STONE));
        System.out.println(gameResults.getResults(Choice.STONE, Choice.SCISSORS));
    }

}
