package ru.gb.course1.mynotes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
private RecyclerView recyclerView;
private NoteAdapter adapter;
private final ArrayList<NoteEntity> noteList = new ArrayList<>();

    private ArrayList<NoteEntity> fillNoteWithDumpData() {
        final ArrayList<NoteEntity> noteEntities = new ArrayList<>();
        noteEntities.add(new NoteEntity(
                "Оглавление1",
                "Текс1"));
        noteEntities.add(new NoteEntity(
                "Оглавление2",
                "Текс2"));
        noteEntities.add(new NoteEntity(
                "Оглавление3",
                "Текс3"));
        noteEntities.add(new NoteEntity(
                "Оглавление4",
                "Текс4"));
        noteEntities.add(new NoteEntity(
                "Оглавление5",
                "Текс5"));
        return noteEntities;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        noteList.addAll(fillNoteWithDumpData());
        initNote();

    }

    private void initNote() {
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new NoteAdapter();
        recyclerView.setAdapter(adapter);
        adapter.setData(noteList);
    }


}