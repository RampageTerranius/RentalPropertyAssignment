import java.util.ArrayList;
import java.util.List;

//used to convert various data types to help with saving/loading files
public class IOConversion {
	public boolean saveAllData(String personFileName, String propertyFileName, ArrayList<HomeOwner> owners, ArrayList<Tenant> tenants, ArrayList<Property> properties) {
		boolean result = true;
		IO io = new IO();
		List<String> data = null;
		
		//saving the person file		
		data = new ArrayList<String>();
		
		for (HomeOwner owner : owners)
			data.add(owner.convertToString());
		
		for (Tenant tenant : tenants) 
			data.add(tenant.convertToString());
		
		if (!io.saveFile(personFileName, data.toArray(new String[0]))) {
			System.out.println("Failed to save person file...");
			result = false;
		}
		
		//saving the property file		
		data = new ArrayList<String>();		
		
		for (Property property : properties)
			data.add(property.convertToString());
		
		if (!io.saveFile(propertyFileName, data.toArray(new String[0]))) {
			System.out.println("Failed to save property file...");
			result = false;
		}
		
		return result;
	}
}
