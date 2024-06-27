package presentation.screens.purchase.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import clashguide.composeapp.generated.resources.Res
import clashguide.composeapp.generated.resources.only
import clashguide.composeapp.generated.resources.premium_troops
import clashguide.composeapp.generated.resources.price
import clashguide.composeapp.generated.resources.purchase_premium
import clashguide.composeapp.generated.resources.super_wizard
import clashguide.composeapp.generated.resources.unlimited_access
import clashguide.composeapp.generated.resources.unlimited_views
import domain.utils.LondrinaSolid
import domain.utils.clashFontColor
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

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
            .fillMaxWidth(0.9f)
            .height(200.dp),
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
            Image(
                painter = painterResource(resource = Res.drawable.super_wizard),
                modifier = Modifier.weight(1f),
                contentDescription = stringResource(resource = Res.string.purchase_premium)
            )

            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(1f),
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.Start
            ) {
                Column(
                    modifier = Modifier.weight(1f),
                    verticalArrangement = Arrangement.spacedBy(5.dp),
                    horizontalAlignment = Alignment.Start
                ) {
                    benefitsList.forEach { text ->
                        PremiumTextWithIcon(text = text)
                    }
                }

                Text(
                    text = buildAnnotatedString {
                        withStyle(
                            style = SpanStyle(
                                fontSize = 25.sp,
                                fontWeight = FontWeight.Normal,
                                fontFamily = LondrinaSolid(),
                                color = clashFontColor
                            )
                        ) {
                            append(stringResource(resource = Res.string.only))
                        }

                        withStyle(
                            style = SpanStyle(
                                fontSize = 32.sp,
                                fontWeight = FontWeight.Bold,
                                fontFamily = LondrinaSolid(),
                                color = clashFontColor
                            )
                        ) {
                            append(stringResource(resource = Res.string.price))
                        }
                    }
                )
            }
        }
    }
}