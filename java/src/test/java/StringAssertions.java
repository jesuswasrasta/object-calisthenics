import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

/**
 * Custom assertion for text lines.
 * Just a dumb trick to avoid line endings test failures... 😅
 */
public class StringAssertions {
    public static void assertLinesEqual(String expectedString, String actualString){
        BufferedReader expectedLinesReader = new BufferedReader(new StringReader(expectedString));
        BufferedReader actualLinesReader = new BufferedReader(new StringReader(actualString));

        try {
            int lineNumber = 0;

            String actualLine;
            while((actualLine = actualLinesReader.readLine()) != null){
                String expectedLine = expectedLinesReader.readLine();
                assertEquals(expectedLine, actualLine, "Line " + lineNumber + " does not match" );
                lineNumber++;
            }

            if(expectedLinesReader.readLine() != null){
                fail("Actual string does not contain all expected lines");
            }
        } catch (IOException e) {
            fail(e.getMessage());
        } finally {
            try {
                expectedLinesReader.close();
            } catch (IOException e) {
                fail(e.getMessage());
            }
            try {
                actualLinesReader.close();
            } catch (IOException e) {
                fail(e.getMessage());
            }
        }
    }
}