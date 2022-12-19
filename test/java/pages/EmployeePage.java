package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class EmployeePage {

    @FindBy(className = "oxd-button")
    public List<WebElement> btnAddEmployee;

    @FindBy(css = "[type=submit]")
     public WebElement btnSubmit;

    @FindBy(name = "firstName")
    WebElement txtFirstName;

    @FindBy(name = "lastName")
    WebElement txtLastName;

    @FindBy(className = "oxd-switch-input")
   public WebElement toggleButton;

    @FindBy(className = "oxd-input")
   public List<WebElement> txtUserCreds;

    @FindBy(className = "oxd-select-text-input")
   public List<WebElement> dropdownBox;

    @FindBy(className = "oxd-input-field--error-message")
    public WebElement lblValidationError;

    @FindBy(className = "oxd-main-menu-item--name")
      public List<WebElement> PIM;

    public EmployeePage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    public String checkIfUserExists(String username){
        PIM.get(1).click();
        btnAddEmployee.get(2).click();
        toggleButton.click();
        txtUserCreds.get(5).sendKeys(username);
//        txtUserCreds.get(5).clear();
        return lblValidationError.getText();
    }

    public void createEmployee(String firstName,String lastName,String userName,String password,String confirmPassword){
        txtFirstName.sendKeys(firstName);
        txtLastName.sendKeys(lastName);
        txtUserCreds.get(5).clear();
        txtUserCreds.get(5).sendKeys(userName);
        txtUserCreds.get(6).clear();
        txtUserCreds.get(6).sendKeys(password);
        txtUserCreds.get(7).sendKeys(confirmPassword);
        btnSubmit.click();
    }
}
