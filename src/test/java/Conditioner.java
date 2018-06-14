import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class Conditioner {
    private String installType;
    private String compressorType;
    private String type;
    private String recommendedSquare;
    private String coolMaker;
    private String hotMaker;
    private String internalDimensions;
    private String externalDimensions;
    private String colour;

    private String parameter1 = "\'Тип установки внутреннего блока:\'";
    private String parameter2 = "\'Тип компрессора:\'";
    private String parameter3 = "\'Тип:\'";
    private String parameter4 = "\'Рекомендованная площадь помещения:\'";
    private String parameter5 = "\'Холодопроизводительность:\'";
    private String parameter6 = "\'Теплопроизводительность:\'";
    private String parameter7 = "\'Габариты внутреннего блока (ВхШхГ):\'";
    private String parameter8 = "\'Габариты наружного блока (ВхШхГ):\'";
    private String parameter9 = "\'Цвет:\'";

    private String xpath = "//*[@class = 'g-i-tile-i-box']//*[contains(@value,%s)]//parent::div//*[@class='short-chars-l flex']//child::li//*[contains(text(), %s)]//parent::li//child::a[@class = 'novisited']";
    private String xpath2 = "//*[@class = 'g-i-tile-i-box']//*[contains(@value,%s)]//parent::div//*[@class='short-chars-l flex']//child::li//*[contains(text(), %s)]//parent::li//child::span[@class = 'chars-value-inner']";


    public Conditioner(WebElement properties, String index) {
        this.installType = properties.findElement(By.xpath(String.format(xpath, index, parameter1))).getAttribute("innerHTML");
        this.compressorType = properties.findElement(By.xpath(String.format(xpath, index, parameter2))).getAttribute("innerHTML");
        this.type = properties.findElement(By.xpath(String.format(xpath, index, parameter3))).getAttribute("innerHTML");;
        this.recommendedSquare = properties.findElement(By.xpath(String.format(xpath2, index, parameter4))).getAttribute("innerHTML").trim();
        this.coolMaker = properties.findElement(By.xpath(String.format(xpath2, index, parameter5))).getAttribute("innerHTML").trim();
        this.hotMaker = properties.findElement(By.xpath(String.format(xpath2, index, parameter6))).getAttribute("innerHTML").trim();
        this.internalDimensions = properties.findElement(By.xpath(String.format(xpath2, index, parameter7))).getAttribute("innerHTML").trim();
        this.externalDimensions = properties.findElement(By.xpath(String.format(xpath2, index, parameter8))).getAttribute("innerHTML").trim();
        this.colour = properties.findElement(By.xpath(String.format(xpath2, index, parameter9))).getAttribute("innerHTML").trim();
    }

    public String getInstallType(){
        return this.installType;
    }

    public String getCompressorType(){
        return this.compressorType;
    }

    public String getType() {
        return this.type;
    }

    public String getRecommendedSquare() {
        return this.recommendedSquare;
    }

    public String getCoolMaker() {
        return this.coolMaker;
    }

    public String getHotMaker() {
        return this.hotMaker;
    }

    public String getInternalDimensions() {
        return this.internalDimensions;
    }

    public String getExternalDimensions() {
        return this.externalDimensions;
    }

    public String getColour() {
        return this.colour;
    }





}
