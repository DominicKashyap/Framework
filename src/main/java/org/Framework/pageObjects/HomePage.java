package org.Framework.pageObjects;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.Framework.helpers.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.Framework.logger.LoggingManager.logMessage;

public class HomePage extends Page {

    WebDriver driver;

    @FindBy(xpath = "//a[@title='Log In'][1]")
    @AndroidFindBy(id = "login_button")
    @iOSFindBy(xpath = "//XCUIElementTypeButton[contains(@label, 'Log In')]")
    private WebElement eleSignInBtn;

    @FindBy(xpath = "//a[@title='Get Started']")
    @AndroidFindBy(id = "create_site_button")
    @iOSFindBy(id = "Sign up for WordPress.com Button")
    private WebElement eleSignUpBtn;

    public HomePage(WebDriver driver) throws InterruptedException {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        logMessage("Initializing the "+this.getClass().getSimpleName()+" elements");
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        Thread.sleep(1000);
    }

    public org.oneframework.pageObjects.SignInPage chooseSignInOption() throws Exception {
        clickElement(eleSignInBtn);
        new org.oneframework.pageObjects.SignInPage(driver).clickOnSignInTitle();
        logMessage("Chosen signIn option");
        return new org.oneframework.pageObjects.SignInPage(driver);
    }

    public org.oneframework.pageObjects.SignUpPage chooseSignUpOption() throws Exception {
        clickElement(eleSignUpBtn);
        logMessage("Chosen signUp option");
        return new org.oneframework.pageObjects.SignUpPage(driver);
    }

}