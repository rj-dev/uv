import static java.lang.System.out;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Customers<T> extends MembershipCard {

	private String name;
	private List<T> rented = new ArrayList<T>();
	private AccessLevel level;
	private List<Customers<T>> CustomersList = new ArrayList<Customers<T>>();

	Scanner myObj;

	Customers() {
		initCustomersList();
	}

	Customers(String name, AccessLevel level) {
		this.name = name;
		this.setLevel(level);
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * add new customer based on the data informed
	 */
	protected void addCustomer() {

		out.println("Adding new Customer\nInform name:");
		myObj = new Scanner(System.in);

		String name = myObj.nextLine();

		out.println("Inform subscription plan");
		out.println("1 -> Music Lover");
		out.println("2 -> Video Lover");
		out.println("3 -> TV Lover");
		out.println("4 -> Premium");

		while (!myObj.hasNextInt())
			myObj.next();

		int accessLevelOption = myObj.nextInt();

		while (accessLevelOption > 4)
			accessLevelOption = myObj.nextInt();

		AccessLevel al = AccessLevel.ML;
		switch (accessLevelOption) {
		case 2:
			al = AccessLevel.VL;
			break;
		case 3:
			al = AccessLevel.TV;
			break;
		case 4:
			al = AccessLevel.PR;
			break;
		default:
			break;
		}

		Customers<T> newCustomer = new Customers<T>(name, al);
		CustomersList.add(newCustomer);

		out.println("New customer " + name + " (" + al + ") has been added");

	}

	/**
	 * update customer subscription plan
	 */
	protected void updateCustomer() {
		Customers<T> ct = searchCustomers("updating");
		List<AccessLevel> alList = new ArrayList<>();
		alList.add(AccessLevel.ML);
		alList.add(AccessLevel.VL);
		alList.add(AccessLevel.TV);
		alList.add(AccessLevel.PR);

		out.println(ct.name + " is subscribed as " + ct.level.label + "\nYou can change to:");

		out.println("1 -> " + AccessLevel.ML.label);
		out.println("2 -> " + AccessLevel.VL.label);
		out.println("3 -> " + AccessLevel.TV.label);
		out.println("4 -> " + AccessLevel.PR.label);

		myObj = new Scanner(System.in);

		while (!myObj.hasNextInt())
			myObj.next();

		int option = myObj.nextInt(); // Read user input

		if (option == 0 || option > 4)
			return;

		if (ct.level == alList.get(option - 1)) {
			out.println("Customer has kept the same subscription plan");
			return;
		}

		ct.setLevel(alList.get(option - 1));
		out.println(ct.name + " was subscripted to the plan " + alList.get(option - 1).label);
	}

	/**
	 * execute rent title action
	 * 
	 * @param title
	 */
	protected void rentTitle(T title) {
		if (canRentMore()) {
			this.rented.add(Utils.addDateRent(title));
			// this.rented.add(title);
			addPoints(10);

			if (isfreeRentAllowed()) {
				myObj = new Scanner(System.in);
				out.println("Due to the amount accumulated on your membership card,\n"
						+ "you are entitled to receive one free rental.\nWould you like to use it? (y/n)");

				if (myObj.nextLine().equals("y")) {
					if (availFreeRent()) {
						out.println("You have received a free rental");
					}
				}
			}

			out.println(this.name + " has rented " + Utils.fetchGenericInfo(title));
		} else {
			out.println("You can not rent more titles, return at least one!");
		}
	}

	/**
	 * return title based on choose made
	 */
	protected void returnTitle() {

		for (int i = 0; i < this.rented.size(); i++) {
			out.println((i + 1) + " -> " + Utils.fetchGenericInfo(this.rented.get(i)));
		}

		myObj = new Scanner(System.in);
		out.println("Select a Title for devolution by code");

		while (!myObj.hasNextInt())
			myObj.next();

		int titleCode = myObj.nextInt(); // Read user input

		if (titleCode == 0)
			return;

		if (titleCode > this.rented.size()) {
			out.println("inform a valid code");
		} else {
			out.println("title selected for devolution is: " + Utils.fetchGenericInfo(this.rented.get(titleCode - 1)));
			this.rented.remove(titleCode - 1);
		}

		out.println("Title returned, thank you!");
	}

	/**
	 * verify if can rent
	 * 
	 * @return true|false
	 */
	private boolean canRentMore() {
		return this.rented.size() < 4;
	}

	/**
	 * start a list of customers
	 */
	protected void initCustomersList() {
		// JSONParser parser = new JSONParser();
		// JSONArray arr = (JSONArray) parser.parse(new
		// FileReader("../source/customers.json"));

		// for (Object o : a) {
		// JSONObject JSONcustomer = (JSONObject) o;

		// String name = (String) JSONcustomer.get("name");
		// AccessLevel accessLevel = (AccessLevel) JSONcustomer.get("accessLevel");

		// Customers<T> customer = new Customers<T>(name, accessLevel);

		// CustomersList.add(customer);

		// }

		Customers<T> customer1 = new Customers<T>("Joao", AccessLevel.ML);
		Customers<T> customer2 = new Customers<T>("Maria", AccessLevel.ML);
		Customers<T> customer3 = new Customers<T>("Carlos", AccessLevel.TV);
		Customers<T> customer4 = new Customers<T>("Rodrigo", AccessLevel.ML);
		Customers<T> customer5 = new Customers<T>("Guilherme", AccessLevel.PR);
		Customers<T> customer6 = new Customers<T>("Bruno", AccessLevel.ML);
		Customers<T> customer7 = new Customers<T>("Douglas", AccessLevel.TV);
		Customers<T> customer8 = new Customers<T>("Miller", AccessLevel.VL);

		CustomersList.add(customer1);
		CustomersList.add(customer2);
		CustomersList.add(customer3);
		CustomersList.add(customer4);
		CustomersList.add(customer5);
		CustomersList.add(customer6);
		CustomersList.add(customer7);
		CustomersList.add(customer8);

	}

	/**
	 * search customer based on data informed
	 * 
	 * @return generic Customers object
	 */
	protected Customers<T> searchCustomers(String action) {

		while (true) {

			out.println("Inform the name of the customer for " + action);
			myObj = new Scanner(System.in);
			String name = myObj.nextLine();

			List<Customers<T>> ResultSearchCustomer = CustomersList.stream()
					.filter(c -> c.getName().toLowerCase().contains(name)).collect(Collectors.toList());
			if (ResultSearchCustomer.size() > 0) {
				return selectCustomer(ResultSearchCustomer);
			} else {
				out.println("Customer - " + name + " - not found try another name");
			}

		}

	}

	/**
	 * verify customers rents
	 * 
	 * @return generic Customers with rents
	 */
	protected Customers<T> searchCustomerRents() {

		while (true) {

			out.println("Inform the name of the customer of the devolution");
			myObj = new Scanner(System.in);
			String name = myObj.nextLine();

			List<Customers<T>> ResultSearchCustomersWithRents = CustomersList.stream().filter(c -> c.rented.size() > 0)
					.collect(Collectors.toList());

			if (ResultSearchCustomersWithRents.size() == 0) {
				out.println("No one has pending devolutions");
				return null;
			}

			ResultSearchCustomersWithRents = ResultSearchCustomersWithRents.stream()
					.filter(c -> c.getName().toLowerCase().contains(name)).collect(Collectors.toList());

			if (ResultSearchCustomersWithRents.size() > 0) {
				for (int i = 0; i < ResultSearchCustomersWithRents.size(); i++) {
					out.println((i + 1) + " -> " + ResultSearchCustomersWithRents.get(i).getName());
				}

				myObj = new Scanner(System.in);
				out.println("Select Customer by code");

				while (!myObj.hasNextInt())
					myObj.next();

				int customerCode = myObj.nextInt(); // Read user input

				if (customerCode > ResultSearchCustomersWithRents.size()) {
					out.println("inform a valid code");
				} else {
					out.println(
							"customer selected for devolution is: " + ResultSearchCustomersWithRents.get(customerCode - 1).getName());
					return ResultSearchCustomersWithRents.get(customerCode - 1);
				}

			} else {
				out.println("Customer - " + name + " - not found try another name");
			}

		}

	}

	/**
	 * select customer chosen
	 * 
	 * @param ResultSearchCustomer
	 * @return Customers found
	 */
	protected Customers<T> selectCustomer(List<Customers<T>> ResultSearchCustomer) {

		while (true) {
			for (int i = 0; i < ResultSearchCustomer.size(); i++) {
				out.println((i + 1) + " -> " + ResultSearchCustomer.get(i).getName());
			}

			out.println("Select Customer by code");
			myObj = new Scanner(System.in);

			while (!myObj.hasNextInt()) {
				out.println("Select Customer by code");
				myObj.next();
			}

			int customerCode = myObj.nextInt(); // Read user input
			if (customerCode == 0)
				return null;

			if (customerCode > ResultSearchCustomer.size()) {
				out.println("inform a valid code");
			} else {
				out.println("customer selected is: " + ResultSearchCustomer.get(customerCode - 1).getName());
				return ResultSearchCustomer.get(customerCode - 1);
			}

		}
	}

	/**
	 * @return the level
	 */
	public AccessLevel getLevel() {
		return level;
	}

	/**
	 * @param level the level to set
	 */
	public void setLevel(AccessLevel level) {
		this.level = level;
	}

}
