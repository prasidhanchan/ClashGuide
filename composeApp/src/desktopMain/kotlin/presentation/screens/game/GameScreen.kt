package presentation.screens.game

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import clashguide.composeapp.generated.resources.Res
import clashguide.composeapp.generated.resources.game
import clashguide.composeapp.generated.resources.game_body
import clashguide.composeapp.generated.resources.game_title
import domain.utils.LondrinaSolid
import domain.utils.clashBlack
import domain.utils.clashFontColor
import org.jetbrains.compose.resources.stringResource
import presentation.components.RegularAppBar

@Composable
actual fun GameScreen(
    innerPadding: PaddingValues,
    modifier: Modifier,
    onBackPress: () -> Unit
) {
    Surface(
        modifier = modifier.fillMaxSize(),
        color = clashBlack
    ) {
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(horizontal = 30.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start
        ) {
            RegularAppBar(
                text = stringResource(resource = Res.string.game),
                modifier = Modifier.padding(bottom = 10.dp),
                fontSize = 30,
                onBackPress = onBackPress
            )

            Text(
                text = stringResource(resource = Res.string.game_title),
                style = TextStyle(
                    fontSize = 45.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = LondrinaSolid(),
                    color = clashFontColor
                )
            )

            Spacer(modifier = Modifier.height(30.dp))

            Text(
                text = stringResource(resource = Res.string.game_body),
                modifier = Modifier.fillMaxWidth(0.9f),
                style = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = LondrinaSolid(),
                    color = clashFontColor
                )
            )
        }
    }
}

@Preview
@Composable
private fun GameScreenPreview() {
    GameScreen(
        innerPadding = PaddingValues(),
        onBackPress = { }
    )
}