
public class Other<t> extends Property{
	private t extraData;
	
	public Other() {
		super();
	}
	
	public Other(int pIdNumber, String pAddress, double pCostPerWeek) {
		super(pIdNumber, pAddress, pCostPerWeek);
	}
	
	public Other(int pIdNumber, String pAddress, double pCostPerWeek, t pExtraData) {
		super(pIdNumber, pAddress, pCostPerWeek);
		setExtraData(pExtraData);
	}
	
	public Other(int pIdNumber, String pAddress, double pCostPerWeek, GarageType pGarageType, String pDescription, t pExtraData) {
		super(pIdNumber, pAddress, pCostPerWeek, pGarageType, pDescription);
		setExtraData(pExtraData);
	}

	public t getExtraData()	{
		return extraData;
	}
	
	public void setExtraData(t pExtraData) {
		extraData = pExtraData;		
	}
	
	public String convertToString() {
		String result = "";
		
		result += baseConvertToString() + ",";
		result += getExtraData();
		
		return result;
	}
	
	//toString override
	@Override
	public String toString() {
		return super.toString() + "\n ExtraData: " + getExtraData() + "\n";
	}
}
