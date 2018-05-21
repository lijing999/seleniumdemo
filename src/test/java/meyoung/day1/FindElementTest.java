package meyoung.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by lijing on 2018/5/16.
 */
public class FindElementTest {

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
     * 打开百度首页
     * 通过ID定位 搜索 文本框
     */
    @Test
    public void byIDTest(){
        webDriver.get("https://www.baidu.com");
        WebElement keyField =  webDriver.findElement(By.id("kw"));

    }

    /**
     * 打开百度首页
     * 通过name定位 搜索 文本框
     */
    @Test
    public void byNameDTest(){
        webDriver.get("https://www.baidu.com");
        WebElement keyField =  webDriver.findElement(By.name("wd"));

    }

    /**
     * 打开百度首页
     * 通过LinkText定位 搜索 文本框
     */
    @Test
    public void byLinkTextTest(){
        webDriver.get("https://www.baidu.com");
        WebElement keyField =  webDriver.findElement(By.linkText("新闻"));

    }

    /**
     * 打开百度首页
     * 通过LinkText定位 搜索 文本框
     */
    @Test
    public void byTagNameTest(){
        webDriver.get("https://www.baidu.com");
        List<WebElement> list =  webDriver.findElements(By.tagName("input"));
        System.out.println(list.size());
    }
    /**
     * 打开百度首页
     * 通过xpath定位 按钮
     */
    @Test
    public void byXpathTest(){
        webDriver.get("https://www.baidu.com");
        WebElement el =  webDriver.findElement(By.xpath(".//*[@id='su']"));

    }

    /**
     * 打开百度首页
     * 通过xpath定位 多个元素
     */
    @Test
    public void byXpathTest1(){
        webDriver.get("https://www.baidu.com");
        List<WebElement> list1 =  webDriver.findElements(By.xpath(".//*[@id='u1']/a"));
        for (int i=0;i<list1.size();i++){
            String text=list1.get(i).getText();
            System.out.println(text);
        }
    }



    @AfterMethod
    public void closeBrowser(){
        webDriver.quit();
    }
}
