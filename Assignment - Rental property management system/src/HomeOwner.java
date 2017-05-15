import java.util.ArrayList;
import java.util.Date;

public class HomeOwner extends Person {
	private ArrayList<Property> properties;
	
	//defaulted data constructor
	public HomeOwner() {
		super(-1, "None", "None", new Date(), 'U');		
		properties = new ArrayList<Property>();
	}
	
	//default constructor
	public HomeOwner(int pIdNumber, String pFirstName, String pLastName, Date pDOB, char pGender) {
		super(pIdNumber, pFirstName, pLastName, pDOB, pGender);		
		properties = new ArrayList<Property>();
	}
	
	//extra constructor enabling addition of property
	public HomeOwner(int pIdNumber, String pFirstName, String pLastName, Date pDOB, char pGender, Property property) {
		super(pIdNumber, pFirstName, pLastName, pDOB, pGender);
		properties = new ArrayList<Property>();
		addProperty(property);
	}
	
	public void addProperty(Property pProperty, boolean affectsOwner) {
		properties.add(pProperty);
		
		if (affectsOwner)
			pProperty.addOwner(this, false);
	}
	
	public void addProperty(Property pProperty) {
		addProperty(pProperty, true);
	}
	
	public void removeProperty(Property pProperty) {
		properties.remove(pProperty);
		pProperty.removeOwner(this);
	}
	
	public ArrayList<Property> getProperties() {
		return properties;
	}
	
	public Property getProperty(int index) {
		return properties.get(index);
	}
	
	public int getTotalOwnedProperties() {
		return properties.size();
	}
	
	private String returnPropertyAddresses() {
		String lReturn = "";
		
		if (properties != null)
			if (properties.size() > 0)		
			{
				for(int i = 0; i < properties.size(); i++)
					lReturn += properties.get(i).getAddress() + "   ";
				
				return lReturn;
			}		
		
		return "None";
	}
	
	//toString override
	@Override
	public String toString() {
		return "Home Owner ID: " + getIdNumber() + "\n FirstName: " + getFirstName() + "\n LastName: " + getLastName() + "\n DOB: " + getDOB() + "\n Gender: " + getGender() + "\n Properties: " + returnPropertyAddresses() + "\n";
	}	
}