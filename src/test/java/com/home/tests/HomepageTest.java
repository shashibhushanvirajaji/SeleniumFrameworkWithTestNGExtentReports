package com.home.tests;

import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.home.driver.Driver;
import com.home.driver.DriverManager;

public final class HomepageTest extends BaseClassTest {

	private HomepageTest() {

	}
	
	@Test
	public void test3()
	{				
		DriverManager.getDriver().findElement(By.name("q")).sendKeys("Ushas sri kankanala",Keys.ENTER);
//		Assert.assertTrue(Objects.nonNull(DriverManager.getDriver().getTitle()));
//		Assert.assertTrue(DriverManager.getDriver().getTitle().contains("kankanala"));
		String sTitle = DriverManager.getDriver().getTitle();
		
		assertThat(sTitle)   /// importing assertions class statically.
		.contains("kankanala")
		.hasSizeGreaterThan(10);
		
		/*
		 * SoftAssertions softassert = new SoftAssertions();
		 * softassert.assertThat(sTitle) .hasSize(12) .isNotEmpty()
		 * .contains("kankanala");
		 */
	}
}
