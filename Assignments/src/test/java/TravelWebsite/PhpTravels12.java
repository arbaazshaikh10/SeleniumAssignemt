package TravelWebsite;

import browsers.LaunchBrowser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class PhpTravels12 extends LaunchBrowser {

    @Test
    public void firstTwo(){
        launchBrowser("Chrome");
        driver.get("https://phptravels.com/demo/");

        //1. Check current year 2020 is part of copyright
        String s = driver.findElement(By.xpath("//div[@class='copyright hidden-xs']/p")).getText();
        System.out.println(s);
        if(s.contains("2020"))
            System.out.println("Copyright contains 2020");
        else
            System.out.println("Copyright does not contain 2020");

        //2. List the number of social media accounts with links
        List<WebElement> links= driver.findElements(By.xpath("//ul[@class='links-social hidden-xs']/li/form"));
        System.out.println("The total number of social media accounts: "+links.size());

        for(int i = 0; i < links.size(); i++){
            System.out.println((i+1)+". "+links.get(i).getAttribute("action"));
        }
        driver.close();
    }


}
