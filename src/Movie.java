import java.util.Scanner;

public class Movie extends Title {

	protected Movie() {
		initMovieList();
	}

	Movie(int YearofRelease, String Title, String Genre, String Director) {
		super(YearofRelease, Title, Genre, Director);
	}

	/**
	 * add new movie based on data informed
	 */
	public void addNewTitle() {
		System.out.println("Adding new Movie\nInform title:");
		myObj = new Scanner(System.in);

		String title = myObj.nextLine();

		System.out.println("Inform genre:");
		myObj = new Scanner(System.in);

		String genre = myObj.nextLine();

		System.out.println("Inform director:");
		myObj = new Scanner(System.in);

		String director = myObj.nextLine();

		System.out.println("Inform year of release (YYYY):");
		myObj = new Scanner(System.in);

		int yearOfRelease = myObj.nextInt();

		Movie newLiveConcertVideo = new Movie(yearOfRelease, title, genre, director);
		TitleList.add(newLiveConcertVideo);

		System.out.println("New movie title has been added");
	}

	/**
	 * start list of live concert movie
	 */
	protected void initMovieList() {
		Movie movie1 = new Movie(2019, "Avengers", " Action ", " Renatinho");
		Movie movie2 = new Movie(2018, "Avengers", " Action ", " Renatinho");
		Movie movie3 = new Movie(2001, "spider", " Action ", " Renatinho");
		Movie movie4 = new Movie(2011, "Avengers", " Action ", " Renatinho");
		Movie movie5 = new Movie(2015, "spiderman", " Action ", " Renatinho");

		TitleList.add(movie1);
		TitleList.add(movie2);
		TitleList.add(movie3);
		TitleList.add(movie4);
		TitleList.add(movie5);

	}

}
