package org.pages;

import org.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * 
 * @author MANOJKUMAR
 * @see SelectHotelPage
 * @Date 07-12-2022
 *
 */
public class SelectHotelPage extends BaseClass {

	public SelectHotelPage() {

		PageFactory.initElements(driver, this);
	}

	// 1. By select hotel name
	@FindBy(className = "login_title")
	private WebElement selectHoteltext;

	@FindBy(xpath = "//input[@id='radiobutton_0']")
	private WebElement btnClick;

	@FindBy(xpath = "//input[@id='continue']")
	private WebElement btnContinue;

	@FindBy(id = "radiobutton_span")
	private WebElement errorContinueClick;

	public WebElement getErrorContinueClick() {
		return errorContinueClick;
	}

	public WebElement getSelectHoteltext() {
		return selectHoteltext;
	}

	public WebElement getBtnClick() {
		return btnClick;
	}

	public WebElement getBtnContinue() {
		return btnContinue;
	}

	/**
	 * @see select and click button
	 */
	public void selectHotelPage() {
		elementClick(getBtnClick());
		elementClick(getBtnContinue());
	}

	/**
	 * @see clickContinue
	 */
	// 2.without click select hotel click continue

	public void clickContinue() {
		elementClick(getBtnContinue());

	}

	

}
