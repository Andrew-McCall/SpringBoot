package com.qa.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SeleniumTest2 {

	private static WebDriver driver;

	@BeforeAll
	public static void setup() {
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		driver = new ChromeDriver();
	}

	@AfterAll
	public static void tearDown() {
		driver.quit();
	}

	@Test
	public void index() {
		driver.get("http://localhost:8090/index.html");
		assertEquals(driver.findElement(By.xpath("//p[3]")).getText(), "David, McCall");
		assertEquals(driver.getTitle(), "Index");
	}

	@Test
	public void home() {
		driver.get("http://localhost:8090/home.html");
		assertEquals(driver.findElement(By.xpath("//h1")).getText(), "Hello !");
		assertEquals(driver.getTitle(), "Home Page");
	}

	@Test
	public void both() {
		driver.get("http://localhost:8090/home.html");
		assertEquals(driver.findElement(By.xpath("//h1")).getText(), "Hello !");
		assertEquals(driver.getTitle(), "Home Page");

		driver.navigate().to("http://localhost:8090/index.html");
		assertEquals(driver.findElement(By.xpath("//p[3]")).getText(), "David, McCall");
		assertEquals(driver.getTitle(), "Index");
	}
}
