package meyoung.day3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.testng.annotations.Test;

/**
 * Created by lijing on 2018/5/18.
 * phantomjs不会打开浏览器页面，节约时间
 */
public class PhantomjsTest {
    @Test
    public void pjsTest() throws InterruptedException {
        System.setProperty("phantomjs.binary.path","E:\\TestDevs\\MySeleniumAuto\\.idea\\drivers\\phantomjs.exe");
        WebDriver driver=new PhantomJSDriver();
        driver.get("http://www.baidu.com");
        driver.findElement(By.id("kw")).sendKeys("phantomJS");
        Thread.sleep(5000);
        String a = driver.getTitle();
        System.out.println(a);
        driver.quit();
    }



}
