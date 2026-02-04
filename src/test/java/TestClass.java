import java.io.IOException;
import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.baseClass.BaseClass;

public class TestClass extends BaseClass {

	@BeforeClass
	public static void BeforeClass() {
		chromeBrowser(10);
		getURL("https://www.facebook.com/");
	}
	
	@AfterClass
	public static void AfterClass() {
		quit();
	}
	
	@Before
	public void Before() {
		Date d=new Date();
		System.out.println("Start Ttime is: "+d);
	}
	
	@After
	public void After() throws IOException {
		
		screenShot(getTitle());
		
		Date d=new Date();
		System.out.println("End Ttime is: "+d);
		
	}
	
	@Test
	public void test() {
		System.out.println("Test Complete");

	}
	
}
