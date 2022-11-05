package com.mindera.people.android.ui.biometrics

import android.Manifest
import android.app.KeyguardManager
import android.content.Context
import android.content.pm.PackageManager
import android.hardware.biometrics.BiometricPrompt
import android.os.Build
import android.os.CancellationSignal
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.core.app.ActivityCompat
import com.mindera.people.android.R
import com.mindera.people.android.utils.longToast
import com.mindera.people.android.utils.shortToast

@RequiresApi(Build.VERSION_CODES.Q)
@Composable
fun Biometrics() {
    val context = LocalContext.current

    val authenticationCallback: BiometricPrompt.AuthenticationCallback =
        object : BiometricPrompt.AuthenticationCallback() {
            override fun onAuthenticationSucceeded(result: BiometricPrompt.AuthenticationResult?) {
                super.onAuthenticationSucceeded(result)
                context.shortToast("Authentication Succeeded")
            }

            override fun onAuthenticationError(errorCode: Int, errString: CharSequence?) {
                super.onAuthenticationError(errorCode, errString)
                context.shortToast("Authentication Error code: $errorCode")
            }

            override fun onAuthenticationHelp(helpCode: Int, helpString: CharSequence?) {
                super.onAuthenticationHelp(helpCode, helpString)
            }
        }

    context.launchBiometric(authenticationCallback)
}

@RequiresApi(Build.VERSION_CODES.Q)
private fun Context.launchBiometric(
    callback: BiometricPrompt.AuthenticationCallback
) {
    if (checkBiometricSupport()) {
        val biometricPrompt = BiometricPrompt.Builder(this)
            .apply {
                setTitle(getString(R.string.prompt_info_title))
                setSubtitle(getString(R.string.prompt_info_subtitle))
                setDescription(getString(R.string.prompt_info_description))
                setConfirmationRequired(false)
                setNegativeButton(getString(R.string.prompt_info_go_back), mainExecutor) { _, _ ->
                    shortToast("Authentication Cancelled")
                }
            }.build()

        biometricPrompt.authenticate(cancellationSignal, this.mainExecutor, callback)
    }
}

@RequiresApi(Build.VERSION_CODES.M)
private fun Context.checkBiometricSupport(): Boolean = when {
    !(getSystemService(Context.KEYGUARD_SERVICE) as KeyguardManager).isDeviceSecure -> true

    ActivityCompat.checkSelfPermission(
        this,
        Manifest.permission.USE_BIOMETRIC
    ) != PackageManager.PERMISSION_GRANTED -> false

    else -> this.packageManager.hasSystemFeature(PackageManager.FEATURE_FINGERPRINT)
}

private val Context.cancellationSignal: CancellationSignal
    get() = CancellationSignal().apply {
        setOnCancelListener { longToast("Authentication Cancelled Signal") }
    }
