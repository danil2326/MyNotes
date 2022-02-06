package ru.gb.course1.mynotes.ui.details;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import ru.gb.course1.mynotes.App;
import ru.gb.course1.mynotes.R;
import ru.gb.course1.mynotes.domain.NoteEntity;

public class NotesDetailsFragment extends Fragment {
    private EditText textNotesView;

   // public static final String NOTES_EXTRA_KEY = "NOTES_EXTRA_KEY";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_notes, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
      //  App.get(this).getNotesRepo();
        textNotesView = view.findViewById(R.id.text_notes_view);
        //NoteEntity noteEntity = getIntent().getParcelableExtra(NOTES_EXTRA_KEY);
       // textNotesView.setText(noteEntity.getText());
    }
}
