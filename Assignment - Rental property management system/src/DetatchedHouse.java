public class DetatchedHouse extends Property {
	
	public DetatchedHouse() {
		super();
	}
	
	public DetatchedHouse(int pIdNumber, String pAddress, double pCostPerWeek, double pLandArea) {
		super(pIdNumber, pAddress, pCostPerWeek);
	}
	
	public DetatchedHouse(int pIdNumber, String pAddress, double pCostPerWeek, GarageType pGarageType, String pDescription, double pPropertyArea, double pLandArea) {
		super(pIdNumber, pAddress, pCostPerWeek, pGarageType, pDescription, pPropertyArea);
	}
	
	public String convertToString() {
		String result = "";
		
		result += "4," + baseConvertToString();
		
		return result;		
	}
	
	//toString override
	@Override
	public String toString() {
		return super.toString();
	}	
}
