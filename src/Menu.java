import java.util.Scanner;

public class Menu<T> {

	Music musics = new Music();
	LiveConcertVideos liveConcertVideos = new LiveConcertVideos();
	Movie movies = new Movie();
	BoxSet boxSets = new BoxSet();
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
				ctRent = ct.searchCustomers("renting");
				if (ctRent != null) {
					T titlesAllowed = titles(ctRent);
					if (titlesAllowed != null)
						ctRent.rentTitle(titlesAllowed);
				}

				break;
			case 2:
				ctRent = ct.searchCustomerRents();
				if (ctRent != null)
					ctRent.returnTitle();
				break;
			case 3:
				addNewTitle();
				break;
			case 4:
				ct.addCustomer();
				break;
			case 5:
				ct.updateCustomer();
				break;
			default:
				break;

			}
		}

	}

	/**
	 * @param ct -- Customers object
	 * @return generic object title
	 */
	@SuppressWarnings("unchecked")
	private T titles(Customers<T> ct) {

		while (true) {
			System.out.println("Select one option from the list bellow");

			AccessLevel ctLevel = ct.getLevel();
			if (ctLevel.equals(AccessLevel.ML) || ctLevel.equals(AccessLevel.PR)) {
				System.out.println("1 -> Rent music");
				System.out.println("2 -> Rent Live Concert");
			}

			if (ctLevel.equals(AccessLevel.VL) || ctLevel.equals(AccessLevel.PR)) {
				System.out.println("3 -> Rent movie");
			}

			if (ctLevel.equals(AccessLevel.TV) || ctLevel.equals(AccessLevel.PR)) {
				System.out.println("4 -> Rent Box Set");

			}

			myObj = new Scanner(System.in);

			while (!myObj.hasNextInt())
				myObj.next();

			int option = myObj.nextInt();

			switch (option) {
			case 1:
				return (T) musics.searchMusic();
			case 2:
				return (T) liveConcertVideos.searchLiveConcertVideos();
			case 3:
				return (T) movies.searchMovie();
			case 4:
				break;
			default:
				return null;
			}

		}
	}

	/**
	 * execute action of adding new title
	 */
	private void addNewTitle() {

		System.out.println("===========================================");
		System.out.println("| What type of title do you want to add?  |");
		System.out.println("| 1 -> Music			  	  |");
		System.out.println("| 2 -> Live Concert Video 		  |");
		System.out.println("| 3 -> Movie			  	  |");
		System.out.println("| 4 -> Box Set			  	  |");
		System.out.println("============================================");

		myObj = new Scanner(System.in);

		while (!myObj.hasNextInt())
			myObj.next();

		int option = myObj.nextInt();

		switch (option) {
		case 1:
			musics.addNewMusic();
			break;
		case 2:
			liveConcertVideos.addNewLiveConcertVideo();
			break;
		case 3:
			movies.addNewMovie();
			break;
		case 4:
			boxSets.addNewBoxSet();
			break;
		default:
			return;
		}

	}
}
