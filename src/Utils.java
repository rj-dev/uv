import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class Utils {

  /**
   * @param <T>
   * @param title - generic object
   * @return generic item info
   */
  public static <T> String fetchGenericInfo(T title) {

    if (title instanceof BoxSet) {
      return "BoxSet";

    } else if (title instanceof LiveConcertVideos) {

      return String.format("%s - %s | rented since: %tc", title.getClass().getSimpleName(),
          ((LiveConcertVideos) title).getTitle(), ((LiveConcertVideos) title).getDataOfRent());

    } else if (title instanceof Movie) {

      return String.format("%s - %s | rented since: %tc", title.getClass().getSimpleName(), ((Movie) title).getTitle(),
          ((Movie) title).getDataOfRent());

    } else {

      return String.format("%s - %s | rented since: %tc", title.getClass().getSimpleName(), ((Music) title).getTitle(),
          ((Music) title).getDataOfRent());
    }
  }

  /**
   * insert date at generic title object
   * 
   * @param <T>
   * @param title - generic object
   * @return title with date of rent setted up
   */
  public static <T> T addDateRent(T title) {

    if (title instanceof BoxSet) {
      ((BoxSet) title).setDataOfRent();
      return title;
    } else if (title instanceof LiveConcertVideos) {
      ((LiveConcertVideos) title).setDataOfRent();
      return title;
    } else if (title instanceof Movie) {
      ((Movie) title).setDataOfRent();
      return title;
    } else {
      ((Music) title).setDataOfRent();
      return title;
    }
  }

}
