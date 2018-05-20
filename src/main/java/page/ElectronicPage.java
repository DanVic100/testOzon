package page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ElectronicPage extends BasePage {

    //*[@id="form1"]/div/div[3]/div[1]/div/div[2]/div[3]/div/div[2]/div/div[1]/div/a[1]
    //ССылка на смартфоны
    @FindBy(xpath = "//a[contains(@class,'eLeftMainMenu_Link') and contains(text(),'Смартфоны')]")
    public WebElement smartPhone;

    //ССылка на зеркальные камеры
    @FindBy(xpath = "//a[@class=\"eLeftMainMenu_Link\" and contains(text(),'Зеркальные')]")
    public WebElement zerkCamera;
}
