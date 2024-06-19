package presentation.home.components

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import clashguide.composeapp.generated.resources.Res
import clashguide.composeapp.generated.resources.slider_image
import clashguide.composeapp.generated.resources.slider_image1
import clashguide.composeapp.generated.resources.slider_image2
import clashguide.composeapp.generated.resources.slider_image3
import domain.utils.clashOffBlack
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview

/**
 * Slider composable to display the list of images.
 * @param modifier Modifier to be applied to the slider.
 * @param sliderImages List of DrawableResource to be displayed.
 * @param duration Duration of the animation in milliseconds.
 * @param delay Delay between each page animation in milliseconds.
 */
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ClashGuideSlider(
    modifier: Modifier = Modifier,
    sliderImages: List<DrawableResource>,
    duration: Int = 800,
    delay: Int = 1000
) {
    val state = rememberPagerState(
        initialPage = sliderImages.size / 2,
        pageCount = { sliderImages.size }
    )

    LaunchedEffect(Unit, state.isScrollInProgress) {
        state.animateScrollToPage(
            page = (state.currentPage + 1) % sliderImages.size,
            animationSpec = tween(
                durationMillis = duration,
                delayMillis = delay
            )
        )
    }

    Column(
        modifier = modifier
            .padding(vertical = 12.dp)
            .fillMaxWidth()
            .height(220.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        HorizontalPager(
            modifier = modifier.weight(6f),
            contentPadding = PaddingValues(horizontal = 30.dp),
            state = state,
            userScrollEnabled = true,
            pageContent = { page ->
                SliderCard(
                    sliderImage = sliderImages[page],
                    isSelected = state.currentPage == page
                )
            }
        )

        DotsIndicator(
            modifier = Modifier
                .padding(top = 10.dp)
                .weight(1f),
            pageCount = sliderImages.size,
            selectedIndex = state.currentPage
        )
    }
}

/**
 * Slider Card composable to display slider images.
 * @param modifier Modifier to be applied to the Card.
 * @param sliderImage DrawableResource to be displayed.
 * @param isSelected Boolean to determine if the card is selected or not.
 */
@Composable
fun SliderCard(
    modifier: Modifier = Modifier,
    sliderImage: DrawableResource,
    isSelected: Boolean
) {
    val height by animateDpAsState(
        targetValue = if (isSelected) 180.dp else 155.dp,
        animationSpec = tween(durationMillis = 600),
        label = "cardHeightAnimation",
    )

    Surface(
        modifier = modifier
            .padding(horizontal = 8.dp)
            .fillMaxWidth()
            .height(height),
        shape = RoundedCornerShape(30.dp),
        color = clashOffBlack
    ) {
        Image(
            painter = painterResource(sliderImage),
            contentDescription = stringResource(Res.string.slider_image),
            contentScale = ContentScale.Crop
        )
    }
}

/**
 * Dots Indicator composable to display the horizontal row of dots.
 * @param modifier Modifier to be applied to the Row.
 * @param pageCount The number of pages in the horizontal pager.
 * @param selectedIndex The index of the currently selected page.
 */
@Composable
fun DotsIndicator(
    modifier: Modifier = Modifier,
    pageCount: Int,
    selectedIndex: Int
) {
    Row(
        modifier = modifier
    ) {
        repeat(pageCount) { page ->
            Box(
                modifier = Modifier
                    .padding(horizontal = 2.dp)
                    .size(8.dp)
                    .clip(CircleShape)
                    .background(color = if (selectedIndex == page) Color.White else Color.Gray),
            )
        }
    }
}

@Preview
@Composable
private fun ClashGuideSliderPreview() {
    ClashGuideSlider(
        sliderImages = listOf(
            Res.drawable.slider_image1,
            Res.drawable.slider_image2,
            Res.drawable.slider_image3
        )
    )
}

@Preview
@Composable
private fun SliderCardPreview() {
    SliderCard(
        sliderImage = Res.drawable.slider_image1,
        isSelected = true
    )
}

@Preview
@Composable
private fun DotsIndicatorPreview() {
    DotsIndicator(
        pageCount = 3,
        selectedIndex = 1
    )
}