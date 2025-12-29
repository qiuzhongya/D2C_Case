package com.example.myapplication

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(showBackground = true)
@Composable
fun VideoPostScreen() {
    val scrollState = rememberScrollState()

    Scaffold(
        containerColor = Color.White,
        bottomBar = { BottomBar() }
    ) { innerPadding ->
        Box(modifier = Modifier.fillMaxSize()) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(scrollState)
                    .padding(bottom = 84.dp) // Height of bottom bar
            ) {
                // Status Bar Placeholder
                Spacer(modifier = Modifier.height(47.dp))
                
                // Top Content Padding to accommodate TitleBar which is overlaid
                Spacer(modifier = Modifier.height(44.dp))

                // Preview Area
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Box(
                        modifier = Modifier
                            .size(162.dp, 216.dp)
                            .clip(RoundedCornerShape(8.dp))
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.img_a0de6d91f4117244f86e2afda6c64fdc55975c13),
                            contentDescription = "Preview",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier.fillMaxSize()
                        )
                        Box(
                            modifier = Modifier
                                .align(Alignment.BottomCenter)
                                .padding(bottom = 12.dp)
                                .size(88.dp, 28.dp)
                                .background(
                                    color = Color(0xFF444444).copy(alpha = 0.1f),
                                    shape = RoundedCornerShape(100.dp)
                                ),
                            contentAlignment = Alignment.Center
                        ) {
                            /*
                            Text(
                                text = "选封面",
                                style = TextStyle(
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.Medium,
                                    color = Color.White
                                )
                            )
                            */
                        }
                    }
                }

                // Input Area
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(100.dp)
                        .padding(horizontal = 16.dp, vertical = 20.dp)
                ) {
                    /*
                    BasicTextField(
                        value = "添加标题",
                        onValueChange = {},
                        textStyle = TextStyle(
                            fontSize = 17.sp,
                            fontWeight = FontWeight.Medium,
                            color = Color(0xFF161823)
                        ),
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                     */
                    BasicTextField(
                        value = "",
                        onValueChange = {},
                        decorationBox = { innerTextField ->
                            if (true) { // Simulate Empty
                                Text(
                                    text = "添加作品描述...",
                                    style = TextStyle(
                                        fontSize = 15.sp,
                                        color = Color(0xFF161823).copy(alpha = 0.34f)
                                    )
                                )
                            }
                            innerTextField()
                        },
                        textStyle = TextStyle(
                            fontSize = 15.sp,
                            color = Color(0xFF161823)
                        ),
                        modifier = Modifier.fillMaxWidth()
                    )
                }

                // Features Area
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                ) {
                    // Feature Icons Row
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        FeatureItem(iconRes = R.drawable.ic_hashtag_small_td, text = "话题")
                        Spacer(modifier = Modifier.width(20.dp))
                        FeatureItem(iconRes = R.drawable.ic_at_small_td, text = "朋友")
                        Spacer(modifier = Modifier.width(20.dp))
                        Spacer(modifier = Modifier.weight(5f))
                        //FeatureItem(iconRes = R.drawable.ic_template, text = "模板") // Using placeholder for template group
                        //Spacer(modifier = Modifier.weight(1f))
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Image(
                                painter = painterResource(id = R.drawable.ic_expand),
                                contentDescription = "Expand",
                                modifier = Modifier.size(32.dp)
                            )
                            Spacer(modifier = Modifier.width(4.dp))
                            /*
                            Text(
                                text = "展开",
                                style = TextStyle(
                                    fontSize = 13.sp,
                                    color = Color(0xFF161823)
                                )
                            )
                            */
                        }
                    }

                    Spacer(modifier = Modifier.height(12.dp))

                    // Suggestions Row
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .horizontalScroll(rememberScrollState()),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        SuggestionChip(text = "卫星桥下")
                        SuggestionChip(text = "实地拍摄")
                        SuggestionChip(text = "享受这悠闲时光")
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))
                Divider(thickness = 0.5.dp, color = Color(0xFF161823).copy(alpha = 0.12f), modifier = Modifier.padding(horizontal = 16.dp))

                // Settings List
                Column(modifier = Modifier.fillMaxWidth()) {
                    // Location
                    SettingsItem(
                        iconRes = R.drawable.ic_pin_small_dt,
                        title = "你在哪里",
                        //subtitle = "卫星桥下",
                        rightContent = {
                            // Arrow handled by item
                        },
                        showSubtitleInTag = true
                    )
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .horizontalScroll(rememberScrollState()),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        SuggestionLocation(text = "卫星桥下")
                        SuggestionLocation(text = "知村社区居民活动...")
                        SuggestionLocation(text = "百万庄园（卫星")
                    }
                    
                    // Add Element
                    SettingsItem(
                        iconRes = R.drawable.ic_s_s_module,
                        title = "添加标签",
                        rightContent = {
                            Text(
                                text = "商品、影视综艺等",
                                style = TextStyle(
                                    fontSize = 14.sp,
                                    color = Color(0xFF161823).copy(alpha = 0.34f)
                                )
                            )
                        }
                    )

                    // Privacy
                    SettingsItem(
                        iconRes = R.drawable.ic_lock_small_dt,
                        title = "公开 · 所有人可见",
                        rightContent = {}
                    )

                    // Advanced
                    SettingsItem(
                        iconRes = R.drawable.icon_filter_management_dt, // Using placeholder for ic_post_limit_public_2
                        title = "高级设置",
                        rightContent = {}
                    )
                }
            }

            // Title Bar (Overlaid)
            TopBar()
        }
    }
}

@Composable
fun TopBar() {
    Column(modifier = Modifier.fillMaxWidth()) {
        Spacer(modifier = Modifier.height(47.dp)) // Status Bar Height
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(44.dp)
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(id = R.drawable.left_button_1),
                    contentDescription = "Back",
                    modifier = Modifier.size(24.dp)
                )
                Spacer(modifier = Modifier.width(20.dp))
                Image(
                    painter = painterResource(id = R.drawable.left_button_2),
                    contentDescription = "Close",
                    modifier = Modifier.size(24.dp)
                )
            }
            /*
            Text(
                text = "标题栏",
                style = TextStyle(
                    fontSize = 17.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color(0xFF161823),
                    textAlign = TextAlign.Center
                )
            )
            */
            Row(verticalAlignment = Alignment.CenterVertically) {
                // Empty view to balance layout if needed, or specific right icons
                Spacer(modifier = Modifier.width(68.dp)) // Approximate width of left buttons
            }
        }
    }
}

@Composable
fun FeatureItem(iconRes: Int, text: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Image(
            painter = painterResource(id = iconRes),
            contentDescription = null,
            modifier = Modifier.size(14.dp)
        )
        Text(
            text = text,
            style = TextStyle(
                fontSize = 15.sp,
                fontWeight = FontWeight.Medium,
                color = Color(0xFF161823)
            )
        )
    }
}

@Composable
fun SuggestionChip(text: String) {
    Box(
        modifier = Modifier
            .height(36.dp)
            .background(
                color = Color(0xFF161823).copy(alpha = 0.05f),
                shape = RoundedCornerShape(8.dp)
            )
            .padding(horizontal = 12.dp),
        contentAlignment = Alignment.Center
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            // Assuming hashtag icon is part of suggestion or text starts with # in data
            // Design shows icon in chip
            Image(
                painter = painterResource(id = R.drawable.ic_hashtag_small_td),
                contentDescription = null,
                modifier = Modifier.size(14.dp)
            )
            Spacer(modifier = Modifier.width(4.dp))
            Text(
                text = text,
                style = TextStyle(
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color(0xFF161823).copy(alpha = 0.6f)
                )
            )
        }
    }
}

@Composable
fun SuggestionLocation(text: String) {
    Box(
        modifier = Modifier
            .height(36.dp)
            .background(
                color = Color(0xFF161823).copy(alpha = 0.05f),
                shape = RoundedCornerShape(8.dp)
            )
            .padding(horizontal = 12.dp),
        contentAlignment = Alignment.Center
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            // Assuming hashtag icon is part of suggestion or text starts with # in data
            // Design shows icon in chip
            Text(
                text = text,
                style = TextStyle(
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color(0xFF161823)
                )
            )
        }
    }
}

@Composable
fun SettingsItem(
    iconRes: Int,
    title: String,
    subtitle: String? = null,
    rightContent: @Composable () -> Unit,
    showSubtitleInTag: Boolean = false
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { }
            .padding(horizontal = 16.dp, vertical = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = iconRes),
            contentDescription = null,
            modifier = Modifier.size(20.dp)
        )
        Spacer(modifier = Modifier.width(12.dp))
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = title,
                style = TextStyle(
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color(0xFF161823)
                )
            )
            if (subtitle != null) {
                Spacer(modifier = Modifier.height(4.dp))
                if (showSubtitleInTag) {
                    Box(
                        modifier = Modifier
                            .background(
                                color = Color(0xFF161823).copy(alpha = 0.05f),
                                shape = RoundedCornerShape(4.dp)
                            )
                            .padding(horizontal = 6.dp, vertical = 2.dp)
                    ) {
                        Text(
                            text = subtitle,
                            style = TextStyle(
                                fontSize = 12.sp,
                                color = Color(0xFF161823).copy(alpha = 0.6f)
                            )
                        )
                    }
                } else {
                    Text(
                        text = subtitle,
                        style = TextStyle(
                            fontSize = 12.sp,
                            color = Color(0xFF161823).copy(alpha = 0.6f)
                        )
                    )
                }
            }
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            rightContent()
            Spacer(modifier = Modifier.width(4.dp))
            Image(
                painter = painterResource(id = R.drawable.ic_arrow_small_dt),
                contentDescription = null,
                modifier = Modifier.size(20.dp)
            )
        }
    }
}

@Composable
fun BottomBar() {
    Column(modifier = Modifier.fillMaxWidth().background(Color.White)) {
        Divider(thickness = 0.5.dp, color = Color(0xFF161823).copy(alpha = 0.12f))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Save Draft
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(end = 16.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_save_draft),
                    contentDescription = "Draft",
                    modifier = Modifier.size(24.dp)
                )
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    text = "存草稿",
                    style = TextStyle(
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Medium,
                        color = Color(0xFF161823)
                    )
                )
            }

            // Buttons
            Row(
                modifier = Modifier.weight(1f),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                // Daily Button
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .height(44.dp)
                        .background(
                            color = Color(0xFF161823).copy(alpha = 0.05f),
                            shape = RoundedCornerShape(8.dp)
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Box(
                            modifier = Modifier
                                .size(26.dp)
                                .border(
                                    width = 1.5.dp,
                                    brush = Brush.linearGradient(
                                        colors = listOf(
                                            Color(0xFF4FC3F7),
                                            Color(0xFF00F2FE),
                                            Color(0xFF43E97B)
                                        )
                                    ),
                                    shape = CircleShape
                                )
                                .padding(2.dp)
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.img_da876f0e16559314de7a9dc432a46404f12a1eb3),
                                contentDescription = null,
                                contentScale = ContentScale.Crop,
                                modifier = Modifier
                                    .fillMaxSize()
                                    .clip(CircleShape)
                            )
                        }
                        Spacer(modifier = Modifier.width(6.dp))
                        Text(
                            text = "发日常",
                            style = TextStyle(
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Medium,
                                color = Color(0xFF161823)
                            )
                        )
                    }
                }

                // Post Button
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .height(44.dp)
                        .background(
                            color = Color(0xFFFE2C55),
                            shape = RoundedCornerShape(8.dp)
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_post_work),
                            contentDescription = null,
                            modifier = Modifier.size(20.dp)
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            text = "发作品",
                            style = TextStyle(
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Medium,
                                color = Color.White
                            )
                        )
                    }
                }
            }
        }
        Spacer(modifier = Modifier.height(20.dp)) // Home indicator area
    }
}