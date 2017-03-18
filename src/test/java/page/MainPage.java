package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MainPage {
    private WebDriver driver;
    private String path;

    public MainPage(WebDriver driver){
        this.driver = driver;
    }

   public MainPage openMainPage(){
       driver.get("https://www.tut.by");
       return this;
    }

    public JobPage navigateMenu(String nameItemMenu){
        driver.findElement(By.xpath("//a[@class = 'topbar__link' and @title = '"+nameItemMenu+"']")).click();
        return new JobPage(driver);
    }
}
