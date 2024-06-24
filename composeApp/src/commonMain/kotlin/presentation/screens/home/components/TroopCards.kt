package presentation.screens.home.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.FilterQuality
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import clashguide.composeapp.generated.resources.Res
import clashguide.composeapp.generated.resources.clash_of_clans
import coil3.compose.AsyncImage
import domain.models.Troop
import domain.utils.ClashMagic
import domain.utils.LondrinaSolid
import domain.utils.clashFontColor
import kotlinx.coroutines.delay
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview

/**
 * Troops card row to display the troop details of the available troops.
 * @param modifier The Modifier to be applied to the row.
 * @param troops List if troops to be displayed.
 * @param cardWidth Width fo each card.
 * @param header Header text to be displayed.
 * @param delay The delay of each card animation in milliseconds.
 * @param duration The duration of the card animation in milliseconds.
 * @param navigateToDetail OnClick event for the card that passes a troop object.
 */
@Composable
fun TroopCards(
    modifier: Modifier = Modifier,
    state: ScrollState = rememberScrollState(),
    troops: List<Troop>,
    cardWidth: Dp = 220.dp,
    header: String,
    duration: Int = 1000,
    delay: Int = 100,
    navigateToDetail: (Troop) -> Unit
) {
    if (troops.isNotEmpty()) {
        Column(
            modifier = modifier
                .padding(all = 10.dp)
                .fillMaxWidth()
                .height(260.dp),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = header,
                style = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = LondrinaSolid(),
                    color = clashFontColor
                ),
                textAlign = TextAlign.Start,
                modifier = Modifier.padding(horizontal = 10.dp)
            )

            Row(
                modifier = Modifier
                    .horizontalScroll(state)
                    .height(250.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                troops.forEachIndexed { index, troop ->
                    TroopCard(
                        troop = troop,
                        cardWidth = cardWidth,
                        duration = duration,
                        delay = delay * index,
                        onClick = { navigateToDetail(troop) }
                    )
                }
            }
        }
    }
}

/**
 * Troops card composable to display the troop details.
 * @param modifier The Modifier to be applied to the card.
 * @param troop The Troops to be displayed.
 * @param cardWidth Width of the card.
 * @param delay The delay of each card animation in milliseconds.
 * @param duration The duration of the card animation in milliseconds.
 * @param onClick OnClick event for the card.
 */
@Composable
private fun TroopCard(
    modifier: Modifier = Modifier,
    troop: Troop,
    cardWidth: Dp = 220.dp,
    duration: Int,
    delay: Int,
    onClick: () -> Unit
) {
    var alpha by rememberSaveable { mutableFloatStateOf(0f) }
    val interactionSource = remember { MutableInteractionSource() }

    val alphaAnimation by animateFloatAsState(
        targetValue = alpha,
        animationSpec = tween(
            durationMillis = duration,
            delayMillis = delay
        ),
        label = "alphaAnimation"
    )

    LaunchedEffect(key1 = Unit) {
        if (alpha == 0f) {
            delay(800L)
            alpha = 1f
        }
    }

    Box(
        modifier = modifier
            .padding(all = 10.dp)
            .fillMaxHeight()
            .width(cardWidth)
            .alpha(alphaAnimation)
            .clickable(
                indication = null,
                interactionSource = interactionSource,
                onClick = onClick
            ),
        contentAlignment = Alignment.BottomCenter
    ) {
        Surface(
            modifier = modifier
                .fillMaxWidth()
                .fillMaxHeight(0.8f),
            shape = RoundedCornerShape(25.dp),
            color = Color(troop.color.substring(2).toLong(16))
        ) {
            Box(
                modifier = Modifier
                    .padding(all = 20.dp)
                    .fillMaxSize(),
                contentAlignment = Alignment.CenterStart
            ) {
                Text(
                    text = stringResource(Res.string.clash_of_clans),
                    style = TextStyle(
                        fontSize = 32.sp,
                        fontWeight = FontWeight.Normal,
                        fontFamily = ClashMagic(),
                        color = Color.Black.copy(alpha = 0.2f)
                    )
                )

                Column(
                    modifier = Modifier
                        .fillMaxSize(),
                    verticalArrangement = Arrangement.Bottom,
                    horizontalAlignment = Alignment.Start
                ) {
                    Text(
                        text = troop.name,
                        style = TextStyle(
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            fontFamily = LondrinaSolid(),
                            color = clashFontColor,
                        ),
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )

                    Text(
                        text = troop.description,
                        style = TextStyle(
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold,
                            fontFamily = LondrinaSolid(),
                            color = clashFontColor,
                        ),
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }
            }
        }

        AsyncImage(
            model = troop.image,
            modifier = Modifier
                .padding(bottom = 55.dp)
                .fillMaxSize(),
            contentScale = ContentScale.Fit,
            filterQuality = FilterQuality.Low,
            alignment = Alignment.Center,
            contentDescription = troop.name
        )
    }
}

@Preview
@Composable
private fun TroopCardPreview() {
    TroopCard(
        troop = Troop(
            _id = "1",
            name = "Giant",
            description = "These big guys may seem calm, but show a Cannon or Archer Tower and you’ll see their fury unleashed!",
            color = "0XFFF98B68",
            image = "",
            isSuperTroop = false
        ),
        duration = 1000,
        delay = 800,
        onClick = { }
    )
}