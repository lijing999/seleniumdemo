package meyoung.day2;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by lijing on 2018/5/17.
 */
public class ActionsTest {

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
     * 点击百度首页的新闻链接
     */
    @Test
    public void ClickTest(){
        webDriver.get("https://www.baidu.com");
        WebElement newslink=webDriver.findElement(By.name("tj_trnews"));
        newslink.click();
        String url=webDriver.getCurrentUrl();
        Assert.assertEquals(url,"http://news.baidu.com/");
    }
    /**
     * 百度文本框输入关键字selenium，点击 百度一下搜索
     * 校验第一搜索结果显示“”
     */
    @Test
    public void sendKeysTest() throws InterruptedException {
        webDriver.get("https://www.baidu.com");
        WebElement keys=webDriver.findElement(By.id("kw"));
        keys.sendKeys("selenium");
        WebElement button=webDriver.findElement(By.id("su"));
        button.click();
        Thread.sleep(3000);
        //WebElement text=webDriver.findElement(By.xpath(".//*[@id='4001']/div[1]/h3/a[1]"));
        String title=webDriver.getTitle();
        Assert.assertEquals(title,"selenium_百度搜索");
    }

    /**
     * 判断按钮显示的文本值为 百度一下”
     */
    @Test
    public void getATest(){
        webDriver.get("https://www.baidu.com");
        String attributeValue=webDriver.findElement(By.id("su")).getAttribute("value");
        Assert.assertEquals(attributeValue,"百度一下");
    }
    /**
     * 截图  应用：跑多个脚本时，把当前页面失败的图截下来；
     */
    @Test
    public void screenShotFile() throws IOException {
        webDriver.get("https://www.baidu.com");
        File screenShotFile=((TakesScreenshot)webDriver).getScreenshotAs(OutputType.FILE);
        org.apache.commons.io.FileUtils.copyFile(screenShotFile,new File("D:/test.png"));
    }
    /**
     * 一个浏览器中打开两个窗口时，句柄转交；
     */
    @Test
    public void testWin() throws InterruptedException {
        webDriver.get("http://news.baidu.com/");
        webDriver.findElement(By.xpath(".//*[@id='pane-news']/div/ul/li[1]/strong/a")).click();
        Thread.sleep(3000);
        //获取当前页面的句柄值
        String handle1=webDriver.getWindowHandle();
        //控制权移交到第二个窗口
        //FOR循环判断 获取到的 handles是否等于handle1
        for(String handles:webDriver.getWindowHandles()){
            if(handles.equals(handle1)){
                continue; //本次循环结束，到下次循环。
            }else {
                webDriver.switchTo().window(handles);
            }
        }
        webDriver.findElement(By.xpath(".//*[@id='page_bottom']/div[2]/div[1]/a[1]")).click();
    }

    /**
     * 打开百度页面，右击按钮
     */
    @Test
    public void rightClickTest(){
        webDriver.get("http://wwww.baidu.com/");
        WebElement buttonBaidu=webDriver.findElement(By.id("su"));
//       实例化actions
        Actions actions=new Actions(webDriver);
        actions.contextClick(buttonBaidu).perform();
    }

    /**
     * 下拉框多选
     */
    @Test
    public void selectTest(){
        webDriver.get("file:///E:/%E5%AD%A6%E4%B9%A0%E8%B5%84%E6%96%99/selenium+java%E8%87%AA%E5%8A%A8%E5%8C%96%EF%BC%88%E6%9C%80%E6%96%B0%EF%BC%89/%E6%BA%90%E7%A0%81/webdriver_demo/selenium_html/index.html");
       WebElement element=webDriver.findElement(By.xpath(".//*[@id='selectWithMultipleEqualsMultiple']"));
        List<WebElement>list=webDriver.findElements(By.xpath(".//*[@id='selectWithMultipleEqualsMultiple']/option"));
        Actions actions=new Actions(webDriver);
        actions.keyDown(Keys.SHIFT).
                click(list.get(0)).
                click(list.get(2)).
                keyUp(Keys.SHIFT).perform();

    }

    /**
     * ctrl+s保存html页面
     */
    @Test
    public void saveHtmlTest() throws AWTException, InterruptedException {
        webDriver.get("file:///E:/%E5%AD%A6%E4%B9%A0%E8%B5%84%E6%96%99/selenium+java%E8%87%AA%E5%8A%A8%E5%8C%96%EF%BC%88%E6%9C%80%E6%96%B0%EF%BC%89/%E6%BA%90%E7%A0%81/webdriver_demo/selenium_html/index.html");
        Robot robot=new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_S);
        Thread.sleep(2000);
        robot.keyPress(KeyEvent.VK_ENTER);
        //按键释放掉
        robot.keyRelease(KeyEvent.VK_CONTROL);
    }




    /**
     * 把关闭浏览器的方法抽取出来
     */
    @AfterMethod
    public  void closedBrowser() throws InterruptedException {
        Thread.sleep(3000);
        webDriver.quit();
    }
}



