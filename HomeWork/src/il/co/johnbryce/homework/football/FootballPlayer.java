package il.co.johnbryce.homework.football;
public class FootballPlayer implements Comparable<FootballPlayer> {
	private String _firstName;
	private String _lastName;
	private int _tshirtNumber;
	private int _scoreGoals;
	private Object _goalsBlocker;
	
	public FootballPlayer(String firstName, String lastName, int tshirtNumber) {
		_firstName = firstName;
		_lastName = lastName;
		_tshirtNumber = tshirtNumber;
		_scoreGoals = 0;
		_goalsBlocker = new Object();
	}//c-tor 

	public synchronized void setScoreGoals(int scoreGoals) {
		_scoreGoals += scoreGoals;
//		notify();
	}//setScoreGoals
	
	public synchronized int getScoreGoals() {
		return _scoreGoals;
	}//getScoreGoals
	@Override
	public boolean equals(Object obj) {
		boolean ret = false;
		try {
				ret = (_scoreGoals == ((FootballPlayer) obj)._scoreGoals); 
		} catch (Exception e) {
			// TODO: handle exception
		}
		return ret;
	}//equals

	@Override
	public synchronized String toString() {
		return _tshirtNumber + " " + _firstName + " " + _lastName  + ", The score of goals: " + _scoreGoals;
	}

		@Override
	public synchronized int compareTo(FootballPlayer o) {
		if(_scoreGoals > o.getScoreGoals()) {
			return -1;
		}else if(_scoreGoals < o.getScoreGoals()) {
			return 1;
		}else return 0;
		}//compareTo
		
		public synchronized void printRow() {
	 		String fullName = _firstName + " " + _lastName;
	 		System.out.format("%6d%32s%5d", _tshirtNumber, fullName, _scoreGoals);
	 		System.out.println();
	 	}// A method prints row of a table with data of current player.  

	}//FootballPlayer
 	