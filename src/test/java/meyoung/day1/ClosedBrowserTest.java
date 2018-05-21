package meyoung.day1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import java.lang.*;

/**
 * Created by lijing on 2018/5/16.
 */
public class ClosedBrowserTest {
    @Test
    public void closedChrome()throws InterruptedException{
        //设置chromedrvier路径，实例化chromedriver
        System.setProperty("webdriver.chrome.driver","E:\\TestDevs\\MySeleniumAuto\\.idea\\drivers\\chromedriver.exe");
        WebDriver webDriver = new ChromeDriver();

        //等待5s ,抛出异常 查看源代码
        Thread.sleep(5000);

        //关闭当前浏览器窗口。
        //webDriver.close(); // 任务管理器的chromedriver.exe还在

        //完全退出浏览器
        webDriver.quit(); //用这个！！！
    }
}
