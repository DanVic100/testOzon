package step;


import page.ItemPage;
import ru.yandex.qatools.allure.annotations.Step;

public class ItemStep {

    @Step("Добаляем в корзину")
    public void goBack(){
        try {
            new ItemPage().buttonCart.click();
            BaseStep.getDriver().navigate().back();
        }catch(Exception e){BaseStep.getDriver().navigate().back();}

   }
}
