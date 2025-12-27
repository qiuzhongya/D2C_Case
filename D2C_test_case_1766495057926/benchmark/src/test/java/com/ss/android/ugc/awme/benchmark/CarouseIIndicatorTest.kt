package com.ss.android.ugc.awme.benchmark

import app.cash.paparazzi.DeviceConfig
import com.google.testing.junit.testparameterinjector.TestParameter
import com.google.testing.junit.testparameterinjector.TestParameterInjector
import com.ss.android.ugc.awme.benchmark.case1.IndicatorDemo
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(TestParameterInjector::class)
class CarouseIIndicatorTest(
    @TestParameter locale: Locale
) {
    @get:Rule
    val paparazzi = app.cash.paparazzi.Paparazzi(
        deviceConfig = DeviceConfig.PIXEL_6_PRO.copy(locale = locale.tag)
    )

    @Test
    fun compose() {
        paparazzi.snapshot { IndicatorDemo() }
    }

    enum class Locale(val tag: String?) {
        Default(null)
    }
}
