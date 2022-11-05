package com.mindera.people.android.utils

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.mindera.people.android.navigation.Navigator

class PreviewNavigatorWithBack: PreviewParameterProvider<Navigator> {
    override val values = sequenceOf(getNavigator(hasBackStack = true))
    override val count: Int = values.count()
}

class PreviewNavigatorWithoutBack: PreviewParameterProvider<Navigator> {
    override val values = sequenceOf(getNavigator(hasBackStack = false))
    override val count: Int = values.count()
}

private fun getNavigator(hasBackStack: Boolean): Navigator =
    object : Navigator {
        override fun hasBackStack(): Boolean = hasBackStack
        override fun goBack() {/* no-op */}
        override fun navigateToSettingsScreen() {/* no-op */}
    }