package com.cucumber.baidu;

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

import java.util.concurrent.TimeUnit;

public class BaiDuSearchStepDefs {
    private WebDriver driver;

    @Given("^Go to baidu home$")
    public void goToBaiDuHome() throws Exception{
        System.setProperty("webdriver.chrome.driver","E:\\work\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("http://www.baidu.com/");
    }

    @When("^I find baidu logo")
    public WebElement iFindBaiDuLogo(){
        WebDriverWait wait = new WebDriverWait(driver,10);
        return wait.until(ExpectedConditions.visibilityOf(
                driver.findElement(By.xpath("//div[@id='lg']/img"))
        ));
    }

    @And("^Type the search text \"([^\"]*)\"$")
    public void typeTheSearchText(String searchText){
        driver.findElement(By.id("kw")).clear();
        driver.findElement(By.id("kw")).sendKeys(searchText);
    }

    @And("^Click the submit$")
    public void clickTheSubmit() {
        driver.findElement(By.id("su")).click();
    }

    @Then("^Wait the baidu query result \"([^\"]*)\"$")
    public void waitTheQueryResult(String result) throws InterruptedException {
        Thread.sleep(10000);
        Assert.assertEquals(result,driver.getTitle());
        driver.close();
        driver.quit();
    }
}
