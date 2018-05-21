package meyoung.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by lijing on 2018/5/17.
 */
public class WaitTest {
    WebDriver webDriver;

    /**
     * 打开浏览器的方法抽取出来，每个用例之前都执行
     */
    @BeforeMethod
    public void openChrome(){
        //设置chromedrvier路径，实例化chromedriver
        System.setProperty("webdriver.chrome.driver","E:\\TestDevs\\MySeleniumAuto\\.idea\\drivers\\chromedriver.exe");webDriver = new ChromeDriver();
        webDriver = new ChromeDriver();
    }
    /**
     * 打开测试界面
     * 点击  按钮
     * 获取文本，并判断是否为“”
     */
    @Test
    public void waitTest(){
        webDriver.get("https://www.baidu.com");
        //全局等待，找10s
        webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        //显示等待:智能等待
        WebDriverWait wait=new WebDriverWait(webDriver,10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("")));

    }
}
