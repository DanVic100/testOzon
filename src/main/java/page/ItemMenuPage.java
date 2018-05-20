package page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ItemMenuPage extends BasePage{

    //Ссылка на поле минимальной цены
    @FindBy(xpath="//*[@id=\"price_filter\"]//input[@class = 'eFromToInput_InputField mFrom']")
    public WebElement minPrice;

    //Сcылка на название продукта в каталоге
    @FindBy(xpath = "//*[@id=\"bTilesModeShow\"]//div[@itemprop='name']")
    public List<WebElement> nameProduct;


    //Ссылка на продукт
    //*[@id="bTilesModeShow"]/
    @FindBy(className = " //*[@id=\"bTilesModeShow\"]")
    public List<WebElement> product;

    //Ссылка на корзину
    //*[@id="form1"]//div[class=]
    @FindBy(xpath = "//div[@class='eMyOzon_Item_Bottom']")
    public WebElement cart;

    //ссылка на бред
    //*[@id="facetControl_brand"]//span[contains(text(),'Apple')]
    @FindBy(xpath ="//span[contains(text(),'Apple')]")
    public WebElement appleButton;


    @FindBy(xpath ="//a[contains(text(),'Nikon')]")
    public List<WebElement> niconButton;

    @FindBy(xpath ="//a[contains(text(),'Canon')]")
    public List<WebElement> canonButton;

    @FindBy(xpath = "//div[@class=\"bFlatButton mMicro mWhite\"]")
    public WebElement done;

}
