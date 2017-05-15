public class TownHouse extends Property {
	private int attachedHouses;
	
	public TownHouse() {
		super();
		setAttachedHouses(0);
	}
	
	public TownHouse(int pIdNumber, String pAddress, double pCostPerWeek, int pAttachedHouses) {
		super(pIdNumber, pAddress, pCostPerWeek);
		setAttachedHouses(pAttachedHouses);
	}
	
	public TownHouse(int pIdNumber, String pAddress, double pCostPerWeek, GarageType pGarageType, String pDescription, double pPropertyArea, int pAttachedHouses) {
		super(pIdNumber, pAddress, pCostPerWeek, pGarageType, pDescription, pPropertyArea);
		setAttachedHouses(pAttachedHouses);
	}

	public int getAttachedHouses() {
		return attachedHouses;
	}

	public void setAttachedHouses(int pAttachedHouses) {
		attachedHouses = pAttachedHouses;
	}
	
	//toString override
	@Override
	public String toString() {
		return super.toString() + "\n AttatchedHouses: " + getAttachedHouses() + "\n"; 
	}
	
	public String convertToString() {
		String result = "";
		
		result += "2," + baseConvertToString() + ",";
		result += getAttachedHouses();
		
		return result;		
	}
}
