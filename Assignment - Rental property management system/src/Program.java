import java.util.ArrayList;
import java.util.Scanner;

public class Program {
	private ArrayList<HomeOwner> owners;
	private ArrayList<Tenant> tenants;
	private ArrayList<Property> properties;
	private Scanner sc;
	
	//constants for use with file saving/loading
	private final String personFileName = "person.txt";
	private final String propertyFileName = "property.txt";
	
	public Program() {
		owners = new ArrayList<HomeOwner>();
		tenants = new ArrayList<Tenant>();
		properties = new ArrayList<Property>();
		sc = new Scanner(System.in);
	}
	
	//primary program loop handler
	public void runProgram() {
		showMessage("welcome message");
		
		//auto loading file
		IOConversion ioc = new IOConversion();		
		ioc.loadAllData(personFileName, propertyFileName, owners, tenants, properties);
		
		boolean running = true;
		
		while (running) 
			running = getInput();
		
		sc.close();
	}
	
	public boolean getInput() {
		System.out.println("\n--Main Menu--");
		System.out.println("Please enter your command");
		
		switch(sc.nextLine().toLowerCase()) {
			case "exit":
				System.out.println("Exiting program...");
				return false;	
				
			case "help":
				showMessage("help");
				break;	

			case "add":
				addData();
				break;
				
			case "modify":
				modifyData();
				break;
				
			case "delete":
				deleteData();
				break;
				
			case "save":
				saveData();
				break;
				
			case "load":
				loadData();
				break;
				
			case "show":
				showData(false);
				break;
				
			case "credits":
				System.out.println("Created by tyler brown");
				System.out.println("created for tafe java assignment 2017");
				break;
				
			default:
				System.out.println("unknown command");
				System.out.println("type help for command list");
				break;
		}
		
		return true;
	}
	
	//prints all the data in each array using toString method
	public void showData(boolean showDeleteId) {
		int i = 0;
		if (owners.size() > 0)
			for (HomeOwner homeOwner : owners) {
				if (showDeleteId)
					System.out.println(i);
				System.out.println(homeOwner.toString());
				i++;
			}							
		else if (!showDeleteId)
			System.out.println("No home owners loaded...");
		
		if (tenants.size() > 0) 
			for (Tenant tenant : tenants) {
				if (showDeleteId)
					System.out.println(i);
				System.out.println(tenant.toString());
				i++;
			}	
		else if (!showDeleteId)
			System.out.println("No tenants loaded...");
		
		if (properties.size() > 0) 
			for (Property property : properties) {
				if (showDeleteId)
					System.out.println(i);
				System.out.println(property.toString());	
				i++;
			}	
		else if (!showDeleteId)
			System.out.println("No properties loaded...");
	}
	
	//loop for adding data
	public void addData() {
		boolean loop = true;
		System.out.println("\n--Data Add--");
		System.out.println("type help for command list");
		
		while (loop) {			
			System.out.println("Please enter your command");
			
			switch(sc.nextLine().toLowerCase()) {
			
			case "test":
				tenants.add(new Tenant());
				tenants.add(new Tenant());
				owners.add(new HomeOwner());
				owners.add(new HomeOwner());
				properties.add(new Apartment());
				properties.add(new TownHouse());
				properties.add(new Studio());
				properties.add(new DetatchedHouse());
				break;
			
			case "create tenant":
				tenants.add(new Tenant());
				System.out.println("new tenant created, modify it in the modify menu");
				break;
				
			case "create homeowner":
				owners.add(new HomeOwner());
				System.out.println("new home owner created, modify it in the modify menu");
				break;
				
			case "create apartment":
				properties.add(new Apartment());
				System.out.println("new apartment created, modify it in the modify menu");
				break;
				
			case "create townhouse":
				properties.add(new TownHouse());
				System.out.println("new townhouse created, modify it in the modify menu");
				break;
				
			case "create studio":
				properties.add(new Studio());
				System.out.println("new studio created, modify it in the modify menu");
				break;
				
			case "create detatchedhouse":
				properties.add(new DetatchedHouse());
				System.out.println("new detatchedhouse created, modify it in the modify menu");
				break;
				
			/*case "create other":
				properties.add(new Other());
				System.out.println("new other created, modify it in the modify menu");
				break;*/
			
			
			case "exit":
			case "back":
				loop = false;
				break;
				
			case "help":
				System.out.println("create tenant - create a blank tenant");
				System.out.println("create homeowner - create a blank home owner");
				System.out.println("create apartment - create a blank apartment");
				System.out.println("create townhouse - create a blank townhouse");
				System.out.println("create studio - create a blank studio");
				System.out.println("create detatchedhouse - create a blank detatchedhouse");
				System.out.println("create other  - create a blank home using custom data");
				System.out.println("exit - returns to the previous menu");
				break;
			
			default:
				System.out.println("unknown command");
				System.out.println("type help for command list");
				break;
			}
		}
	}
	
	public void modifyData() {
		boolean loop = true;
		
		System.out.println("\n--Data Modify--");
		System.out.println("type help for command list");
		
		while (loop) {
			System.out.println("Please enter your command");
			String string = sc.nextLine().toLowerCase();
			switch(string.split(" ")[0]) {
			
			case "back":
			case "exit":
				loop = false;
				break;
				
			default:
				System.out.println("unknown command");
				System.out.println("type help for command list");
				break;			
			}
		}				
	}
	
	public void deleteData() {
		boolean loop = true;
		
		if (owners.size() + tenants.size() + properties.size() == 0) {
			System.out.println("\n--Data Delete--");
			System.out.println("no data to delete! returning to last menu");
			return;
		}
			
		
		System.out.println("\n--Data Delete--");
		System.out.println("type help for command list");
		
		while (loop) {			
			System.out.println("Please enter your command");
			String string = sc.nextLine().toLowerCase();
			switch(string.split(" ")[0]) {
			
			case "delete":		
				if (string.split(" ").length > 1) {
					try {
						int num = Integer.parseInt(string.split(" ")[1]);
						int totalSize = (owners.size() + tenants.size() + properties.size());
						if (num >= 0 && num < totalSize) {
							
							if (num >= (owners.size() + tenants.size())) {
								if (properties.size() > 0) {
									System.out.println(num);
									num -= owners.size();
									num -= tenants.size();
									System.out.println(num);
									properties.remove(num);
									System.out.println("property deleted");
								}
								
							} else if (num >= owners.size()) {
								if (tenants.size() > 0) {
									System.out.println(num);
									num -= owners.size();
									System.out.println(num);
									tenants.remove(num);
									System.out.println("tenant deleted");
								}								
							} else if (owners.size() > 0) {
								System.out.println(num);
								owners.remove(num);
								System.out.println("owner deleted");
							}
								
						}
						else
							System.out.println("invalid index");
					}
					catch (NumberFormatException e) {
						System.out.println("unknown command");
						System.out.println("type help for command list");
					}
				}
				else
				{
					System.out.println("unknown command");
					System.out.println("type help for command list");
				}									
				break;
					
			case "show":
				showData(true);
				break;
			
			case "help":
				System.out.println("show - shows the list of all data with an accompanying id");
				System.out.println("delete <#> - removes the data with the given id");
				System.out.println("exit - returns to the previous menu");
			
			case "back":
			case "exit":
				loop = false;
				break;
				
			default:
				System.out.println("unknown command");
				System.out.println("type help for command list");
				break;
			}				
		}
	}

	public void saveData() {
		System.out.println("Saving data...");		
		
		IOConversion conv = new IOConversion();		
		if(conv.saveAllData(personFileName, propertyFileName, owners, tenants, properties))
			System.out.println("Data saved");
		else
			System.out.println("Save failed...");		
	}
	
	public void loadData() {
		IOConversion ioc = new IOConversion();
		if (ioc.loadAllData(personFileName, propertyFileName, owners, tenants, properties))					
			System.out.println("Data loaded");
	}
	
	public void showMessage(String messageName) {
		
		switch(messageName.toLowerCase()) {
			case "welcome message":
				System.out.println("Welcome to the program");			
				System.out.println("Type help for command list");
				break;
				
			case "help":
				System.out.println("Commands:");	
				System.out.println("help - shows this dialog");
				System.out.println("show - shows all data");
				System.out.println("add - opens the menu to add data");
				System.out.println("modify - opens the menu to modify data");
				System.out.println("delete - opens the menu to delete data");
				System.out.println("save - saves the current changes to file");
				System.out.println("load - reloads the original file discarding changes");
				System.out.println("credits - shows the credits");
				System.out.println("exit - exits program");
				break;
		}		
	}
}

