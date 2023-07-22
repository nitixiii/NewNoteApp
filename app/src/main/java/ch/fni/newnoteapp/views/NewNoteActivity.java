package ch.fni.newnoteapp.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;

import ch.fni.newnoteapp.R;

public class NewNoteActivity extends AppCompatActivity {

    public static final String EXTRA_REPLY = "com.example.android.wordlistsql.REPLY";

    private EditText mEditTitleView;
    private EditText mEditContentView;
    private EditText mEditAuthorView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_note);
        mEditTitleView = findViewById(R.id.edit_title);
        mEditContentView = findViewById(R.id.edit_content);
        mEditAuthorView = findViewById(R.id.edit_author);

        final Button button = findViewById(R.id.button_save);
        button.setOnClickListener(view -> {
            Intent replyIntent = new Intent();
            if (TextUtils.isEmpty(mEditTitleView.getText())) {
                setResult(RESULT_CANCELED, replyIntent);
            } else {
                String title = mEditTitleView.getText().toString();
                // TODO: Content, title etc.
                replyIntent.putExtra(EXTRA_REPLY, title);
                setResult(RESULT_OK, replyIntent);
            }
            finish();
        });
    }
}