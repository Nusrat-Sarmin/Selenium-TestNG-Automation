package testrunner;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.EmployeePage;
import pages.LoginPage;
import setup.Setup;
import utils.Utils;

import java.io.IOException;
import java.util.List;

public class EmployeeTestRunner extends Setup {

    @BeforeTest
    public void doLogin() {
        driver.get("https://opensource-demo.orangehrmlive.com");
        LoginPage loginPage = new LoginPage(driver);
        String adminUser= "Admin";
        String adminPass="admin123";
        loginPage.doLogin(adminUser,adminPass);
    }

    @Test(priority = 1, description = "Check if user exists",enabled = false)
   public void checkIfUserExists() throws IOException, ParseException {
       EmployeePage employeePage = new EmployeePage(driver);

      List data = Utils.readJSONArray("./src/test/resources/Users.json");
       JSONObject userObj = (JSONObject) data.get(data.size()-1);
        String existingUserName = (String) userObj.get("userName");
      String validationMessageActual = employeePage.checkIfUserExists(existingUserName);
      String validationMessageExpected = "Username already exists";

        Assert.assertTrue(validationMessageActual.contains(validationMessageExpected));
   }


    @Test(priority = 2, description = "Create new employee")
    public void createEmployee() throws IOException, ParseException, InterruptedException {
        EmployeePage employeePage= new EmployeePage(driver);
        employeePage.PIM.get(1).click();
        employeePage.btnAddEmployee.get(2).click();
        employeePage.toggleButton.click();
        Utils utils = new Utils();
        utils.generateRandomData();
        Thread.sleep(3000);
        String firstName = utils.getFirstname();
        String lastName = utils.getLastname();
        int randomId = Utils.generateRandomNumber(1000,9999);
        String userName = utils.getFirstname()+randomId;
        String password = "P@ssword123";
        String confirmPassword = password;

        employeePage.createEmployee(firstName,lastName,userName,password,confirmPassword);

         List<WebElement> headerTitle = driver.findElements(By.className("orangehrm-main-title"));
        Assert.assertTrue(headerTitle.get(0).isDisplayed());

        Utils.waitForElement(driver,headerTitle.get(0),50);
        if (headerTitle.get(0).isDisplayed()){
            utils.saveJsonList(userName,password);
        }

    }

}
