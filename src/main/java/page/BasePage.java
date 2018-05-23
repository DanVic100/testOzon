package page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import step.BaseStep;

public class BasePage {

    public BasePage (){
        PageFactory.initElements(BaseStep.getDriver(),this);
    }


}
