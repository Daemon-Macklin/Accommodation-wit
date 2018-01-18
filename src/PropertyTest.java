import org.junit.Before;
import org.junit.After;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test for Property Class
 *
 * @author Daemon-Macklin
 *
 */

public class PropertyTest {

    private Property property1;
    private Property propertyInvalid;


    /**
     * Set up test fixtures
     *
     * Called before every test method
     */
    @Before
    public void setUp() {

        property1 = new Property("15 Cork Road", 2, 1.5, 1);
        propertyInvalid = new Property("can only be forty charachters after thisWILLBETOOLONG", 2, 150, 2);
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
        assertNotNull(property1); //will test these in testGetters()
        assertEquals(99, propertyInvalid.getDistanceWit(), .5);
    }

    /**
     * Test all getters using valid data
     */
    @Test
    public void testGetters() {
        assertEquals("15 Cork Road", property1.getAddress());
        assertEquals(1, property1.getId());
        assertEquals(2, property1.getParking());
        assertEquals(1.5, property1.getDistanceWit(), .5);
    }

    /**
     * Test all setters for Property
     */
    @Test
    public void testSetters() {
        property1.setDistanceWit(2); //Valid change
        assertEquals(2, property1.getDistanceWit(),.5);
        property1.setDistanceWit(20000000);
        assertEquals(99, property1.getDistanceWit(), .5);
    }

    /**
     * Test the ToString Method for Property
     *
     */
    @Test
    public void testToString() {
        assertEquals(
         "Address: " + "15 Cork Road" + " ID:" + 1
                + " Parking: " + 2 + "Distance: " + 1.5
                , property1.toString());

    }


}