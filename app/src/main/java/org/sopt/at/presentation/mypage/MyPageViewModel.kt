package org.sopt.at.presentation.mypage

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import org.sopt.at.presentation.login.util.LoginRepository
import javax.inject.Inject

@HiltViewModel
class MyPageViewModel @Inject constructor(private val repository: LoginRepository):ViewModel() {
    val _userId = MutableStateFlow<String?>(null)
    val userId: StateFlow<String?> = _userId.asStateFlow()

    fun getUserInfo(){
        _userId.value = repository.getUserId()
    }
    fun logOut(){
        repository.clearUserData()
    }
}