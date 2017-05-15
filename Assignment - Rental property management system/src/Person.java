import java.util.Date;

abstract public class Person {
	private int idNumber;
	private String firstName;
	private String lastName;
	private long DOB;
	private char gender;
	
	//defaulted data constructor
	public Person()	{
		setIdNumber(-1);
		setFirstName("John");
		setLastName("Doe");
		setDOB(new Date().getTime());
		setGender('m');
	}
	
	//specified data constructor
	public Person(int pIdNumber, String pFirstName, String pLastName, long pDOB, char pGender) {
		setIdNumber(pIdNumber);
		setFirstName(pFirstName);
		setLastName(pLastName);
		setDOB(pDOB);
		setGender(pGender);
	}
	
	public int getIdNumber() {
		return idNumber;
	}
	
	public void setIdNumber(int pIdNumber) {
		idNumber = pIdNumber;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String pFirstName) {
		firstName = pFirstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String pLastName) {
		lastName = pLastName;
	}
	
	public long getDOB() {
		return DOB;
	}
	
	public String printDOB() {
		return new Date(DOB).toString();
	}
	
	public void setDOB(long pDOB) {
		DOB = pDOB;
	}
	
	public char getGender() {
		return gender;
	}
	
	public void setGender(char pGender) {
		pGender = Character.toUpperCase(pGender);
		
		//assign the correct value to gender, if unknown type assign unknown
		if (pGender == 'M' || pGender == 'F')
			gender = pGender;
		else
			gender = 'U';
	}
	
	protected String baseConvertToString() {
		String result = "";
		
		result += getIdNumber() + ",";
		result += getFirstName() + ",";
		result += getLastName() + ",";
		result += getDOB() + ",";
		result += getGender();
		
		return result;
	}
	
	public abstract String convertToString();
	
	public abstract String toString();
}
