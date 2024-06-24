package presentation.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import clashguide.composeapp.generated.resources.Res
import clashguide.composeapp.generated.resources.compose_multiplatform
import clashguide.composeapp.generated.resources.github
import clashguide.composeapp.generated.resources.supercell_logo
import clashguide.composeapp.generated.resources.website
import domain.utils.LondrinaSolid
import domain.utils.clashBlack
import domain.utils.clashFontColor
import domain.utils.clashOffBlack
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview

/**
 * Menu Item composable to display the Menu Item lis.
 * @param visible The visibility of the Menu.
 * @param modifier The Modifier to be applied to the Menu.
 * @param contentAlignment The alignment of the Menu.
 * @param topPadding The top padding of the Menu.
 * @param endPadding The end padding of the Menu.
 * @param onDismiss The onDismiss callback to be invoked when the Menu is dismissed.
 */
@Composable
fun ClashGuideMenu(
    visible: Boolean,
    modifier: Modifier = Modifier,
    contentAlignment: Alignment,
    topPadding: Dp,
    endPadding: Dp,
    onDismiss: () -> Unit
) {
    val uriHandler = LocalUriHandler.current
    val interactionSource = remember { MutableInteractionSource() }

    AnimatedVisibility(
        visible = visible,
        enter = fadeIn(),
        exit = fadeOut()
    ) {
        Box(
            modifier = modifier
                .fillMaxSize()
                .background(color = clashOffBlack.copy(alpha = 0.6f))
                .clickable(
                    indication = null,
                    interactionSource = interactionSource,
                    onClick = onDismiss
                ),
            contentAlignment = contentAlignment
        ) {
            Surface(
                modifier = Modifier
                    .padding(top = topPadding, end = endPadding)
                    .wrapContentSize(Alignment.Center),
                shape = RoundedCornerShape(20.dp),
                color = clashBlack
            ) {
                Column(
                    modifier = Modifier.wrapContentSize(Alignment.Center),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    ClashGuideMenuItem(
                        text = stringResource(resource = Res.string.website),
                        leadingIcon = Res.drawable.supercell_logo,
                        trailingIcon = null,
                        onClick = { uriHandler.openUri("https://www.supercell.com") }
                    )

                    Divider(
                        color = Color.White.copy(alpha = 0.2f),
                        thickness = 0.5.dp,
                        modifier = Modifier.width(150.dp)
                    )

                    ClashGuideMenuItem(
                        text = stringResource(resource = Res.string.github),
                        leadingIcon = Res.drawable.github,
                        trailingIcon = null,
                        onClick = { uriHandler.openUri("https://github.com/prasidhanchan") }
                    )
                }
            }
        }
    }
}

/**
 * Menu Item to be displayed in the [ClashGuideMenu]
 * @param text The text to be displayed in the menu item.
 * @param modifier The Modifier to be applied to the menu item.
 * @param leadingIcon The Leading icon to be displayed in the menu item.
 * @param trailingIcon The Trailing icon to be displayed in the menu item.
 * @param onClick The on click callback to be invoked when the menu item is clicked.
 */
@Composable
private fun ClashGuideMenuItem(
    text: String,
    modifier: Modifier = Modifier,
    leadingIcon: DrawableResource,
    trailingIcon: DrawableResource?,
    onClick: () -> Unit
) {
    Surface(
        modifier = modifier
            .height(45.dp)
            .width(200.dp)
            .clickable(onClick = onClick),
        color = clashBlack
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(all = 10.dp),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            ) {
                Icon(
                    painter = painterResource(resource = leadingIcon),
                    tint = Color.White,
                    contentDescription = text
                )

                Text(
                    text = text,
                    modifier = Modifier.padding(horizontal = 10.dp),
                    style = TextStyle(
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Light,
                        fontFamily = LondrinaSolid(),
                        color = clashFontColor
                    )
                )

                if (trailingIcon != null) {
                    Icon(
                        painter = painterResource(resource = trailingIcon),
                        tint = Color.White,
                        contentDescription = text
                    )
                }
            }
        }
    }
}

@Preview
@Composable
private fun ClashGuideMenuPreview() {
    ClashGuideMenu(
        visible = true,
        contentAlignment = Alignment.TopEnd,
        topPadding = 30.dp,
        endPadding = 30.dp,
        onDismiss = { }
    )
}

@Preview
@Composable
private fun ClashGuideMenuItemPreview() {
    ClashGuideMenuItem(
        text = "Website",
        leadingIcon = Res.drawable.compose_multiplatform,
        trailingIcon = null,
        onClick = { }
    )
}

