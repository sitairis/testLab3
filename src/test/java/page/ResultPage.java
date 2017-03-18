package page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.*;

public class ResultPage {
    private WebDriver driver;


    ResultPage(WebDriver driver){
        this.driver = driver;
    }

    public List<WebElement> returnTextResult(WebDriver driver, String searchText){
        List<WebElement> list = driver.findElements(By.xpath("//a[text()= '"+searchText+"']"));//linkText(searchText));
        return list;

    }

    public List<WebElement> returnPartialTextResult(WebDriver driver, String searchText) {
        List<WebElement> list = driver.findElements(By.xpath("//a[@data-qa = 'vacancy-serp__vacancy-title']"));
        ArrayList arraylistOftitle = new ArrayList();
        ArrayList arraylistOfname = new ArrayList();
        for (WebElement alist : list) {
            arraylistOftitle.add(alist.getText());
        }
        for (int i = 0; i < arraylistOftitle.size(); i++) {
            if (((String) (arraylistOftitle.get(i))).contains(searchText) || ((String) arraylistOftitle.get(i)).contains(searchText.toLowerCase()))
                arraylistOfname.add(arraylistOftitle.get(i));
        }
        list.clear();
        for (int i = 0; i < arraylistOfname.size(); i++) {
            list.add(driver.findElement(By.linkText((String) arraylistOfname.get(i))));
        }
        return list;
    }
}
