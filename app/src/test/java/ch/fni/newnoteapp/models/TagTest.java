package ch.fni.newnoteapp.models;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * JUnit Test for Tag.class
 * @author Niti Kohli
 * @version 0.0.1
 * @since version 0.0.1
 */
@RunWith(JUnit4.class)
public class TagTest {

    private final Tag tag1 = new Tag("TAG1");
    private final Tag tag2 = new Tag("Tag2");
    private final Tag tag1_copy = new Tag("Tag1");
    private Tag tag1_clone;
    private Tag tag3 = new Tag("TAG3");
    private Tag tag4 = new Tag("  TAG4 ");

    @Before
    public void setUp() throws Exception {
        tag1.setId(1);
        tag2.setId(2);
        tag1_copy.setId(3);
        tag1_clone = tag1;
        tag3.setId(4);
    }

    @Test
    public void testToString() {
        assertEquals("TAG1", tag1.toString());
        assertEquals("TAG1", tag1_copy.toString());
        assertEquals("TAG1", tag1_clone.toString());
        assertEquals("TAG2", tag2.toString());
    }

    @Test
    public void testEquals() {
        assertTrue(tag1.equals(tag1));
        assertFalse(tag1.equals(tag2));
        assertFalse(tag1.equals(tag1_copy));
        assertTrue(tag1.equals(tag1_clone));
    }

    @Test
    public void testHashCode() {
        assertTrue(tag1.hashCode() == tag1.hashCode());
        assertFalse(tag1.hashCode() == tag1_copy.hashCode());
        assertTrue(tag1.hashCode() == tag1_clone.hashCode());
        assertFalse(tag1.hashCode() == tag2.hashCode());
    }

    @Test
    public void getId() {
        assertEquals(4, tag3.getId());
    }

    @Test
    public void getName() {
        assertEquals("TAG1", tag1.getName());
        assertEquals("TAG1", tag1_copy.getName());
        assertEquals("TAG1", tag1_clone.getName());
        assertEquals("TAG2", tag2.getName());
        assertEquals("TAG4", tag4.getName());
    }

    @Test
    public void setId() {
        tag3.setId(10);
        assertEquals(10, tag3.getId());
    }

    @Test
    public void setName() {
        tag3.setName("Test");
        tag4.setName("  TAG      TEST  ");
        assertEquals("TEST", tag3.getName());
        assertEquals("TAG", tag4.getName());
    }
}