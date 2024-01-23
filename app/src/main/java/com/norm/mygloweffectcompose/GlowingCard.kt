package com.norm.mygloweffectcompose

import android.graphics.Paint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun GlowingCard(
    modifier: Modifier = Modifier,
    glowingColor: Color,
    containerColor: Color = Color.White,
    cardRadius: Dp = 0.dp,
    glowingRadius: Dp = 20.dp,
    xShifting: Dp = 0.dp,
    yShifting: Dp = 0.dp,
    content: @Composable BoxScope.() -> Unit
) {
    Box(
        modifier = modifier
            .drawBehind {
                val size = this.size
                drawContext.canvas.nativeCanvas.apply {
                    drawRoundRect(
                        0f,
                        0f,
                        size.width,
                        size.height,
                        cardRadius.toPx(),
                        cardRadius.toPx(),
                        Paint().apply {
                            color = containerColor.toArgb()
                            setShadowLayer(
                                glowingRadius.toPx(),
                                xShifting.toPx(),
                                yShifting.toPx(),
                                glowingColor.copy(alpha = 0.4f).toArgb()
                            )
                        }
                    )
                }
            }
    ) {
        content()
    }
}