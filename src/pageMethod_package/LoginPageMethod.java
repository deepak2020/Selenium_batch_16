package pageMethod_package;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import commonMethods_package.CommonMethods;

public class LoginPageMethod extends CommonMethods{
	
	
	public void loginFunctionality(String usernam, String pass) throws IOException, InterruptedException{
		WebElement elem = findElement("xpath", getProperties("accountElem"));
		click(elem);
		WebElement username = findElement("id", getProperties("usernameElem"));
		sendKeys(username, usernam);		
		WebElement password = findElement("id", getProperties("passwordElem"));
		sendKeys(password, pass);
		WebElement button = findElement("id", getProperties("loginButtonElem"));
		click(button);
		WebElement message = findElement("css", ".response>a");
		String text = message.getText();
		System.out.println(text);
		assertEquals(text, "Lost your password?");
		
	}

}
