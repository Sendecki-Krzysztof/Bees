import java.util.Scanner;

public class Main {
    static int width = 800;
    static int height = 600;
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        Game game = new Game(width, height);
        new Thread((new GameLoop(game))).start();



        //game.autoPlayGame();
        game.playGame(input);

    }
}