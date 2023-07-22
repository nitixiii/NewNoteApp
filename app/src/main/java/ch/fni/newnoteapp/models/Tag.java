package ch.fni.newnoteapp.models;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

/**
 * Tag class. Tag are topics describing the note.
 * @author Niti Kohli
 * @version 0.0.1
 * @since version 0.0.1
 */
@Entity (tableName = "tags")
public class Tag {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @NonNull
    @ColumnInfo
    private String name;


    // --- CONSTRUCTOR(S) ---


    public Tag(@NonNull String name) {
        id = 0;
        this.name = name;
    }


    // --- OVERRIDE (FUNDAMENTALS) ---


    /**
     * Returns the name of the tag.
     * @return name (String)
     */
    @NonNull
    @Override
    public String toString() {
        return name;
    }


    /**
     * Compares the equality of the object id and content.
     * @param obj object to compare
     * @return true or false (boolean)
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) { return false; }

        if (obj.getClass() != this.getClass()) { return false; }

        final Tag other  = (Tag) obj;
        return Objects.equals(this.id, other.id)
                && Objects.equals(this.name, other.name);
    }

    /**
     * Creates a hashCode with prime numbers an the object content.
     * @return hashCode (int)
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.name.hashCode();
        hash = 53 * hash + id;
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
     * Returns the name of the object.
     * @return name (String)
     */
    @NonNull
    public String getName() {
        return name;
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
     * Sets the name of the object.
     * Note: Takes the first tag name if multiple tag names are available.
     * @param name Name of the object
     */
    public void setName(@NonNull String name) {
        String[] nameArray = name.trim().toUpperCase().split("[^A-Za-z0-9]+");
        this.name = new ArrayList<>(Arrays.asList(nameArray)).get(0);
    }


    // --- OTHER ---



}
// --- EOF ---