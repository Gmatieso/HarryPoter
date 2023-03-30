package com.example.harrypotter.data.remote.datastore

import android.content.Context
import androidx.datastore.preferences.preferencesDataStore


/*TODO Theme Prefences use datastore*/
val Context.datastore by preferencesDataStore(
    name = DatastoreConstants.PREFERENCES_NAME
)