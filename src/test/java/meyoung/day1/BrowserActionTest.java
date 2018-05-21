package meyoung.day1;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by lijing on 2018/5/16.
 */
public class BrowserActionTest {

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
     * 打开chrome浏览器
     * 打开 百度首页
     * 等待5s
     * 关闭浏览器
     */
    @Test
    public void getTest() throws InterruptedException {

        //打开百度页面
        webDriver.get("https://www.baidu.com");
        //webDriver.navigate().to(url);

        //等待5s
        Thread.sleep(5000);



    }


    /**
     * 打开chrome浏览器
     * 打开 百度首页
     * 等待3s
     * 后退
     * 等待3s
     * 关闭浏览器
     */
    @Test
    public void backTest() throws InterruptedException {


        //打开百度页面
        webDriver.get("https://www.baidu.com");
        //webDriver.navigate().to(url);

        //等待3s
        Thread.sleep(3000);

        //后退
        webDriver.navigate().back();

        //等待3s
        Thread.sleep(3000);



    }

    /**
     * 打开chrome浏览器
     * 打开 百度首页
     * 等待3s
     * 后退
     * 等待3s
     * 前进
     * 等待3s
     * 关闭浏览器
     */
    @Test
    public void forwardTest() throws InterruptedException {

        //打开百度页面
        webDriver.get("https://www.baidu.com");
        //webDriver.navigate().to(url);

        //等待3s
        Thread.sleep(3000);

        //后退
        webDriver.navigate().back();

        //等待3s
        Thread.sleep(3000);

        //前进
        webDriver.navigate().forward();

        //等待3s
        Thread.sleep(3000);



    }
    /**
     * 打开chrome浏览器
     * 设置窗口大小500×500
     * 等待3s
     * 最大化窗口
     * 等待3s
     * 关闭浏览器
     */

    @Test
    public void winTest() throws InterruptedException {

        Dimension dimension = new Dimension(500,500);
        webDriver.manage().window().setSize(dimension);

        //最大化浏览器
        Thread.sleep(3000);
        webDriver.manage().window().maximize();

        //等待3s
        Thread.sleep(3000);


    }

    /**
     * 打开chrome浏览器
     * 打开百度首页
     * 等待3s
     * 获取当前页面的url
     * 校验当前页面URL是不是百度地址
     * 等待3s
     * 关闭浏览器
     */

    @Test
    public void getURLTest() throws InterruptedException {

        webDriver.get("https://www.baidu.com");
        String url =  webDriver.getCurrentUrl();
        System.out.print("获取到的URL是："+ url);
        Assert.assertEquals(url,"https://www.baidu.com/");



    }

    /**
     * 把关闭浏览器的方法抽取出来
     */
    @AfterMethod
    public  void closedBrowser(){
        webDriver.quit();
    }

}
