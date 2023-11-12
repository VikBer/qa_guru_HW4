import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;



public class SelenideGithubWikiPageTest {

    @BeforeAll
    public static void beforeAll(){
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl="https://github.com";
        Configuration.holdBrowserOpen=true;

    }

    @Test
    void checkSelenideGithubWikiPageTest(){
        open("/selenide/selenide");
        $("#wiki-tab").click();
        $(".js-wiki-more-pages-link").click();
        $(byText("SoftAssertions")).click();
        $(".gh-header-title").shouldHave(text("SoftAssertions"));
        $("#user-content-3-using-junit5-extend-test-class+div").$("pre").
                shouldHave(text("""
                        @ExtendWith({SoftAssertsExtension.class})
                        class Tests {
                         @Test
                        void test() {
                        Configuration.assertionMode = SOFT;
                        open("page.html");

                        $("#first").should(visible).click();
                        $("#second").should(visible).click();
                        }
                        }"""));
    }

}
