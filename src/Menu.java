import java.awt.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu<T> {

	Movie movies = new Movie();
	Music musics = new Music();
	Customers<T> ct = new Customers<T>();
	private Scanner myObj;

	Menu() {
		main();
	}

	private void main() {
		while (true) {
			System.out.println("===========================================");
			System.out.println("| Select one option from the list bellow  |");
			System.out.println("| 1 -> Rent a Title			  |");
			System.out.println("| 2 -> Return a Title 			  |");
			System.out.println("| 3 -> Add Title			  |");
			System.out.println("| 4 -> Add Customer			  |");
			System.out.println("| 5 -> Update Customer			  |");
			System.out.println("============================================");

			myObj = new Scanner(System.in);
			while (!myObj.hasNextInt())
				myObj.next();

			int option = myObj.nextInt();
			Customers<T> ctRent;
			
			switch (option) {
			case 1:
				ctRent = rentingTitle();
				ctRent.rentTitle(titles());
				break;
			case 2:
				ctRent = returningTitle();
				ctRent.returnTitle();
				break;
			default:
				break;

			}
		}

	}

	private Customers<T> rentingTitle() {
		return ct.searchCustomers();
	}

	private Customers<T> returningTitle() {
		return ct.searchCustomerRents();
	}

	private T titles() {

		while (true) {
			System.out.println("Select one option from the list bellow");
			System.out.println("1 -> Rent movie");
			System.out.println("2 -> Rent music");
			System.out.println("3 -> Rent Live Concert");
			System.out.println("4 -> Rent Box Set");

			myObj = new Scanner(System.in);
			while (!myObj.hasNextInt())
				myObj.next();

			int option = myObj.nextInt();

			switch (option) {
			case 1:
				return (T) movies.searchMovie();
			case 2:
				return (T) musics.searchMusic();
			default:
				break;
			}

		}
	}
}
