import com.codeborne.selenide.*;
import org.openqa.selenium.*;

import java.io.*;
import java.time.Duration;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Condition.empty;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

// this is not a full list, just the most common
public class Snippets {

    void browser_command_examples() {
        open("https://google.com"); // открыть по конкретному урлу
        Configuration.baseUrl="http:сайт"; // прописываем основной сайт, что бы работала команда относительно урла
        open("/customer/orders");     // открыть по относительному урлу
        open("/", AuthenticationType.BASIC,
                new BasicAuthCredentials("", "user", "password")); // открытие базовой аутентификации (без использования элементов DOM)

        Selenide.back(); //вернуться назад в браузере
        Selenide.refresh(); //обновить страницу

        Selenide.clearBrowserCookies(); //очищение куки
        Selenide.clearBrowserLocalStorage(); //очищение локал сторидж
        executeJavaScript("sessionStorage.clear();"); // очищение сесион сторидж

        Selenide.confirm(); // OK в стандартном диалоге браузера
        Selenide.dismiss(); // Cancel в стандартном диалоге браузера

        Selenide.closeWindow(); // закрытие окна браузера
        Selenide.closeWebDriver(); // закрытие браузере

        Selenide.switchTo().frame("new"); //переход на поиск во фрейме ( страничка в страничке)
        Selenide.switchTo().defaultContent(); // вернуться из поиска во фремйме в поиск в DOM

        Selenide.switchTo().window("The Internet"); //переключение между окнами браузера

    }

    void selectors_examples() {
        $("div").click(); //выбор селектора и нажатие на него
        element("div").click(); // альтернативный вариант

        $("div", 2).click(); // выбор третьего див и нажатие на него

        $x("//h1/div").click(); // поиск элемента по искпасу и нажатие на него
        $(byXpath("//h1/div")).click(); // альтернативный вариант

        $(byText("full text")).click(); // поиск элемента по полному тексту (между тегами) и клик на него
        $(withText("ull tex")).click(); // поиск элемента по части текста (между тегами) и клик на него

        $(byTagAndText("div", "full text")); // поиск элемента по тегу и полному тексту
        $(withTagAndText("div", "ull text")); //поиск элемента по тегу и части текста

        $("").parent(); //поиск родителя
        $("").sibling(1); //поиск элемента вниз внутри родителя
        $("").preceding(1); //поиск элемента вверх внутри родетиля
        $("").closest("div"); //возвращает ближайший родительский элемент
        $("").ancestor("div"); // альтернативный вариант
        $("div:last-child"); // поиск последнего ребенка в родительском классе

        $(byAttribute("abc", "x")).click(); // развернутый поиск по атрибуту
        $("[abc=x]").click(); // поиск по атрибуту

        $(byId("mytext")).click(); // развернутый поиск по id
        $("#mytext").click(); // поиск по id

        $(byClassName("red")).click(); // развернуты поиск по классу
        $(".red").click(); // поиск по классу
    }

    void actions_examples() {
        $("").click(); // клик по элементу
        $("").doubleClick(); // двойной клик по элементу
        $("").contextClick(); // клик правой кнопкой мышки

        $("").hover(); // подвести мышку, но не кликать

        $("").setValue("text"); // удалить в поле ввода текста данные и ввести заново
        $("").append("text"); // добавить в поле ввода текста данные в конец имеющихся данных
        $("").clear(); //удалить данные из поля ввода текста ( но не всегда корректно работает)
        $("").setValue(""); // удалить данные из поля ввода текста (надо установить пустое значение)

        $("div").sendKeys("c"); // использовать горячую клавишу на элемента
        actions().sendKeys("c").perform(); // использовать горячую клавишу клавишу на странице
        actions().sendKeys(Keys.chord(Keys.CONTROL, "f")).perform(); // нажатие комбинаицй клавишь на странице (например Ctrl + F)
        $("html").sendKeys(Keys.chord(Keys.CONTROL, "f")); // альтернативный способ через использование на главном элементе

        $("").pressEnter(); //использовать Enter на элементе
        $("").pressEscape();// использовать Escape на элементе
        $("").pressTab(); // использовать Tab на элементе

        actions().moveToElement($("div")).clickAndHold().moveByOffset(300, 200).release().perform(); // сложные запросы на действия (пододвинуть мышку к элементу, затем нажать и не отпускать, затем передвинуть мышку на нужные координаты, затем отпустить клавишу мыши). Альтернатива Drag&Drop

        $("").selectOption("dropdown_option"); // выбор дропдауна (выпадающий список)
        $("").selectRadio("radio_options"); // выбор элемента из списка на странице

    }

    void assertions_examples() {
        $("").shouldBe(visible); // проверка на видимость элемента
        $("").shouldNotBe(visible); //проверка на невидимость элемента
        $("").shouldHave(text("abc")); // провреа на наличие текста
        $("").shouldNotHave(text("abc")); // проверка на отсутствие текста
        $("").should(appear); // проверка на то, что элемент появился
        $("").shouldNot(appear); // проверка на то, что элемент не появился

        $("").shouldBe(visible, Duration.ofSeconds(30)); // установка таймаута для конкретной проверки

    }

    void conditions_examples() {
        $("").shouldBe(visible); // элемент появился
        $("").shouldBe(hidden);// элемент  исчез

        $("").shouldHave(text("abc"));// поиск по неполному тексту
        $("").shouldHave(exactText("abc")); //поиск по точному тексту
        $("").shouldHave(textCaseSensitive("abc"));
        $("").shouldHave(exactTextCaseSensitive("abc"));
        $("").should(matchText("[0-9]abc$")); // сложная проврека на текст

        $("").shouldHave(cssClass("red")); // проверка класса
        $("").shouldHave(cssValue("font-size", "12")); // проверка свойст элемента (вкладка  Computed)

        $("").shouldHave(value("25")); // значение заполненого поля по значению
        $("").shouldHave(exactValue("25")); // значение заполненого поля по точному значению
        $("").shouldBe(empty); // проверка наличия значения

        $("").shouldHave(attribute("disabled")); // проверка наличия атрбута
        $("").shouldHave(attribute("name", "example")); // проверка значения атрибута
        $("").shouldHave(attributeMatching("name", "[0-9]abc$")); // сложная проверка начения атрибута

        $("").shouldBe(checked); // проверка чекбокса

        $("").should(exist); // проверка существования элемента, если он невидимый на странице

        $("").shouldBe(disabled); // проверка что кнопка не кликабельна (метод может не работать)
        $("").shouldBe(enabled); // проверка что кнопка кликабельна (метод может не работать)
    }

    void collections_examples() {

        $$("div"); // поиск коллекции по селекторам (не работают без действия или проверки)

        $$x("//div"); // поиск коллекции по икспасу (не работают без действия или проверки)

        // selections
        $$("div").filterBy(text("123")).shouldHave(size(1)); // фильтр поиска элемента которые удволетворяют условию
        $$("div").excludeWith(text("123")).shouldHave(size(1)); // фильтр поиска элемента которые не удволетворяют условию

        $$("div").first().click();// поиск первого элемента и клик по нему
        elements("div").first().click(); //альтернатиный вариант
        // $("div").click();
        $$("div").last().click(); //поиск последнего элемента и клик по нему
        $$("div").get(1).click(); //  поиск номенорованного элемента и клик по нему
        $("div", 1).click(); // альтернативный вариант
        $$("div").findBy(text("123")).click(); // поиск первого элемента и определеным параметром и клик по нему

        // assertions
        $$("").shouldHave(size(0)); //проверка размера коллекции (то что пустая)
        $$("").shouldBe(CollectionCondition.empty); // альтернативный вариант

        $$("").shouldHave(texts("Alfa", "Beta", "Gamma")); //колекция содержит такие текстовые значения
        $$("").shouldHave(exactTexts("Alfa", "Beta", "Gamma")); //коллекция содержит точное совпадаение текстового значения

        $$("").shouldHave(textsInAnyOrder("Beta", "Gamma", "Alfa")); //коллекция содержит такие текстовые значение, но порядок их расположения не важен
        $$("").shouldHave(exactTextsCaseSensitiveInAnyOrder("Beta", "Gamma", "Alfa")); ////колекция содержит такие текстовые значения с учетом регистра

        $$("").shouldHave(itemWithText("Gamma")); // проверка, что в коллекции есть элемент с заданным текстом

        $$("").shouldHave(sizeGreaterThan(0)); // проверка что колекция больше нуля
        $$("").shouldHave(sizeGreaterThanOrEqual(1)); // проверка что коллекция больше или ровна единице

    }

    void file_operation_examples() throws FileNotFoundException {

        File file1 = $("a.fileLink").download(); // скачивание файла по ссылкам формета  <a href="..">
        File file2 = $("div").download(DownloadOptions.using(FileDownloadMode.FOLDER)); // скачивание файла

        File file = new File("src/test/resources/readme.txt"); // загрузка файла
        $("#file-upload").uploadFile(file); //выбор файла
        $("#file-upload").uploadFromClasspath("readme.txt");
        // don't forget to submit!
        $("uploadButton").click(); // нажать кнопку загрузить файл
    }

    void javascript_examples() {
        executeJavaScript("alert('selenide')"); // запускает любую команду JS
        executeJavaScript("alert(arguments[0]+arguments[1])", "abc", 12);// считывание аругментов и запуск JS с этими аргументами
        long fortytwo = executeJavaScript("return arguments[0]*arguments[1];", 6, 7);

    }
}