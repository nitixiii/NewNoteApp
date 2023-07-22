package ch.fni.newnoteapp.models;

import static org.junit.Assert.*;

import android.net.Uri;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * JUnit Test for Note.class
 * @author Niti Kohli
 * @version 0.0.1
 * @since version 0.0.1
 */
@RunWith(RobolectricTestRunner.class)
public class NoteTest {
    private Note note1;
    private Note note2;
    private Note note3;
    private Note note4;
    private Note note5;
    private Note note6;
    private Note note7;
    private Note note8;
    private final String author2 = "author2";
    private final String title2 = "title2";
    private final String body2 = "content2";
    private final String author3 = "author3";
    private final String title3 = "title3";
    private final String body3 = "content3";
    Annex attachment3_1 = new Annex(FileType.PICTURE, Uri.parse("//content/picture/3/1/"));
    Annex attachment3_2 = new Annex(FileType.AUDIO, Uri.parse("//content/audio/3/2/"));
    Annex attachmentToAdd = new Annex(FileType.OTHER, Uri.parse("//content/other/"));
    private final List<Annex> attachments3 = new ArrayList<>(Arrays.asList(attachment3_1, attachment3_2));
    Tag tag3_1 = new Tag("Tag3_1");
    Tag tag3_2 = new Tag("Tag3_2");
    Tag tag3_3 = new Tag("Tag3_3");
    Tag tagToAdd = new Tag("Tag");
    private final List<Tag> tags3 = new ArrayList<>(Arrays.asList(tag3_1, tag3_2, tag3_3));


    @Before
    public void setUp() throws Exception {
        note1 = new Note();
        Thread.sleep(1);
        note2 = new Note(author2, title2, body2);
        Thread.sleep(1);
        note3 = new Note(author3, title3, body3, attachments3, tags3);
        Thread.sleep(1);
        note4 = new Note();
        note4.setTitle(title2);
        Thread.sleep(1);
        note5 = new Note();
        note5.setBody(body2);
        note6 = note3;
        Thread.sleep(1);
        note7 = new Note(note3);
        note7.setId(1);
        Thread.sleep(1);
        note8 = new Note();
    }

    @Test
    public void testToString() {
        assertEquals("<EMPTY NOTE>", note1.toString());
        assertEquals("title2: content2", note2.toString());
        assertEquals("title3: content3", note3.toString());
        assertEquals(title2, note4.toString());
        assertEquals(body2, note5.toString());
    }

    @Test
    public void testEquals() {
        assertFalse(note1.equals(note2));
        assertFalse(note2.equals(note3));
        assertFalse(note2.equals(note4));
        assertFalse(note2.equals(note5));
        assertFalse(note3.equals(note7));
        assertTrue(note3.equals(note6));

    }

    @Test
    public void testHashCode() {
        assertNotEquals(note1.hashCode(), note2.hashCode());
        assertNotEquals(note2.hashCode(), note3.hashCode());
        assertNotEquals(note2.hashCode(), note4.hashCode());
        assertNotEquals(note2.hashCode(), note5.hashCode());
        assertNotEquals(note3.hashCode(), note7.hashCode());
        assertEquals(note3.hashCode(), note6.hashCode());

    }

    @Test
    public void getAndSetId() {
        assertEquals(0,note1.getId());
        assertEquals(0,note3.getId());
        assertEquals(0,note6.getId());
        assertEquals(1, note7.getId());
    }

    @Test
    public void getCreateDateTime() {
        assertNotNull(note1.getCreateDateTime());
        assertNotNull(note2.getCreateDateTime());
        assertNotEquals(note1.getCreateDateTime(), note2.getCreateDateTime());
        assertEquals(note3.getCreateDateTime(), note6.getCreateDateTime());
        assertNotEquals(note3.getCreateDateTime(), note7.getCreateDateTime());
    }

    @Test
    public void getAndSetUpdateTime() {
        assertNotNull(note1.getUpdateDateTime());
        assertEquals(note7.getUpdateDateTime(), note7.getCreateDateTime());
        note7.setUpdateDateTimeNow();
        assertNotEquals(note7.getUpdateDateTime(), note7.getCreateDateTime());
    }

    @Test
    public void getAndSetAuthor() {
        assertEquals("", note1.getAuthor());
        assertEquals(author2, note2.getAuthor());
        note8.setAuthor("author8");
        assertEquals("author8", note8.getAuthor());
    }

    @Test
    public void getAndSetTitle() {
        assertEquals("", note1.getTitle());
        assertEquals(title2, note2.getTitle());
        note8.setTitle("title8");
        assertEquals("title8", note8.getTitle());
    }

    @Test
    public void getBody() {
        assertEquals("", note1.getBody());
        assertEquals(body2, note2.getBody());
        note8.setBody("content8");
        assertEquals("content8", note8.getBody());
    }

    @Test
    public void isAttachmentListEmpty() {
        assertTrue(note1.isAttachmentListEmpty());
        assertTrue(note2.isAttachmentListEmpty());
        assertFalse(note3.isAttachmentListEmpty());
        assertFalse(note6.isAttachmentListEmpty());
    }

    @Test
    public void isTagListEmpty() {
        assertTrue(note1.isTagListEmpty());
        assertTrue(note2.isTagListEmpty());
        assertFalse(note3.isTagListEmpty());
        assertFalse(note6.isTagListEmpty());
    }

    @Test
    public void containsAttachment() {
        assertFalse(note1.containsAttachment(attachment3_1));
        assertFalse(note2.containsAttachment(attachment3_1));
        assertTrue(note3.containsAttachment(attachment3_2));
        assertTrue(note6.containsAttachment(attachment3_2));
    }

    @Test
    public void containsTag() {
        assertFalse(note1.containsTag(tag3_1));
        assertFalse(note2.containsTag(tag3_1));
        assertTrue(note3.containsTag(tag3_2));
        assertTrue(note6.containsTag(tag3_3));
    }

    @Test
    public void addAttachment() {
        note8.addAttachment(attachmentToAdd);
        assertTrue(note8.containsAttachment(attachmentToAdd));

    }

    @Test
    public void addTag() {
        note8.addTag(tagToAdd);
        assertTrue(note8.containsTag(tagToAdd));
    }

    @Test
    public void removeAttachment() {
        note8.removeAttachment(attachmentToAdd);
        assertFalse(note8.containsAttachment(attachmentToAdd));
        assertTrue(note8.isAttachmentListEmpty());
    }

    @Test
    public void removeTag() {
        note8.removeTag(tagToAdd);
        assertFalse(note8.containsTag(tagToAdd));
        assertTrue(note8.isTagListEmpty());
    }
}