import org.junit.Before;
import org.junit.After;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test for Bed Class
 *
 * @author Daemon-Macklin
 *
 */

public class BedTest {

    private Bed bed1;
    private Bed bedInvalid;


    /**
     * Set up test fixtures
     *
     * Called before every test method
     */
    @Before
    public void setUp() {
        bed1 = new Bed(1, 0, 50, "Single", 1);
        bedInvalid = new Bed(2, 0, 1000, "Invalid", 2);
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
        assertNotNull(bed1); //will test these in testGetters()
        assertEquals(999, bedInvalid.getCost());
        assertEquals("Unspecified", bedInvalid.getType());
    }

    /**
     * Test all getters using valid data
     */
    @Test
    public void testGetters() {
        assertEquals(1, bed1.getId());
        assertEquals(0, bed1.getStudent());
        assertEquals(1, bed1.getRoomId());
        assertEquals(50, bed1.getCost());
        assertEquals("Single", bed1.getType());
    }

    /**
     * Test all setters for Bed
     */
    @Test
    public void testSetters() {
        bed1.setCost(65); //Valid change
        assertEquals(65, bed1.getCost());
        bed1.setCost(20000000);
        assertEquals(999, bed1.getCost());
    }

    /**
     * Test the ToString Method for Bed
     *
     */
    @Test
    public void testToString() {
        assertEquals(
                "ID; " + 1 + ", Cost: " + 50 +
                        " Type: " + "Single" + " Room: " + 1
                        + " Student " + 0
                , bed1.toString());

    }


}