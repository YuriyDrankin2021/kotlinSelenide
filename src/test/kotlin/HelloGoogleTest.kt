import com.codeborne.selenide.Condition
import com.codeborne.selenide.Selenide.element
import com.codeborne.selenide.Selenide.open
import mu.KotlinLogging
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.openqa.selenium.By


private val log = KotlinLogging.logger {}

class HelloGoogleTest {

    @BeforeAll
    fun setUp() {
        open("https://google.com")
    }

    @Test
    fun fun1() {
        val inputString = element(By.name("q"))
        val str = "Hello, Google"
        inputString.sendKeys(str)
        inputString.pressEnter()
        element(By.name("q")).shouldHave(Condition.exactValue(str))
    }
}