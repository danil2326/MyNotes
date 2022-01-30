package ru.gb.course1.mynotes.data;

import java.util.ArrayList;
import java.util.List;

import ru.gb.course1.mynotes.domain.NoteEntity;
import ru.gb.course1.mynotes.domain.NotesRepository;

public class CasheNotesRepositoryImpl implements NotesRepository {
    private ArrayList<NoteEntity> cache = new ArrayList<>();

    public CasheNotesRepositoryImpl() {
        cache.addAll(fillNoteWithDumpData());

    }

    @Override
    public List<NoteEntity> getNotes() {
        return new ArrayList<>(cache);
    }

    @Override
    public void deleteNotes(NoteEntity noteEntity) {
        cache.remove(findPos(noteEntity));
    }

    @Override
    public void addNotes() {
        int i = cache.size();
        cache.add(new NoteEntity("Новый заголовок", "Новый текст","7"));

    }

    @Override
    public void saveNotes(NoteEntity noteEntity) {
        for (int i = 0; i < cache.size(); i++) {
            if (cache.get(i).getId().equals(noteEntity.getId()));
            {
                cache.set(i , noteEntity);

            }
        }
    }


    private int findPos(NoteEntity noteEntity) {
        for (int i = 0; i < cache.size(); i++) {
            if (noteEntity.getId().equals(cache.get(i).getId())) {
                return i;
            }

        }
        throw new IllegalArgumentException("Нет такого элемента");
    }

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
}
