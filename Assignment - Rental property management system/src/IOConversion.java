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
	
	//loads the files into the array
	public boolean loadAllData(String personFileName, String propertyFileName, ArrayList<HomeOwner> owners, ArrayList<Tenant> tenants, ArrayList<Property> properties) {
		boolean result = true;
		IO io = new IO();
		
		//loading the person file
		String[] file = io.loadFile(personFileName);
		int line = 0;
		if (file != null)
		for (String string : file) {
			String[] split = string.split(",");
			switch (split[0]) {
				//tenant
				case "1":
					try{
						Tenant tenant = new Tenant(Integer.parseInt(split[1]), split[2], split[3], Long.parseLong(split[4]), split[5].toCharArray()[0]);
						tenants.add(tenant);
					}
					catch (Exception e) {
						System.out.println("Failed to load person file at line: " + line);
					}					
					break;
					
				//homeowner
				case "2":
					try{
						HomeOwner owner = new HomeOwner(Integer.parseInt(split[1]), split[2], split[3], Long.parseLong(split[4]), split[5].toCharArray()[0]);
						owners.add(owner);
					}
					catch (Exception e) {
						System.out.println("Failed to load person file at line: " + line);
					}		
					break;
			}
			line++;
		}
		
		return result;
	}
}
