package TravelWebsite;

import browsers.LaunchBrowser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class PhpTravels7to11 extends LaunchBrowser {
    @Test
    public void lastPost(){
        launchBrowser("Chrome");
        driver.get("https://phptravels.com/blog/");

        //Store links in a list, visit the last link(last post) on page 1
        List<WebElement> links = driver.findElements(By.xpath("//*[@id='main']/div/div/div/div/div/div/div/div[2]/h3/a"));
        System.out.println("Total Links: "+links.size());
        for(int i = 0; i <= links.size(); i++){
            if(i==links.size())
            driver.findElement(By.xpath("//*[@id='main']/div/div/div[1]/div/div[1]/div/div["+(i+5)+"]/div[2]/div[2]/a")).click();
        }

        //Get Title and Date
        System.out.println(driver.getTitle());
        System.out.println(driver.findElement(By.xpath("//*[@id='main']/div/div/div[2]/div/div[1]/div[2]/span[1]")).getText());

        //Print total number of likes
        driver.findElement(By.xpath("//*[@id='reactions_result']/div[1]/div/div[3]/button")).click();
        System.out.println("Total Number of Likes: "+driver.findElement(By.xpath("//*[@id='reactions_result']/div[1]/div/div[2]/div/span")).getText());

        //Print number of views
        String initialCount = driver.findElement(By.xpath("//*[@id='main']/div/div/div[2]/div/div[1]/div[2]/span[3]")).getText().trim();
        System.out.println("Total views before the click: "+initialCount);
        // driver.close();

        //Go back and reopen the post and verify the view count has increased by 1 at least.
        driver.navigate().back();
        for(int i = 0; i <= links.size(); i++){
            if(i==links.size())
                driver.findElement(By.xpath("//*[@id='main']/div/div/div[1]/div/div[1]/div/div["+(i+5)+"]/div[2]/div[2]/a")).click();
        }

        String finalCount = driver.findElement(By.xpath("//*[@id='main']/div/div/div[2]/div/div[1]/div[2]/span[3]")).getText().trim();
        System.out.println("Total views after the click: "+finalCount);

        //Verifying view count has increased
        int init = Integer.valueOf(initialCount);
        int fin = Integer.valueOf(finalCount);
        if(fin > init){
            System.out.println("Post views have increased after revisiting");
        }

    }
}
