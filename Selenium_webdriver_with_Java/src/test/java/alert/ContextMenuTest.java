package alert;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ContextMenuTest extends BaseTests {

    @Test
    public void testContextMenuPopUp(){
        var contextMenuPage = homePage.clickContextMenu();
        contextMenuPage.clickInputField();
        String text = contextMenuPage.getPopUpText();
        contextMenuPage.acceptPopUp();
        assertEquals(text, "You selected a context menu", "Results text incorrect");

    }
}
