package presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
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
 * @param icon The icon to be displayed in the AppBar.
 * @param iconTint The icon tint color.
 * @param modifier The Modifier to be applied on the AppBar.
 * @param height The height of the AppBar.
 * @param fontSize Font size of the Header.
 * @param onBackPress Click event of the back button.
 */
@Composable
fun RegularAppBar(
    text: String,
    icon: Painter? = null,
    iconTint: Color = Color.White,
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
        Row(
            modifier = Modifier.weight(1f),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(10.dp)
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

            if (icon != null) {
                Icon(
                    painter = icon,
                    tint = iconTint,
                    contentDescription = text
                )
            }
        }

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