package testrunner;

import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.EmployeePage;
import pages.LoginPage;
import pages.ViewEmployeePage;
import setup.Setup;

import java.util.List;

public class ViewEmployeePageTestRunner extends Setup {

    ViewEmployeePage viewEmployeePage;
    EmployeePage employeePage;

    @BeforeTest
    public void doLogin() {
        driver.get("https://opensource-demo.orangehrmlive.com");
        LoginPage loginPage = new LoginPage(driver);
        String adminUser = "admin";
        String adminPass = "admin123";
       loginPage.doLogin(adminUser, adminPass);
    }

    @Test(priority = 1, description="Select employee status")
    public void selectEmploymentStatus() throws InterruptedException {
        ViewEmployeePage viewEmployeePage = new ViewEmployeePage(driver);
        viewEmployeePage.PIM.get(1).click();
        Thread.sleep(2000);
        viewEmployeePage.dropdowns.get(0).click();
        viewEmployeePage.dropdowns.get(0).sendKeys(Keys.ARROW_DOWN);
        viewEmployeePage.dropdowns.get(0).sendKeys(Keys.ARROW_DOWN);
        viewEmployeePage.dropdowns.get(0).sendKeys(Keys.ENTER);
        viewEmployeePage.btnSubmit.click();

        Thread.sleep(3000);
        List<WebElement> txtData = driver.findElements(By.tagName("span"));
        String dataActual = txtData.get(14).getText();
        String dataExpected = "Records Found";
        Assert.assertTrue(dataActual.contains(dataExpected));

    }

    @Test(priority = 2, description="Showing employee list")
    public void listEmployee(){

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");

        WebElement table=driver.findElement(By.className("oxd-table-body"));
        List<WebElement> allRows =table.findElements(By.cssSelector("[role=row]"));
        for(WebElement row:allRows){
            List<WebElement> cells = row.findElements(By.cssSelector("[role=cell]"));
            System.out.println(cells.get(5).getText());
            Assert.assertTrue(cells.get(5).getText().contains("Full-Time Contact"));
        }
    }

    @Test(priority = 3, description = "Showing no employee data if not in database",enabled = false)
    public void noEmployeeData() throws InterruptedException {
        Thread.sleep(2000);
        viewEmployeePage=new ViewEmployeePage(driver);
        viewEmployeePage.dropdowns.get(0).click();
        viewEmployeePage.dropdowns.get(0).sendKeys(Keys.ARROW_DOWN);
        viewEmployeePage.dropdowns.get(0).sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        viewEmployeePage.btnSubmit.click();
        Thread.sleep(2000);

        String dataStatusActual= driver.findElement(By.xpath("//span[contains(text(),'No Records Found')]")).getText();
        String dataStatusExpected="No Records Found";
        Assert.assertEquals(dataStatusActual,dataStatusExpected);
    }
}
