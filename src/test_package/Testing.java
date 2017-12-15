package test_package;

import java.io.IOException;

import org.testng.annotations.Test;

import pageMethod_package.LoginPageMethod;
import commonMethods_package.CommonMethods;

public class Testing extends CommonMethods{
	LoginPageMethod login = new LoginPageMethod();

	@Test
	public void loginFunctionality() throws IOException, InterruptedException{
		openBrowser();
		getURL(getProperties("URL"));
		login.loginFunctionality(getProperties("username"), getProperties("password"));
	}

}
