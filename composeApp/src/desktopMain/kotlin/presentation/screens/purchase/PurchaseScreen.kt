package presentation.screens.purchase

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import clashguide.composeapp.generated.resources.Res
import clashguide.composeapp.generated.resources.access_all_super_troops
import clashguide.composeapp.generated.resources.premium
import clashguide.composeapp.generated.resources.purchase_premium
import clashguide.composeapp.generated.resources.super_wizard
import domain.utils.LondrinaSolid
import domain.utils.clashBlack
import domain.utils.clashFontColor
import domain.utils.clashYellow
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import presentation.screens.purchase.components.PurchaseAppBar
import presentation.screens.purchase.components.PurchaseCard
import presentation.screens.purchase.components.PurchaseCompleteIndicator

@Composable
actual fun PurchaseScreen(
    innerPadding: PaddingValues,
    modifier: Modifier,
    loading: Boolean,
    hasPurchasedPremium: Boolean,
    onPurchasePress: (Boolean) -> Unit,
    onBackPress: () -> Unit
) {
    var showCard by rememberSaveable { mutableStateOf(false) }

    Surface(
        modifier = modifier.fillMaxSize(),
        color = clashBlack
    ) {
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            PurchaseAppBar(
                modifier = Modifier.fillMaxHeight(0.5f),
                horizontalPadding = 30.dp,
                onBackPress = onBackPress
            )

            Text(
                text = buildAnnotatedString {
                    withStyle(
                        style = SpanStyle(
                            fontSize = 30.sp,
                            fontWeight = FontWeight.Bold,
                            fontFamily = LondrinaSolid(),
                            color = clashFontColor
                        )
                    ) {
                        append(stringResource(resource = Res.string.access_all_super_troops))
                    }

                    withStyle(
                        style = SpanStyle(
                            fontSize = 30.sp,
                            fontWeight = FontWeight.Bold,
                            fontFamily = LondrinaSolid(),
                            color = clashYellow
                        )
                    ) {
                        append(stringResource(resource = Res.string.premium))
                    }
                },
                modifier = Modifier
                    .padding(start = 30.dp, end = 30.dp, top = 20.dp)
                    .fillMaxWidth(),
                textAlign = TextAlign.Start
            )

            Row(
                modifier = Modifier
                    .padding(horizontal = 30.dp, vertical = 35.dp)
                    .fillMaxHeight()
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Image(
                    painter = painterResource(resource = Res.drawable.super_wizard),
                    modifier = Modifier.weight(1f),
                    contentDescription = stringResource(resource = Res.string.purchase_premium)
                )

                PurchaseCard(
                    modifier = Modifier.weight(2f),
                    loading = loading,
                    onPurchasePress = {
                        showCard = true
                        onPurchasePress(true)
                    }
                )
            }
        }
    }

    PurchaseCompleteIndicator(
        visible = hasPurchasedPremium && showCard,
        onDismiss = {
            showCard = false
            onBackPress()
        }
    )
}