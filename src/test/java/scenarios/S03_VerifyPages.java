package scenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.swing.*;
import java.time.Duration;

public class S03_VerifyPages {
    WebDriver driver;



    @BeforeMethod
    public void setUP (){
        driver = new FirefoxDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.amazon.eg/?language=en_AE");


    }

    @Test
    public void accessToShowOrders (){
        WebElement label = driver.findElement(By.xpath("//*[@id='nav-link-accountList-nav-line-1']"));
        new Actions(driver).moveToElement(label).perform();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"nav_prefetch_yourorders\"]/span")));
        driver.findElement(By.xpath("//*[@id=\"nav_prefetch_yourorders\"]/span")).click();
        System.out.println(driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div/div[2]/div/div[1]/form/div/div/div/h1")).getText());
        Assert.assertTrue(driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div/div[2]/div/div[1]/form/div/div/div/h1")).getText().contains("Sign in"));



    }
    @AfterMethod
    public void tearDown () throws Exception{
    Thread.sleep(3000);
    driver.quit();
    }
}
