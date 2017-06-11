package View;
import java.io.IOException;

public class DeveloperApp {

	public static void main (String[] args) {
		System.getProperty("user.dir");
		DeveloperView developerView = new DeveloperView();
		System.getProperty("user.dir");
		developerView.showStartMenu();
	}
}
