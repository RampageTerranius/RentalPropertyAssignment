import java.util.ArrayList;
import java.util.Scanner;

public class Program {
	private ArrayList<HomeOwner> owners;
	private ArrayList<Tenant> tenants;
	private ArrayList<Property> properties;
	private Scanner sc;

	// constants for use with file saving/loading
	private final String personFileName = "person.txt";
	private final String propertyFileName = "property.txt";

	public Program() {
		owners = new ArrayList<HomeOwner>();
		tenants = new ArrayList<Tenant>();
		properties = new ArrayList<Property>();
		sc = new Scanner(System.in);
	}

	// primary program loop handler
	public void runProgram() {
		System.out.println("Welcome to the program");
		System.out.println("Type help for command list");

		// auto loading file
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

		switch (sc.nextLine().toLowerCase()) {
		case "exit":
			System.out.println("Exiting program...");
			return false;

		case "help":
			System.out.println("Commands:");
			System.out.println("help - shows this dialog");
			System.out.println("show - shows all data");
			System.out.println("add - opens the menu to add data");
			System.out.println("delete - opens the menu to delete data");
			System.out.println("save - saves the current changes to file");
			System.out.println("load - reloads the original file discarding changes");
			System.out.println("credits - shows the credits");
			System.out.println("exit - exits program");
			break;

		case "add":
			addData();
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

	// prints all the data in each array using toString method
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

	public void getInputForAddData(Property property) {
		boolean loop = true;
		int section = 0;

		while (loop) {
			switch (section) {
			case 0:
				System.out.println("Please enter a ID Number (try to make it unique)");
				try {
					property.setIdNumber(Integer.parseInt(sc.nextLine()));
					section++;
				} catch (Exception e) {

				}
				break;

			case 1:
				try {
					System.out.println("Please enter a address");
					property.setAddress(sc.nextLine());
					section++;
				} catch (Exception e) {

				}
				break;

			case 2:
				try {
					System.out.println("Please enter the cost per week");
					property.setCostPerWeek(Double.parseDouble(sc.nextLine()));
					section++;
				} catch (Exception e) {

				}
				break;

			case 3:
				try {
					System.out.println("Please enter the GarageType using an int (0 = none, 1 = garage, 2 = secure)");
					int val = Integer.parseInt(sc.nextLine());
					if (val >= 0 && val <= 2) {
						property.setGarageType(GarageType.values()[val]);
						section++;
					}
				} catch (Exception e) {

				}
				break;

			case 4:
				try {
					System.out.println("Please enter a description");
					property.setDescription(sc.nextLine());
					section++;
				} catch (Exception e) {

				}
				break;

			case 5:
				try {
					System.out.println("Please enter a rating");
					property.setRating(Double.parseDouble(sc.nextLine()));
					section++;
				} catch (Exception e) {

				}
				break;

			case 6:
				try {
					System.out.println("Please enter a property area");
					property.setPropertyArea(Double.parseDouble(sc.nextLine()));
					section++;
				} catch (Exception e) {

				}
				break;
			case 7:
				try {
					if (property instanceof Apartment) {
						System.out.println("Please enter a floor number");
						((Apartment) property).setFloorNumber(sc.nextLine());
						section++;
					} else if (property instanceof TownHouse) {
						System.out.println("Please enter the ammount of attached houses");
						((TownHouse) property).setAttachedHouses(Integer.parseInt(sc.nextLine()));
						section++;
					} else
						section++;
				} catch (Exception e) {

				}
				break;
			case 8:
				loop = false;
				break;
			}
		}
	}

	public void getInputForAddData(Person person) {
		boolean loop = true;
		int section = 0;
		while (loop) {
			switch (section) {
			case 0:
				System.out.println("Please enter a ID Number (try to make it unique)");
				
				try {					
					person.setIdNumber(Integer.parseInt(sc.nextLine()));
					section++;
				} catch (Exception e) {
					
				}
				break;

			case 1:
					System.out.println("Please enter a First Name");
					person.setFirstName(sc.nextLine());
					section++;
				break;

			case 2:
					System.out.println("Please enter a Last Name");
					person.setLastName(sc.nextLine());
					section++;
				break;

			case 3:
				try {
					System.out.println("Please enter a Date of birth (using long type)");
					person.setDOB(Long.parseLong(sc.nextLine()));
					section++;
				} catch (Exception e) {

				}
				break;

			case 4:
				try {
					System.out.println("Please enter a Gender (either m , f or u)");
					person.setGender(sc.nextLine().charAt(0));
					section++;
				} catch (Exception e) {

				}
				break;
			}

			if (person instanceof Tenant) {
				switch (section) {
				case 5:
					try {
						System.out.println("Please enter a date leased (using long type)");
						((Tenant) person).setDateLeased(Long.parseLong(sc.nextLine()));
						section++;
					} catch (Exception e) {

					}
					break;

				case 6:
					try {
						System.out.println("Please enter the length of the contract in days");
						((Tenant) person).setLengthOfContract(Integer.parseInt(sc.nextLine()));
						section++;
						loop = false;
					} catch (Exception e) {

					}
					break;
				}
			} else if (person instanceof HomeOwner) {
				loop = false;
			}
		}
	}

	// loop for adding data
	public void addData() {
		boolean loop = true;
		System.out.println("\n--Data Add--");
		System.out.println("type help for command list");

		while (loop) {
			System.out.println("Please enter your command");

			switch (sc.nextLine().toLowerCase()) {

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

			case "tenant":
				Tenant tenant = new Tenant();
				getInputForAddData(tenant);
				tenants.add(tenant);
				System.out.println("new tenant created, modify it in the modify menu");
				break;

			case "homeowner":
				HomeOwner owner = new HomeOwner();
				getInputForAddData(owner);
				owners.add(owner);
				System.out.println("new home owner created, modify it in the modify menu");
				break;

			case "apartment":
				Apartment ap = new Apartment();
				getInputForAddData(ap);
				properties.add(ap);
				System.out.println("new apartment created, modify it in the modify menu");
				break;

			case "townhouse":
				TownHouse th = new TownHouse();
				getInputForAddData(th);
				properties.add(th);
				System.out.println("new townhouse created, modify it in the modify menu");
				break;

			case "studio":
				Studio st = new Studio();
				getInputForAddData(st);
				properties.add(st);
				System.out.println("new studio created, modify it in the modify menu");
				break;

			case "detatchedhouse":
				DetatchedHouse dh = new DetatchedHouse();
				getInputForAddData(dh);
				properties.add(dh);
				System.out.println("new detatchedhouse created, modify it in the modify menu");
				break;

			/*
			 * case "create other": properties.add(new Other());
			 * System.out.println(
			 * "new other created, modify it in the modify menu"); break;
			 */

			case "exit":
			case "back":
				loop = false;
				break;

			case "help":
				System.out.println("tenant - create a blank tenant");
				System.out.println("homeowner - create a blank home owner");
				System.out.println("apartment - create a blank apartment");
				System.out.println("townhouse - create a blank townhouse");
				System.out.println("studio - create a blank studio");
				System.out.println("detatchedhouse - create a blank detatchedhouse");
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
			switch (string.split(" ")[0]) {

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
			switch (string.split(" ")[0]) {

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

						} else
							System.out.println("invalid index");
					} catch (NumberFormatException e) {
						System.out.println("unknown command");
						System.out.println("type help for command list");
					}
				} else {
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
		if (conv.saveAllData(personFileName, propertyFileName, owners, tenants, properties))
			System.out.println("Data saved");
		else
			System.out.println("Save failed...");
	}

	public void loadData() {
		IOConversion ioc = new IOConversion();
		if (ioc.loadAllData(personFileName, propertyFileName, owners, tenants, properties))
			System.out.println("Data loaded");
		else
			System.out.println("Data failed to load");
	}
}
