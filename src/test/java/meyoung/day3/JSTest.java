package meyoung.day3;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by lijing on 2018/5/18.
 */
public class JSTest {
    WebDriver webDriver;

    /**
     * 打开浏览器的方法抽取出来，每个用例之前都执行
     */
    @BeforeMethod
    public void openChrome(){
        //设置chromedrvier路径，实例化chromedriver
        System.setProperty("webdriver.chrome.driver","E:\\TestDevs\\MySeleniumAuto\\.idea\\drivers\\chromedriver.exe");
        webDriver = new ChromeDriver();
    }
    /**
     * 执行JS
     */
    @Test
    public void JSTest() throws InterruptedException {
        webDriver.get("https://www.baidu.com");
        JavascriptExecutor js=(JavascriptExecutor)webDriver;
        js.executeScript("document.getElementById(\"kw\").setAttribute(\"value\",\"webdriver\");");
        Thread.sleep(3000);

    }
    @AfterMethod
    public void closeBrowser(){
        webDriver.quit();
    }


}
