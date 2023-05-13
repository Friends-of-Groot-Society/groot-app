package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class BlazeMeter {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
    driver = new ChromeDriver();
    baseUrl = "https://www.blazedemo.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testBlazeMeter() throws Exception {
    // Label: Test
    // ERROR: Caught exception [ERROR: Unsupported command [resizeWindow | 1390,888 | ]]
    driver.get("https://blazedemo.com/");
    driver.findElement(By.name("fromPort")).click();
    new Select(driver.findElement(By.name("fromPort"))).selectByVisibleText("Boston");
    driver.findElement(By.name("fromPort")).click();
    driver.findElement(By.name("toPort")).click();
    new Select(driver.findElement(By.name("toPort"))).selectByVisibleText("London");
    driver.findElement(By.name("toPort")).click();
    driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
    driver.findElement(By.xpath("(//input[@value='Choose This Flight'])[2]")).click();
    driver.findElement(By.id("inputName")).click();
    driver.findElement(By.id("inputName")).clear();
    driver.findElement(By.id("inputName")).sendKeys("thomas");
    driver.findElement(By.id("address")).clear();
    driver.findElement(By.id("address")).sendKeys("123 main st");
    driver.findElement(By.id("city")).clear();
    driver.findElement(By.id("city")).sendKeys("pittsburgh");
    driver.findElement(By.id("state")).clear();
    driver.findElement(By.id("state")).sendKeys("PA");
    driver.findElement(By.id("city")).clear();
    driver.findElement(By.id("city")).sendKeys("Pittsburgh");
    driver.findElement(By.id("zipCode")).clear();
    driver.findElement(By.id("zipCode")).sendKeys("15220");
    driver.findElement(By.id("creditCardNumber")).click();
    driver.findElement(By.id("creditCardNumber")).clear();
    driver.findElement(By.id("creditCardNumber")).sendKeys("4430123412341234");
    driver.findElement(By.id("creditCardYear")).click();
    driver.findElement(By.cssSelector("body")).click();
    driver.findElement(By.id("creditCardYear")).clear();
    driver.findElement(By.id("creditCardYear")).sendKeys("2021");
    driver.findElement(By.id("nameOnCard")).click();
    driver.findElement(By.id("nameOnCard")).clear();
    driver.findElement(By.id("nameOnCard")).sendKeys("Thomas Maestas");
    driver.findElement(By.id("rememberMe")).click();
    driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
    driver.findElement(By.cssSelector("div.container.hero-unit")).click();
    driver.findElement(By.cssSelector("pre")).click();
  }

  @AfterClass(alwaysRun = true)
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
