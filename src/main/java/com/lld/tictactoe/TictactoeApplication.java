package com.lld.tictactoe;

import com.lld.tictactoe.controllers.GameController;
import com.lld.tictactoe.exceptions.InvalidGameParamsException;
import com.lld.tictactoe.models.*;
import com.lld.tictactoe.strategies.winningstrategies.OrderOneColumnWinningStrategy;
import com.lld.tictactoe.strategies.winningstrategies.OrderOneDiagonalWinningStrategy;
import com.lld.tictactoe.strategies.winningstrategies.OrderOneRowWinningStrategy;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class TictactoeApplication {

	public static void main(String[] args) {
		// Create a game
		GameController gameController = new GameController();
		Scanner scanner = new Scanner(System.in);

		Game game;
		List<Player> players = List.of(
				new Player(new Symbol('X'), "Naman", PlayerType.HUMAN),
				new Bot(new Symbol('O'), "Aman", BotDifficultyLevel.EASY)
		);
		int dimension = 3;

		try {
			game = gameController.createGame(
					dimension,
					players,
					List.of(
							new OrderOneDiagonalWinningStrategy(players),
							new OrderOneColumnWinningStrategy(dimension, players),
							new OrderOneRowWinningStrategy(dimension, players)
					)
			);
		} catch (InvalidGameParamsException e) {
			System.out.println("Seems like you gave invalid params. Update those.");
			return;
		}

//        Game.Builder gameBuilder = new Game.Builder();
		System.out.println("-------------- Game is starting --------------");

		// while game status in progress
		while (gameController.getGameStatus(game).equals(GameStatus.IN_PROGRESS)) {
			System.out.println("This is how board looks like:");
			// print board
			gameController.displayBoard(game);
			// print if undo
			System.out.println("Does anyone want to undo? (y/n)");
			// if yes -> call undo
			String input = scanner.next();

			if (input.equalsIgnoreCase("y")) {
				gameController.undo(game);
			} else {
				// move next player
				gameController.makeMove(game);
			}
		}
		// check status of game


		gameController.printResult(game);
		gameController.displayBoard(game);
		// else -> print draw
	}

}
