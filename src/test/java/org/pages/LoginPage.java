package org.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.base.BaseClass;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * 
 * @author MANOJKUMAR
 * @see LoginPage
 * @Date 07-12-2022
 *
 */
public class LoginPage extends BaseClass {

	// 1.Valid
	// 2.Verifying with Invalid Credentials

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "username")
	private WebElement txtUsername;

	@FindBy(id = "password")
	private WebElement txtPassword;

	@FindBy(id = "login")
	private WebElement loginButton;

	@FindBy(xpath = "//b[text()='Invalid Login details or Your Password might have expired. ']")
	private WebElement textErrorLogin;

	public WebElement getTxtUsername() {
		return txtUsername;
	}

	public WebElement getTxtPassword() {
		return txtPassword;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}

	public WebElement getTextErrorLogin() {
		return textErrorLogin;
	}

	/**
	 * 
	 * @param username
	 * @param password
	 * @see login using valid details
	 */
	public void login(String username, String password) {

		WebElement txtUsername = getTxtUsername();
		elementsendkeys(txtUsername, username);

		WebElement txtPassword = getTxtPassword();
		elementsendkeys(txtPassword, password);

		WebElement loginButton = getLoginButton();
		elementClick(loginButton);

	}

	/**
	 * 
	 * @param username
	 * @param password
	 * @see login with valid details and using Enter keys
	 * @throws AWTException
	 */
	// 2.Verifying login fun with Enter Key
	public void loginWithEnterKey(String username, String password) throws AWTException {

		WebElement txtuser = getTxtUsername();
		txtuser.sendKeys(username);
		WebElement txtpass = getTxtPassword();
		txtpass.sendKeys(password);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

	}

}
