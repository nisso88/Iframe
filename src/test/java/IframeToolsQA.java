import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class IframeToolsQA {

    WebDriver driver;

    @Before
        public void init(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://toolsqa.com");
    }

    @Test
    public void test1(){

    }

    @After
    public void colsePage(){
        driver.quit();
    }


}
