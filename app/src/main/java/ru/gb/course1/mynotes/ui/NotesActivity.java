package ru.gb.course1.mynotes.ui;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import ru.gb.course1.mynotes.App;
import ru.gb.course1.mynotes.R;
import ru.gb.course1.mynotes.domain.NoteEntity;
import ru.gb.course1.mynotes.domain.NotesRepository;

public class NotesActivity extends AppCompatActivity {
    private EditText textNotesView;

    public static final String NOTES_EXTRA_KEY = "NOTES_EXTRA_KEY";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);
        App.get(this).getNotesRepo();
        textNotesView = findViewById(R.id.text_notes_view);
        NoteEntity noteEntity = getIntent().getParcelableExtra(NOTES_EXTRA_KEY);
        textNotesView.setText(noteEntity.getText());

    }

}
