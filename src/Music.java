import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Music {

	private int YearofRelease;
	private String Title;
	private String Genre;
	private Date dataOfRent;

	private ArrayList<Music> MusicList = new ArrayList<>();
	private static Scanner myObj;

	Music() {
		initMusicList();
	}

	Music(int YearofRelease, String Title, String Genre) {

		this.YearofRelease = YearofRelease;
		this.Title = Title;
		this.Genre = Genre;

	}

	/**
	 * @return the Title
	 */
	public String getTitle() {
		return this.Title;

	}

	/**
	 * add new music based on data informed
	 */
	public void addNewMusic() {
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
		MusicList.add(newMusic);

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

		MusicList.add(music1);
		MusicList.add(music2);
		MusicList.add(music3);
		MusicList.add(music4);
		MusicList.add(music5);

	}

	/**
	 * search for a music based on data informed
	 * 
	 * @return Music object
	 */
	protected Music searchMusic() {

		while (true) {

			System.out.println("Inform the name of the music");
			myObj = new Scanner(System.in);

			String term = myObj.nextLine();

			List<Music> ResultSearchMusic = MusicList.stream().filter(m -> m.getTitle().toLowerCase().contains(term))
					.collect(Collectors.toList());

			if (ResultSearchMusic.size() > 0) {
				return selectMusic(ResultSearchMusic);
			} else {
				System.out.println("Movie - " + term + " - not found try another name");
			}

		}

	}

	/**
	 * select music chosen
	 * 
	 * @param ResultSearchMusic
	 * @return Music object
	 */
	protected Music selectMusic(List<Music> ResultSearchMusic) {

		while (true) {
			for (int i = 0; i < ResultSearchMusic.size(); i++) {
				System.out.println((i + 1) + " -> " + ResultSearchMusic.get(i).getTitle());
			}

			myObj = new Scanner(System.in);
			System.out.println("Select Music by code");

			while (!myObj.hasNextInt())
				myObj.next();

			int musicCode = myObj.nextInt(); // Read user input

			if (musicCode > ResultSearchMusic.size()) {
				System.out.println("inform a valid code");
			} else {
				System.out.println("music selected is: " + ResultSearchMusic.get(musicCode - 1).getTitle());
				return ResultSearchMusic.get(musicCode - 1);
			}

		}
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