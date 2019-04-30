
public final class Utils {
  public static <T> String fetchGenericInfo(T title) {

    if (title instanceof BoxSet) {
      return "BoxSet";

    } else if (title instanceof LiveConcertVideos) {
      return title.getClass().getSimpleName() + " - " + ((LiveConcertVideos) title).getTitle();
    } else if (title instanceof Movie) {
      return title.getClass().getSimpleName() + " - " + ((Movie) title).getTitle();
    } else {
      return title.getClass().getSimpleName() + " - " + ((Music) title).getTitle();
    }
  }

}
