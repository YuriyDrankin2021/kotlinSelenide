import com.codeborne.selenide.Selenide.open
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test

class UiTests {
    @BeforeAll
    fun before() {
        open("https://the-internet.herokuapp.com/")
    }
//
//    @Test
//    fun check
}