package presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import clashguide.composeapp.generated.resources.Res
import clashguide.composeapp.generated.resources.back
import domain.utils.LondrinaSolid
import domain.utils.clashFontColor
import org.jetbrains.compose.resources.stringResource

/**
 * Regular AppBar That displays a Header text and a back button.
 * @param text The Header text to be displayed.
 * @param modifier The Modifier to be applied on the AppBar.
 * @param height The height of the AppBar.
 * @param fontSize Font size of the Header.
 * @param onBackPress Click event of the back button.
 */
@Composable
fun RegularAppBar(
    text: String,
    modifier: Modifier = Modifier,
    height: Dp = 100.dp,
    fontSize: Int = 22,
    onBackPress: () -> Unit
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(height),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = text,
            style = TextStyle(
                fontSize = fontSize.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = LondrinaSolid(),
                color = clashFontColor
            )
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