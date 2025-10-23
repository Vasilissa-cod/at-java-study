import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class LocatorsTests {
    @Test
    void test01ById() {
        open("https://slqa.ru/cases/DeepSeekFlights/");
        $(By.id("loginContainer")).shouldHave(text("Аутентификация"));
        $("#loginContainer").shouldHave(text("Аутентификация"));
        $x("//*[@id='loginContainer']").shouldHave(text("Аутентификация"));
    }
    @Test
    void test02ByIdExamTickets() {
        open("http://92.51.36.108:7777/sl.qa/exam_tickets/");
        sleep(5_000);
        $(By.id("quantity_of_tickets")).sendKeys("10");
        sleep(10_000);
    }
    @Test
    void test03ByName() {
        open("https://slqa.ru/cases/fc/v01/");
        sleep(3_000);
        $("[name=sum").setValue("100");
        sleep(3_000);
        $(By.name("sum")).type("12345678901234567890");
        sleep(10_000);
    }

}