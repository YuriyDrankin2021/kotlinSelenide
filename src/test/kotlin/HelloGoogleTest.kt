import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import com.codeborne.selenide.Selenide.*
import com.codeborne.selenide.commands.Find
import com.codeborne.selenide.commands.FindByXpath
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions
import org.openqa.selenium.By


//private val log = KotlinLogging.logger{}
class HelloGoogleTest {

    @BeforeAll
    fun setUp(){
        open("https://google.com")
    }

    @Test
    fun fun1(){
        val inputString = element(By.name("q"))
        val str = "Hello, Google"
        inputString.sendKeys(str)
        inputString.pressEnter()
        val result = element(By.name("q"))
        assertThat(result.value).contains(str)
    }
}