import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class IframeToolsQA {

    WebDriver driver;

    @Before
        public void init(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://toolsqa.com");
    }

    @Test
    public void test1(){
        Actions action = new Actions(driver);
        WebElement demoSites = driver.findElement(By.cssSelector("#primary-menu>.menu-item-17611"));

        action.moveToElement(demoSites);
        action.build().perform();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"primary-menu\"]/li[8]/ul")));

        WebElement ifrmPractice = driver.findElement(By.xpath("//*[@id=\"primary-menu\"]/li[8]/ul/li[7]/a"));
        action.moveToElement(ifrmPractice).build().perform();
        ifrmPractice.click();

        WebElement texttext = driver.findElement(By.xpath("//*[@id=\"content\"]/h1"));

        Assert.assertEquals("Sample Iframe page", texttext.getText());

        driver.switchTo().frame(driver.findElement(By.id("IF1")));
        WebElement texttext2 = driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/div/div/div/div[2]/div/h1"));
        Assert.assertEquals("Practice Automation Form", texttext2.getText());
        driver.switchTo().defaultContent();

        driver.switchTo().frame(driver.findElement(By.id("IF2")));
        WebElement texttext3 = driver.findElement(By.xpath("//*[@id=\"breadcrumbs\"]/li/span"));
        Assert.assertEquals("Home", texttext3.getText());
        driver.switchTo().defaultContent();
    }
  
    @After
    public void colsePage(){
        driver.quit();
    }


}
