import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.Objects;

import static org.openqa.selenium.By.cssSelector;
import static org.openqa.selenium.By.xpath;

public class OrangeHrmLive {

    public static void main(String[] args) throws InterruptedException{
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver=new FirefoxDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));

        //Login
        driver.findElement(By.name("username")).sendKeys("Admin");
        driver.findElement(By.name("password")).sendKeys("admin123");
        driver.findElement(By.tagName("button")).click();
        String title = driver.getTitle();
        if (Objects.equals(title, "OrangeHRM")){
            System.out.println("title is matched");
        }
        else {
            System.out.println("title is not matched");
        }
        driver.findElement(By.xpath("//a[@href='/web/index.php/admin/viewAdminModule']")).click();
        driver.findElement(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary']")).click();

        //Add-User
        driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[1]/div/div[2]/div/div/div[2]/i")).click();
        driver.findElement(By.xpath("//div[@class='oxd-select-option'][2]")).click();
        driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[3]/div/div[2]/div/div/div[2]/i")).click();
        driver.findElement(By.xpath("//div[@class='oxd-select-option'][2]")).click();


        WebElement input = driver.findElement(By.xpath("//input[@placeholder='Type for hints...']"));
        input.sendKeys("pe");
        Thread.sleep(1500);
        input.sendKeys(Keys.ARROW_DOWN);
        input.sendKeys(Keys.ENTER);

        driver.findElement(By.xpath("//input[@autocomplete='off']")).sendKeys("Tester");
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("*1234aA*");
        driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[2]/div/div[2]/input")).sendKeys("*1234aA*");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        //Find-User
        driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[1]/div/div[2]/input")).sendKeys("Tester");
        driver.findElement(By.cssSelector("div.oxd-grid-item:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1)")).click();
        driver.findElement(By.cssSelector("div.oxd-select-option:nth-child(2) > span:nth-child(1)")).click();

        WebElement input2 = driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[3]/div/div[2]/div/div/input"));
        input2.click();
        input2.sendKeys("pe");
        Thread.sleep(1500);
        input2.sendKeys(Keys.ARROW_DOWN);
        input2.sendKeys(Keys.ENTER);

        driver.findElement(By.cssSelector("div.oxd-grid-item:nth-child(4) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1)")).click();
        driver.findElement(By.cssSelector("div.oxd-select-option:nth-child(2)")).click();
        driver.findElement(By.cssSelector("button.oxd-button:nth-child(2)")).click();

        //Delete-User
        driver.findElement(By.cssSelector("button.oxd-table-cell-action-space:nth-child(1)")).click();
        driver.findElement(By.cssSelector(".oxd-button--label-danger")).click();

        //LOGOUT
        driver.findElement(By.cssSelector("li.oxd-userdropdown")).click();
        driver.findElement(By.cssSelector(".oxd-dropdown-menu > li:nth-child(4)")).click();
    }
}
