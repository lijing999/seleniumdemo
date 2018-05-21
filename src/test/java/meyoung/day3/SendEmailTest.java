package meyoung.day3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by lijing on 2018/5/18.
 */
public class SendEmailTest {
    public static WebDriver Driver;

    /**
     * 打开chrome浏览器
     */
    @BeforeMethod
    public void openChrome() throws InterruptedException {
        //设置chromedrvier路径，实例化chromedriver
        System.setProperty("webdriver.chrome.driver","E:\\TestDevs\\MySeleniumAuto\\.idea\\drivers\\chromedriver.exe");
        Driver = new ChromeDriver();
        Driver.get("https://mail.163.com/");
        Thread.sleep(5000);

    }

    @Test
    public static void login(){
        Login163.login(Driver,"winnilee999","lijing19870909");
    }

    @Test
    public void sendEmail(){
        //登录
        SendEmailTest.login();
        //Login163.login(Driver,"winnilee999","lijing19870909");
        //全局等待加载页面
        Driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //点击 写信
        Driver.findElement(By.xpath(".//*[@id='dvNavTop']/ul/li[2]/span[2]")).click();
        //输入收件人
        //Driver.findElement(By.className("js-component-emailtips nui-ipt-placeholder")).sendKeys("lijing@pdmi.cn");
        Driver.findElement(By.xpath(".//*[@aria-label='收件人地址输入框，请输入邮件地址，多人时地址请以分号隔开']"));//通过属性定位
        //Driver.findElement(By.xpath(".//*[@title='发给多人时地址请以分号隔开']")).sendKeys("winnilee999@163.com");
        //输入邮件主题
        Driver.findElement(By.xpath(".//*[@aria-label='邮件主题输入框，请输入邮件主题']/input")).sendKeys("test");
        //上传附件
        Driver.findElement(By.xpath(".//*[@title='一次可发送2000张照片，600首MP3，一部高清电影']/input")).sendKeys("E:\\证件照.jpg");

        // 文本框，在iframe里
        WebElement frame=Driver.findElement(By.className("APP-editor-iframe"));
        Driver.switchTo().frame(frame);
        Driver.findElement(By.xpath("/html/body")).sendKeys("hello");

        //发送 通过文本获取元素
        //控制权转交回来
        Driver.switchTo().defaultContent();
        Driver.findElement(By.xpath(".//*[text()='发送']")).click();

    }



    @AfterMethod
    public void closeBrowser() throws InterruptedException {
        Thread.sleep(5000);
        Driver.quit();
    }
}
