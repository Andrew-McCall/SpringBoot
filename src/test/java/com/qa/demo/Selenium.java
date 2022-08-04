package com.qa.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("dev")
public class Selenium {

	private static WebDriver driver;

	@BeforeAll
	public static void setup() {
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		driver = new ChromeDriver();
		System.out.println("driver");
	}

	@AfterAll
	public static void tearDown() {
		driver.quit();
	}

	@Test
	public void index() {
		driver.get("http://localhost:8090/index.html");
		assertEquals(driver.getTitle(), ("Index"));
		assertEquals(driver.findElement(By.xpath("//p")).getText(), ("Andrew, McCall"));
	}

}
