package meyoung.day1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

/**
 * Created by lijing on 2018/5/15.
 */
public class OpenBrowserTest {

    //selenium默认有firefox driver
    @Test
    public void oepnFF(){
        //WebDriver webDriver = new FirefoxDriver(); //必须是火狐浏览器默认安装在C:\Program Files (x86)
    }

    @Test
    public void oepnFF2(){

        System.setProperty("webdriver.firefox.bin","C:\\Program Files\\Mozilla Firefox\\firefox.exe");
        WebDriver webDriver = new FirefoxDriver();

    }

    //启动chrome浏览器，需要下载chromedriver
    @Test
    public void openChrome(){
        System.setProperty("webdriver.chrome.driver","E:\\TestDevs\\MySeleniumAuto\\.idea\\drivers\\chromedriver.exe");
        WebDriver webDriver = new ChromeDriver();
    }

    //启动IE浏览器，下载IEdriver
    @Test
    public void openIE(){
        System.setProperty("webdriver.ie.driver","E:\\TestDevs\\MySeleniumAuto\\.idea\\drivers\\IEDriverServer.exe");
        WebDriver webDriver=new InternetExplorerDriver();
    }

}
