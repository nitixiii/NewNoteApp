package ch.fni.newnoteapp.models;

import android.net.Uri;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.util.Objects;

/**
 * Annex class. Contains an Uri to attachment files of notes.
 * @author Niti Kohli
 * @version 0.0.1
 * @since version 0.0.1
 */
@Entity (tableName = "annex")
public class Annex {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @NonNull
    @ColumnInfo
    private Enum<FileType> type;
    @ColumnInfo
    private Uri uri;


    // --- CONSTRUCTOR(S) ---


    /**
     * The empty constructor of the attachment object.
     */
    @Ignore
    public Annex() {
        id = 0;
        type = FileType.NONE;
    }

    /**
     * The copy constructor of the attachment object.
     * @param attachment The attachment object to copy
     */
    @Ignore
    public Annex(Annex attachment) {
        id = 0;
        type = attachment.getType();
        uri = attachment.getUri();
    }

    /**
     * Parameterized constructor of the attachment object.
     * @param type File type of the file at uri destination (Enum)
     * @param uri File path
     */
    public Annex(@NonNull Enum<FileType> type, Uri uri) {
        id = 0;
        this.type = type;
        this.uri = uri;
    }


    // --- OVERRIDE (FUNDAMENTALS) ---


    /**
     * Returns the uri of the attachment as string.
     * @return uri (String)
     */
    @NonNull
    @Override
    public String toString() {
        return uri.toString();
    }

    /**
     * Compares the equality of object type, content and id.
     * @param obj object to compare
     * @return true or false (boolean)
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) { return false; }

        if (obj.getClass() != this.getClass()) { return false; }

        final Annex other  = (Annex) obj;
        return Objects.equals(this.id, other.id)
                && Objects.equals(this.type, other.type)
                && Objects.equals(this.uri, other.uri);
    }

    /**
     * Creates a hashCode with prime numbers an the object content.
     * @return hashCode (int)
     */
    @Override
    public int hashCode() {
        int hash = 13;
        hash = 53 * hash + (this.uri != null ? this.uri.hashCode() : 0);
        hash = 53 * hash + this.type.hashCode();
        hash = 53 * hash + id;
        return hash;
    }


    // --- GETTER ---


    /**
     * Returns the id of the object.
     * @return id (int)
     */
    public int getId() {
        return id;
    }

    /**
     * Returns the file type of the uri destination.
     * @return type (FileType)
     */
    @NonNull
    public Enum<FileType> getType() {
        return type;
    }

    /**
     * Returns the uri of the file.
     * @return uri (Uri)
     */
    public Uri getUri() {
        return uri;
    }


    // --- SETTER ---


    /**
     * Sets the id of the object.
     * @param id Id of the object
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Sets the (file) type of the uri destination.
     * @param type Type of file
     */
    public void setType(@NonNull Enum<FileType> type) {
        this.type = type;
    }

    /**
     * Sets the uri of the file.
     * @param uri Uri of file
     */
    public void setUri(Uri uri) {
        this.uri = uri;
    }


    // --- OTHER ---


    /**
     * Returns true if FileType is FileType.NONE.
     * @return true or false
     */
    public boolean isEmpty() {
        return type == FileType.NONE;
    }

    /**
     * Returns true when object points to an uri
     * @return uri of file
     */
    public boolean hasUri() {
        return !isEmpty() && uri != null;
    }

}
// --- EOF ---