package il.co.johnbryce.homework.army;

public class EnlistedSoldier {
	protected int _personalNumber;
	protected String _firstName;
	protected String _lastName;
	protected int _minimumTime;
	
	public EnlistedSoldier(int personalNumber, String firstName, String lastName) {
		_personalNumber = personalNumber;
		_firstName = firstName;
		_lastName = lastName;
		_minimumTime = 0;
	}//c-tor
	
	public int getMinimumTime() {
		return _minimumTime;
	}
	public void anotherMonth() {
		_minimumTime++;
	}//anotherMonth

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
		return _firstName + " " +  _lastName + ": " + _personalNumber + "; A minimum time is: " + _minimumTime;
	}//toString
	
	
}//EnlistedSoldier
