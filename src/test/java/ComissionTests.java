import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class ComissionTests {

    @Test
        //Проверить, что для суммы 2000 рублей форма работает
    void test01UsualSum() {
        //Открыть страницу
        open("https://slqa.ru/cases/fc/v01");
        //Ввести 2000 в поле "Сумма перевода"
        $(By.name("sum")).setValue("2000");
        //Нажать на кнопку
        $(By.name("submit")).click();
        //Проверить комиссию и проверить общую сумму к оплате
        $(By.name("com")).shouldHave(text("20"));
        $(By.name("total")).shouldHave(text("2020"));
    }
    @Test
//Проверить, что для суммы "q" форма работает
    void test02InvalidSum() {
        //Открыть страницу
        open("https://slqa.ru/cases/fc/v01");
        //Ввести "q" в поле "Сумма перевода"
        $(By.name("sum")).setValue("q");
        //Нажать на кнопку
        $(By.name("submit")).click();
        //Проверить, что появилось сообщение об ошибке
        $(By.name("error")).shouldHave(text("Неверный формат суммы"));
    }
}