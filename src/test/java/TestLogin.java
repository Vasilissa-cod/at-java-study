import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class TestLogin {

    @Test
    void test01_find_element() {
        open("https://slqa.ru/cases/ChatGPTLogin/");
        $(By.id("username")).setValue("Vasilissa");
        sleep(5_000);
    }
}