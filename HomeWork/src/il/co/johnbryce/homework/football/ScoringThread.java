package il.co.johnbryce.homework.football;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ScoringThread implements Runnable {

	private List<FootballPlayer> _players;
	private Random _randomGenerator;
	private int _randomIndex;
	private Object _monitor;
	
	private class OneMinuteGoalsSetter implements Runnable {
		private List<FootballPlayer> _players;
		public OneMinuteGoalsSetter() {
			_players = ScoringThread.this._players;
		}//inner c-tor 
		@Override
		public void run() {
			try {
				while(true) synchronized(_players){
				Thread.sleep(60000);
				this.addScore();
				synchronized (_monitor) {
					_monitor.notifyAll();
				}
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}//run 
		public void addScore() throws InterruptedException {
			_randomIndex = _randomGenerator.nextInt(((ArrayList<FootballPlayer>) _players).size());
			_players.get(_randomIndex).setScoreGoals(1);
//			_players.notify();
		}// addScoreToRandomPlayer every 1 minute
	}//One
	
	private class ThreeMinuteGoalsSetter implements Runnable{
		private List<FootballPlayer> _players;
		public ThreeMinuteGoalsSetter() {
			_players = ScoringThread.this._players;
		}//inner c-tor  
		public void addScore() throws InterruptedException {
			_randomIndex = _randomGenerator.nextInt(((ArrayList<FootballPlayer>) _players).size());
			_players.get(_randomIndex).setScoreGoals(1);

//			_players.notify();
		}// addScoreToRandomPlayer every 3 minute
		@Override
		
		public void run() {
			try {
				while(true) synchronized(_players){
				Thread.sleep(180000);
				this.addScore();
				this.addScore();
				synchronized (_monitor) {
					_monitor.notifyAll();
				}
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}// run		
	}//three
	
	private class FiveMinuteGoalsSetter implements Runnable{
		private List<FootballPlayer> _players;
		public FiveMinuteGoalsSetter() {
			_players = ScoringThread.this._players;
		}//inner c-tor  
		public void addScore() throws InterruptedException {
			_randomIndex = _randomGenerator.nextInt(((ArrayList<FootballPlayer>) _players).size());
			_players.get(_randomIndex).setScoreGoals(1);
//			_players.notify();
		}// addScoreToRandomPlayer every 1 minute
		@Override
		
		public void run() {
			try {
				while(true) synchronized(_players){
				Thread.sleep(300000);
				this.addScore();
				this.addScore();
				this.addScore();
				synchronized (_monitor) {
					_monitor.notifyAll();
				}
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}// run
		
	}//five
	public ScoringThread (List<FootballPlayer> players, Object monitor) {
		_monitor = monitor;
		_players = players;
		_randomGenerator = new Random();
		_randomIndex = 0;
	}// c-tor
	@Override
	public void run() {
		try {
//			while (true) {
				Thread t1 = new Thread(new OneMinuteGoalsSetter());
				Thread t2 = new Thread(new ThreeMinuteGoalsSetter());
				Thread t3 = new Thread(new FiveMinuteGoalsSetter());
				t1.start();
				t2.start();
				t3.start();
//			}// outer run
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}// run
	public void addScoreToRandomPlayerEveryOneMinute() throws InterruptedException {
		_randomIndex = _randomGenerator.nextInt(((ArrayList<FootballPlayer>) _players).size());
		_players.get(_randomIndex).setScoreGoals(1);
		_players.notify();
	}// addScoreToRandomPlayer every 1 minute
	public void addScoreToRandomPlayerEveryThreeMinute() throws InterruptedException {
		_randomIndex = _randomGenerator.nextInt(((ArrayList<FootballPlayer>) _players).size());
		_players.get(_randomIndex).setScoreGoals(1);
		_randomIndex = _randomGenerator.nextInt(((ArrayList<FootballPlayer>) _players).size());
		_players.get(_randomIndex).setScoreGoals(1);
	
	}// addScoreToRandomPlayer every 3 minutes
	public void addScoreToRandomPlayerEveryFiveMinute() throws InterruptedException {
		_randomIndex = _randomGenerator.nextInt(((ArrayList<FootballPlayer>) _players).size());
		_players.get(_randomIndex).setScoreGoals(1);
		_randomIndex = _randomGenerator.nextInt(((ArrayList<FootballPlayer>) _players).size());
		_players.get(_randomIndex).setScoreGoals(1);
		_randomIndex = _randomGenerator.nextInt(((ArrayList<FootballPlayer>) _players).size());
		_players.get(_randomIndex).setScoreGoals(1);

	}// addScoreToRandomPlayer every 5 minutes
}// Scoring Thread
