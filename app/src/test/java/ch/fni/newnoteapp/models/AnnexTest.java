package ch.fni.newnoteapp.models;

import static org.junit.Assert.*;

import android.net.Uri;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;

/**
 * JUnit Test for Annex.class
 * @author Niti Kohli
 * @version 0.0.1
 * @since version 0.0.1
 */

@RunWith(RobolectricTestRunner.class)
public class AnnexTest {
    String path1 = "//test/folder/1/";
    String path2 = "//test/folder/2/";

    private final Uri uri1 = Uri.parse(path1);
    private final Uri uri2 = Uri.parse(path2);

    private Annex annex1;
    private Annex annex2;
    private Annex annex3;
    private Annex annex4;
    private Annex annex5;
    private Annex annex6;
    private Annex annex7;
    @Before
    public void setUp() throws Exception {
        annex1 = new Annex();
        annex2 = new Annex(FileType.OTHER, uri1);
        annex3 = new Annex(FileType.PICTURE, uri1);
        annex4 = new Annex(FileType.AUDIO, uri2);
        annex5 = new Annex(FileType.PICTURE, uri2);
        annex6 = annex5;
        annex7 = new Annex(annex5);
        annex5.setId(1);
        annex5.setUri(uri1);
        annex7.setType(FileType.OTHER);
    }

    @Test
    public void testToString() {
        assertEquals(FileType.NONE, annex1.getType());
        assertEquals (path1, annex2.toString());
        assertEquals (path1, annex3.toString());
        assertEquals (FileType.AUDIO, annex4.getType());
    }

    @Test
    public void testEquals() {
        assertFalse(annex1.equals(annex2));
        assertFalse(annex2.equals(annex3));
        assertFalse(annex3.equals(annex4));
        assertFalse(annex4.equals(annex5));
        assertTrue(annex5.equals(annex6));
        assertFalse(annex5.equals(annex7));
    }

    @Test
    public void testHashCode() {
        assertNotEquals(annex1.hashCode(), annex2.hashCode());
        assertNotEquals(annex2.hashCode(), annex3.hashCode());
        assertNotEquals(annex3.hashCode(), annex4.hashCode());
        assertNotEquals(annex4.hashCode(), annex5.hashCode());
        assertEquals(annex5.hashCode(), annex6.hashCode());
        assertNotEquals(annex5.hashCode(), annex7.hashCode());
    }

    @Test
    public void getAndSetId() {
        assertEquals(0,annex2.getId());
        annex2.setId(4);
        assertEquals(4, annex2.getId());
        assertEquals(annex5.getId(), annex6.getId());
        assertNotEquals(annex5.getId(), annex7.getId());
    }

    @Test
    public void getAndSetType() {
        assertEquals(FileType.OTHER,annex2.getType());
        annex2.setType(FileType.PICTURE);
        assertEquals(FileType.PICTURE,annex2.getType());
        assertNotEquals(annex7.getType(), annex5.getType());
    }

    @Test
    public void getAndSetUri() {
        assertEquals(uri1, annex2.getUri());
        annex2.setUri(uri2);
        assertEquals(uri2, annex2.getUri());
        assertNotEquals(annex7.getUri(), annex5.getUri());
    }

    @Test
    public void isEmpty() {
        assertTrue(annex1.isEmpty());
        assertFalse(annex2.isEmpty());
    }

    @Test
    public void hasUri() {
        assertFalse(annex1.hasUri());
        assertTrue(annex2.hasUri());
    }
}