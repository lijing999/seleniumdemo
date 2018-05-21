package meyoung.day3;

import com.po.page.loginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by lijing on 2018/5/18.
 */
public class Login163 {
    WebDriver Driver;

    /**
     * 打开chrome浏览器
     */
    @BeforeMethod
    public void openChrome() throws InterruptedException {
        //设置chromedrvier路径，实例化chromedriver
        System.setProperty("webdriver.chrome.driver","E:\\TestDevs\\MySeleniumAuto\\.idea\\drivers\\chromedriver.exe");
        Driver = new ChromeDriver();
        Driver.get("https://mail.163.com/");
        Thread.sleep(3000);

    }

    /**
     * 登录正确的
     * @throws InterruptedException
     */
    @Test
    public void loginTest() throws InterruptedException {
        /*Driver.switchTo().frame("x-URS-iframe");
        Driver.findElement(By.name("email")).sendKeys("winnilee999");
        Driver.findElement(By.name("password")).sendKeys("lijing19870909");
        Driver.findElement(By.id("dologin")).click();*/
        //Thread.sleep(3000);

        //直接调用封装的login
        Login163.login(Driver,"winnilee999","lijing19870909");

        //显示等待，防止页面没有加载出来
        WebDriverWait wait=new WebDriverWait(Driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("退出")));
        // 断言：页面包含 退出 按钮
        String  logout=Driver.findElement(By.linkText("退出")).getText();
        Assert.assertEquals(logout,"退出");
    }

    /**
     * 登录错误的
     * @throws InterruptedException
     */
    @Test
    public void ErrorloginTest() throws InterruptedException {

       /* Driver.switchTo().frame("x-URS-iframe");
        Driver.findElement(By.name("email")).sendKeys("winnilee999");
        Driver.findElement(By.name("password")).sendKeys("lijing198709091");
        Driver.findElement(By.id("dologin")).click();*/
        //Thread.sleep(3000);

        //直接调用封装的login
        Login163.login(Driver,"winnilee999","lijing19870909/");

        //显示等待，防止页面没有加载出来
        WebDriverWait wait=new WebDriverWait(Driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"nerror\"]/div[2]")));
        // 断言
        String  erromessage=Driver.findElement(By.xpath("//*[@id=\"nerror\"]/div[2]")).getText();
        Assert.assertEquals(erromessage,"帐号或密码错误");
    }

    /**
     * 抽取登录方法，用参数传递用户名密码
     * 定义为静态方法，用类名直接调用即可
     */
    public  static void login(WebDriver Driver,String email,String pwd){

        Driver.switchTo().frame("x-URS-iframe");
        /*Driver.findElement(By.name("email")).sendKeys(email);
        Driver.findElement(By.name("password")).sendKeys(pwd);
        Driver.findElement(By.id("dologin")).click();*/

        //login页面元素定位抽取后
        Driver.findElement(loginPage.emailInupt).sendKeys(email);
        Driver.findElement(loginPage.pwdInput).sendKeys(pwd);
        Driver.findElement(loginPage.loginbutton).click();

    }

    @AfterMethod
    public void closeBrowser() throws InterruptedException {
        Thread.sleep(5000);
        Driver.quit();
    }
}
