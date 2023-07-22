package ch.fni.newnoteapp.data;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import ch.fni.newnoteapp.Utilities.Converters;
import ch.fni.newnoteapp.models.Annex;
import ch.fni.newnoteapp.models.Note;
import ch.fni.newnoteapp.models.Tag;

/**
 * Abstract Note Database class. Makes access to database possible.
 * @author Niti Kohli
 * @version 0.0.1
 * @since version 0.0.1
 */
@Database(entities = {Note.class, Annex.class, Tag.class}, version = 1, exportSchema = false)
@TypeConverters({Converters.class})
public abstract class NewNoteAppDB extends RoomDatabase {
    public abstract NoteDAO noteDAO();

    private static volatile NewNoteAppDB INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    public static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public static NewNoteAppDB getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (NewNoteAppDB.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            NewNoteAppDB.class, "note_database")
                            .addCallback(sRoomDatabaseCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    private static RoomDatabase.Callback sRoomDatabaseCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);

            // If you want to keep data through app restarts,
            // comment out the following block
            databaseWriteExecutor.execute(() -> {
                // Populate the database in the background.
                // If you want to start with more words, just add them.
                NoteDAO dao = INSTANCE.noteDAO();
                dao.deleteAllNotes();

                Note note = new Note("Johnny", "Note1", "Content1");
                dao.insertNote(note);
                note = new Note("Bella", "Note2", "Content2");
                dao.insertNote(note);
            });
        }
    };

}
// --- EOF ---