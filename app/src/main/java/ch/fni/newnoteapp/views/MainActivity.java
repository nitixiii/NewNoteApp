package ch.fni.newnoteapp.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import ch.fni.newnoteapp.R;
import ch.fni.newnoteapp.viewmodels.WelcomeViewModel;

/**
 * Main Activity class --> First Layout
 */
public class MainActivity extends AppCompatActivity {

    private final String TAG = "MainActivity";

    private WelcomeViewModel welcomeView;

    // --- LIFECYCLE ---
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        welcomeView = new WelcomeViewModel();
        Intent intent = new Intent(this, NoteActivity.class);
        startActivity(intent);
    }
}
// --- END OF FILE (EOF) ---