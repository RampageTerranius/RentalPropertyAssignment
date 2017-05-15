public class DetatchedHouse extends Property {
	private double landArea;
	
	public DetatchedHouse() {
		super();
		setLandArea(0);
	}
	
	public DetatchedHouse(int pIdNumber, String pAddress, double pCostPerWeek, double pLandArea) {
		super(pIdNumber, pAddress, pCostPerWeek);
		setLandArea(pLandArea);
	}
	
	public DetatchedHouse(int pIdNumber, String pAddress, double pCostPerWeek, GarageType pGarageType, String pDescription, double pPropertyArea, double pLandArea) {
		super(pIdNumber, pAddress, pCostPerWeek, pGarageType, pDescription, pPropertyArea);
		setLandArea(pLandArea);
	}

	public double getLandArea() {
		return landArea;
	}

	public void setLandArea(double pLandArea) {
		landArea = pLandArea;
	}
	
	public String convertToString() {
		String result = "";
		
		result += "4," + baseConvertToString() + ",";
		result += getLandArea();
		
		return result;		
	}
	
	//toString override
	@Override
	public String toString() {
		return super.toString() + "\n LandArea: " + getLandArea() + "\n";
	}	
}
