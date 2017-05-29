import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Scanner;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Program implements ActionListener {
	private ArrayList<HomeOwner> owners;
	private ArrayList<Tenant> tenants;
	private ArrayList<Property> properties;
	private Scanner sc;
	private JFrame mainFrame;

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
		// auto loading files
		IOConversion ioc = new IOConversion();
		ioc.loadAllData(personFileName, propertyFileName, owners, tenants, properties);
		
		//create the ui
		createUI();

		boolean running = true;

		while (running){
			
		}			

		sc.close();
	}
	
	//creates the user interface
	public void createUI() {
		//base frame
		mainFrame = new JFrame("Rental Property Manager");
		mainFrame.setVisible(true);
		mainFrame.setSize(640,480);
		mainFrame.setMinimumSize(new Dimension(640,480));    
		mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//force the program to actually exit on closing the window (instead of the default of hiding it in the background)
		
		createButtonPanel();
		createDataPanel();
	}
	
	public void createDataPanel() {
		JPanel result = new JPanel(new GridLayout(1, 2));
		result.setVisible(true);
		
		//column names
		String propColumnNames[] = {"ID", "Address", "Owner(s)", "Tenant(s)", "Cost Per Week", "Garage Type", "Description", "Rating", "Property Area"};
		int propColumnWidth[] = {20, 60, 60, 60, 40, 30, 40, 20, 40};
		String personColumnNames[] = {"ID", "First Name", "Last Name", "DOB", "Gender"};	
		int personColumnWidth[] = {25, 50, 50, 50, 20};
		
		DefaultTableModel  dtmProperty = new DefaultTableModel(propColumnNames, 0);
		DefaultTableModel  dtmPerson = new DefaultTableModel(personColumnNames, 0);		
		
		//populating property table
		for (int i = 0; i < properties.size(); i++) {			
			int ID = properties.get(i).getIdNumber();
			String address = properties.get(i).getAddress();
			String lOwners = properties.get(i).ownerNamesToString();
			String lTenants = properties.get(i).tenantNamesToString();
			double costPerWeek = properties.get(i).getCostPerWeek();
			GarageType garageType = properties.get(i).getGarageType();
			String description = properties.get(i).getDescription();
			double rating = properties.get(i).getRating();
			double propertyArea = properties.get(i).getPropertyArea();
			
			Object[] data = { ID, address, lOwners, lTenants, costPerWeek, garageType, description, rating, propertyArea };
			
			dtmProperty.addRow(data);
			}
		
		//populating person table
		for (int i = 0; i < owners.size(); i++) {			
			int ID = owners.get(i).getIdNumber();	
			String firstName = owners.get(i).getFirstName();
			String lastName = owners.get(i).getLastName();
			long DOB = owners.get(i).getDOB();
			char gender = owners.get(i).getGender();
			
			Object[] data = { ID, firstName, lastName, DOB, gender};
			
			dtmPerson.addRow(data);
			}
		
		//populating person table
		for (int i = 0; i < tenants.size(); i++) {			
			int ID = tenants.get(i).getIdNumber();	
			String firstName = tenants.get(i).getFirstName();
			String lastName = tenants.get(i).getLastName();
			long DOB = tenants.get(i).getDOB();
			char gender = tenants.get(i).getGender();
			
			Object[] data = { ID, firstName, lastName, DOB, gender};
			
			dtmPerson.addRow(data);
			}
		
		JTable tblProperty = new JTable(dtmProperty);
		JTable tblPerson = new JTable(dtmPerson);
		
		//setting up minimum column width
		for(int i = 0; i < propColumnWidth.length; i++) {
			tblProperty.getColumnModel().getColumn(i).setMinWidth(propColumnWidth[i]);
		}
		
		for(int i = 0; i < personColumnWidth.length; i++) {
			tblPerson.getColumnModel().getColumn(i).setMinWidth(personColumnWidth[i]);
		}
		
		JScrollPane scr1 = new JScrollPane(tblProperty);
		JScrollPane scr2 = new JScrollPane(tblPerson);
		
		result.add(scr1, BorderLayout.EAST);
		result.add(scr2, BorderLayout.WEST);
		
		mainFrame.add(result, "Center");
		mainFrame.validate();
	}
	
	public void createButtonPanel() {
		JPanel result = new JPanel();
		
		JButton btnAdd = new JButton ("Add");
		JButton btnModify = new JButton ("Modify");
		JButton btnDelete = new JButton ("Delete");
		JButton btnSave = new JButton ("Save");
		JButton btnLoad = new JButton ("Load");
		
		btnAdd.addActionListener(this);
		btnModify.addActionListener(this); 
		btnDelete.addActionListener(this); 
		btnSave.addActionListener(this); 
		btnLoad.addActionListener(this); 
		
		result.add(btnAdd);
		result.add(btnModify);
		result.add(btnDelete);
		result.add(btnSave);
		result.add(btnLoad);
		
		mainFrame.add(result, "South");
		mainFrame.validate();
	}

	//event handler for all button presses
	public void actionPerformed (ActionEvent ae) {
		switch(ae.getActionCommand()) {
		case "Add": 
			break;
		case "Modify":
			break;
		case "Delete":
			break;
		case "Save":
			break;
		case "Load":
			break;
		}
	}

	// prints all the data in each array using toString method
	public void showData(boolean showDeleteId) {		
	}

	// loop for adding data
	public void addData() {
	}

	public void modifyData() {
	}

	public void deleteData() {
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
