package domain.utils

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import clashguide.composeapp.generated.resources.LondrinaSolid_Black
import clashguide.composeapp.generated.resources.LondrinaSolid_Light
import clashguide.composeapp.generated.resources.LondrinaSolid_Regular
import clashguide.composeapp.generated.resources.LondrinaSolid_Thin
import clashguide.composeapp.generated.resources.Res
import org.jetbrains.compose.resources.Font

/**
 * LondrinaSolid Font family.
 * @return returns a FontFamily object.
 */
@Composable
fun LondrinaSolid(): FontFamily = FontFamily(
    Font(resource = Res.font.LondrinaSolid_Regular, FontWeight.Normal),
    Font(resource = Res.font.LondrinaSolid_Black, FontWeight.Bold),
    Font(resource = Res.font.LondrinaSolid_Thin, FontWeight.Thin),
    Font(resource = Res.font.LondrinaSolid_Light, FontWeight.Light),
)