package presentation.home.components

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import clashguide.composeapp.generated.resources.Res
import clashguide.composeapp.generated.resources.about
import clashguide.composeapp.generated.resources.game
import clashguide.composeapp.generated.resources.menu
import clashguide.composeapp.generated.resources.supercell
import clashguide.composeapp.generated.resources.supercell_logo
import domain.utils.LondrinaSolid
import domain.utils.clashFontColor
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@Composable
actual fun HomeAppBar(
    modifier: Modifier,
    onGameClick: () -> Unit,
    onAboutClick: () -> Unit,
    onMenuClick: () -> Unit
) {
    Row(
        modifier = modifier
            .padding(start = 20.dp, end = 20.dp, top = 20.dp)
            .fillMaxWidth()
            .height(100.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Image(
            modifier = Modifier.size(100.dp),
            painter = painterResource(Res.drawable.supercell_logo),
            contentDescription = stringResource(Res.string.supercell)
        )

        Row(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth(0.9f),
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.End
        ) {
            TextButton(
                onClick = onGameClick,
                content = {
                    Text(
                        text = stringResource(Res.string.game),
                        style = TextStyle(
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            fontFamily = LondrinaSolid(),
                            color = clashFontColor
                        )
                    )
                }
            )

            Spacer(modifier = Modifier.width(20.dp))

            TextButton(
                onClick = onAboutClick,
                content = {
                    Text(
                        text = stringResource(Res.string.about),
                        style = TextStyle(
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            fontFamily = LondrinaSolid(),
                            color = clashFontColor
                        )
                    )
                }
            )

            Spacer(modifier = Modifier.width(20.dp))

            TextButton(
                onClick = onMenuClick,
                content = {
                    Text(
                        text = stringResource(Res.string.menu),
                        style = TextStyle(
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            fontFamily = LondrinaSolid(),
                            color = clashFontColor
                        )
                    )
                }
            )
        }
    }
}

@Preview
@Composable
private fun HomeAppBarPreview() {
    HomeAppBar(
        onGameClick = { },
        onAboutClick = { },
        onMenuClick = { }
    )
}