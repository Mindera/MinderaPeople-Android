package com.mindera.people.android.ui.google

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.mindera.people.UiState
import com.mindera.people.auth.AuthViewModel
import com.mindera.people.user.User
import kotlinx.coroutines.launch

class SignInGoogleViewModel(
    private val context: Context,
    private val authViewModel: AuthViewModel
) : ViewModel() {

    private var _userState = MutableLiveData<UiState<User>>()
    val googleUser: LiveData<UiState<User>> = _userState

    init {
        checkSignedInUser()
    }

    fun fetchSignInUser(email: String?, name: String?) {
        showLoading()
        viewModelScope.launch { setUser(email, name) }
    }

    private fun setUser(email: String?, name: String?) {
        User(email = email, name = name).run {
            _userState.value = UiState.Success(this)
            authViewModel.authenticate(this)
        }
    }

    private fun checkSignedInUser() {
        GoogleSignIn.getLastSignedInAccount(context)?.run {
            setUser(email, displayName)
        }
    }

    fun hideLoading() {
        _userState.value = UiState.Idle
    }

    fun showLoading() {
        _userState.value = UiState.Loading
    }

    fun setError() {
        _userState.value = UiState.Error
    }
}