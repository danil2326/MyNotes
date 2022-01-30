package ru.gb.course1.mynotes.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import ru.gb.course1.mynotes.App;
import ru.gb.course1.mynotes.domain.NoteEntity;
import ru.gb.course1.mynotes.R;
import ru.gb.course1.mynotes.domain.NotesRepository;

public class MainActivity extends AppCompatActivity  {
    private RecyclerView recyclerView;
    private NoteAdapter adapter;
    private NotesRepository notesRepository;
    private NoteEntity noteEntity;
    private Button addNoteButton;
    private Button saveNote;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        notesRepository = App.get(this).getNotesRepo();
        initNote();



    }

    private void initNote() {
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new NoteAdapter();
        recyclerView.setAdapter(adapter);
        adapter.setData(notesRepository.getNotes());
        addNoteButton = findViewById(R.id.add_note_button);
        addNoteButton.setOnClickListener(v -> {
            notesRepository.addNotes();
            adapter.setData(notesRepository.getNotes());


        });
        saveNote = findViewById(R.id.save_button);
        adapter.setOnNoteSaveListener(noteEntity -> {
            savedNotes(noteEntity);
        });

        adapter.setOnDeletClickListener(noteEntity -> {
            deleteNotes(noteEntity);

        });
        adapter.setOnNoteDoubleListener(noteEntity -> {
            onClickDoubleView(noteEntity);
        });


    }


    private void onClickDoubleView(NoteEntity noteEntity) {
        Intent intent = new Intent(this, NotesActivity.class);
        intent.putExtra(NotesActivity.NOTES_EXTRA_KEY, noteEntity);
        startActivity(intent);
    }

    private void deleteNotes(NoteEntity noteEntity) {
        notesRepository.deleteNotes(noteEntity);
        adapter.setData(notesRepository.getNotes());
        Toast.makeText(this, noteEntity.getTitle() + " " + "Удаленно", Toast.LENGTH_SHORT).show();
    }

    private void savedNotes(NoteEntity noteEntity) {
        notesRepository.saveNotes(noteEntity);
        adapter.setData(notesRepository.getNotes());
    }


    }


