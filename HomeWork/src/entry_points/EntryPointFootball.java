package entry_points;

import java.util.ArrayList;
import java.util.List;

import il.co.johnbryce.homework.football.FootballPlayer;
import il.co.johnbryce.homework.football.ScoreTableThread;
import il.co.johnbryce.homework.football.ScoringThread;

public class EntryPointFootball {

	public static void main(String[] args) {
		List<FootballPlayer> players = new ArrayList<>();
		players.add(new FootballPlayer("Lionel", "Messi", 10));
		players.add(new FootballPlayer("Diego", "Maradona", 11));
		players.add(new FootballPlayer("Ferenc", "Puskas", 9));
		players.add(new FootballPlayer("Oleg", "Blokhin", 12));
		players.add(new FootballPlayer("Johannes", "Cruiff", 13));
		Object monitor = new Object();
		Thread t1 = new Thread(new ScoringThread(players, monitor));
		Thread t2 = new Thread(new ScoreTableThread(players, monitor));
		t1.start();
		t2.start();
		
	}//main
}// Entry point
