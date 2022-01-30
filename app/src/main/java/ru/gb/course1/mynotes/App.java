package ru.gb.course1.mynotes;

import android.app.Application;
import android.content.Context;

import ru.gb.course1.mynotes.data.CasheNotesRepositoryImpl;
import ru.gb.course1.mynotes.domain.NotesRepository;
import ru.gb.course1.mynotes.ui.MainActivity;

public class App extends Application {
    private NotesRepository notesRepository = new CasheNotesRepositoryImpl();

    public static App get(Context context) {
        return (App) context.getApplicationContext();
    }

    public NotesRepository getNotesRepo() {
        return notesRepository;
    }
}
