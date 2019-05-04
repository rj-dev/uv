import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LiveConcertVideos extends Title {

	private String Band;

	private static Scanner myObj;

	LiveConcertVideos() {
		initLiveConvertVideosList();
	}

	LiveConcertVideos(int YearOfRelease, String Title, String Band) {
		super(YearOfRelease, Title);
		this.Band = Band;
	}

	/**
	 * add new live concert video based on data informed
	 */
	public void addNewTitle() {
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
		TitleList.add(newLiveConcertVideo);

		System.out.println("New live concert video title has been added");
	}

	/**
	 * start list of live concert videos
	 */
	protected void initLiveConvertVideosList() {
		LiveConcertVideos liveConvertVIdeo1 = new LiveConcertVideos(2019, "Avengers", " Action ");
		LiveConcertVideos liveConvertVIdeo2 = new LiveConcertVideos(2018, "Avengers", " Action ");
		LiveConcertVideos liveConvertVIdeo3 = new LiveConcertVideos(2001, "spider", " Action ");
		LiveConcertVideos liveConvertVIdeo4 = new LiveConcertVideos(2011, "Avengers", " Action ");
		LiveConcertVideos liveConvertVIdeo5 = new LiveConcertVideos(2015, "spiderman", " Action ");

		TitleList.add(liveConvertVIdeo1);
		TitleList.add(liveConvertVIdeo2);
		TitleList.add(liveConvertVIdeo3);
		TitleList.add(liveConvertVIdeo4);
		TitleList.add(liveConvertVIdeo5);

	}

}
