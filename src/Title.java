import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.stream.Collectors;

abstract class Title {

    private int YearofRelease;
    private String Title;
    private String Genre;
    private String Director;
    private String Band;
    private Date dataOfRent;

    protected ArrayList<Title> TitleList = new ArrayList<>();
    protected static Scanner myObj;

    abstract void addNewTitle();

    Title() {

    }

    Title(int YearofRelease, String Title) {
        this.YearofRelease = YearofRelease;
        this.Title = Title;
    }

    Title(int YearofRelease, String Title, String Genre) {
        this.YearofRelease = YearofRelease;
        this.Title = Title;
        this.Genre = Genre;
    }

    Title(int YearofRelease, String Title, String Genre, String Director) {
        this.YearofRelease = YearofRelease;
        this.Title = Title;
        this.Genre = Genre;
        this.Director = Director;
    }

    /**
     * search title based on data informed
     * 
     * @param <T>
     * 
     * @return Title object
     */
    protected <T> Title searchTitle() {

        while (true) {
            System.out.println("Inform the name of the " + this.getClass().getName());
            myObj = new Scanner(System.in);

            String term = myObj.nextLine();

            ArrayList<Title> ResultTitle = (ArrayList<Title>) TitleList.stream()
                    .filter(m -> m.getTitle().toLowerCase().contains(term)).collect(Collectors.toList());

            if (ResultTitle.size() > 0) {
                return selectTitle(ResultTitle);
            } else {
                System.out.println(this.getClass().getName() + " - " + term + " - not found try another name");
            }

        }
    }

    /**
     * select title chosen
     * 
     * @param ResultTitle
     * @return Title object
     */
    protected Title selectTitle(ArrayList<Title> ResultTitle) {

        while (true) {
            for (int i = 0; i < ResultTitle.size(); i++) {
                System.out.println((i + 1) + " -> " + ResultTitle.get(i).getTitle());
            }

            myObj = new Scanner(System.in);
            System.out.println("Select Title by code");

            int TitleCode = myObj.nextInt(); // Read user input

            if (TitleCode > ResultTitle.size()) {
                System.out.println("inform a valid code");
            } else {
                System.out.println(ResultTitle.get(TitleCode - 1).getClass().getName() + " selected is: "
                        + ResultTitle.get(TitleCode - 1).getTitle());
                return ResultTitle.get(TitleCode - 1);
            }

        }
    }

    /**
     * @param band the band to set
     */
    public void setBand(String band) {
        this.Band = band;
    }

    /**
     * @return the Title
     */
    protected String getTitle() {
        return this.Title;
    }

    /**
     * @return the dataOfRent
     */
    protected Date getDataOfRent() {
        return dataOfRent;
    }

    /**
     * @param dataOfRent the dataOfRent to set
     */
    protected void setDataOfRent() {
        this.dataOfRent = new Date();
    }
}