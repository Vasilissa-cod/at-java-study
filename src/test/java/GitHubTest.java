import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Condition.text;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GitHubTest {
    
    @Test
    void simpleGitHubTest() {
        // Шаг 4: Открываем страницу GitHub
        open("https://github.com/Vasilissa-cod/at-java-study");
        
        // Шаг 5: Проверяем наличие текста "gradle/wrapper"
        String pageText = $("body").getText();
        assertTrue(pageText.contains("gradle/wrapper"));
        
        // Шаг 7: Проверяем наличие текста "src/test/java"
        $("body").shouldHave(text("src/test/java"));
    }
}
