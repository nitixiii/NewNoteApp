package ch.fni.newnoteapp.viewmodels;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import ch.fni.newnoteapp.data.NoteRepository;
import ch.fni.newnoteapp.models.Note;

public class NoteViewModel extends AndroidViewModel {
    private NoteRepository mRepository;

    private final LiveData<List<Note>> mAllNotes;

    public NoteViewModel (Application application) {
     super(application);
     mRepository = new NoteRepository(application);
     mAllNotes = mRepository.getAllNotes();
    }

    public LiveData<List<Note>> getAllNotes() { return mAllNotes; }

    public void insertNote(Note note) { mRepository.insertNote(note); }
}
