import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Movie {

	private int YearofRelease;
	private String Title;
	private String Genre;
	private String Director;
	private String dataOfRent;

	private ArrayList<Movie> MovieList = new ArrayList<>();
	private static Scanner myObj;

	protected Movie() {
		initMovieList();
	}

	Movie(int YearofRelease, String Title, String Genre, String Director) {

		this.YearofRelease = YearofRelease;
		this.Title = Title;
		this.Genre = Genre;
		this.Director = Director;

	}

	/**
	 * add new movie based on data informed
	 */
	public void addNewMovie() {
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
		MovieList.add(newLiveConcertVideo);

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

		MovieList.add(movie1);
		MovieList.add(movie2);
		MovieList.add(movie3);
		MovieList.add(movie4);
		MovieList.add(movie5);

	}

	/**
	 * search for a movie based on data informed
	 * 
	 * @return Movie object
	 */
	protected Movie searchMovie() {

		while (true) {
			System.out.println("Inform the name of the movie");
			myObj = new Scanner(System.in);

			String term = myObj.nextLine();

			List<Movie> ResultSearchMovie = MovieList.stream().filter(m -> m.getTitle().toLowerCase().contains(term))
					.collect(Collectors.toList());

			if (ResultSearchMovie.size() > 0) {
				return selectMovie(ResultSearchMovie);
			} else {
				System.out.println("Movie - " + term + " - not found try another name");
			}
		}

	}

	/**
	 * select movie chosen
	 * 
	 * @param ResultSearchMovie
	 * @return Movie object
	 */
	protected Movie selectMovie(List<Movie> ResultSearchMovie) {

		while (true) {
			for (int i = 0; i < ResultSearchMovie.size(); i++) {
				System.out.println((i + 1) + " -> " + ResultSearchMovie.get(i).getTitle());
			}

			myObj = new Scanner(System.in);
			System.out.println("Select Movie by code");

			int movieCode = myObj.nextInt(); // Read user input

			if (movieCode > ResultSearchMovie.size()) {
				System.out.println("inform a valid code");
			} else {
				System.out.println("movied selected is: " + ResultSearchMovie.get(movieCode - 1).getTitle());
				return ResultSearchMovie.get(movieCode - 1);
			}

		}
	}

	/**
	 * @return the Title
	 */
	public String getTitle() {
		return this.Title;

	}

	/**
	 * 
	 * @param title the Title to set
	 */
	public void setTitle(String title) {
		this.Title = title;

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
