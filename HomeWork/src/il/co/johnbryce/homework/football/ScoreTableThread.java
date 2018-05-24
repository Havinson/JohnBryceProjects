package il.co.johnbryce.homework.football;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Collections;
import java.util.List;

public class ScoreTableThread implements Runnable {
	private List<FootballPlayer> _players;
	private Object _monitor;
	
	public ScoreTableThread(List<FootballPlayer> players, Object monitor) {
		_players = players;
		_monitor = monitor;
	}// c-tor
	@Override
	public void run() {
		while (true) {
			// TODO Auto-generated method stub
			try {
				synchronized (_monitor) {
					_monitor.wait(45000);
				}
				System.out.println(LocalTime.now());
				printTable();
				
			} catch (Exception e) {
				e.printStackTrace();
			} 
			
		}// loop
		
	}// run
	public void printTable(){
		Collections.sort(_players);
		for (int i = 0; i < 43; i++) {
			System.out.print("-");
		}
		System.out.println();
		System.out.println("            A king of goals!!!");
		for (int i = 0; i < 43; i++) {
			System.out.print("-");
		}
		System.out.println();// Print a header.
		System.out.format("%6s%32s%5s", "Number", "Name             ", "Score");
		System.out.println();// Set columns names and width. 
		for (int i = 0; i < 43; i++) {
			System.out.print("-");
		}
		System.out.println();// print separator.
		for (FootballPlayer curr : _players) {
			curr.printRow();
			for (int i = 0; i < 43; i++) {
				System.out.print("-");
			}
			System.out.println();//A method is prints rows of the table
		}
	}
}// Score table thread
