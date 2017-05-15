import java.security.acl.Owner;
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
		IO io = new IO();
		
		//loading the person file
		String[] file = io.loadFile(personFileName);
		int line = 1;
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
		
		//loading the person file
		file = io.loadFile(propertyFileName);
		line = 1;
		if (file == null)
			return false;
		
		for (String string : file) {
			String[] split = string.split(",");
			switch (split[0]) {
				//apartment
				case "1":
					try{						
						Apartment ap = new Apartment(Integer.parseInt(split[1]), split[2], Double.parseDouble(split[5]), GarageType.valueOf(split[6]), split[7], Double.parseDouble(split[9]), split[10]); 
						String[] val = null;
						
						//adding owners
						val = split[3].split("=");
						if (val.length > 0)
						for (String string2 : val) 
							for (HomeOwner owner : owners) 
								if (owner.getIdNumber() == Integer.parseInt(string2) && owner.getIdNumber() != -1)								
									ap.addOwner(owner);						
						
						
						//adding tenants
						val = split[4].split("=");
						
						//adding owners
						if (val.length > 0)
						for (String string2 : val) 
							for (Tenant tenant : tenants) 
								if (tenant.getIdNumber() == Integer.parseInt(string2) && tenant.getIdNumber() != -1)								
									ap.addTenant(tenant, true);
						
						properties.add(ap);
					}
					catch (Exception e) {
						System.out.println("Failed to load properties file at line: " + line);
					}					
					break;
					
				//townhouse
				case "2":
					try{						
						TownHouse th = new TownHouse(Integer.parseInt(split[1]), split[2], Double.parseDouble(split[5]), GarageType.valueOf(split[6]), split[7], Double.parseDouble(split[9]), Integer.parseInt(split[10])); 
						String[] val = null;
						
						//adding owners
						val = split[3].split("=");
						if (val.length > 0)
						for (String string2 : val) 
							for (HomeOwner owner : owners) 
								if (owner.getIdNumber() == Integer.parseInt(string2) && owner.getIdNumber() != -1)								
									th.addOwner(owner);						
						
						
						//adding tenants
						val = split[4].split("=");
						
						//adding owners
						if (val.length > 0)
						for (String string2 : val) 
							for (Tenant tenant : tenants) 
								if (tenant.getIdNumber() == Integer.parseInt(string2) && tenant.getIdNumber() != -1)								
									th.addTenant(tenant, true);
						
						properties.add(th);
					}
					catch (Exception e) {
						System.out.println("Failed to load properties file at line: " + line);
					}		
					break;
					
				//studio
				case "3":
					try{						
						Studio st = new Studio(Integer.parseInt(split[1]), split[2], Double.parseDouble(split[5]), GarageType.valueOf(split[6]), split[7], Double.parseDouble(split[9])); 
						String[] val = null;
						
						//adding owners
						val = split[3].split("=");
						if (val.length > 0)
						for (String string2 : val) 
							for (HomeOwner owner : owners) 
								if (owner.getIdNumber() == Integer.parseInt(string2) && owner.getIdNumber() != -1)								
									st.addOwner(owner);						
						
						
						//adding tenants
						val = split[4].split("=");
						
						//adding owners
						if (val.length > 0)
						for (String string2 : val) 
							for (Tenant tenant : tenants) 
								if (tenant.getIdNumber() == Integer.parseInt(string2) && tenant.getIdNumber() != -1)								
									st.addTenant(tenant, true);
						
						properties.add(st);
					}
					catch (Exception e) {
						System.out.println("Failed to load properties file at line: " + line);
					}		
					break;
					
				//detatched house
				case "4":
					try{						
						DetatchedHouse dt = new DetatchedHouse(Integer.parseInt(split[1]), split[2], Double.parseDouble(split[5]), GarageType.valueOf(split[6]), split[7], Double.parseDouble(split[9]), Double.parseDouble(split[10])); 
						String[] val = null;
						
						//adding owners
						val = split[3].split("=");
						if (val.length > 0)
						for (String string2 : val) 
							for (HomeOwner owner : owners) 
								if (owner.getIdNumber() == Integer.parseInt(string2) && owner.getIdNumber() != -1)								
									dt.addOwner(owner);						
						
						
						//adding tenants
						val = split[4].split("=");
						
						//adding owners
						if (val.length > 0)
						for (String string2 : val) 
							for (Tenant tenant : tenants) 
								if (tenant.getIdNumber() == Integer.parseInt(string2) && tenant.getIdNumber() != -1)								
									dt.addTenant(tenant, true);
						
						properties.add(dt);
					}
					catch (Exception e) {
						System.out.println("Failed to load properties file at line: " + line);
					}		
					break;
					
				//other
				/*case "5":
					try{
						HomeOwner owner = new HomeOwner(Integer.parseInt(split[1]), split[2], split[3], Long.parseLong(split[4]), split[5].toCharArray()[0]);
						owners.add(owner);
					}
					catch (Exception e) {
						System.out.println("Failed to load properties file at line: " + line);
					}		
					break;*/
			}
			line++;
		}
		
		return true;
	}
}
