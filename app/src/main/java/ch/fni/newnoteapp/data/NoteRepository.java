package ch.fni.newnoteapp.data;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

import ch.fni.newnoteapp.models.Note;

public class NoteRepository {
    NoteDAO mNoteDao;
    private LiveData<List<Note>> mAllNotes;

    // Note that in order to unit test the WordRepository, you have to remove the Application
    // dependency. This adds complexity and much more code, and this sample is not about testing.
    // See the BasicSample in the android-architecture-components repository at
    // https://github.com/googlesamples
    public NoteRepository(Application application) {
        NewNoteAppDB db = NewNoteAppDB.getDatabase(application);
        mNoteDao = db.noteDAO();
        mAllNotes = mNoteDao.getAllNotes();
    }

    // Room executes all queries on a separate thread.
    // Observed LiveData will notify the observer when the data has changed.
    public LiveData<List<Note>> getAllNotes() {
        return mAllNotes;
    }

    // You must call this on a non-UI thread or your app will throw an exception. Room ensures
    // that you're not doing any long running operations on the main thread, blocking the UI.
    public void insertNote(Note note) {
        NewNoteAppDB.databaseWriteExecutor.execute(() -> {
            mNoteDao.insertNote(note);
        });
    }
}
