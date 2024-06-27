package presentation.screens.purchase.components

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import clashguide.composeapp.generated.resources.Res
import clashguide.composeapp.generated.resources.only
import clashguide.composeapp.generated.resources.premium_troops
import clashguide.composeapp.generated.resources.price
import clashguide.composeapp.generated.resources.purchase
import clashguide.composeapp.generated.resources.unlimited_access
import clashguide.composeapp.generated.resources.unlimited_views
import domain.utils.LondrinaSolid
import domain.utils.clashFontColor
import org.jetbrains.compose.resources.stringResource
import presentation.components.ClashGuideButton

@Composable
actual fun PurchaseCard(
    modifier: Modifier,
    loading: Boolean,
    onPurchasePress: () -> Unit
) {
    val benefitsList = listOf(
        stringResource(resource = Res.string.premium_troops),
        stringResource(resource = Res.string.unlimited_access),
        stringResource(resource = Res.string.unlimited_views)
    )

    Surface(
        modifier = modifier
            .padding(vertical = 10.dp)
            .fillMaxWidth(0.6f)
            .fillMaxHeight(),
        shape = RoundedCornerShape(15.dp),
        border = BorderStroke(width = 1.dp, color = Color.White),
        color = Color.Transparent
    ) {
        Row(
            modifier = Modifier
                .padding(horizontal = 10.dp, vertical = 20.dp)
                .fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = buildAnnotatedString {
                    withStyle(
                        style = SpanStyle(
                            fontSize = 30.sp,
                            fontWeight = FontWeight.Normal,
                            fontFamily = LondrinaSolid(),
                            color = clashFontColor
                        )
                    ) {
                        append(stringResource(resource = Res.string.only))
                    }

                    withStyle(
                        style = SpanStyle(
                            fontSize = 40.sp,
                            fontWeight = FontWeight.Bold,
                            fontFamily = LondrinaSolid(),
                            color = clashFontColor
                        )
                    ) {
                        append(stringResource(resource = Res.string.price))
                    }
                },
                modifier = Modifier.weight(1f),
                textAlign = TextAlign.Center
            )

            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(2f),
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.Start
            ) {
                benefitsList.forEach { text ->
                    PremiumTextWithIcon(text = text)
                }

                ClashGuideButton(
                    text = stringResource(resource = Res.string.purchase),
                    loading = loading,
                    cornerRadius = 10.dp,
                    onClick = onPurchasePress
                )
            }
        }
    }
}

@Preview
@Composable
private fun PurchaseCardPreview() {
    PurchaseCard()
}