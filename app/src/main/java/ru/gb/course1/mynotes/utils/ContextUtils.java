package ru.gb.course1.mynotes.utils;

import android.content.Context;

import ru.gb.course1.mynotes.App;

public class ContextUtils {
    public static App getApp(Context contex) {
        return (App) contex.getApplicationContext();
    }
}
