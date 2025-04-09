package org.sopt.at.util

import android.content.Context
import androidx.core.content.edit

object SharedPreferencesManager {
    private const val PREFS_NAME = "fred_login_data"
    private const val USER_ID = "user_id"
    private const val USER_PWD = "user_password"
    private const val IS_LOGGED_IN = "is_logged_in"

    fun saveUser(context: Context, id: String, password: String){
        val prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        prefs.edit() { putString(USER_ID, id).putString(USER_PWD, password).putBoolean(IS_LOGGED_IN, true) }
    }

    fun getUser(context: Context): Pair<String?, String?>{
        val prefs = context.getSharedPreferences(PREFS_NAME,Context.MODE_PRIVATE)
        return prefs.getString(USER_ID, null) to prefs.getString(USER_PWD,null)
    }

    fun setLoggedIn(context: Context, value: Boolean) {
        val prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        prefs.edit() { putBoolean(IS_LOGGED_IN, value) }
    }

    fun isLoggedIn(context: Context): Boolean {
        val prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        return prefs.getBoolean(IS_LOGGED_IN, false)
    }

    fun logOut(context: Context){
        val prefs = context.getSharedPreferences(PREFS_NAME,Context.MODE_PRIVATE)
        prefs.edit(){ putBoolean(IS_LOGGED_IN, false) }
    }

}