import java.util.ArrayList;

abstract public class Property {
	private int idNumber;
	private String address;
	private ArrayList<HomeOwner> owners;
	private ArrayList<Tenant> tenants;
	private double costPerWeek;
	private GarageType garageType;
	private String description;
	private double rating;
	private double propertyArea;
	
	//defaulted data constructor
	public Property() {
		setIdNumber(-1);
		setAddress("No Name");
		setCostPerWeek(0);
		owners = null;
		tenants = null;
		setGarageType(GarageType.none);
		setDescription("No Description");		
		setRating(0);
		owners = new ArrayList<HomeOwner>();
		tenants = new ArrayList<Tenant>();		
	}
	
	//default constructor
	public Property(int pIdNumber, String pAddress, double pCostPerWeek) {
		setIdNumber(pIdNumber);
		setAddress(pAddress);
		setCostPerWeek(pCostPerWeek);
		owners = null;
		tenants = null;
		setGarageType(GarageType.none);
		setDescription("No Description");		
		setRating(0);
		owners = new ArrayList<HomeOwner>();
		tenants = new ArrayList<Tenant>();
	}
	
	//extra data constructor
	public Property(int pIdNumber, String pAddress, double pCostPerWeek, GarageType pGarageType, String pDescription, double pPropertyArea) {
		setIdNumber(pIdNumber);
		setAddress(pAddress);
		setCostPerWeek(pCostPerWeek);
		owners = null;
		tenants = null;
		setGarageType(pGarageType);
		setDescription(pDescription);	
		
		setRating(0);
		owners = new ArrayList<HomeOwner>();
		tenants = new ArrayList<Tenant>();
	}

	public int getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(int pIdNumber) {
		idNumber = pIdNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String pAddress) {
		address = pAddress;
	}
	
	public ArrayList<HomeOwner> getOwners() {
		return owners;
	}
	
	public void addOwner(HomeOwner owner) {
		addOwner(owner, true);
	}
	
	public void addOwner(HomeOwner owner, boolean affectsProperty) {
		owners.add(owner);
		if (affectsProperty)
			owner.addProperty(this, false);
	}
	
	public void removeOwner(HomeOwner owner) {
		owners.remove(owner);
		owner.removeProperty(this);
	}
	
	public ArrayList<Tenant> getTenants() {
		return tenants;
	}
	
	public void addTenant(Tenant pTenant, boolean affectsProperty) {
		if (affectsProperty)
		{
			tenants.add(pTenant);
			pTenant.setProperty(this);
		}			
	}
	
	public void addTenant(Tenant pTenant) {
		addTenant(pTenant, true);
	}
	
	public void removeTenant(Tenant pTenant, boolean affectsProperty) {
		if (pTenant != null)
			tenants.remove(pTenant);
		if (affectsProperty)
			pTenant.setProperty(null);
	}
	
	public void removeTenant(Tenant pTenant) {
		removeTenant(pTenant, true);
	}

	public double getCostPerWeek() {
		return costPerWeek;
	}

	public void setCostPerWeek(double pCostPerWeek) {
		costPerWeek = pCostPerWeek;
	}

	public GarageType getGarageType() {
		return garageType;
	}

	public void setGarageType(GarageType pGarageType) {
		garageType = pGarageType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String pDescription) {
		description = pDescription;
	}
	
	public double getRating() {		
		return rating;
	}
	
	public void setRating(double pRating) {
		rating = pRating;
	}
	
	public double getPropertyArea() {
		return propertyArea;
	}
	
	public void setPropertyArea(double pPropertyArea) {
		propertyArea = pPropertyArea;
	}
	
	private String ownerIdsToString() {
		String result = "";
		
		if (owners.size() > 0)		
		{
			for (HomeOwner owner : owners)
				result += owner.getIdNumber() + "-";
			
			//remove the last - symbol added
			result = result.substring(0, result.length() - 1);
		}
		else
			result = "-1";
		
		return result;
	}
	
	public String ownerNamesToString() {
		String result = "";
		
		if (owners.size() > 0)		
		{
			for (HomeOwner owner : owners)
				result += owner.getFirstName() + " " + owner.getLastName() + "-";
			
			//remove the last - symbol added
			result = result.substring(0, result.length() - 1);
		}
		else
			result = "None";
		
		return result;
	}
	
	private String tenantIdsToString() {
		String result = "";
		
		if (tenants.size() > 0)		
		{
			for (Tenant tenant : tenants)
				result += tenant.getIdNumber() + "-";
			
			//remove the last - symbol added
			result = result.substring(0, result.length() - 1);
		}
		else
			result = "-1";
		
		return result;
	}
	
	public String tenantNamesToString() {
		String result = "";
		
		if (tenants.size() > 0)		
		{
			for (Tenant tenant : tenants)
				result += tenant.getFirstName() + " " + tenant.getLastName() + "-";
			
			//remove the last - symbol added
			result = result.substring(0, result.length() - 1);
		}
		else
			result = "None";
		
		return result;
	}
	
	//used for automatically returning the base property values as a string
	protected String baseConvertToString() {
		String result = "";		
		//type id
		result += getIdNumber() + ",";
		result += getAddress() + ",";
		result += ownerIdsToString() + ",";//TODO: get owners and get tenants somehow
		result += tenantIdsToString() + ",";
		result += getCostPerWeek() + ",";
		result += getGarageType() + ",";
		result += getDescription() + ",";
		result += getRating() + ",";
		result += getPropertyArea();
		//extra data after this
		return result;
	}
	
	//used with IOConversion
	public abstract String convertToString();
		
	//toString override
	@Override
	public String toString() {
		//setting up the owner and tenant names ahead of time
		String lOwners = "";
		String lTenants = "";
		
		if (owners.size() != 0)
			for (int i = 0; i < owners.size(); i++)		
			{
				lOwners += owners.get(i).getFirstName() + " " + owners.get(i).getLastName();
				if (i < owners.size() - 1)
					lOwners += ", ";
			}				
		else
			lOwners = "None";
		
		if (tenants.size() != 0)
			for (int i = 0; i < tenants.size(); i++)	
			{
				lTenants += tenants.get(i).getFirstName() + " " + tenants.get(i).getLastName();
				if (i < tenants.size() - 1)
					lTenants += ", ";
			}				
		else
			lTenants = "None";
		
		return "PropertyID: " + getIdNumber() + "\n Address: " + getAddress() + "\n Owners: " + lOwners + "\n Tenants: " + lTenants + "\n CostPerWeek: " + getCostPerWeek() + "\n GarageType: " + getGarageType().toString() + "\n Description: " + getDescription() + "\n Rating: " + getRating();
	}
}
