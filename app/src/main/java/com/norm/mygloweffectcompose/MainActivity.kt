package com.norm.mygloweffectcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                GlowingCard(
                    modifier = Modifier.size(200.dp),
                    glowingColor = Color.Green,
                    cardRadius = Int.MAX_VALUE.dp,
                    glowingRadius = 32.dp
                ) {
                    Text(
                        text = "Content",
                        modifier = Modifier.align(Alignment.Center),
                    )
                }
            }
        }
    }
}