import org.junit.Before;
import org.junit.After;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test for Student Class
 *
 * @author Daemon-Macklin
 *
 */

public class StudentTest {

    private Student stud1;
    private Student studInvalid;


    /**
     * Set up test fixtures
     *
     * Called before every test method
     */
    @Before
    public void setUp() {

        stud1 = new Student("John Doe", "M", false, 1);
        studInvalid = new Student("Valid name is 30 chars to hereANYTHINGAFTERTHEREISTOOLONG", "k", false, 2);
    }

    /**
     * Teardown test fixtures
     *
     * Called after each test method
     */
    @After
    public void tearDown() {

    }

    /**
     * Test the contsructor
     */
    @Test
    public void testConstructor() {
        assertNotNull(stud1); //will test these in testGetters()
        assertEquals("Valid name is 30 chars to here", studInvalid.getName());
        assertEquals("Unspecified", studInvalid.getGender());
    }

    /**
     * Test all getters using valid data
     */
    @Test
    public void testGetters() {
        assertEquals("John Doe", stud1.getName());
        assertEquals("M", stud1.getGender());
    }

    /**
     * Test all setters for Student
     */
    @Test
    public void testSetters() {
        stud1.setName("Jane Soap");
        assertEquals("Jane Soap", stud1.getName());
        stud1.setName("This name is far too long for the validation rules");
        assertEquals("Jane Soap", stud1.getName());


        assertEquals("M", stud1.getGender());
        stud1.setGender("anythinginvalid");
        assertEquals("M", stud1.getGender());

    }

    /**
     * Test the ToString Method for Student
     *
     */
    @Test
    public void testToString() {
        assertEquals(
            "Name: " + "John Doe" + " Gender: " + "M" + " Car: "
                + false, stud1.toString());

    }


}