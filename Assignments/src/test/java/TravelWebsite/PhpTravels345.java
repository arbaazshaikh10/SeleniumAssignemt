package TravelWebsite;

import browsers.LaunchBrowser;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class PhpTravels345 extends LaunchBrowser {

    @Test
    public void register() throws InterruptedException {

        launchBrowser("Chrome");
        driver.get("https://phptravels.com/demo/");

        //Click on blog menu
        driver.findElement(By.xpath("//*[@id='mega-nav-navigation']/div/ul[1]/li[11]/a")).click();

        //Blog opens in a new window, capture window IDs
        Set<String> s = driver.getWindowHandles();
        Iterator<String> it = s.iterator();

        String mainWindow = it.next();
        String newWindow = it.next();

        //Switch to the new window
        driver.switchTo().window(newWindow);

        //click on register button
        driver.findElement(By.cssSelector("li.nav-item-right:nth-child(2)")).click();

        //Verify validation errors
        verifyValidationErrors("aa");

        driver.findElement(By.name("username")).sendKeys("qwerty");
        driver.findElement(By.name("email")).sendKeys("qwerty@qwerty.com");
        driver.findElement(By.name("password")).sendKeys("qwertyuiop");
        driver.findElement(By.name("confirm_password")).sendKeys("qwertyuiop");

        Thread.sleep(2000);

        //Checkbox click
        WebElement element = driver.findElement(By.xpath("//label[@class='custom-checkbox']/input"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();", element);

        //Register
        driver.findElement(By.xpath("//button[@class='btn btn-block btn-custom margin-top-15']")).click();

//        JavascriptExecutor jse = (JavascriptExecutor)driver;
//        jse.executeScript("document.getElementById('gbqfb').click();");

    }

    public void verifyValidationErrors(String uname) throws InterruptedException {
        //Enter values
        driver.findElement(By.name("username")).sendKeys(uname);
        driver.findElement(By.name("email")).sendKeys("qwe@qwe.com");
        driver.findElement(By.name("password")).sendKeys("qwertyuiop");
        driver.findElement(By.name("confirm_password")).sendKeys("qwertyuiop");

        Thread.sleep(2000);

        //Checkbox click
        WebElement element = driver.findElement(By.xpath("//label[@class='custom-checkbox']/input"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();", element);

        //Register
        driver.findElement(By.xpath("//button[@class='btn btn-block btn-custom margin-top-15']")).click();

        //Check if validation is present for username
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='The Username field must be at least 4 characters in length.']")));
        String s = driver.findElement(By.xpath("//*[@id='main']/div/div/div[2]/div/div/div/div/p[1]")).getText();
        Assert.assertEquals(s,"The Username field must be at least 4 characters in length.","Validation Not Present");

        driver.findElement(By.name("username")).clear();
        driver.findElement(By.name("email")).clear();
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("confirm_password")).clear();

    }


}
