import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Condition.*;


public class SelenidRepositoriyTest {
    @Test
    void shouldFindSelenideRepositoryAtTheTop() {
        // открыть главную страницу
        open("https://github.com/");
        // ввести в поле поиска selenide и нажать enter
        $("[data-test-selector=nav-search-input]").setValue("selenide").pressEnter();
        // кликнуть на первый репозиторий из списка найденых
        $$("ul.repo-list li").first().$("a").click();
        // проверка: заголовок selenide/selenide
        $("#repository-container-header").shouldHave(text("selenide / selenide"));
    }
    @Test
    void solntsevShouldBeTheTopContributor() {
        // открыть страницу репозитория селенида
        open("https://github.com/selenide/selenide");
        // подвести мышку к первому аватару из блока contributors
        $(".BorderGrid").$(byText("Contributors")).ancestor(".BorderGrid-row")
                .$$("ul li").first().hover();
        // проверка: во всплывающем окне есть текст Andrei Solntsev
        $$(".Popover .Popover-message").findBy(visible).shouldHave(text("Andrei Solntsev"));
        $x("//div").shouldBe(visible);
    }
}
