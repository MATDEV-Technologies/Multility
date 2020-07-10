// This is for local unit-testing with JUnit

package com.matdevtech.multility;

 // Imports
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    // Basic assertion system check with addition
    // More tests can be added by the host developer
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }
}