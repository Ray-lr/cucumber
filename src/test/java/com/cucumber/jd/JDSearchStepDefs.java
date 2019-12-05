package com.cucumber.jd;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class JDSearchStepDefs {
    private WebDriver driver;

    @Given("^Go to JD home$")
    public void goToJDHome() {
        System.setProperty("webdriver.chrome.driver","E:\\work\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("http://jd.com");

    }

    @When("^I find JD search box$")
    public WebElement iFindJDSearchBox() {
        WebDriverWait wait = new WebDriverWait(driver,10);
        return wait.until(ExpectedConditions.visibilityOf(
                driver.findElement(By.id("J_searchbg"))
        ));
    }

    @And("^Type the search content \"([^\"]*)\"$")
    public void typeTheSearchContent(String searchContent) {
        driver.findElement(By.id("key")).clear();
        driver.findElement(By.id("key")).sendKeys(searchContent);
    }

    @And("^Click the search button$")
    public void clickTheSearchButton() {
        driver.findElement(By.xpath("//button[@clstag='h|keycount|head|search_a']"))
                .click();
    }

    @And("^Click the first good$")
    public void clickTheFirstGood() {
        WebElement element =driver.findElement(By.cssSelector("div#J_goodsList>ul>li>div>div>a"));
//        element.click();
        driver.get(element.getAttribute("href"));
    }

    @And("^Add into cart$")
    public void addIntoCart() {
        WebDriverWait wait = new WebDriverWait(driver,10);
        WebElement element = driver.findElement(By.id("InitCartUrl"));
        wait.until(ExpectedConditions.visibilityOf(element));
//        element.click();
        driver.get(element.getAttribute("href"));
    }

    @And("^Go to shopping cart$")
    public void goToShoppingCart() {
        WebDriverWait wait = new WebDriverWait(driver,10);
        WebElement element = driver.findElement(By.id("GotoShoppingCart"));
        wait.until(ExpectedConditions.visibilityOf(element));
//        element.click();
        driver.get(element.getAttribute("href"));
    }

    @And("^Go to order$")
    public void goToOrder() {
        Set<String> windows = driver.getWindowHandles();
        driver.findElement(By.xpath("//a[@href='javascript:void(0);']" +
                "[@onclick='return false;'][@class='submit-btn']")).click();
    }


    @Then("^Wait the JD query result$")
    public void waitTheQueryResult() throws InterruptedException {
        Thread.sleep(3000);
        Assert.assertTrue(driver.findElement(By.id("loginDialogBody")).isDisplayed());
        WebElement img = driver.findElement(By.cssSelector("div.item-form>div.cell.p-goods>div.goods-item>" +
                "div.p-img>a>img"));
        String ImgUrl = img.getAttribute("src");
        System.out.println(ImgUrl);
        driver.close();
        driver.quit();
    }



}
