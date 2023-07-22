package ch.fni.newnoteapp.viewmodels;

import android.util.Log;

import androidx.lifecycle.ViewModel;

/**
 * Handles welcome screen
 */
public class WelcomeViewModel extends ViewModel {
    public final String TAG = "WelcomeViewModel";

    public WelcomeViewModel() {
        Log.d(TAG, "Initialize Welcome ViewModel");
    }
}
// --- EOF ---