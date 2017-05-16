import java.util.ArrayList;

public class HomeOwner extends Person {
	private ArrayList<Property> properties;
	
	//defaulted data constructor
	public HomeOwner() {
		super();		
		properties = new ArrayList<Property>();
	}
	
	//default constructor
	public HomeOwner(int pIdNumber, String pFirstName, String pLastName, long pDOB, char pGender) {
		super(pIdNumber, pFirstName, pLastName, pDOB, pGender);		
		properties = new ArrayList<Property>();
	}
	
	//extra constructor enabling addition of property
	public HomeOwner(int pIdNumber, String pFirstName, String pLastName, long pDOB, char pGender, Property property) {
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
	
	private String getPropertyIds() {
		String result = "";
		if (properties.size() > 0)
		{
			for (Property property : properties)
				result += property.getIdNumber() + "=";
			
			//remove the last - symbol
			result = result.substring(0, result.length() - 1);
		}	
			
		return result;
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
	
	public String convertToString() {
		String result = "";
		
		result += "2," + baseConvertToString() + ",";
		if (getPropertyIds() != "")
			result += getPropertyIds();
		else
			result += "-1";
		
		return result;
	}
	
	//toString override
	@Override
	public String toString() {
		return "Home Owner ID: " + getIdNumber() + "\n FirstName: " + getFirstName() + "\n LastName: " + getLastName() + "\n DOB: " + printDOB() + "\n Gender: " + getGender() + "\n Properties: " + returnPropertyAddresses() + "\n";
	}	
}
