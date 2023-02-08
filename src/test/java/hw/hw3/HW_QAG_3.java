package hw.hw3;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selectors.*;

public class HW_QAG_3 {
    @Test
    void checkGitHubPage() {
        Configuration.holdBrowserOpen = true;
        //открываем главную страницу GitHub
        open("https://github.com/");
        //наводим курсор на надпись Solutions
        $(byText("Solutions")).hover();
        //выбираем пункт Enterprise
        $(byText("Enterprise")).click();
        //проверяем, что открылась нужная страница
        $(".font-mktg").shouldHave(text("Build like the best"));
    }
}
