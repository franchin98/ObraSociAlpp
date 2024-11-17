package com.example.compose
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import com.softchin.obrasocialpp.ui.theme.backgroundDark
import com.softchin.obrasocialpp.ui.theme.backgroundDarkHighContrast
import com.softchin.obrasocialpp.ui.theme.backgroundDarkMediumContrast
import com.softchin.obrasocialpp.ui.theme.backgroundLight
import com.softchin.obrasocialpp.ui.theme.backgroundLightHighContrast
import com.softchin.obrasocialpp.ui.theme.backgroundLightMediumContrast
import com.softchin.obrasocialpp.ui.theme.errorContainerDark
import com.softchin.obrasocialpp.ui.theme.errorContainerDarkHighContrast
import com.softchin.obrasocialpp.ui.theme.errorContainerDarkMediumContrast
import com.softchin.obrasocialpp.ui.theme.errorContainerLight
import com.softchin.obrasocialpp.ui.theme.errorContainerLightHighContrast
import com.softchin.obrasocialpp.ui.theme.errorContainerLightMediumContrast
import com.softchin.obrasocialpp.ui.theme.errorDark
import com.softchin.obrasocialpp.ui.theme.errorDarkHighContrast
import com.softchin.obrasocialpp.ui.theme.errorDarkMediumContrast
import com.softchin.obrasocialpp.ui.theme.errorLight
import com.softchin.obrasocialpp.ui.theme.errorLightHighContrast
import com.softchin.obrasocialpp.ui.theme.errorLightMediumContrast
import com.softchin.obrasocialpp.ui.theme.inverseOnSurfaceDark
import com.softchin.obrasocialpp.ui.theme.inverseOnSurfaceDarkHighContrast
import com.softchin.obrasocialpp.ui.theme.inverseOnSurfaceDarkMediumContrast
import com.softchin.obrasocialpp.ui.theme.inverseOnSurfaceLight
import com.softchin.obrasocialpp.ui.theme.inverseOnSurfaceLightHighContrast
import com.softchin.obrasocialpp.ui.theme.inverseOnSurfaceLightMediumContrast
import com.softchin.obrasocialpp.ui.theme.inversePrimaryDark
import com.softchin.obrasocialpp.ui.theme.inversePrimaryDarkHighContrast
import com.softchin.obrasocialpp.ui.theme.inversePrimaryDarkMediumContrast
import com.softchin.obrasocialpp.ui.theme.inversePrimaryLight
import com.softchin.obrasocialpp.ui.theme.inversePrimaryLightHighContrast
import com.softchin.obrasocialpp.ui.theme.inversePrimaryLightMediumContrast
import com.softchin.obrasocialpp.ui.theme.inverseSurfaceDark
import com.softchin.obrasocialpp.ui.theme.inverseSurfaceDarkHighContrast
import com.softchin.obrasocialpp.ui.theme.inverseSurfaceDarkMediumContrast
import com.softchin.obrasocialpp.ui.theme.inverseSurfaceLight
import com.softchin.obrasocialpp.ui.theme.inverseSurfaceLightHighContrast
import com.softchin.obrasocialpp.ui.theme.inverseSurfaceLightMediumContrast
import com.softchin.obrasocialpp.ui.theme.onBackgroundDark
import com.softchin.obrasocialpp.ui.theme.onBackgroundDarkHighContrast
import com.softchin.obrasocialpp.ui.theme.onBackgroundDarkMediumContrast
import com.softchin.obrasocialpp.ui.theme.onBackgroundLight
import com.softchin.obrasocialpp.ui.theme.onBackgroundLightHighContrast
import com.softchin.obrasocialpp.ui.theme.onBackgroundLightMediumContrast
import com.softchin.obrasocialpp.ui.theme.onErrorContainerDark
import com.softchin.obrasocialpp.ui.theme.onErrorContainerDarkHighContrast
import com.softchin.obrasocialpp.ui.theme.onErrorContainerDarkMediumContrast
import com.softchin.obrasocialpp.ui.theme.onErrorContainerLight
import com.softchin.obrasocialpp.ui.theme.onErrorContainerLightHighContrast
import com.softchin.obrasocialpp.ui.theme.onErrorContainerLightMediumContrast
import com.softchin.obrasocialpp.ui.theme.onErrorDark
import com.softchin.obrasocialpp.ui.theme.onErrorDarkHighContrast
import com.softchin.obrasocialpp.ui.theme.onErrorDarkMediumContrast
import com.softchin.obrasocialpp.ui.theme.onErrorLight
import com.softchin.obrasocialpp.ui.theme.onErrorLightHighContrast
import com.softchin.obrasocialpp.ui.theme.onErrorLightMediumContrast
import com.softchin.obrasocialpp.ui.theme.onPrimaryContainerDark
import com.softchin.obrasocialpp.ui.theme.onPrimaryContainerDarkHighContrast
import com.softchin.obrasocialpp.ui.theme.onPrimaryContainerDarkMediumContrast
import com.softchin.obrasocialpp.ui.theme.onPrimaryContainerLight
import com.softchin.obrasocialpp.ui.theme.onPrimaryContainerLightHighContrast
import com.softchin.obrasocialpp.ui.theme.onPrimaryContainerLightMediumContrast
import com.softchin.obrasocialpp.ui.theme.onPrimaryDark
import com.softchin.obrasocialpp.ui.theme.onPrimaryDarkHighContrast
import com.softchin.obrasocialpp.ui.theme.onPrimaryDarkMediumContrast
import com.softchin.obrasocialpp.ui.theme.onPrimaryLight
import com.softchin.obrasocialpp.ui.theme.onPrimaryLightHighContrast
import com.softchin.obrasocialpp.ui.theme.onPrimaryLightMediumContrast
import com.softchin.obrasocialpp.ui.theme.onSecondaryContainerDark
import com.softchin.obrasocialpp.ui.theme.onSecondaryContainerDarkHighContrast
import com.softchin.obrasocialpp.ui.theme.onSecondaryContainerDarkMediumContrast
import com.softchin.obrasocialpp.ui.theme.onSecondaryContainerLight
import com.softchin.obrasocialpp.ui.theme.onSecondaryContainerLightHighContrast
import com.softchin.obrasocialpp.ui.theme.onSecondaryContainerLightMediumContrast
import com.softchin.obrasocialpp.ui.theme.onSecondaryDark
import com.softchin.obrasocialpp.ui.theme.onSecondaryDarkHighContrast
import com.softchin.obrasocialpp.ui.theme.onSecondaryDarkMediumContrast
import com.softchin.obrasocialpp.ui.theme.onSecondaryLight
import com.softchin.obrasocialpp.ui.theme.onSecondaryLightHighContrast
import com.softchin.obrasocialpp.ui.theme.onSecondaryLightMediumContrast
import com.softchin.obrasocialpp.ui.theme.onSurfaceDark
import com.softchin.obrasocialpp.ui.theme.onSurfaceDarkHighContrast
import com.softchin.obrasocialpp.ui.theme.onSurfaceDarkMediumContrast
import com.softchin.obrasocialpp.ui.theme.onSurfaceLight
import com.softchin.obrasocialpp.ui.theme.onSurfaceLightHighContrast
import com.softchin.obrasocialpp.ui.theme.onSurfaceLightMediumContrast
import com.softchin.obrasocialpp.ui.theme.onSurfaceVariantDark
import com.softchin.obrasocialpp.ui.theme.onSurfaceVariantDarkHighContrast
import com.softchin.obrasocialpp.ui.theme.onSurfaceVariantDarkMediumContrast
import com.softchin.obrasocialpp.ui.theme.onSurfaceVariantLight
import com.softchin.obrasocialpp.ui.theme.onSurfaceVariantLightHighContrast
import com.softchin.obrasocialpp.ui.theme.onSurfaceVariantLightMediumContrast
import com.softchin.obrasocialpp.ui.theme.onTertiaryContainerDark
import com.softchin.obrasocialpp.ui.theme.onTertiaryContainerDarkHighContrast
import com.softchin.obrasocialpp.ui.theme.onTertiaryContainerDarkMediumContrast
import com.softchin.obrasocialpp.ui.theme.onTertiaryContainerLight
import com.softchin.obrasocialpp.ui.theme.onTertiaryContainerLightHighContrast
import com.softchin.obrasocialpp.ui.theme.onTertiaryContainerLightMediumContrast
import com.softchin.obrasocialpp.ui.theme.onTertiaryDark
import com.softchin.obrasocialpp.ui.theme.onTertiaryDarkHighContrast
import com.softchin.obrasocialpp.ui.theme.onTertiaryDarkMediumContrast
import com.softchin.obrasocialpp.ui.theme.onTertiaryLight
import com.softchin.obrasocialpp.ui.theme.onTertiaryLightHighContrast
import com.softchin.obrasocialpp.ui.theme.onTertiaryLightMediumContrast
import com.softchin.obrasocialpp.ui.theme.outlineDark
import com.softchin.obrasocialpp.ui.theme.outlineDarkHighContrast
import com.softchin.obrasocialpp.ui.theme.outlineDarkMediumContrast
import com.softchin.obrasocialpp.ui.theme.outlineLight
import com.softchin.obrasocialpp.ui.theme.outlineLightHighContrast
import com.softchin.obrasocialpp.ui.theme.outlineLightMediumContrast
import com.softchin.obrasocialpp.ui.theme.outlineVariantDark
import com.softchin.obrasocialpp.ui.theme.outlineVariantDarkHighContrast
import com.softchin.obrasocialpp.ui.theme.outlineVariantDarkMediumContrast
import com.softchin.obrasocialpp.ui.theme.outlineVariantLight
import com.softchin.obrasocialpp.ui.theme.outlineVariantLightHighContrast
import com.softchin.obrasocialpp.ui.theme.outlineVariantLightMediumContrast
import com.softchin.obrasocialpp.ui.theme.primaryContainerDark
import com.softchin.obrasocialpp.ui.theme.primaryContainerDarkHighContrast
import com.softchin.obrasocialpp.ui.theme.primaryContainerDarkMediumContrast
import com.softchin.obrasocialpp.ui.theme.primaryContainerLight
import com.softchin.obrasocialpp.ui.theme.primaryContainerLightHighContrast
import com.softchin.obrasocialpp.ui.theme.primaryContainerLightMediumContrast
import com.softchin.obrasocialpp.ui.theme.primaryDark
import com.softchin.obrasocialpp.ui.theme.primaryDarkHighContrast
import com.softchin.obrasocialpp.ui.theme.primaryDarkMediumContrast
import com.softchin.obrasocialpp.ui.theme.primaryLight
import com.softchin.obrasocialpp.ui.theme.primaryLightHighContrast
import com.softchin.obrasocialpp.ui.theme.primaryLightMediumContrast
import com.softchin.obrasocialpp.ui.theme.scrimDark
import com.softchin.obrasocialpp.ui.theme.scrimDarkHighContrast
import com.softchin.obrasocialpp.ui.theme.scrimDarkMediumContrast
import com.softchin.obrasocialpp.ui.theme.scrimLight
import com.softchin.obrasocialpp.ui.theme.scrimLightHighContrast
import com.softchin.obrasocialpp.ui.theme.scrimLightMediumContrast
import com.softchin.obrasocialpp.ui.theme.secondaryContainerDark
import com.softchin.obrasocialpp.ui.theme.secondaryContainerDarkHighContrast
import com.softchin.obrasocialpp.ui.theme.secondaryContainerDarkMediumContrast
import com.softchin.obrasocialpp.ui.theme.secondaryContainerLight
import com.softchin.obrasocialpp.ui.theme.secondaryContainerLightHighContrast
import com.softchin.obrasocialpp.ui.theme.secondaryContainerLightMediumContrast
import com.softchin.obrasocialpp.ui.theme.secondaryDark
import com.softchin.obrasocialpp.ui.theme.secondaryDarkHighContrast
import com.softchin.obrasocialpp.ui.theme.secondaryDarkMediumContrast
import com.softchin.obrasocialpp.ui.theme.secondaryLight
import com.softchin.obrasocialpp.ui.theme.secondaryLightHighContrast
import com.softchin.obrasocialpp.ui.theme.secondaryLightMediumContrast
import com.softchin.obrasocialpp.ui.theme.surfaceBrightDark
import com.softchin.obrasocialpp.ui.theme.surfaceBrightDarkHighContrast
import com.softchin.obrasocialpp.ui.theme.surfaceBrightDarkMediumContrast
import com.softchin.obrasocialpp.ui.theme.surfaceBrightLight
import com.softchin.obrasocialpp.ui.theme.surfaceBrightLightHighContrast
import com.softchin.obrasocialpp.ui.theme.surfaceBrightLightMediumContrast
import com.softchin.obrasocialpp.ui.theme.surfaceContainerDark
import com.softchin.obrasocialpp.ui.theme.surfaceContainerDarkHighContrast
import com.softchin.obrasocialpp.ui.theme.surfaceContainerDarkMediumContrast
import com.softchin.obrasocialpp.ui.theme.surfaceContainerHighDark
import com.softchin.obrasocialpp.ui.theme.surfaceContainerHighDarkHighContrast
import com.softchin.obrasocialpp.ui.theme.surfaceContainerHighDarkMediumContrast
import com.softchin.obrasocialpp.ui.theme.surfaceContainerHighLight
import com.softchin.obrasocialpp.ui.theme.surfaceContainerHighLightHighContrast
import com.softchin.obrasocialpp.ui.theme.surfaceContainerHighLightMediumContrast
import com.softchin.obrasocialpp.ui.theme.surfaceContainerHighestDark
import com.softchin.obrasocialpp.ui.theme.surfaceContainerHighestDarkHighContrast
import com.softchin.obrasocialpp.ui.theme.surfaceContainerHighestDarkMediumContrast
import com.softchin.obrasocialpp.ui.theme.surfaceContainerHighestLight
import com.softchin.obrasocialpp.ui.theme.surfaceContainerHighestLightHighContrast
import com.softchin.obrasocialpp.ui.theme.surfaceContainerHighestLightMediumContrast
import com.softchin.obrasocialpp.ui.theme.surfaceContainerLight
import com.softchin.obrasocialpp.ui.theme.surfaceContainerLightHighContrast
import com.softchin.obrasocialpp.ui.theme.surfaceContainerLightMediumContrast
import com.softchin.obrasocialpp.ui.theme.surfaceContainerLowDark
import com.softchin.obrasocialpp.ui.theme.surfaceContainerLowDarkHighContrast
import com.softchin.obrasocialpp.ui.theme.surfaceContainerLowDarkMediumContrast
import com.softchin.obrasocialpp.ui.theme.surfaceContainerLowLight
import com.softchin.obrasocialpp.ui.theme.surfaceContainerLowLightHighContrast
import com.softchin.obrasocialpp.ui.theme.surfaceContainerLowLightMediumContrast
import com.softchin.obrasocialpp.ui.theme.surfaceContainerLowestDark
import com.softchin.obrasocialpp.ui.theme.surfaceContainerLowestDarkHighContrast
import com.softchin.obrasocialpp.ui.theme.surfaceContainerLowestDarkMediumContrast
import com.softchin.obrasocialpp.ui.theme.surfaceContainerLowestLight
import com.softchin.obrasocialpp.ui.theme.surfaceContainerLowestLightHighContrast
import com.softchin.obrasocialpp.ui.theme.surfaceContainerLowestLightMediumContrast
import com.softchin.obrasocialpp.ui.theme.surfaceDark
import com.softchin.obrasocialpp.ui.theme.surfaceDarkHighContrast
import com.softchin.obrasocialpp.ui.theme.surfaceDarkMediumContrast
import com.softchin.obrasocialpp.ui.theme.surfaceDimDark
import com.softchin.obrasocialpp.ui.theme.surfaceDimDarkHighContrast
import com.softchin.obrasocialpp.ui.theme.surfaceDimDarkMediumContrast
import com.softchin.obrasocialpp.ui.theme.surfaceDimLight
import com.softchin.obrasocialpp.ui.theme.surfaceDimLightHighContrast
import com.softchin.obrasocialpp.ui.theme.surfaceDimLightMediumContrast
import com.softchin.obrasocialpp.ui.theme.surfaceLight
import com.softchin.obrasocialpp.ui.theme.surfaceLightHighContrast
import com.softchin.obrasocialpp.ui.theme.surfaceLightMediumContrast
import com.softchin.obrasocialpp.ui.theme.surfaceVariantDark
import com.softchin.obrasocialpp.ui.theme.surfaceVariantDarkHighContrast
import com.softchin.obrasocialpp.ui.theme.surfaceVariantDarkMediumContrast
import com.softchin.obrasocialpp.ui.theme.surfaceVariantLight
import com.softchin.obrasocialpp.ui.theme.surfaceVariantLightHighContrast
import com.softchin.obrasocialpp.ui.theme.surfaceVariantLightMediumContrast
import com.softchin.obrasocialpp.ui.theme.tertiaryContainerDark
import com.softchin.obrasocialpp.ui.theme.tertiaryContainerDarkHighContrast
import com.softchin.obrasocialpp.ui.theme.tertiaryContainerDarkMediumContrast
import com.softchin.obrasocialpp.ui.theme.tertiaryContainerLight
import com.softchin.obrasocialpp.ui.theme.tertiaryContainerLightHighContrast
import com.softchin.obrasocialpp.ui.theme.tertiaryContainerLightMediumContrast
import com.softchin.obrasocialpp.ui.theme.tertiaryDark
import com.softchin.obrasocialpp.ui.theme.tertiaryDarkHighContrast
import com.softchin.obrasocialpp.ui.theme.tertiaryDarkMediumContrast
import com.softchin.obrasocialpp.ui.theme.tertiaryLight
import com.softchin.obrasocialpp.ui.theme.tertiaryLightHighContrast
import com.softchin.obrasocialpp.ui.theme.tertiaryLightMediumContrast

private val lightScheme = lightColorScheme(
    primary = primaryLight,
    onPrimary = onPrimaryLight,
    primaryContainer = primaryContainerLight,
    onPrimaryContainer = onPrimaryContainerLight,
    secondary = secondaryLight,
    onSecondary = onSecondaryLight,
    secondaryContainer = secondaryContainerLight,
    onSecondaryContainer = onSecondaryContainerLight,
    tertiary = tertiaryLight,
    onTertiary = onTertiaryLight,
    tertiaryContainer = tertiaryContainerLight,
    onTertiaryContainer = onTertiaryContainerLight,
    error = errorLight,
    onError = onErrorLight,
    errorContainer = errorContainerLight,
    onErrorContainer = onErrorContainerLight,
    background = backgroundLight,
    onBackground = onBackgroundLight,
    surface = surfaceLight,
    onSurface = onSurfaceLight,
    surfaceVariant = surfaceVariantLight,
    onSurfaceVariant = onSurfaceVariantLight,
    outline = outlineLight,
    outlineVariant = outlineVariantLight,
    scrim = scrimLight,
    inverseSurface = inverseSurfaceLight,
    inverseOnSurface = inverseOnSurfaceLight,
    inversePrimary = inversePrimaryLight,
    surfaceDim = surfaceDimLight,
    surfaceBright = surfaceBrightLight,
    surfaceContainerLowest = surfaceContainerLowestLight,
    surfaceContainerLow = surfaceContainerLowLight,
    surfaceContainer = surfaceContainerLight,
    surfaceContainerHigh = surfaceContainerHighLight,
    surfaceContainerHighest = surfaceContainerHighestLight,
)

private val darkScheme = darkColorScheme(
    primary = primaryDark,
    onPrimary = onPrimaryDark,
    primaryContainer = primaryContainerDark,
    onPrimaryContainer = onPrimaryContainerDark,
    secondary = secondaryDark,
    onSecondary = onSecondaryDark,
    secondaryContainer = secondaryContainerDark,
    onSecondaryContainer = onSecondaryContainerDark,
    tertiary = tertiaryDark,
    onTertiary = onTertiaryDark,
    tertiaryContainer = tertiaryContainerDark,
    onTertiaryContainer = onTertiaryContainerDark,
    error = errorDark,
    onError = onErrorDark,
    errorContainer = errorContainerDark,
    onErrorContainer = onErrorContainerDark,
    background = backgroundDark,
    onBackground = onBackgroundDark,
    surface = surfaceDark,
    onSurface = onSurfaceDark,
    surfaceVariant = surfaceVariantDark,
    onSurfaceVariant = onSurfaceVariantDark,
    outline = outlineDark,
    outlineVariant = outlineVariantDark,
    scrim = scrimDark,
    inverseSurface = inverseSurfaceDark,
    inverseOnSurface = inverseOnSurfaceDark,
    inversePrimary = inversePrimaryDark,
    surfaceDim = surfaceDimDark,
    surfaceBright = surfaceBrightDark,
    surfaceContainerLowest = surfaceContainerLowestDark,
    surfaceContainerLow = surfaceContainerLowDark,
    surfaceContainer = surfaceContainerDark,
    surfaceContainerHigh = surfaceContainerHighDark,
    surfaceContainerHighest = surfaceContainerHighestDark,
)

private val mediumContrastLightColorScheme = lightColorScheme(
    primary = primaryLightMediumContrast,
    onPrimary = onPrimaryLightMediumContrast,
    primaryContainer = primaryContainerLightMediumContrast,
    onPrimaryContainer = onPrimaryContainerLightMediumContrast,
    secondary = secondaryLightMediumContrast,
    onSecondary = onSecondaryLightMediumContrast,
    secondaryContainer = secondaryContainerLightMediumContrast,
    onSecondaryContainer = onSecondaryContainerLightMediumContrast,
    tertiary = tertiaryLightMediumContrast,
    onTertiary = onTertiaryLightMediumContrast,
    tertiaryContainer = tertiaryContainerLightMediumContrast,
    onTertiaryContainer = onTertiaryContainerLightMediumContrast,
    error = errorLightMediumContrast,
    onError = onErrorLightMediumContrast,
    errorContainer = errorContainerLightMediumContrast,
    onErrorContainer = onErrorContainerLightMediumContrast,
    background = backgroundLightMediumContrast,
    onBackground = onBackgroundLightMediumContrast,
    surface = surfaceLightMediumContrast,
    onSurface = onSurfaceLightMediumContrast,
    surfaceVariant = surfaceVariantLightMediumContrast,
    onSurfaceVariant = onSurfaceVariantLightMediumContrast,
    outline = outlineLightMediumContrast,
    outlineVariant = outlineVariantLightMediumContrast,
    scrim = scrimLightMediumContrast,
    inverseSurface = inverseSurfaceLightMediumContrast,
    inverseOnSurface = inverseOnSurfaceLightMediumContrast,
    inversePrimary = inversePrimaryLightMediumContrast,
    surfaceDim = surfaceDimLightMediumContrast,
    surfaceBright = surfaceBrightLightMediumContrast,
    surfaceContainerLowest = surfaceContainerLowestLightMediumContrast,
    surfaceContainerLow = surfaceContainerLowLightMediumContrast,
    surfaceContainer = surfaceContainerLightMediumContrast,
    surfaceContainerHigh = surfaceContainerHighLightMediumContrast,
    surfaceContainerHighest = surfaceContainerHighestLightMediumContrast,
)

private val highContrastLightColorScheme = lightColorScheme(
    primary = primaryLightHighContrast,
    onPrimary = onPrimaryLightHighContrast,
    primaryContainer = primaryContainerLightHighContrast,
    onPrimaryContainer = onPrimaryContainerLightHighContrast,
    secondary = secondaryLightHighContrast,
    onSecondary = onSecondaryLightHighContrast,
    secondaryContainer = secondaryContainerLightHighContrast,
    onSecondaryContainer = onSecondaryContainerLightHighContrast,
    tertiary = tertiaryLightHighContrast,
    onTertiary = onTertiaryLightHighContrast,
    tertiaryContainer = tertiaryContainerLightHighContrast,
    onTertiaryContainer = onTertiaryContainerLightHighContrast,
    error = errorLightHighContrast,
    onError = onErrorLightHighContrast,
    errorContainer = errorContainerLightHighContrast,
    onErrorContainer = onErrorContainerLightHighContrast,
    background = backgroundLightHighContrast,
    onBackground = onBackgroundLightHighContrast,
    surface = surfaceLightHighContrast,
    onSurface = onSurfaceLightHighContrast,
    surfaceVariant = surfaceVariantLightHighContrast,
    onSurfaceVariant = onSurfaceVariantLightHighContrast,
    outline = outlineLightHighContrast,
    outlineVariant = outlineVariantLightHighContrast,
    scrim = scrimLightHighContrast,
    inverseSurface = inverseSurfaceLightHighContrast,
    inverseOnSurface = inverseOnSurfaceLightHighContrast,
    inversePrimary = inversePrimaryLightHighContrast,
    surfaceDim = surfaceDimLightHighContrast,
    surfaceBright = surfaceBrightLightHighContrast,
    surfaceContainerLowest = surfaceContainerLowestLightHighContrast,
    surfaceContainerLow = surfaceContainerLowLightHighContrast,
    surfaceContainer = surfaceContainerLightHighContrast,
    surfaceContainerHigh = surfaceContainerHighLightHighContrast,
    surfaceContainerHighest = surfaceContainerHighestLightHighContrast,
)

private val mediumContrastDarkColorScheme = darkColorScheme(
    primary = primaryDarkMediumContrast,
    onPrimary = onPrimaryDarkMediumContrast,
    primaryContainer = primaryContainerDarkMediumContrast,
    onPrimaryContainer = onPrimaryContainerDarkMediumContrast,
    secondary = secondaryDarkMediumContrast,
    onSecondary = onSecondaryDarkMediumContrast,
    secondaryContainer = secondaryContainerDarkMediumContrast,
    onSecondaryContainer = onSecondaryContainerDarkMediumContrast,
    tertiary = tertiaryDarkMediumContrast,
    onTertiary = onTertiaryDarkMediumContrast,
    tertiaryContainer = tertiaryContainerDarkMediumContrast,
    onTertiaryContainer = onTertiaryContainerDarkMediumContrast,
    error = errorDarkMediumContrast,
    onError = onErrorDarkMediumContrast,
    errorContainer = errorContainerDarkMediumContrast,
    onErrorContainer = onErrorContainerDarkMediumContrast,
    background = backgroundDarkMediumContrast,
    onBackground = onBackgroundDarkMediumContrast,
    surface = surfaceDarkMediumContrast,
    onSurface = onSurfaceDarkMediumContrast,
    surfaceVariant = surfaceVariantDarkMediumContrast,
    onSurfaceVariant = onSurfaceVariantDarkMediumContrast,
    outline = outlineDarkMediumContrast,
    outlineVariant = outlineVariantDarkMediumContrast,
    scrim = scrimDarkMediumContrast,
    inverseSurface = inverseSurfaceDarkMediumContrast,
    inverseOnSurface = inverseOnSurfaceDarkMediumContrast,
    inversePrimary = inversePrimaryDarkMediumContrast,
    surfaceDim = surfaceDimDarkMediumContrast,
    surfaceBright = surfaceBrightDarkMediumContrast,
    surfaceContainerLowest = surfaceContainerLowestDarkMediumContrast,
    surfaceContainerLow = surfaceContainerLowDarkMediumContrast,
    surfaceContainer = surfaceContainerDarkMediumContrast,
    surfaceContainerHigh = surfaceContainerHighDarkMediumContrast,
    surfaceContainerHighest = surfaceContainerHighestDarkMediumContrast,
)

private val highContrastDarkColorScheme = darkColorScheme(
    primary = primaryDarkHighContrast,
    onPrimary = onPrimaryDarkHighContrast,
    primaryContainer = primaryContainerDarkHighContrast,
    onPrimaryContainer = onPrimaryContainerDarkHighContrast,
    secondary = secondaryDarkHighContrast,
    onSecondary = onSecondaryDarkHighContrast,
    secondaryContainer = secondaryContainerDarkHighContrast,
    onSecondaryContainer = onSecondaryContainerDarkHighContrast,
    tertiary = tertiaryDarkHighContrast,
    onTertiary = onTertiaryDarkHighContrast,
    tertiaryContainer = tertiaryContainerDarkHighContrast,
    onTertiaryContainer = onTertiaryContainerDarkHighContrast,
    error = errorDarkHighContrast,
    onError = onErrorDarkHighContrast,
    errorContainer = errorContainerDarkHighContrast,
    onErrorContainer = onErrorContainerDarkHighContrast,
    background = backgroundDarkHighContrast,
    onBackground = onBackgroundDarkHighContrast,
    surface = surfaceDarkHighContrast,
    onSurface = onSurfaceDarkHighContrast,
    surfaceVariant = surfaceVariantDarkHighContrast,
    onSurfaceVariant = onSurfaceVariantDarkHighContrast,
    outline = outlineDarkHighContrast,
    outlineVariant = outlineVariantDarkHighContrast,
    scrim = scrimDarkHighContrast,
    inverseSurface = inverseSurfaceDarkHighContrast,
    inverseOnSurface = inverseOnSurfaceDarkHighContrast,
    inversePrimary = inversePrimaryDarkHighContrast,
    surfaceDim = surfaceDimDarkHighContrast,
    surfaceBright = surfaceBrightDarkHighContrast,
    surfaceContainerLowest = surfaceContainerLowestDarkHighContrast,
    surfaceContainerLow = surfaceContainerLowDarkHighContrast,
    surfaceContainer = surfaceContainerDarkHighContrast,
    surfaceContainerHigh = surfaceContainerHighDarkHighContrast,
    surfaceContainerHighest = surfaceContainerHighestDarkHighContrast,
)

@Immutable
data class ColorFamily(
    val color: Color,
    val onColor: Color,
    val colorContainer: Color,
    val onColorContainer: Color
)

val unspecified_scheme = ColorFamily(
    Color.Unspecified, Color.Unspecified, Color.Unspecified, Color.Unspecified
)

@Composable
fun AppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable() () -> Unit
) {
  val colorScheme = when {
      dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
          val context = LocalContext.current
          if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
      }
      
      darkTheme -> darkScheme
      else -> lightScheme
  }

  MaterialTheme(
    colorScheme = colorScheme,
    typography = AppTypography,
    content = content
  )
}

