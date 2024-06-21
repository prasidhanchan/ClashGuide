package presentation.splash

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import clashguide.composeapp.generated.resources.Res
import clashguide.composeapp.generated.resources.supercell
import clashguide.composeapp.generated.resources.supercell_logo
import domain.utils.clashBlack
import kotlinx.coroutines.delay
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@Composable
fun SplashScreen(
    modifier: Modifier = Modifier,
    innerPadding: PaddingValues,
    navigateToHome: () -> Unit
) {
    var alpha by remember { mutableFloatStateOf(0f) }
    val animatedAlpha by animateFloatAsState(
        targetValue = alpha,
        animationSpec = tween(durationMillis = 1000),
        label = "splashAnimation"
    )

    LaunchedEffect(Unit) {
        delay(800L)
        alpha = 1f
        delay(1000L)
        alpha = 0f
        navigateToHome()
    }

    Surface(
        modifier = modifier
            .fillMaxSize(),
        color = clashBlack
    ) {
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                painter = painterResource(Res.drawable.supercell_logo),
                modifier = Modifier
                    .size(150.dp)
                    .alpha(animatedAlpha),
                tint = Color.White,
                contentDescription = stringResource(Res.string.supercell)
            )
        }
    }
}