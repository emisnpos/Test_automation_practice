package alert;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class FileUploadTests extends BaseTests {

    @Test
    public void testFileUpload(){
        var uploadPage = homePage.clickFileUpload();
        uploadPage.uploadFile("/home/emis/Projects/sajat/TAU/Test_automation_practice/Selenium_webdriver_with_Java/resources/chromedriver");
        assertEquals(uploadPage.getUploadedFiles(),"chromedriver", "Upload files incorrect");
    }
}
