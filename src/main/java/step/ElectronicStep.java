package step;

import org.junit.Assert;
import org.openqa.selenium.interactions.Actions;
import page.BasePage;
import page.ElectronicPage;
import ru.yandex.qatools.allure.annotations.Step;

public class ElectronicStep {

    ElectronicPage electronicPage = new ElectronicPage();


    @Step("пунт меню {0}")
    public void getManuItem(String arg1) {

        switch (arg1) {
            case "Телефоны":
                electronicPage.smartPhone.click();
                break;
            case "Зеркальные фотоаппарты":
                new Actions(BaseStep.getDriver()).moveToElement(electronicPage.zerkCamera);
                electronicPage.zerkCamera.click();
                break;
            default:
                Assert.fail("Нет такой кнопки " + arg1);
        }

    }
}
