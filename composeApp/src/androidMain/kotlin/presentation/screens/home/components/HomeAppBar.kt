package presentation.screens.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
            .padding(horizontal = 25.dp)
            .height(80.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Image(
            painter = painterResource(resource = Res.drawable.supercell_logo),
            modifier = Modifier.size(80.dp),
            contentDescription = stringResource(resource = Res.string.supercell)
        )

        Row(
            modifier = Modifier
                .padding(vertical = 20.dp)
                .fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
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