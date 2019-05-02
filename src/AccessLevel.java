/**
 * subscription plan
 */
public enum AccessLevel {
	ML("Music Lovers"), VL("Video Lovers"), TV("TV Lover"), PR("Premium");

	public final String label;

	private AccessLevel(String label) {
		this.label = label;
	}
}
