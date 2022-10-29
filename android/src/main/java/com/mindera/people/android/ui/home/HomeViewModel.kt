package com.mindera.people.android.ui.home

import androidx.lifecycle.viewModelScope
import com.mindera.people.auth.AuthViewModel
import com.mindera.people.user.User
import com.mindera.people.utils.UiState
import com.mindera.people.utils.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class HomeViewModel(
    private val authViewModel: AuthViewModel
) : ViewModel() {

    private var _userState = MutableStateFlow<UiState<User>>(UiState.Idle)
    val googleUser: StateFlow<UiState<User>> = _userState

    fun fetchSignInUser(email: String?, name: String?) {
        showLoading()
        viewModelScope.launch { setUser(email, name) }
    }

    fun setUser(email: String?, name: String?) {
        User(email = email, name = name).run {
            _userState.value = UiState.Success(this)
            authViewModel.authenticate(this)
        }
    }

    private fun showLoading() {
        _userState.value = UiState.Loading
    }

    fun setError() {
        _userState.value = UiState.Error
    }
}
