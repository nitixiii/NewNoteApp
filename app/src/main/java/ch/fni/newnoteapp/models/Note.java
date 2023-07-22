package ch.fni.newnoteapp.models;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Note class. Contains tags and attachments.
 * @author Niti Kohli
 * @version 0.0.1
 * @since version 0.0.1
 */
@Entity (tableName = "notes")
public class Note {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo
    private LocalDateTime createDateTime;
    @ColumnInfo
    private LocalDateTime updateDateTime;
    @ColumnInfo
    private String author;
    @ColumnInfo
    private String title;
    @ColumnInfo
    private String body;
    @Ignore
    private List<Annex> attachments;
    @Ignore
    private List<Tag> tags;


    // --- CONSTRUCTOR(S) ---


    /**
     * The empty constructor of the note object.
     */
    @Ignore
    public Note(){
        id = 0;
        createDateTime = LocalDateTime.now();
        updateDateTime = createDateTime;
        author = "";
        title = "";
        body = "";
        attachments = new ArrayList<>();
        tags = new ArrayList<>();
    }

    /**
     * The copy constructor of a note object.
     * @param note The note object to copy
     */
    @Ignore
    public Note(Note note){
        id = 0;
        createDateTime = LocalDateTime.now();
        updateDateTime = createDateTime;
        author = note.getAuthor();
        title = note.getTitle();
        body = note.getBody();
        attachments = note.getAttachments();
        tags = note.getTags();
    }

    /**
     * Parameterized constructor of the note object (without attachment and/or tags).
     * @param author Authors name of the note
     * @param title Title of the note
     * @param body Main text content of the note
     */
    public Note(String author, String title, String body) {
        id = 0;
        createDateTime = LocalDateTime.now();
        updateDateTime = createDateTime;
        this.author = author;
        this.title = title;
        this.body = body;
        attachments = new ArrayList<>();
        tags = new ArrayList<>();
    }

    /**
     * Parameterized constructor of the note object (attachments and/or tags can be empty/null).
     * @param author Authors name of the note
     * @param title Title of the note
     * @param body Main text content of the note
     * @param attachments Attachment list (or null)
     * @param tags Tags list (or null)
     */
    @Ignore
    public Note(String author, String title, String body, List<Annex> attachments, List<Tag> tags) {
        id = 0;
        createDateTime = LocalDateTime.now();
        updateDateTime = createDateTime;
        this.author = author;
        this.title = title;
        this.body = body;
        this.attachments = attachments == null ? new ArrayList<>() : attachments;
        this.tags = tags == null ? new ArrayList<>() : tags;
    }


    // --- OVERRIDE (FUNDAMENTALS) ---


    /**
     * Returns the title and/or content of the note if available.
     * @return name (String)
     */
    @NonNull
    @Override
    public String toString() {
        if (title.isEmpty() && body.isEmpty()) { return "<EMPTY NOTE>"; }
        else if (title.isEmpty()) { return body; }
        else if (body.isEmpty()) { return title; }
        else { return title + ": " + body; }
    }

    /**
     * Compares the equality of object id and content.
     * @param obj object to compare
     * @return true or false (boolean)
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) { return false; }

        if (obj.getClass() != this.getClass()) { return false; }

        final Note other  = (Note) obj;
        return Objects.equals(this.createDateTime, other.createDateTime)
                && Objects.equals(this.updateDateTime, other.updateDateTime)
                && Objects.equals(this.id, other.id)
                && Objects.equals(this.author, other.author)
                && Objects.equals(this.title, other.title)
                && Objects.equals(this.body, other.body)
                && Objects.equals(this.attachments, other.attachments)
                && Objects.equals(this.tags, other.tags);
    }

    /**
     * Creates a hashCode with prime numbers an the object content.
     * @return hashCode (int)
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + (this.title != null ? this.title.hashCode() : 0);
        hash = 53 * hash + (this.body != null ? this.body.hashCode() : 0);
        hash = 53 * hash + (this.author != null ? this.author.hashCode() : 0);
        hash = 53 * hash + (this.createDateTime.getNano());
        hash = 53 * hash + this.id;
        return hash;
    }


    // --- GETTER ---


    /**
     * Returns the id of the object.
     * Note: When an object is created, the 'id' is 0 until the object is added to the database.
     * @return id (int)
     */
    public int getId() {
        return id;
    }

    /**
     * Returns the date when the note was created.
     * @return Create Date Time (LocalDateTime)
     */
    public LocalDateTime getCreateDateTime() {
        return createDateTime;
    }

    /**
     * Returns the date when the note was last updated.
     * @return Update Time Date (LocaleDateTime)
     */
    public LocalDateTime getUpdateDateTime() {
        return updateDateTime;
    }

    /**
     * Returns the authors name of the note.
     * @return author (String)
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Returns the title of the note.
     * @return title (String)
     */
    public String getTitle() {
        return title;
    }

    /**
     * Returns the body (main text content) of the note.
     * @return text (String)
     */
    public String getBody() {
        return body;
    }

    /**
     * Returns the attachments list (empty list if no attachments)
     * @return Attachments List (List&lt;Annex&gt;)
     */
    public List<Annex> getAttachments() { return attachments; }

    /**
     * Returns the tag list (empty list if no tags)
     * @return Tags list (List&lt;Tags&gt;)
     */
    public List<Tag> getTags() { return tags; }


    // --- SETTER ---


    /**
     * Sets the 'id' of the note.
     * @param id Id of the note
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Sets the creation date and time of the note for a given date and time.
     * @param createDateTime Creation date and time of the note
     */
    public void setCreateDateTime(LocalDateTime createDateTime) {
        this.createDateTime = createDateTime;
    }

    /**
     * Sets the current creation date and time of the note.
     */
    public void setCreateDateTimeNow() {
        this.createDateTime = LocalDateTime.now();
    }

    /**
     * Sets the update date and time of the object of given date and time.
     * @param updateDateTime Date and Time of update
     */
    public void setUpdateDateTime(LocalDateTime updateDateTime) {
        this.updateDateTime = updateDateTime;
    }

    /**
     * Sets the update date and time of the object.
     */
    public void setUpdateDateTimeNow() {
        this.updateDateTime = LocalDateTime.now();
    }

    /**
     * Sets the authors name.
     * @param author name of the author of the note.
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * Sets the title of the note.
     * @param title Title of the note
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Sets the body (main text content) of the note.
     * @param body main text content of the note.
     */
    public void setBody(String body) {
        this.body = body;
    }

    /**
     * Sets the attachment list.
     * @param attachments A list of attachments
     */
    public void setAttachments(List<Annex> attachments) { this.attachments = attachments; }

    /**
     * Sets the tags list.
     * @param tags A list of tags
     */
    public void setTags(List<Tag> tags) { this.tags = tags; }


    // --- OTHER (COMPARE LISTS)---


    /**
     * Checks the size of the attachment list.
     * @return true or false if list is empty
     */
    public boolean isAttachmentListEmpty() { return attachments.isEmpty(); }

    /**
     * Checks the size of the attachment list.
     * @return true or false if list is empty
     */
    public boolean isTagListEmpty() { return tags.isEmpty(); }

    /**
     * Checks if attachments list contains the attachment.
     * @param attachment Attachment to compare
     * @return True or false. The result of the search
     */
    public boolean containsAttachment(Annex attachment) { return attachments.contains(attachment); }

    /**
     * Checks if tags list contains the tag.
     * @param tag Tag to compare
     * @return True or false. The result of the search
     */
    public boolean containsTag(Tag tag) { return tags.contains(tag); }

    // --- OTHER (HANDLE LISTS)---

    /**
     * Adds an attachment to the attachments list.
     * @param attachment The attachment to add
     */
    public void addAttachment(Annex attachment) { attachments.add(attachment); }

    /**
     * Adds a tag to the tags list.
     * @param tag The tag to add
     */
    public void addTag(Tag tag) { tags.add(tag); }

    /**
     * Removes the attachment from the attachments list.
     * @param attachment The attachment to remove
     */
    public void removeAttachment(Annex attachment) { attachments.remove(attachment); }

    /**
     * Removes the tag from the tags list.
     * @param tag The tag to remove
     */
    public void removeTag(Tag tag) { tags.remove(tag); }


    // --- OTHER ---



}
// --- EOF ---