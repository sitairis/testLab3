package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JobPage {
    private WebDriver driver;
    private By txbSearch = By.xpath("//input[@data-qa = 'vacancy-serp__query']");
    private By btnSearch = By.xpath("//button[@data-qa = 'navi-search__button']");

    JobPage(WebDriver driver){
        this.driver = driver;
    }

    public ResultPage searchByText(WebDriver driver, String text) {
        driver.findElement(txbSearch).sendKeys(text);
        driver.findElement(btnSearch).submit();
        return new ResultPage(driver);
    }
}
