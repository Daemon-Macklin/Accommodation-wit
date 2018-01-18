import org.junit.Before;
import org.junit.After;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test for Room Class
 *
 * @author Daemon-Macklin
 *
 */

public class RoomTest {

    private Room room1;
    private Room roomInvalid;


    /**
     * Set up test fixtures
     *
     * Called before every test method
     */
    @Before
    public void setUp() {

        room1 = new Room(1, true, 1, 1);
        roomInvalid = new Room(8, false, 2, 2);
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
        assertNotNull(room1); //will test these in testGetters()
        assertEquals(1, roomInvalid.getLevel());
    }

    /**
     * Test all getters using valid data
     */
    @Test
    public void testGetters() {
        assertEquals(1, room1.getProperty());
        assertEquals(1, room1.getId());
        assertEquals(true, room1.isEnSuit());
        assertEquals(1, room1.getLevel());
    }

    /**
     * Test all setters for Room
     */
    @Test
    public void testSetters() {
        room1.setLevel(2); //Valid change
        assertEquals(2, room1.getLevel());
        room1.setLevel(6);
        assertEquals(1, room1.getLevel());
    }

    /**
     * Test the ToString Method for Room
     *
     */
    @Test
    public void testToString() {
        assertEquals(
            "Room: " + 1 + ", Level: " + 1
                + ", EnSuite: " + true + ", Property " + 1
                , room1.toString());

    }


}