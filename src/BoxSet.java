import java.util.Scanner;

public class BoxSet extends Title {

	BoxSet() {
		initBoxSetList();
	}

	BoxSet(int YearofRelease, String Title, String Genre) {
		super(YearofRelease, Title, Genre);
	}

	/**
	 * add new box set based on data informed
	 */
	public void addNewTitle() {
		System.out.println("Adding new Box Set\nInform title:");
		myObj = new Scanner(System.in);

		String title = myObj.nextLine();

		System.out.println("Inform genre:");
		myObj = new Scanner(System.in);

		String genre = myObj.nextLine();

		System.out.println("Inform year of release (YYYY):");
		myObj = new Scanner(System.in);

		int yearOfRelease = myObj.nextInt();

		BoxSet newBoxSet = new BoxSet(yearOfRelease, title, genre);
		TitleList.add(newBoxSet);

		System.out.println("New box set title has been added");
	}

	/**
	 * start list of box set
	 */
	protected void initBoxSetList() {
		BoxSet boxSet1 = new BoxSet(2019, "Avengers", " Action ");
		BoxSet boxSet2 = new BoxSet(2018, "Avengers", " Action ");
		BoxSet boxSet3 = new BoxSet(2001, "spider", " Action ");
		BoxSet boxSet4 = new BoxSet(2011, "Avengers", " Action ");
		BoxSet boxSet5 = new BoxSet(2015, "spiderman", " Action ");

		TitleList.add(boxSet1);
		TitleList.add(boxSet2);
		TitleList.add(boxSet3);
		TitleList.add(boxSet4);
		TitleList.add(boxSet5);
	}
}
