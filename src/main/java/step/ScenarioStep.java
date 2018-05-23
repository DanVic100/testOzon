package step;

import cucumber.api.DataTable;
import cucumber.api.java.ru.Когда;
import cucumber.api.java.ru.Тогда;
import org.junit.Assert;

import java.util.List;


public class ScenarioStep {
    MainOzonStep mainOzonStep = new MainOzonStep();
    ItemMenuStep itemMenuStep= new ItemMenuStep();
    ElectronicStep electronicStep = new ElectronicStep();
    CartStep cartStep = new CartStep();

    @Когда("^проверяем всплывающую рекламу$")
    public void проверяем_всплывающую_рекламу() throws Throwable {

       mainOzonStep.catchPopup();


    }

    @Когда("^выбираем (.+)$")
    public void выбираем(String str) throws Throwable {

        mainOzonStep.getMenu(str);
    }


    @Когда("^пункт меню (.+)$")
    public void getMenu(String str) throws Throwable {


        electronicStep.getManuItem(str);
    }

   /* @Когда("^производтитель (.+)$")
    public void выбираем_производителя(String str) throws Throwable {

        itemMenuStep.getMaker(str);
    }*/

  //предложенный варант выбора бренда
   @Когда("^выбраны производители (.+)$")
   public void selectBrands(String brands) {
       String[] brandss = brands.split(",");
       for (String brand : brandss)
           itemMenuStep.stepSelectBrand(brand);
   }




    @Когда("^заполнены поля:$")
    public void заполнены_поля(DataTable arg1) throws Throwable {

      arg1.asMap(String.class,String.class).forEach((name,value)->itemMenuStep.sendKeyValue(name,value));
    }

    @Тогда("^из полученного списка выбираем только нечетные элементы$")
    public void из_полученного_списка_выбираем_только_нечетные_элементы() throws Throwable {
    itemMenuStep.goElement();
    }

    @Когда("^нажимаем на Корзина$")
    public void нажимаем_на_Корзина() throws Throwable {
       itemMenuStep.getCart();
    }

    @Тогда("^проверяем в корзине есть добавленный товар$")
    public void проверяем_в_корзине_есть_добавленный_товар() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        cartStep.booleanProductCart();

    }

    @Тогда("^проверяем корзина пуста$")
    public void проверяем_корзина_пуста() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        boolean empty = cartStep.isEmpty();
        Assert.assertFalse("Карзина не пуста",empty);
    }

    @Когда("^нажимаем на Удалить")
    public void нажимаем_на_Удалить() throws Throwable {

        cartStep.deleteProducts();
    }

}


