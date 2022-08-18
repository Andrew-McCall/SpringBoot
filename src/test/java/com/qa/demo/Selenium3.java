package com.qa.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.qa.runner.QaSpringApplication;

@SpringBootTest(classes = { QaSpringApplication.class })
@ActiveProfiles("dev")
public class Selenium3 {

	private static WebDriver driver;

	@BeforeAll
	public static void setup() {
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		driver = new ChromeDriver();
	}

	@Test
	public void homePage() {

		driver.get("http://localhost:8090/home.html");
		assertEquals("Home Page", driver.getTitle());
		WebElement element = driver.findElement(By.xpath("/html/body/h1"));
		assertEquals("Hello !", element.getText());

	}

	@AfterAll
	public static void cleanup() {
		driver.close();
	}

}
