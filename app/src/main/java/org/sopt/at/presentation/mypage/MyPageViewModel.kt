package org.sopt.at.presentation.mypage

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.sopt.at.data.repository.UserRepository
import javax.inject.Inject

@HiltViewModel
class MyPageViewModel @Inject constructor(private val repository: UserRepository):ViewModel() {
    val _userId = MutableStateFlow<String?>(null)
    val userId: StateFlow<String?> = _userId.asStateFlow()

    init {
        getUserInfo()
    }
    fun getUserInfo(){
        _userId.value = repository.getUserId()
    }
    fun logOut(){
        viewModelScope.launch {
            repository.clearUserData()
        }
    }
}