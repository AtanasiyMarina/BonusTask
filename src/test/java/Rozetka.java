import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.concurrent.TimeUnit;



public class Rozetka {
    private WebDriver driver;
    private String url;
    private ChromeOptions options;

    public void compare(Conditioner c1, Conditioner c2){
        if(c1.getInstallType().equals(c2.getInstallType())){
            System.out.println(c2.getInstallType());
        }
        if (c1.getCompressorType().equals(c2.getCompressorType())){
            System.out.println(c2.getCompressorType());
        }
        if (c1.getType().equals(c2.getType())){
            System.out.println(c2.getType());
        }
        if (c1.getRecommendedSquare().equals(c2.getRecommendedSquare())){
            System.out.println(c2.getRecommendedSquare());
        }
        if (c1.getCoolMaker().equals(c2.getCoolMaker())){
            System.out.println(c2.getCoolMaker());
        }
        if (c1.getHotMaker().equals(c2.getHotMaker())){
            System.out.println(c2.getHotMaker());
        }
        if (c1.getInternalDimensions().equals(c2.getInternalDimensions())){
            System.out.println(c2.getInternalDimensions());
        }
        if (c1.getExternalDimensions().equals(c2.getExternalDimensions())){
            System.out.println(c2.getExternalDimensions());
        }
        if (c1.getColour().equals(c2.getColour())){
            System.out.println(c2.getColour());
        }

    }

    @Before
    public void beforeMethod() {
        url = "https://rozetka.com.ua/";
        options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testMethod() {
        driver.get(url);
        driver.findElement(By.id("city-chooser")).click();
        driver.findElement(By.xpath("//a[@locality_id='1']")).click();
        driver.findElement(By.cssSelector("input.rz-header-search-input-text")).sendKeys("кондиционеры");
        String attr = driver.findElement(By.cssSelector("div.rz-header-search-suggest-g div a")).getAttribute("href");
        driver.get(attr);

        Conditioner c1 = new Conditioner(driver.findElement(By.xpath("//*[@class = 'g-i-tile-i-box']//*[contains(@value,'001')]")), "\'001\'");
        Conditioner c2 = new Conditioner(driver.findElement(By.xpath("//*[@class = 'g-i-tile-i-box']//*[contains(@value,'002')]")), "\'002\'");
        compare(c1, c2);
    }

    @After
    public void afterMethod (){
        driver.quit();
    }

    }


