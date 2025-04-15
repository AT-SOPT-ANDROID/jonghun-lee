package org.sopt.at.my

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import org.sopt.at.login.util.LoginRepository

class MyViewModel(private val repository: LoginRepository):ViewModel() {
    val _userId = MutableStateFlow<String?>(null)
    val userId: StateFlow<String?> = _userId.asStateFlow()

    fun getUserInfo(id: String){
        _userId.value = repository.getUserId()
    }
    fun logOut(){
        repository.clearUserData()
    }
}