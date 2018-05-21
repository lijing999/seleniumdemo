package meyoung.day3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by lijing on 2018/5/18.
 */
public class Register163 {

    WebDriver Driver;

    /**
     * 打开chrome浏览器
     */
    @BeforeMethod
    public void openChrome(){
        //设置chromedrvier路径，实例化chromedriver
        System.setProperty("webdriver.chrome.driver","E:\\TestDevs\\MySeleniumAuto\\.idea\\drivers\\chromedriver.exe");
        Driver = new ChromeDriver();
        Driver.get("https://mail.163.com/");
    }
    @Test
    public void ToRegister(){
        // 控制权转交给iframe
        Driver.switchTo().frame("x-URS-iframe");
        // 点击 去注册
       // Driver.findElement(By.id("changepage"));
        Driver.findElement(By.xpath(".//*[@id='changepage']"));
    }

    @Test
    public void registerTest(){
        // 控制权转交给iframe
        Driver.switchTo().frame("x-URS-iframe");
        // 点击 去注册
        Driver.findElement(By.xpath(".//*[@id='changepage']")).click();

        // 获取当前driver所在的handle
        String handle1=Driver.getWindowHandle();
        //driver切换到新的window
        for (String handles:Driver.getWindowHandles()){
            if(handles.equals(handle1)){
                continue;
            }
            Driver.switchTo().window(handles);

        }
       ;
        /**
         * 构造测试数据：保证邮箱没被注册过
         */
        String time = String.valueOf(System.currentTimeMillis()); // 时间戳：19700101000000每秒+1

        // 时间戳作为参数传给邮箱输入框
        Driver.findElement(By.id("nameIpt")).sendKeys(time);
        Driver.findElement(By.id("mainPwdIpt")).sendKeys("abccd556666123");
        Driver.findElement(By.id("mainCfmPwdIpt")).sendKeys("abccd556666123");
        Driver.findElement(By.id("mainMobileIpt")).sendKeys("13191976053");

        //验证码图片
        /**解决办法：
         * 开发给你一个万能验证码 （最后的方法）
         * 先干掉验证码功能（校验规则取消）
         * 解析识别图片验证码
         */
        Driver.findElement(By.id("vcodeIpt")).sendKeys("123");
        Driver.findElement(By.id("mainAcodeIpt")).sendKeys("1234");
        Driver.findElement(By.id("mainRegA")).click();

        String error= Driver.findElement(By.xpath("//*[@id=\"m_mainAcode\"]/span")).getText();
        Assert.assertEquals(error,"  手机验证码不正确，请重新填写");

    }
    @AfterMethod
    public void closeBrowser(){

        Driver.quit();
    }

}
