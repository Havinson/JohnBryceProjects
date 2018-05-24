package il.co.johnbryce.homework.army;

public class ComissionedOfficer extends EnlistedSoldier {
	public enum Rank{
		PROFESSIONAL_ACADEMIC_OFFICER("Professional academic officer"),
		SENIOR_ACADEMIC_OFFICER("Senior academic officer"),
		SECOND_LIEUTENANT("Second lieutenant"),
		FIRST_LIEUTENANT("Firts lieutenant"),
		CAPTAIN("Captain"),
		MAJOR("Major"),
		LIEUTENANT_COLONEL("Lieutenant colonel"),
		COLONENEL("Colonel"),
		BRIGADIER_GENERAL("Brigadier General"),
		MAJOR_GENERAL("Major General"),
		LIEUTENANT_GENERAL("Lieutenant General");
		
		private final String _rank;
		
		private Rank(String rank) {
			_rank = rank;
			
		}//enum c-tor
		
		public String toString() {
			return _rank;
		}
	}//rank
	private Rank _rank;
	
	public  ComissionedOfficer(Rank rank, String firstName, String lastName, int personalNumber){
		super(personalNumber, firstName, lastName);
		_rank = rank;
		
	}//c-tor
	
	public Rank getRank() {
		return _rank;
	}// getRank
	
	public void promote() {
		for(int i = 0; i < Rank.values().length; i++) {
			if(_rank == Rank.values()[i] && _rank != Rank.values()[Rank.values().length - 1]) {
				_rank = Rank.values()[i + 1];
				break;
				}
		}
	}//promote

	@Override
	public boolean equals(Object obj) {
		boolean ret = false;
		try {
			ret = _minimumTime == ((EnlistedSoldier)obj)._minimumTime;
		}catch (Exception e) {
			System.out.println("An object is not from EnlistedSoldier type");
		}
		return ret;
	}//equals

	@Override
	public String toString() {
		return _rank + " " + _firstName + " " + _lastName + ": " + _personalNumber + "; A mimimum time is: " + _minimumTime;
	}// toString
	
	
}//ComissionedOfficer
