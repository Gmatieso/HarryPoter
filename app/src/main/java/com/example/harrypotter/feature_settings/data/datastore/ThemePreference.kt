package com.example.harrypotter.feature_settings.data.datastore

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import com.example.harrypotter.feature_settings.presentation.util.SettingsConstants
import com.example.harrypotter.core.data.datastore.DatastoreConstants
import com.example.harrypotter.core.data.datastore.datastore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class ThemePreference(
    private val context: Context
) {

    companion object {
        val THEME_KEY = stringPreferencesKey(DatastoreConstants.THEME_KEY)
    }

    //  get theme using flow
    val getTheme: Flow<String?> = context.datastore.data
        .map { preferences ->
            preferences[THEME_KEY] ?: SettingsConstants.themeOptions[2].title
        }

    //  set theme
    suspend fun setTheme(theme: String) {
        context.datastore.edit { preferences ->
            preferences[THEME_KEY] = theme
        }
    }
}
















