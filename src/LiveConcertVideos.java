import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LiveConcertVideos {

	private int YearOfRelease;
	private String Title;
	private String Band;

	private ArrayList<LiveConcertVideos> LiveConcertVideosList = new ArrayList<>();
	private static Scanner myObj;

	LiveConcertVideos() {

	}

	LiveConcertVideos(int YearOfRelease, String Title, String Band) {

		this.YearOfRelease = YearOfRelease;
		this.Title = Title;
		this.Band = Band;

	}

	public String getTitle() {
		return this.Title;

	}

	public void addNewLiveConcertVideo() {
		System.out.println("Adding new Live Concert Video\nInform title:");
		myObj = new Scanner(System.in);

		String title = myObj.nextLine();

		System.out.println("Inform band:");
		myObj = new Scanner(System.in);

		String band = myObj.nextLine();

		System.out.println("Inform year of release (YYYY):");
		myObj = new Scanner(System.in);

		int yearOfRelease = myObj.nextInt();

		LiveConcertVideos newLiveConcertVideo = new LiveConcertVideos(yearOfRelease, title, band);
		LiveConcertVideosList.add(newLiveConcertVideo);

		System.out.println("New live concert video title has been added");
	}

	protected void initLiveConvertVideosList() {
		LiveConcertVideos movie1 = new LiveConcertVideos(2019, "Avengers", " Action ");
		LiveConcertVideos movie2 = new LiveConcertVideos(2018, "Avengers", " Action ");
		LiveConcertVideos movie3 = new LiveConcertVideos(2001, "spider", " Action ");
		LiveConcertVideos movie4 = new LiveConcertVideos(2011, "Avengers", " Action ");
		LiveConcertVideos movie5 = new LiveConcertVideos(2015, "spiderman", " Action ");

		LiveConcertVideosList.add(movie1);
		LiveConcertVideosList.add(movie2);
		LiveConcertVideosList.add(movie3);
		LiveConcertVideosList.add(movie4);
		LiveConcertVideosList.add(movie5);

		Scanner myObj = new Scanner(System.in);

		while (true) {

			System.out.println("Inform the name of the movie");

			String term = myObj.nextLine();

			List<LiveConcertVideos> ResultSearchLiveConcertVideos = searchLiveConcertVideos(term);
			if (ResultSearchLiveConcertVideos.size() > 0) {
				selectLiveConcertVideos(ResultSearchLiveConcertVideos);
				break;
			} else {
				System.out.println("Movie - " + term + " - not found try another name");
			}

		}

	}

	protected List<LiveConcertVideos> searchLiveConcertVideos(String term) {

		List<LiveConcertVideos> ResultSearchMovie = LiveConcertVideosList.stream()
				.filter(m -> m.getTitle().toLowerCase().contains(term)).collect(Collectors.toList());

		return ResultSearchMovie;
	}

	protected void selectLiveConcertVideos(List<LiveConcertVideos> ResultSearchLiveConcertVideos) {

		while (true) {
			for (int i = 0; i < ResultSearchLiveConcertVideos.size(); i++) {
				System.out.println((i + 1) + " -> " + ResultSearchLiveConcertVideos.get(i).getTitle());
			}

			myObj = new Scanner(System.in);
			System.out.println("Select Movie by code");

			int liveConcertVideosCode = myObj.nextInt(); // Read user input

			if (liveConcertVideosCode > ResultSearchLiveConcertVideos.size()) {
				System.out.println("inform a valid code");
			} else {
				System.out
						.println("movied selected is: " + ResultSearchLiveConcertVideos.get(liveConcertVideosCode - 1).getTitle());
				break;
			}

		}
	}

}
