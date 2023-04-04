package com.example.harrypotter.util

class Constants {
    companion object {

        const val BASE_URL = "https://hp-api.onrender.com/api/"

        //  endpoints
        const val CHARACTERS_ENDPOINT = "characters"
        const val HOUSES_ENDPOINT = "house/{houseName}"

        // for future use endpoints
        const val STUDENTS_ENDPOINT = "characters/students"
        const val STAFF_ENDPOINT = "characters/staff"
        const val SPELLS_ENDPOINT = "spells"


        const val KEY_HOUSE_ID = "com.example.harrypotter.id"


        //  error messages
        const val SOCKET_TIMEOUT_MSG = "Timeout, please check your internet connection."
        const val UNKNOWN_HOST_MSG = "Unable to make a connection. Check your internet connection"
        const val CONNECTION_SHUTDOWN_MSG = "Connection Shut down, please check internet connection"
        const val IO_EXCEPTION_MSG = "Server is unreachable, please try again later."
    }



    object  Screens {

        const val HOME_SCREEN = "home_screen"
        const val DETAIL_SCREEN = "detail_screen"
    }
}