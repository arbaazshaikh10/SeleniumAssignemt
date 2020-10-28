package TravelWebsite;

import browsers.LaunchBrowser;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class PhpTravel6 extends LaunchBrowser {
    @Test
    public void changepass(){
        //login
        launchBrowser("Chrome");
        driver.get("https://phptravels.com/blog/login");
        driver.findElement(By.name("username")).sendKeys("qwerty123");
        driver.findElement(By.name("password")).sendKeys("qwertyuiop12345");
        driver.findElement(By.xpath("//button[@class='btn btn-block btn-custom']")).click();

        //navigate to change password page
        driver.navigate().to("https://phptravels.com/blog/settings/change-password");

        //change password
        driver.findElement(By.xpath("//input[@name='old_password']")).sendKeys("qwertyuiop12345");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("qwertyuiop12345");
        driver.findElement(By.xpath("//input[@name='password_confirm']")).sendKeys("qwertyuiop12345");
        driver.findElement(By.xpath("//button[@class='btn btn-md btn-custom']")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        //logout
        driver.findElement(By.xpath("//*[@id='header']/nav/div/div[2]/div/ul[2]/li[1]/a")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='header']/nav/div/div[2]/div/ul[2]/li[1]/ul/li[4]/a")));
        driver.findElement(By.xpath("//*[@id='header']/nav/div/div[2]/div/ul[2]/li[1]/ul/li[4]/a")).click();

        //login
        driver.navigate().to("https://phptravels.com/blog/login");
        driver.findElement(By.name("username")).sendKeys("qwerty123");
        driver.findElement(By.name("password")).sendKeys("qwertyuiop12345");
        driver.findElement(By.xpath("//button[@class='btn btn-block btn-custom']")).click();


    }
}
