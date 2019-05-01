import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class BoxSet {

	private int YearofRelease;
	private String Title;
	private String Genre;
	private String dataOfRent;

	private ArrayList<BoxSet> BoxSetList = new ArrayList<>();
	private static Scanner myObj;

	BoxSet() {

	}

	BoxSet(int YearofRelease, String Title, String Genre) {

		this.YearofRelease = YearofRelease;
		this.Title = Title;
		this.Genre = Genre;

	}

	/**
	 * add new box set based on data informed
	 */
	public void addNewBoxSet() {
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
		BoxSetList.add(newBoxSet);

		System.out.println("New box set title has been added");
	}

	/**
	 * @return the dataOfRent
	 */
	public String getDataOfRent() {
		return dataOfRent;
	}

	/**
	 * @param dataOfRent the dataOfRent to set
	 */
	public void setDataOfRent(String dataOfRent) {
		this.dataOfRent = dataOfRent;
	}
}
