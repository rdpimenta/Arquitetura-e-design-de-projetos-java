package br.com.alura.leilao.login;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {
    private static final String URL_LOGIN = "http://localhost:8080/login";
    private WebDriver browser;

    @BeforeEach
    public void beforeEach(){
        this.browser = new ChromeDriver();
        browser.navigate().to(URL_LOGIN);
    }

    @AfterEach
    public void afterEach(){
        this.browser.quit();
    }

    @Test
    public void deveriaEfetuarLoginComDadosValidos() {
        browser.findElement(By.id("username")).sendKeys("fulano");
        browser.findElement(By.id("password")).sendKeys("pass");
        browser.findElement(By.id("login-form")).submit();

        Assertions.assertNotEquals("http://localhost:8080/login", browser.getCurrentUrl());
        Assertions.assertEquals("fulano", browser.findElement(By.id("usuario-logado")).getText());
    }

    @Test
    public void naoDeveriaEfetuarLoginComDadosInvalidos() {
        browser.findElement(By.id("username")).sendKeys("beltrano");
        browser.findElement(By.id("password")).sendKeys("password");
        browser.findElement(By.id("login-form")).submit();

        Assertions.assertEquals("http://localhost:8080/login?error", browser.getCurrentUrl());
        Assertions.assertTrue(browser.getPageSource().contains("Usuário e senha inválidos."));
        Assertions.assertThrows(NoSuchElementException.class, () -> browser.findElement(By.id("usuario-logado")));
    }

    @Test
    public void naoDeveriaAcessarLeiloesSemEstarLogado() {
        browser.navigate().to("http://localhost:8080/leiloes/2");

        Assertions.assertEquals("http://localhost:8080/login", browser.getCurrentUrl());
        Assertions.assertFalse(browser.getPageSource().contains("Dados do leilão"));
    }
}
