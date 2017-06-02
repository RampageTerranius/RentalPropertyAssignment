import java.util.Scanner;

public class Program {
	public Data data;
	private Scanner sc;
	private UI ui;
	public boolean running = true;
	private IOConversion ioc;
	
	// constants for use with file saving/loading
	public final String personFileName = "person.txt";
	public final String propertyFileName = "property.txt";
	
	public Program() {
		data = new Data();
		ioc = new IOConversion();
		ui = new UI(this, data);
		loadData();
		sc = new Scanner(System.in);
	}

	// primary program loop handler
	public void runProgram() {		
		//create the ui = new UI();		
		ui.createUI();	

		boolean running = true;

		while (running){
		}

		sc.close();
	}

	public void saveData() {
		if (ioc.saveAllData(this, data))
			System.out.println("Data saved");
		else
			System.out.println("Save failed...");
	}

	public void loadData() {
		if (ioc.loadAllData(this, data))		
			System.out.println("Data loaded");
		else
			System.out.println("Data failed to load...");
	}
}
