package xml;

import org.junit.Test;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.Assert.*;

public class XmlValidationTest {
    Path path = Paths.get("src/main/resources/file.xml");
    Path emptyContent = Paths.get("src/main/resources/EmptyFile.xml");
    Path testPath = Paths.get("src/main/resources/testFile.fxml");
    XmlValidation validation = new XmlValidation();

    @Test
    public void xmlFileExtensionCorrectness(){
        assertTrue(validation.xmlFileExtension(path));
        assertTrue(validation.xmlFileExtension(emptyContent));
        assertTrue(validation.xmlFileExtension(testPath));
    }

    @Test
    public void xmlFileHeaderShouldBeCorrect() throws IOException {
        assertTrue("Incorrect xml file header, expected '<?xml version='", validation.xmlFileInput(path));
        assertFalse("This file expected to have empty text", validation.xmlFileInput(emptyContent));
    }

    @Test
    public void xmlFileValidationOpenCloseParenthesis() throws IOException {
        assertTrue("All open/close parenthesis should be equal ", validation.xmlParenthesisCheck(path));
        assertFalse("Assert should return false because file doesn't have one close parenthesis", validation.xmlParenthesisCheck(testPath));
        assertFalse("Assert should return false because file has empty content", validation.xmlParenthesisCheck(emptyContent));
    }

}
