
public class Studio extends Property {
	public Studio()	{
		super();
	}
	
	public Studio(int pIdNumber, String pAddress, double pCostPerWeek) {
		super(pIdNumber, pAddress, pCostPerWeek);
	}
	
	public Studio(int pIdNumber, String pAddress, double pCostPerWeek, GarageType pGarageType, String pDescription, double pPropertyArea) {
		super(pIdNumber, pAddress, pCostPerWeek, pGarageType, pDescription, pPropertyArea);
	}
	
	public String convertToString() {
		String result = "";
		
		result += "3," + baseConvertToString();
		
		return result;		
	}
	
	//toString override
	@Override
	public String toString() {
		return super.toString() + "\n";
	}
}
