

public class Apartment extends Property {
	private String floorNumber;
	
	public Apartment() {
		super();
		setFloorNumber("0");
	}
	
	public Apartment(int pIdNumber, String pAddress, double pCostPerWeek, String pFloorNumber) {
		super(pIdNumber, pAddress, pCostPerWeek);
		setFloorNumber(pFloorNumber);
	}
	
	public Apartment(int pIdNumber, String pAddress, double pCostPerWeek, GarageType pGarageType, String pDescription, double pPropertyArea, String pFloorNumber) {
		super(pIdNumber, pAddress, pCostPerWeek, pGarageType, pDescription, pPropertyArea);
		setFloorNumber(pFloorNumber);
	}

	public String getFloorNumber() {
		return floorNumber;
	}

	public void setFloorNumber(String pFloorNumber)	{
		floorNumber = pFloorNumber;
	}
	
	public String convertToString() {
		String result = "";
		
		result += "1," + baseConvertToString() + ",";
		result += getFloorNumber();
		
		return result;
	}
	
	//toString override
	@Override
	public String toString() {
		return super.toString() + "\n FloorNumber: " + getFloorNumber() + "\n";
	}
}
