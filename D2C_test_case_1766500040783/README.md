# D2CShell

## Overview

D2C (Figma 2 code) 代码验证壳工程

## Features

- 通过 gradle 命令快速 Compose 截图

## Usage

- 将生成代码放到 app/src/main/java/com/example/myapplication 目录下

```
// 生成代码示例
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}
```

- 将生成的资源文件解压后，放到 app/src/main/res/drawable-xxhdpi 目录下
- 创建截图测试代码，放到 app/src/test/java/com/example/myapplication 目录下, 示例 ResourcesTest.kt

```
// 截图测试代码示例
@RunWith(TestParameterInjector::class)
class ResourcesTest(
  @TestParameter locale: Locale
) {
  @get:Rule
  val paparazzi = Paparazzi(
    deviceConfig = DeviceConfig.PIXEL_6_PRO.copy(locale = locale.tag)
  )

  @Test
  fun compose() {
    paparazzi.snapshot { Greeting("Android") }
  }

  enum class Locale(val tag: String?) {
    Default(null)
  }
}

```

- 在工程根目录下运行 `./gradlew :app:recordPaparazziDebug` 命令生成截图
- 截图在 app/src/test/snapshots/images 目录下

