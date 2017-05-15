
public class Studio extends Property {
	public Studio()	{
		super();
	}
	
	public Studio(int pIdNumber, String pAddress, double pCostPerWeek) {
		super(pIdNumber, pAddress, pCostPerWeek);
	}
	
	public Studio(int pIdNumber, String pAddress, double pCostPerWeek, GarageType pGarageType, String pDescription) {
		super(pIdNumber, pAddress, pCostPerWeek, pGarageType, pDescription);
	}
	
	//toString override
	@Override
	public String toString() {
		return super.toString() + "\n";
	}
}
