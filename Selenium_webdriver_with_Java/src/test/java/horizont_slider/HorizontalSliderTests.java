package horizont_slider;

import base.BaseTests;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class HorizontalSliderTests extends BaseTests {


    @Test
    public void sliderEqualWithFourTest(){

        int range = 4 * 2;
        // slider 0.5 csuszik felfelé ezért 8 lépést kell megtennünk, hogy eljussunk a 4-ig

        var sliderPage = homePage.moveHorizontalSlider();
        for (int i = 0; i < range; i++) {
            sliderPage.moveSliderRange(Keys.ARROW_RIGHT);
        }
        assertEquals(sliderPage.getResult(), "4", "Slider value is incorrect");

    }
}
