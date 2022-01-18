package ru.gb.course1.mynotes.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

import ru.gb.course1.mynotes.domain.NoteEntity;
import ru.gb.course1.mynotes.R;

public class MainActivity extends AppCompatActivity {
private RecyclerView recyclerView;
private NoteAdapter adapter;
private final ArrayList<NoteEntity> noteList = new ArrayList<>();

    private ArrayList<NoteEntity> fillNoteWithDumpData() {
        final ArrayList<NoteEntity> noteEntities = new ArrayList<>();
        noteEntities.add(new NoteEntity(
                "Оглавление1",
                "Текст1",
                "0"));
        noteEntities.add(new NoteEntity(
                "Оглавление2",
                "Текст2",
                "1"));
        noteEntities.add(new NoteEntity(
                "Оглавление3",
                "Текст3",
                "2"));
        noteEntities.add(new NoteEntity(
                "Оглавление4",
                "Текст4",
                "3"));
        noteEntities.add(new NoteEntity(
                "Оглавление5",
                "Текст5",
                "4"));
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
        adapter.setOnDeletClickListener(noteEntity -> {
           deleteNotes(noteEntity);
        });
    }
    private void deleteNotes (NoteEntity noteEntity) {
        int pos = findPos(noteEntity);
        noteList.remove(pos);
        adapter.setData(noteList);
        Toast.makeText(this, noteEntity.getTitle() + " " + "Удаленно", Toast.LENGTH_SHORT).show();
    }

    private int findPos(NoteEntity noteEntity) {
        for (int i = 0; i < noteList.size(); i++) {
            if(noteEntity.getId().equals(noteList.get(i).getId())) {
                return i;
            }

        }
          throw new IllegalArgumentException("Нет такого элемента");
    }


}