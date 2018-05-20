package page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainOzonPage extends BasePage  {

    //Ссылка на электронику
    @FindBy(xpath = "//*[@id=\"form1\"]//a[@draggable=\"true\"and contains(text(),'Электроника')]")
    public WebElement electronic;

    //ссылка на рекламу
    @FindBy(xpath = "//div[@class='close-icon eDYbanner_close jsCloseBanner']")
    public WebElement closeReklama;
}
