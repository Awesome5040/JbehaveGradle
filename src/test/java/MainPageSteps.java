import com.codeborne.selenide.WebDriverRunner;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.steps.Steps;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MainPageSteps extends Steps {

    @When("User navigates to Epam main page")
    public void userOpensEpamMainPage() {
        getWebDriver().navigate().to("https://www.epam.com/");
    }

    @Given("User opens browser")
    public void userOpensBrowser() {
        WebDriverManager.chromedriver().setup();
        WebDriverRunner.setWebDriver(new ChromeDriver(new ChromeOptions()));
    }

    @Given("User closes browser")
    public void userClosesBrowser() {
        getWebDriver().quit();
    }

    @When("User opens Contact Us Page")
    public void userOpensContactUsPage() {
        $x("//a[contains(@class,'cta-button-ui')]").should(visible).click();
    }

    @Then("User sees the JUST ASK US ANYTHING form on Contact Us Page")
    public void userSeesJustAskUsAnythingFormOnContactUsPage() {
        $x("//div[@class='form-constructor start']").shouldBe(visible);
    }

}
