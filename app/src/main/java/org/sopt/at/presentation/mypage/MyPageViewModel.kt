package org.sopt.at.presentation.mypage

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.sopt.at.domain.model.NickNameRequestInfo
import org.sopt.at.domain.repository.UserRepository
import javax.inject.Inject

@HiltViewModel
class MyPageViewModel @Inject constructor(private val repository: UserRepository) : ViewModel() {

    private val _userId = MutableStateFlow<Long?>(null)
    val userId: StateFlow<Long?> = _userId.asStateFlow()

    private val _nickname = MutableStateFlow("")
    val nickname: StateFlow<String> = _nickname.asStateFlow()

    init {
        getNickName()
    }

    private fun getNickName() {
        val id = repository.getUserId()
        _userId.value = id
        fetchNickname(id)
    }

    private fun fetchNickname(userId: Long) {
        viewModelScope.launch {
            repository.getNickname(NickNameRequestInfo(userId))
                .onSuccess { _nickname.value = it.nickname }
                .onFailure { _nickname.value = "닉네임 불러오기 실패" }
        }
    }

    fun logOut() {
        viewModelScope.launch {
            repository.clearUserData()
        }
    }
}
