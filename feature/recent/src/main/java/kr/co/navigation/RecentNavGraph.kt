package kr.co.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import kr.co.recent.RecentRoute

fun NavGraphBuilder.recentNavGraph(
    padding: PaddingValues,
    navigateToPdf: (String) -> Unit = {},
) {
    composable<MainNavigation.Recent> {
        RecentRoute(
            padding = padding,
            navigateToPdf = navigateToPdf
        )
    }
}