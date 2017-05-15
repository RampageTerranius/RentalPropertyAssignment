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
	
	public DetatchedHouse(int pIdNumber, String pAddress, GarageType pGarageType, String pDescription, double pCostPerWeek, double pLandArea) {
		super(pIdNumber, pAddress, pCostPerWeek, pGarageType, pDescription);
		setLandArea(pLandArea);
	}

	public double getLandArea() {
		return landArea;
	}

	public void setLandArea(double pLandArea) {
		landArea = pLandArea;
	}
	
	//toString override
	@Override
	public String toString() {
		return super.toString() + "\n LandArea: " + getLandArea() + "\n";
	}	
}
