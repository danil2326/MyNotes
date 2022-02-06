package ru.gb.course1.mynotes.ui.main;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import ru.gb.course1.mynotes.App;
import ru.gb.course1.mynotes.R;
import ru.gb.course1.mynotes.domain.NoteEntity;
import ru.gb.course1.mynotes.domain.NotesRepository;

public class NotesListFragment extends Fragment {
    private RecyclerView recyclerView;
    private NoteAdapter adapter;
    private NotesRepository notesRepository;
    private NoteEntity noteEntity;
    private Button addNoteButton;
    private Button saveNote;




    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_main, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        notesRepository = App.get(getContext()).getNotesRepo();
        initNote();

    }

    private void initNote() {
        recyclerView = getView().findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new NoteAdapter();
        recyclerView.setAdapter(adapter);
        adapter.setData(notesRepository.getNotes());
        addNoteButton = getView().findViewById(R.id.add_note_button);
        addNoteButton.setOnClickListener(v -> {
            notesRepository.addNotes();
            adapter.setData(notesRepository.getNotes());


        });
        saveNote = getView().findViewById(R.id.save_button);
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
        Intent intent = new Intent(getContext(), NotesActivity.class);
        intent.putExtra(NotesActivity.NOTES_EXTRA_KEY, noteEntity);
        startActivity(intent);
    }

    private void deleteNotes(NoteEntity noteEntity) {
        notesRepository.deleteNotes(noteEntity);
        adapter.setData(notesRepository.getNotes());
        Toast.makeText(getContext(), noteEntity.getTitle() + " " + "Удаленно", Toast.LENGTH_SHORT).show();
    }

    private void savedNotes(NoteEntity noteEntity) {
        notesRepository.saveNotes(noteEntity);
        adapter.setData(notesRepository.getNotes());
    }



}
