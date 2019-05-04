import java.util.Scanner;

public class Music extends Title {

	private String Genre;

	private static Scanner myObj;

	Music() {
		initMusicList();
	}

	Music(int YearofRelease, String Title, String Genre) {
		super(YearofRelease, Title);
		this.Genre = Genre;

	}

	/**
	 * add new music based on data informed
	 */
	public void addNewTitle() {
		System.out.println("Adding new Music\nInform title:");
		myObj = new Scanner(System.in);

		String title = myObj.nextLine();

		System.out.println("Inform genre:");
		myObj = new Scanner(System.in);

		String genre = myObj.nextLine();

		System.out.println("Inform year of release (YYYY):");
		myObj = new Scanner(System.in);

		int yearOfRelease = myObj.nextInt();

		Music newMusic = new Music(yearOfRelease, title, genre);
		TitleList.add(newMusic);

		System.out.println("New music title has been added");
	}

	/**
	 * start list of live concert music
	 */
	protected void initMusicList() {
		Music music1 = new Music(2019, "Luma Elpido", " Action ");
		Music music2 = new Music(2018, "Trazendo a Arca", " Action ");
		Music music3 = new Music(2001, "Andre Valadao", " Action ");
		Music music4 = new Music(2011, "Nivea Soares", " Action ");
		Music music5 = new Music(2015, "Ellis Soares", " Action ");

		TitleList.add(music1);
		TitleList.add(music2);
		TitleList.add(music3);
		TitleList.add(music4);
		TitleList.add(music5);

	}
}