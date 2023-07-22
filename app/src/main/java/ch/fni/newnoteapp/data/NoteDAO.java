package ch.fni.newnoteapp.data;

import android.net.Uri;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import ch.fni.newnoteapp.models.Annex;
import ch.fni.newnoteapp.models.Note;
import ch.fni.newnoteapp.models.Tag;

/**
 * Note DAO (Data Access Object) Interface.
 * @author Niti Kohli
 * @version 0.0.1
 * @since version 0.0.1
 */
@Dao
public interface NoteDAO {

    // --- QUERIES ---


    @Query("SELECT * FROM notes")
    LiveData<List<Note>> getAllNotes();

    @Query("SELECT * FROM annex")
    LiveData<List<Annex>> getAllAttachments();

    @Query("SELECT * FROM tags")
    LiveData<List<Tag>> getAllTags();

    @Query("SELECT * FROM notes WHERE id = :id")
    Note getNoteById(int id);

    @Query("SELECT * FROM annex WHERE id = :id")
    Annex getAttachmentById(int id);

    @Query("SELECT * FROM tags WHERE id = :id")
    Tag getTagById(int id);

    @Query("SELECT * FROM notes WHERE author = :author")
    List<Note> getNotesByAuthor(String author);

    @Query("SELECT * FROM annex WHERE uri = :uri")
    List<Annex> getAttachmentByUri(Uri uri);

    @Query("SELECT * FROM notes WHERE author = :name")
    List<Note> getTagByName(String name);


    // --- INSERTS ---


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAllNotes(List<Note> notes);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertNote(Note note);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAllAttachments(List<Annex> attachments);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAttachment(Annex attachment);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAllTags(List<Tag> tags);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertTag(Tag tag);


    // --- UPDATE ---

    @Update
    void updateNotes(Note... note);


    // --- DELETE ---


    @Delete
    void deleteNote(Note note);

    @Query("DELETE FROM notes")
    void deleteAllNotes();

    @Delete
    void deleteAttachment(Annex attachment);

    @Query("DELETE FROM annex")
    void deleteAllAttachments();

    @Delete
    void deleteTag(Tag tag);

    @Query("DELETE FROM tags")
    void deleteAllTag();


}
// --- EOF ---