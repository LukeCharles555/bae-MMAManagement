package com.bae.test.selenium;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import com.bae.persistance.domain.Manager;

//@RunWith(SpringRunner.class)
//@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class SeleniumMMA {

//	@LocalServerPort
//	private int port;
	private WebDriver driver;
	private JavascriptExecutor js;
	private Manager testManager;
	private int managerID = 1;
	
	public void SessionStorage(WebDriver driver) {
		this.js = (JavascriptExecutor) driver;
	}
	
	public void setItemInSessionStorage(int managerID, int i) {
		js.executeScript(String.format("window.sessionStorage.setItem('%s','%s');", managerID, i));
	}
	
	@Before
	public void setup() {
//		driver = setItemInSessionStorage(managerID, 1);
 		driver = new ChromeDriver(
				(ChromeDriverService)(new ChromeDriverService.Builder() {
					@Override
					protected File findDefaultExecutable() {
						if (new File("/snap/bin/chromium.chromedriver").exists()) {
							return new File("/snap/bin/chromium.chromedriver") {
								@Override
								public String getCanonicalPath() throws IOException {
									return this.getAbsolutePath();
								}
							};
						} else {
							return super.findDefaultExecutable();
						}
					}
				}).build() /*, options */);
		
		
		ChromeOptions options = new ChromeOptions();
		options.setHeadless(true);
		this.driver.manage().window().maximize();
		this.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test
	public void viewFighterAppTest() throws InterruptedException {
		this.driver.get("http://3.8.164.31:8100/FighterApp.html");
		this.driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/div[2]/input")).sendKeys("Joe");
		Thread.sleep(1000);
		this.driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/div[3]/input")).sendKeys("Bloggs");
		Thread.sleep(1000);
		this.driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/div[4]/input")).sendKeys("60");
		Thread.sleep(1000);
		this.driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/div[5]/input")).sendKeys("200");
		Thread.sleep(1000);
		this.driver.findElement(By.xpath("/html/body/div[3]/div[2]/button")).click();
		Thread.sleep(1000);
		this.driver.findElement(By.xpath("/html/body/div[2]/a[2]")).click();
		Thread.sleep(1000);
		assertEquals("Names match", "Joe Bloggs", this.driver.findElement(By.xpath("/html/body/div[3]/table/tbody/tr/td[1]")).getText());
		assertEquals("Heights match", "60", this.driver.findElement(By.xpath("/html/body/div[3]/table/tbody/tr/td[2]")).getText());
		assertEquals("Weights match", "200", this.driver.findElement(By.xpath("/html/body/div[3]/table/tbody/tr/td[3]")).getText());
	}
	
	@After
	public void tearDown() {
		this.driver.close();
	}
}
