import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;



public class AvtoTestCard {
//


        @BeforeEach
        void setup() {
            open("http://localhost:9999");
        }
        TestsDataGenerator teDaGe = new TestsDataGenerator();

        @Test
        @DisplayName("Should successfully login with active registered user")
        void shouldSuccessfulLoginIfRegisteredActiveUser() {
            var registeredUser = TestsDataGenerator.Registration.getRegisteredUser("active");
            $("[data-test-id='login'] input").setValue(registeredUser.getLogin());
            $("[data-test-id='password'] input").setValue(registeredUser.getPassword());
            $("button.button").click();
            $("h2").shouldHave(Condition.exactText("Личный кабинет")).shouldBe(Condition.visible);

        }

        @Test
        @DisplayName("Should get error message if login with not registered user")
        void shouldGetErrorIfNotRegisteredUser() {
//            var notRegisteredUser = TestsDataGenerator.Registration.getUser("active");
            $("[data-test-id='login'] input").setValue(teDaGe.getRandomLogin());
            $("[data-test-id='password'] input").setValue(teDaGe.getRandomPassword());
            $("button.button").click();
            $("[data-test-id='error-notification'] .notification__content")
                    .shouldHave(Condition.text("Ошибка! Неверно указан логин или пароль"), Duration.ofSeconds(15))
                    .shouldBe(Condition.visible);
        }

        @Test
        @DisplayName("Should get error message if login with blocked registered user")
        void shouldGetErrorIfBlockedUser() {
            var blockedUser = TestsDataGenerator.Registration.getRegisteredUser("blocked");
            $("[data-test-id='login'] input").setValue(blockedUser.getLogin());
            $("[data-test-id='password'] input").setValue(blockedUser.getPassword());
            $("button.button").click();
            $("[data-test-id='error-notification'] .notification__content")
                    .shouldHave(Condition.text("Ошибка! Пользователь заблокирован"), Duration.ofSeconds(15))
                    .shouldBe(Condition.visible);
        }

        @Test
        @DisplayName("Should get error message if login with wrong login")
        void shouldGetErrorIfWrongLogin() {
            var registeredUser = TestsDataGenerator.Registration.getRegisteredUser("active");
            $("[data-test-id='login'] input").setValue(teDaGe.getRandomLogin());
            $("[data-test-id='password'] input").setValue(registeredUser.getPassword());
            $("button.button").click();
            $("[data-test-id='error-notification'] .notification__content")
                    .shouldHave(Condition.text("Ошибка! Неверно указан логин или пароль"), Duration.ofSeconds(15))
                    .shouldBe(Condition.visible);
        }

        @Test
        @DisplayName("Should get error message if login with wrong password")
        void shouldGetErrorIfWrongPassword() {
            var registeredUser = TestsDataGenerator.Registration.getRegisteredUser("active");
            $("[data-test-id='login'] input").setValue(registeredUser.getLogin());
            $("[data-test-id='password'] input").setValue(teDaGe.getRandomPassword());
            $("button.button").click();
            $("[data-test-id='error-notification'] .notification__content")
                    .shouldHave(Condition.text("Ошибка! Неверно указан логин или пароль"), Duration.ofSeconds(15))
                    .shouldBe(Condition.visible);
        }
}

