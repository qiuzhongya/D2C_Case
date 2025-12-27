package com.ss.android.ugc.awme.benchmark.case1

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.bytedance.dux.compose.capability.CarouselIndicator

@Composable
fun IndicatorDemo() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CarouselIndicator(
            itemCount = 5,
            selectedIndex = 1,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
    }
}