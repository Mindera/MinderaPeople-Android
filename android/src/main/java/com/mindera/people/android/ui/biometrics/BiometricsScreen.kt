package com.mindera.people.android.ui.biometrics


import android.Manifest
import android.app.KeyguardManager
import android.content.Context
import android.content.pm.PackageManager
import android.hardware.biometrics.BiometricPrompt
import android.os.Build
import android.os.CancellationSignal
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.core.app.ActivityCompat
import com.mindera.people.android.R

@RequiresApi(Build.VERSION_CODES.Q)
@Composable
fun Biometrics(
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current

    val authenticationCallback: BiometricPrompt.AuthenticationCallback =
        object : BiometricPrompt.AuthenticationCallback() {
            override fun onAuthenticationSucceeded(result: BiometricPrompt.AuthenticationResult?) {
                super.onAuthenticationSucceeded(result)
                Toast.makeText(context, "Authentication Succeeded", Toast.LENGTH_SHORT).show()
            }

            override fun onAuthenticationError(errorCode: Int, errString: CharSequence?) {
                super.onAuthenticationError(errorCode, errString)
                Toast.makeText(
                    context,
                    "Authentication Error code: $errorCode",
                    Toast.LENGTH_SHORT
                ).show()
            }

            override fun onAuthenticationHelp(helpCode: Int, helpString: CharSequence?) {
                super.onAuthenticationHelp(helpCode, helpString)
            }
        }

    BioMetricScreen(context, authenticationCallback)
}

@RequiresApi(Build.VERSION_CODES.Q)
private fun launchBiometric(
    authenticationCallback: BiometricPrompt.AuthenticationCallback,
    context: Context
) {
    if (checkBiometricSupport(context)) {
        val biometricPrompt = BiometricPrompt.Builder(context)
            .apply {
                setTitle(context.getString(R.string.prompt_info_title))
                setSubtitle(context.getString(R.string.prompt_info_subtitle))
                setDescription(context.getString(R.string.prompt_info_description))
                setConfirmationRequired(false)
                setNegativeButton(
                    context.getString(R.string.prompt_info_go_back),
                    context.mainExecutor
                ) { _, _ ->
                    Toast.makeText(
                        context,
                        "Authentication Cancelled",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }.build()

        biometricPrompt.authenticate(
            getCancellationSignal(context),
            context.mainExecutor,
            authenticationCallback
        )
    }
}

@RequiresApi(Build.VERSION_CODES.M)
private fun checkBiometricSupport(context: Context): Boolean {
    val keyGuardManager = context.getSystemService(Context.KEYGUARD_SERVICE) as KeyguardManager

    if (!keyGuardManager.isDeviceSecure) {
        return true
    }
    if (ActivityCompat.checkSelfPermission(
            context,
            Manifest.permission.USE_BIOMETRIC
        ) != PackageManager.PERMISSION_GRANTED
    ) {
        return false
    }

    return context.packageManager.hasSystemFeature(PackageManager.FEATURE_FINGERPRINT)
}


private fun getCancellationSignal(
    context: Context
): CancellationSignal {
    return CancellationSignal().apply {
        setOnCancelListener {
            Toast.makeText(context, "Authentication Cancelled Signal", Toast.LENGTH_SHORT).show()
        }
    }
}

@RequiresApi(Build.VERSION_CODES.Q)
@Composable
fun BioMetricScreen(
    context: Context,
    authenticationCallback: BiometricPrompt.AuthenticationCallback,
) {
    launchBiometric(authenticationCallback, context)
}