import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class SimpleTest {
    @Test
    void test01() {
        open("https://slqamsk.github.io/cases/simple-pages/page01.html");
        $(By.tagName("body")).shouldHave(text("Добро пожаловать"));
    }
    @Test
    void test02() {
        open("https://slqamsk.github.io/cases/simple-pages/page01.html");
        $(By.tagName("body")).shouldNotHave(text("До свидания"));
    }
    @Test
    void testLinkContainsYandex() {
        // Открываем страницу
        open("https://slqamsk.github.io/cases/simple-pages/page01.html");
        $("a").shouldHave(text("Яндекс"));
    }
    @Test
    void test03() {
        // Открываем страницу
        open("https://slqamsk.github.io/cases/simple-pages/page02.html");
        // Через By.id
        $(By.id("log-general")).shouldHave(text("Нажмите любую из кнопок выше..."));
    }
    @Test
    void test04() {
        open("https://slqamsk.github.io/cases/simple-pages/page02.html");
        $(By.id("unique-id-element")).shouldHave(text("Элемент с уникальным ID"));
        sleep(15_000);
    }
    @Test
    void test05() {
        // Открываем страницу с формой
        open("https://slqamsk.github.io/cases/simple-pages/page02.html");

        // Проверяем, что страница загрузилась
        $("body").shouldBe(visible);

        // Проверяем существующие элементы на странице
        $(By.id("unique-id-element")).shouldHave(text("Элемент с уникальным ID"));
        $(By.id("log-general")).shouldHave(text("Нажмите любую из кнопок выше..."));
    }

    @Test
    void test06() {
        // Тест для проверки полей ввода
        open("https://slqamsk.github.io/cases/simple-pages/page01.html");
        $("body").shouldBe(visible);

        if ($("input").exists()) {
            $("input").setValue("test value");
            $("input").shouldHave(value("test value"));
        }
    }

    @Test
    void test07() {
        open("https://slqamsk.github.io/cases/simple-pages/page02.html");

        // Проверяем, что страница загрузилась
        $("body").shouldBe(visible);

        // Проверяем существующие элементы на странице
        $(By.id("unique-id-element")).shouldHave(text("Элемент с уникальным ID"));
        $(By.id("log-general")).shouldHave(text("Нажмите любую из кнопок выше..."));

        // Ищем любые поля ввода на странице и заполняем их
        if ($("input").exists()) {
            $("input").setValue("Алиса");
            $("input").shouldHave(value("Алиса"));
        }

        sleep(15_000);
    }
    @Test
    void test08() {
        open("https://slqamsk.github.io/cases/simple-pages/page02.html");
        $(By.className("unique-class")).shouldHave(text("Элемент с уникальным классом"));

        // Проверяем, что у первого элемента с классом "repeating-class" есть нужный текст
        $(".repeating-class").shouldHave(text("Первый элемент с repeating-class"));
    }
    @Test
    void test09() {
        open("https://slqamsk.github.io/cases/simple-pages/page02.html");
        $(By.id("log-form1")).shouldHave(text("Лог нажатий появится здесь..."));
        $(By.name("username")).setValue("Алиса");
        $(By.name("password")).setValue("Qwery12345*");
        $(By.name("contact")).setValue("alice@example.com");
        $(By.name("submit-btn")).click();

        // Проверяем, что в поле лога отобразились все данные для Алисы
        $(By.id("log-form1")).shouldHave(text("username: Алиса"));
        $(By.id("log-form1")).shouldHave(text("password: Qwery12345*"));
        $(By.id("log-form1")).shouldHave(text("contact: alice@example.com"));

        sleep(5_000);
    }
    @Test
    void test10() {
        open("https://slqamsk.github.io/cases/simple-pages/page02.html");

        // Проверяем, что страница загрузилась
        $("body").shouldBe(visible);

        // Ищем поля ввода на странице и заполняем их
        if ($("input[type='text']").exists()) {
            // Заполняем первое поле (имя)
            $("input[type='text']").setValue("Алиса");
        }

        // Ищем второе поле ввода
        if ($("input[type='text']").exists()) {
            // Заполняем второе поле (фамилия) - используем второй input
            $$("input[type='text']").get(1).setValue("Пухтель");
        }

        // Ищем кнопку отправки
        if ($("button").exists()) {
            $("button").click();
        }

        // Проверяем, что страница отреагировала на действия
        $("body").shouldBe(visible);

        sleep(5_000);
    }



}