package com.bae.test.selenium;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class SeleniumMMA {

	@LocalServerPort
	private int port;
	private WebDriver driver;
	
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "chromedriver");
		ChromeOptions options = new ChromeOptions();
		options.setHeadless(true);
		this.driver = new ChromeDriver(options);
		this.driver.manage().window().maximize();
		this.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test
	public void viewTest() throws InterruptedException {
		this.driver.get("http://localhost:8181/");
		this.driver.findElement(By.xpath("/html/body/form/div[3]/input")).sendKeys("luke");
		Thread.sleep(1000);
		this.driver.findElement(By.xpath("/html/body/form/div[4]/input")).sendKeys("1234");
		Thread.sleep(1000);
		this.driver.findElement(By.xpath("/html/body/form/button")).click();
		Thread.sleep(1000);
		
	}
}
