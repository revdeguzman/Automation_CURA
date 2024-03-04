import java.io.IOException;

public class JavaMain extends HealthcareService {

	public static void main(String[] args) throws InterruptedException, IOException {

		HealthcareService obj = new HealthcareService();
		
		obj.launchBrowser();
		obj.maxWindow();
		obj.navigateURL();
		obj.makeAppointment();
		obj.loginDemoAccount();
		obj.scheduleAppointment();
		obj.confimationPage();
		//obj.menu();
		//obj.menuHome(); //Remove comment if need to verify Home
		obj.menu();
		obj.menuHistory();
		//obj.menu();
		//obj.menuProfile(); //Remove comment if need to verify Profile
		obj.menu();
		obj.menuLogout();
		obj.closeBrowser();

		//By: Rev Christian
		//For Testing purposes only.
		//Thanks.

	}

}
