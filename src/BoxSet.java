import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BoxSet {

	private int YearofRelease;
	private String Title;
	private String Genre;
	private Date dataOfRent;

	private ArrayList<BoxSet> BoxSetList = new ArrayList<>();
	private static Scanner myObj;

	BoxSet() {
		initBoxSetList();
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
	 * start list of box set
	 */
	protected void initBoxSetList() {
		BoxSet boxSet1 = new BoxSet(2019, "Avengers", " Action ");
		BoxSet boxSet2 = new BoxSet(2018, "Avengers", " Action ");
		BoxSet boxSet3 = new BoxSet(2001, "spider", " Action ");
		BoxSet boxSet4 = new BoxSet(2011, "Avengers", " Action ");
		BoxSet boxSet5 = new BoxSet(2015, "spiderman", " Action ");

		BoxSetList.add(boxSet1);
		BoxSetList.add(boxSet2);
		BoxSetList.add(boxSet3);
		BoxSetList.add(boxSet4);
		BoxSetList.add(boxSet5);

	}

	/**
	 * search for a box set based on data informed
	 * 
	 * @return BoxSet object
	 */
	protected BoxSet searchBoxSet() {

		while (true) {
			System.out.println("Inform the name of the box set");
			myObj = new Scanner(System.in);

			String term = myObj.nextLine();

			List<BoxSet> ResultBoxSet = BoxSetList.stream().filter(m -> m.getTitle().toLowerCase().contains(term))
					.collect(Collectors.toList());

			if (ResultBoxSet.size() > 0) {
				return selectBoxSet(ResultBoxSet);
			} else {
				System.out.println("Box Set - " + term + " - not found try another name");
			}

		}

	}

	/**
	 * select live concert video chosen
	 * 
	 * @param ResultBoxSet
	 * @return BoxSet object
	 */
	protected BoxSet selectBoxSet(List<BoxSet> ResultBoxSet) {

		while (true) {
			for (int i = 0; i < ResultBoxSet.size(); i++) {
				System.out.println((i + 1) + " -> " + ResultBoxSet.get(i).getTitle());
			}

			myObj = new Scanner(System.in);
			System.out.println("Select BoxSet by code");

			int boxSetCode = myObj.nextInt(); // Read user input

			if (boxSetCode > ResultBoxSet.size()) {
				System.out.println("inform a valid code");
			} else {
				System.out.println("box set selected is: " + ResultBoxSet.get(boxSetCode - 1).getTitle());
				return ResultBoxSet.get(boxSetCode - 1);
			}

		}
	}

	public String getTitle() {
		return this.Title;
	}

	/**
	 * @return the dataOfRent
	 */
	public Date getDataOfRent() {
		return dataOfRent;
	}

	/**
	 * @param dataOfRent the dataOfRent to set
	 */
	public void setDataOfRent() {
		this.dataOfRent = new Date();
	}
}
