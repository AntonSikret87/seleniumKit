package com.kit.pages.gmail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by AntonKa on 6/10/2017.
 */
public class GmailPage {
    private WebDriver webDriver;

    By emailFieldLocator = By.id("identifierId");
    private WebElement emailField;
    By nextBtnEmailLocator = By.id("identifierNext");
    private WebElement nextButtonEmail;
    By passFieldLocator = By.name("password");
    private WebElement passwordField;
    By nextBtnPassLocator = By.id("passwordNext");
    private WebElement nextButtonPassword;


    public GmailPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void open(String url) {
        webDriver.get(url);
    }

    public void login(String email, String pass) {
        emailField = webDriver.findElement(emailFieldLocator);
        emailField.sendKeys(email);
        nextButtonEmail = webDriver.findElement(nextBtnEmailLocator);
        nextButtonEmail.click();
        passwordField = webDriver.findElement(passFieldLocator);
        passwordField.sendKeys(pass);
        nextButtonPassword = webDriver.findElement(nextBtnPassLocator);
        nextButtonPassword.click();
    }
}