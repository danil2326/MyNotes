package ru.gb.course1.mynotes.ui.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.widget.Toast;

import ru.gb.course1.mynotes.R;
import ru.gb.course1.mynotes.domain.NoteEntity;
import ru.gb.course1.mynotes.ui.details.NotesDetailsFragment;

public class MainActivity extends AppCompatActivity  {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Fragment notesListFragment = new NotesListFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, notesListFragment).commit();
    }


}








