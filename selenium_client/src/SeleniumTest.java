
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
 
public class SeleniumTest {
 
    
 
    
    //WebDriver
    private WebDriver driver;
    private WebElement webElement;
    //Properties
    public static final String WEB_DRIVER_ID = "webdriver.chrome.driver";
    public static final String WEB_DRIVER_PATH = "C:\\JAVA_SPRING\\program\\selenium-server\\chromedriver.exe";
    //크롤링 할 URL
    private String daum_url;
    private String naver_url;
    
    
    public SeleniumTest() {
        super();
 
        //System Property SetUp
        System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);
        
                
        //Driver SetUp
         ChromeOptions options = new ChromeOptions();
         options.setCapability("ignoreProtectedModeSettings", true);
         driver = new ChromeDriver(options);
         daum_url = "https://www.daum.net";
         naver_url = "https://www.naver.com";
        
        
        
    }
    public static void main(String[] args) {
    	 
        SeleniumTest selTest = new SeleniumTest();
        //selTest.daum_login();
        selTest.naver_login();
    }
    public void daum_login() {
        try {
            //get page (= 브라우저에서 url을 주소창에 넣은 후 request 한 것과 같다)
            driver.get(daum_url);
            driver.findElement(By.cssSelector("#inner_login > a:nth-child(1)")).click();
            //iframe으로 구성된 곳은 해당 프레임으로 전환시킨다.
            //driver.switchTo().frame(driver.findElement(By.id("loginForm")));
            //iframe 내부에서 id 필드 탐색
            webElement = driver.findElement(By.id("id"));
            String daum_id ="아이디";
            webElement.sendKeys(daum_id);
             webElement = driver.findElement(By.id("inputPwd"));
            String daum_pw ="패쓰워드";
            webElement.sendKeys(daum_pw);
            //로그인 버튼 클릭
            webElement = driver.findElement(By.id("loginBtn"));
            webElement.click();
            Thread.sleep(20000);
        } catch (Exception e) {
            
            e.printStackTrace();
        
        } finally {
 
            driver.close();
        }
    }
    public void naver_login() {
		try {
			//get방식으로 url 요청
			driver.get(naver_url);
			//로그인 버튼 클릭
			webElement = driver.findElement(By.className("lg_local_btn"));
			webElement.click();
			//아이디 입력
			webElement = driver.findElement(By.id("id"));Thread.sleep(500);
			webElement.sendKeys("아이디입력");
			
			//패스워드 입력
			webElement = driver.findElement(By.id("pw"));
			webElement.sendKeys("비밀번호 입력");
			
			//전송
			webElement = driver.findElement(By.className("btn_global"));
			webElement.submit();
			
			Thread.sleep(10000);
	
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			driver.close();
		}
 
	}
}