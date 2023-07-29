import Controller.GameController;
import Models.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {


        System.out.println("Hello and welcome!");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Provide the dimension for the board:");
        int dimension = scanner.nextInt();
        System.out.println("What are the total number of players:");
        int totalPlayers = scanner.nextInt();
        System.out.println("Is one of them a bot..?");
        String isBotPlaying = scanner.next();

        int totalNumberOfNonBotPlayers = totalPlayers;

        List<Player> players = new ArrayList<>();

        if (isBotPlaying.toLowerCase().charAt(0) == 'y') {
            totalNumberOfNonBotPlayers -= 1;

            System.out.println("Provide the name for the Bot:");
            String playerName = scanner.next();
            System.out.println("Provide the symbol for the Bot " + playerName);
            char playerSymbol = scanner.next().charAt(0);

            System.out.println("Provide the level of Difficulty : EASY/MEDIUM");
            String difficultyLevel = scanner.next().toUpperCase();
            while (!difficultyLevel.equals(BotDifficultyLevel.EASY.toString()) &&
                    !difficultyLevel.equals(BotDifficultyLevel.MEDIUM.toString())) {
                System.out.println("Invalid level of difficulty, please provide input EASY OR MEDIUM");
                difficultyLevel = scanner.next().toUpperCase();
            }
            Player player = new Bot(10, playerName, playerSymbol, BotDifficultyLevel.valueOf(difficultyLevel), scanner);
            players.add(player);

        }

        for (int q = 0; q < totalNumberOfNonBotPlayers; q++) {
            System.out.println("Provide the name for the player: " + (q + 1));
            String playerName = scanner.next();
            System.out.println("Provide the symbol for the player " + playerName);
            char playerSymbol = scanner.next().charAt(0);

            Player player = new Player(q, playerName, playerSymbol, PlayerType.PERSON, scanner);
            players.add(player);
        }

        GameController gameController = new GameController();
        Game gameObject = gameController.instantiateGame(dimension, players);

        while (gameController.checkGameStatus(gameObject).equals(GameStatus.IN_PROGRESS)) {
            System.out.println("This is the current board: ");
            System.out.println();
            gameController.displayBoard(gameObject);

            gameController.executeNextMove(gameObject);

        }

        System.out.println("This is the current board: ");
        gameController.displayBoard(gameObject);

        if (gameController.checkGameStatus(gameObject).equals(GameStatus.DRAW)) {
            System.out.println("Game gets DRAW, please try again...!");

        } else {
            System.out.println(gameController.getWinner(gameObject) + " Won the game,Congratulations..!");
        }

    }
}