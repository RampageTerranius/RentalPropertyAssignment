import java.text.SimpleDateFormat;
import java.util.Date;

public class Tenant extends Person{
	private long dateLeased;
	private int lengthOfContract;
	private Property property;
	
	//defaulted data constructor
	public Tenant() {
		super(-1, "None", "None", new Date().getTime(), 'U');
		setDateLeased(new Date().getTime());
		setLengthOfContract(0);		
		property = null;
	}
	
	//default constructor 
	public Tenant(int pIdNumber, String pFirstName, String pLastName, long pDOB, char pGender) {
		super(pIdNumber, pFirstName, pLastName, pDOB, pGender);
		setDateLeased(new Date().getTime());
		setLengthOfContract(0);		
		property = null;
	}
	
	//secondary constructor for setting extra values
	public Tenant(int pIdNumber, String pFirstName, String pLastName, long pDOB, char pGender, long pDateLeased, int pLengthOfContract, Property pProperty) {
		super(pIdNumber, pFirstName, pLastName, pDOB, pGender);
		setDateLeased(pDateLeased);
		setLengthOfContract(pLengthOfContract);
		setProperty(pProperty);
	}

	public long getDateLeased() {
		return dateLeased;
	}
	
	public String printDateLeased() {
		return new Date(dateLeased).toString();
	}

	public void setDateLeased(long pDateLeased) {
		dateLeased = pDateLeased;
	}

	public int getLengthOfContract() {
		return lengthOfContract;
	}

	public void setLengthOfContract(int pLengthOfContract) {
		lengthOfContract = pLengthOfContract;
	}

	public Property getProperty() {
		return property;			
	}

	public void setProperty(Property pProperty) {
		//clear the tenants out of the last house if they are already assigned to one
		if (getProperty() != null)		
			getProperty().removeTenant(this, false);
		
		property = pProperty;
		
		pProperty.addTenant(this, false);
	}
	
	public void rateProperty(int rating) {
		if (rating >= 0)
			if (rating <= 10)
				property.addRating(rating);
			else
				System.out.println("rating must be 10 or lower");
		else
			System.out.println("rating must be 0 or higher");
	}
	
	public String convertToString() {
		String result = "";
		
		result += "1," + baseConvertToString() + ",";
		result += getDateLeased() + ",";
		result += getLengthOfContract() + ",";
		if (getProperty() != null)
			result += getProperty().getIdNumber();
		else
			result += "-1";
		
		return result;
	}
	
	//toString override
	@Override
	public String toString() {
		//prepare the address ahead of time since we aren't sure if we have an address or not yet
		String lAddress = "None";
		
		if (getProperty() != null)
			lAddress = getProperty().getAddress();
		Date date = new Date();
		
		return "Tenant ID: " + getIdNumber() + "\n FirstName: " + getFirstName() + "\n LastName: " + getLastName() + "\n DOB: " + printDOB() + "\n Gender: " + getGender() +  "\n Property: " + lAddress + "\n DateLeased: " + printDateLeased() + "\n LengthOfContract: " + getLengthOfContract() + "\n";
	}
}
