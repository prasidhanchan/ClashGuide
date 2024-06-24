package presentation.screens.detail.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import clashguide.composeapp.generated.resources.Res
import clashguide.composeapp.generated.resources.back
import clashguide.composeapp.generated.resources.supercell
import clashguide.composeapp.generated.resources.supercell_logo
import domain.utils.LondrinaSolid
import domain.utils.clashFontColor
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@Composable
fun DetailAppBar(
    modifier: Modifier = Modifier,
    iconSize: Dp = 80.dp,
    verticalAlignment: Alignment.Vertical = Alignment.CenterVertically,
    horizontalArrangement: Arrangement.Horizontal = Arrangement.SpaceBetween,
    onBackPress: () -> Unit
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(iconSize),
        verticalAlignment = verticalAlignment,
        horizontalArrangement = horizontalArrangement
    ) {
        Icon(
            painter = painterResource(resource = Res.drawable.supercell_logo),
            modifier = Modifier.size(iconSize),
            tint = Color.White,
            contentDescription = stringResource(resource = Res.string.supercell)
        )

        TextButton(
            onClick = onBackPress,
            modifier = Modifier.padding(horizontal = 10.dp)
        ) {
            Text(
                text = stringResource(resource = Res.string.back),
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = LondrinaSolid(),
                    color = clashFontColor
                )
            )
        }
    }
}