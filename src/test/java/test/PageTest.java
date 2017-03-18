package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import static org.testng.Assert.*;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.apache.log4j.Logger;
import page.*;

public class PageTest {
    Logger logger;
    WebDriver driver;
    MainPage mainPage;
    String itemMenu;
    String textSearch;

    @Parameters({"itemMenu", "textSearch"})
    @BeforeMethod
    public void setUp(String itemMenu, String textSearch){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        this.itemMenu = itemMenu;
        this.textSearch = textSearch;
        logger.info("Start Google Chrome");
    }

    @BeforeTest
    public void log() {
        logger = Logger.getLogger("new logger");
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
        logger.info("Cancel Google Chrome");
    }

    @Test
    public void resultSearchLinkTextTest(){
        logger.info("Start resultSearchLinkTextTest");
        mainPage = new MainPage(driver);
        mainPage.openMainPage();
        logger.info("Open tut.by");
        JobPage jobPage = mainPage.navigateMenu(itemMenu);
        logger.info("Go to " + itemMenu);
        logger.info("Open job.tut.by");
        ResultPage resultPage = jobPage.searchByText(driver, textSearch);
        logger.info("Search " + textSearch);
        List<WebElement> listOfResultsSearch = resultPage.returnTextResult(driver, textSearch);
        logger.info("Results");
        if(listOfResultsSearch.isEmpty()){
            logger.info("List of results is empty --- TEST FAIL");
        }
        else{
            for (WebElement aListOfResultsSearch : listOfResultsSearch) {
                System.out.println(aListOfResultsSearch.getText());
            }
            logger.info("End resultSearchLinkTextTest");
        }
            assertFalse(listOfResultsSearch.isEmpty());
    }

    @Test
    public void resultSearchPartialLinkTextTest(){
        logger.info("Start resultSearchPartialLinkTextTest");
        mainPage = new MainPage(driver);
        mainPage.openMainPage();
        logger.info("Open tut.by");
        JobPage jobPage = mainPage.navigateMenu(itemMenu);
        logger.debug("Go to " + itemMenu);
        logger.info("Open job.tut.by");
        ResultPage resultPage = jobPage.searchByText(driver, textSearch);
        logger.debug("Search " + textSearch);
        List<WebElement> listOfResultsSearch = resultPage.returnPartialTextResult(driver, textSearch);
        logger.info("Results");
        if(listOfResultsSearch.isEmpty()){
            logger.info("List of results is empty --- TEST FAIL");
        }
        else{
            for (WebElement aListOfResultsSearch : listOfResultsSearch) {
                System.out.println(aListOfResultsSearch.getText());
            }
            logger.info("End resultSearchPartialLinkTextTest");
        }
        assertFalse(listOfResultsSearch.isEmpty());
    }
}
