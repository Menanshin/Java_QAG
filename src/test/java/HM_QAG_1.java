import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.selector.ByText;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Condition.*;


public class HM_QAG_1 {
    @Test
    void jUnit5Search() {
        Configuration.holdBrowserOpen = true;
        // открываем страницу Selenide ya GitHub
        open("https://github.com/search?q=selenide");
        // проверяем , что на странице Selenide
        $(".application-main").shouldHave(text("selenide"));
        // переходим на страницу Wiki
        $("[data-search-type=Wikis]").click();
        // проверяем, что на нужной странице есть нужно значение
        $(".application-main").shouldHave(text("SoftAssertions"));
        // проверяем наличие в списке страниц (Pages) страниц SoftAssertions
        $("#wiki_search_results").shouldHave(text("SoftAssertions"));
        // открываем страницу SoftAssertions
        $("[title=SoftAssertions]").click();
        // проверяем внутри наличие примера кода JUnit5
        $(".markdown-body").shouldHave(text("Using JUnit5 extend test class:"));
    }
}
