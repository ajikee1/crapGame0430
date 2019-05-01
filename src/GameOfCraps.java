
//AJITH V KEERIKKATTIL
//4/30/2019

import static java.lang.Boolean.TRUE;
import java.util.*;

public class GameOfCraps {

	public static void main(String[] args) {
		double wager = 0.0;
		double human_winnings = 0.0;
		double computer_winnings = 0.0;
		int numRoundsToPlay;
		int roundCounter = 0;
		Dice dice;
		double limit = 50.0;

		System.out.println("START OF THE GAME........");

		Scanner in = new Scanner(System.in);
		System.out.print("HOW MANY ROUNDS WOULD YOU LIKE TO PLAY? ");
		numRoundsToPlay = in.nextInt();

		System.out.println("HERE WE GO---");
		System.out.println(".........................");

		for (double i = 1.0; i <= numRoundsToPlay; i++) {
			roundCounter++;

			System.out.println("ROUND #" + roundCounter);
			System.out.println("");

			// HUMAN'S ROUND
			System.out.println("HUMAN ROUND");
			System.out.println("........................................................................");
			wager = getHumansWager(limit);

			// PLAY DICE
			dice = new Dice();
			playRound(dice);

			if (dice.getState() instanceof Win) {
				human_winnings = human_winnings + wager;
			} else {
				human_winnings = human_winnings - wager;
			}

			System.out.println("");
			System.out.println("");

			// COMPUTER'S ROUND
			System.out.println("COMPUTER ROUND");
			System.out.println("........................................................................");
			wager = randomly_generate((int) limit);
			System.out.println("COMPUTER BETS " + "$" + wager);

			// PLAY DICE
			dice = new Dice();
			playRound(dice);

			System.out.println("");
			System.out.println("");

			if (dice.getState() instanceof Win) {
				computer_winnings = computer_winnings + wager;
			} else {
				computer_winnings = computer_winnings - wager;
			}

			System.out.println("HUMAN CURRENT WINNINGS: " + human_winnings);
			System.out.println("COMPUTER CURRENT WINNINGS: " + computer_winnings);
		}

		// DISPLAY WHO WON
		System.out.println("");
		System.out.println("........................................................................");
		if (computer_winnings > human_winnings) {
			System.out.println("GAME OVER! COMPUTER RULES");
		} else {
			System.out.println("GAME OVER! HUMAN RULES");
		}

	}

	public static double getHumansWager(double limit) {
		Scanner in = new Scanner(System.in);
		System.out.print("HOW MUCH WOULD YOU LIKE TO WAGER THIS ROUND? (MAX WAGER $50): ");
		double wager = in.nextDouble();
		System.out.println("HUMAN BETS " + "$" + wager);

		while (TRUE) {
			if (wager >= 0.00 && wager <= limit) {
				return wager;
			} else {
				System.out.print(
						"THE AMOUNT YOU WAGED IS NOT VALID. PLEASE ENTER AN AMOUNT BETWEEN (0.00 - " + limit + "): ");
				wager = in.nextDouble();
			}
		}
		return wager;
	}

	public static int randomly_generate(int max) {
		Random rand = new Random();
		return rand.nextInt((max - 1) + 1) + 1;
	}

	public static void playRound(Dice dice) {
		// Keep on rolling dice until a win or loss happens
		while (!(dice.getState() instanceof Win) && !(dice.getState() instanceof Loss)) {
			dice.rollDice();
		}
	}

}
