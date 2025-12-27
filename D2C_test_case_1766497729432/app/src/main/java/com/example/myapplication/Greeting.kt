package com.example.myapplication

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// Colors
val TextPrimary = Color(0xFF161823)
val TextSecondary = Color(0xFF161823).copy(alpha = 0.60f)
val TextTertiary = Color(0xFF161823).copy(alpha = 0.34f)
val BgReverse = Color(0xFFFFFFFF)
val BrandRed = Color(0xFFFE2C55)
val DividerColor = Color(0xFF161823).copy(alpha = 0.08f)
val OnlineGreen = Color(0xFF4FCA5D) // Approximate green from design

// Data Classes
data class Story(
    val name: String,
    val imageRes: Int,
    val isMine: Boolean = false,
    val hasGradientRing: Boolean = false,
    val isOnline: Boolean = false
)

data class Message(
    val title: String,
    val subTitle: String,
    val avatarRes: Int,
    val time: String? = null,
    val badgeCount: Int = 0,
    val isRedDot: Boolean = false,
    val isMuted: Boolean = false,
    val showArrow: Boolean = false
)

@Composable
fun MessagePage() {
    val stories = listOf(
        Story("我的日常", R.drawable.img_da876f0e16559314de7a9dc432a46404f12a1eb3, isMine = true),
        Story("安卡", R.drawable.img_9214f7967b202d4d544e5de8b10ac41642dc14f1, hasGradientRing = true, isOnline = true),
        Story("Zoe", R.drawable.img_8a23afe11990ec271d36b3cbcf37f9e5a1f78015, hasGradientRing = false, isOnline = true),
        Story("椰子🥥", R.drawable.img_c04bb16d0158fe54aae9fb8c796cf4454db16241, hasGradientRing = false, isOnline = true)
    )

    val messages = listOf(
        Message("新关注我的", "Roy 关注了你", R.drawable.ic_new_friend_avatar, badgeCount = 16, showArrow = true),
        Message("互动消息", "小YY 赞了你的作品", R.drawable.ic_interaction_avatar, badgeCount = 16, showArrow = true),
        Message("为益", "明天去干嘛", R.drawable.img_42a264d86575250baaddc689064d597979b5111f, isRedDot = true),
        Message("宝盖木木", "太棒啦", R.drawable.img_a66fb77cc8e2e5a3e70891bc473bd11a49aa5506, isRedDot = true),
        Message("Weiyi", "[分享视频]", R.drawable.img_42a264d86575250baaddc689064d597979b5111f, showArrow = true),
        Message("琳琳", "4小时内在线", R.drawable.img_c04bb16d0158fe54aae9fb8c796cf4454db16241, time = "刚刚"), // reused img
        Message("阿信", "30 分钟内在线", R.drawable.img_da876f0e16559314de7a9dc432a46404f12a1eb3, time = "昨天 06:50", isMuted = true), // reused img
        Message("椰子🥥", "4小时内在线", R.drawable.img_c04bb16d0158fe54aae9fb8c796cf4454db16241, time = "昨天 06:49"),
        Message("琳琳", "4小时内在线", R.drawable.img_42a264d86575250baaddc689064d597979b5111f, time = "昨天 08:12")
    )

    Scaffold(
        bottomBar = { AppBottomBar() },
        containerColor = BgReverse
    ) { innerPadding ->
        Box(modifier = Modifier.fillMaxSize()) {
            Column(modifier = Modifier.padding(innerPadding)) {
                // Top Bar
                TopBar()
                
                LazyColumn(modifier = Modifier.fillMaxWidth()) {
                    item {
                        // Story Section
                        Box(modifier = Modifier.fillMaxWidth()) {
                            LazyRow(
                                contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
                                horizontalArrangement = Arrangement.spacedBy(16.dp)
                            ) {
                                items(stories) { story ->
                                    StoryItem(story)
                                }
                            }
                            
                            // "Say something" bubble
                            Box(
                                modifier = Modifier
                                    .offset(x = 16.dp, y = (-8).dp)
                                    .background(Color.White, RoundedCornerShape(12.dp))
                                    .border(0.5.dp, DividerColor, RoundedCornerShape(12.dp))
                                    .padding(horizontal = 8.dp, vertical = 4.dp)
                            ) {
                                Text(
                                    text = "说点什么",
                                    color = TextSecondary,
                                    fontSize = 10.sp
                                )
                                // Little triangle pointer can be added with drawing, skipping for simplicity or adding simple path
                            }
                        }
                        Divider(thickness = 0.5.dp, color = DividerColor)
                    }

                    items(messages) { message ->
                        MessageItem(message)
                    }
                }
            }
            
            // Popup Overlay
            PopupOverlay(modifier = Modifier.align(Alignment.TopEnd))
        }
    }
}

@Composable
fun TopBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "消息",
            color = TextPrimary,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )
        Row(horizontalArrangement = Arrangement.spacedBy(20.dp)) {
            Image(
                painter = painterResource(id = R.drawable.ic_s_s_linetext),
                contentDescription = "List",
                modifier = Modifier.size(24.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.ic_feed_search),
                contentDescription = "Search",
                modifier = Modifier.size(24.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.ic_add),
                contentDescription = "Add",
                modifier = Modifier.size(24.dp)
            )
        }
    }
}

@Composable
fun StoryItem(story: Story) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Box(contentAlignment = Alignment.Center) {
            // Ring
            if (story.hasGradientRing) {
                Box(
                    modifier = Modifier
                        .size(68.dp)
                        .border(
                            width = 2.dp,
                            brush = Brush.linearGradient(
                                colors = listOf(Color(0xFF26D2F4), Color(0xFF22E955))
                            ),
                            shape = CircleShape
                        )
                )
            } else if (!story.isMine) {
                 Box(
                    modifier = Modifier
                        .size(68.dp)
                        .border(
                            width = 2.dp,
                            color = Color(0xFF161823).copy(alpha = 0.1f),
                            shape = CircleShape
                        )
                )
            } else {
                Spacer(modifier = Modifier.size(68.dp))
            }

            // Avatar
            Image(
                painter = painterResource(id = story.imageRes),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(56.dp)
                    .clip(CircleShape)
            )

            // Add Icon or Online Dot
            if (story.isMine) {
                Box(
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .offset(x = (-2).dp, y = (-2).dp)
                        .size(18.dp)
                        .background(Color(0xFF2BDB75), CircleShape)
                        .border(2.dp, Color.White, CircleShape),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = null,
                        tint = Color.White,
                        modifier = Modifier.size(12.dp)
                    )
                }
            } else if (story.isOnline) {
                Box(
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .offset(x = (-4).dp, y = (-4).dp)
                        .size(14.dp)
                        .background(OnlineGreen, CircleShape)
                        .border(2.dp, Color.White, CircleShape)
                )
            }
        }
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = story.name,
            fontSize = 13.sp,
            color = TextPrimary
        )
    }
}

@Composable
fun MessageItem(message: Message) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Avatar
        Image(
            painter = painterResource(id = message.avatarRes),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(56.dp)
                .clip(CircleShape)
        )
        
        Spacer(modifier = Modifier.width(12.dp))
        
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = message.title,
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                color = TextPrimary
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = message.subTitle,
                fontSize = 14.sp,
                color = TextSecondary,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
        
        Column(horizontalAlignment = Alignment.End) {
            if (message.time != null) {
                Text(
                    text = message.time,
                    fontSize = 12.sp,
                    color = TextTertiary
                )
                Spacer(modifier = Modifier.height(4.dp))
            }
            
            Row(verticalAlignment = Alignment.CenterVertically) {
                if (message.isMuted) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_im_hint_mute_dark),
                        contentDescription = "Muted",
                        modifier = Modifier.size(16.dp),
                        alpha = 0.34f
                    )
                }
                
                if (message.badgeCount > 0) {
                    Box(
                        modifier = Modifier
                            .background(BrandRed, RoundedCornerShape(10.dp))
                            .padding(horizontal = 6.dp, vertical = 2.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = message.badgeCount.toString(),
                            color = Color.White,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                } else if (message.isRedDot) {
                    Box(
                        modifier = Modifier
                            .size(10.dp)
                            .background(BrandRed, CircleShape)
                    )
                } else if (message.showArrow) {
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowRight,
                        contentDescription = null,
                        tint = TextTertiary,
                        modifier = Modifier.size(20.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun AppBottomBar() {
    NavigationBar(
        containerColor = BgReverse,
        tonalElevation = 0.dp
    ) {
        val items = listOf("首页", "朋友", "+", "消息", "我")
        items.forEachIndexed { index, label ->
            if (label == "+") {
                NavigationBarItem(
                    selected = false,
                    onClick = {},
                    icon = {
                        Image(
                            painter = painterResource(id = R.drawable.ic_bottom_tab_publish),
                            contentDescription = "Publish",
                            modifier = Modifier.size(44.dp) // Custom size for center button
                        )
                    }
                )
            } else {
                NavigationBarItem(
                    selected = index == 3,
                    onClick = {},
                    icon = {
                        // Using text as labels in design, or placeholders if icons
                        if (index == 3) {
                            // Message Icon Placeholder logic or just Text as per design review
                            // Design has specific structure, using Label for simplicity and correctness with "TextPrimary"
                            Box {
                                Text(
                                    text = label, 
                                    color = if (index == 3) TextPrimary else TextSecondary,
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.Bold
                                )
                                if (index == 3) {
                                    Box(
                                        modifier = Modifier
                                            .align(Alignment.TopEnd)
                                            .offset(x = 10.dp, y = (-5).dp)
                                            .background(BrandRed, CircleShape)
                                            .padding(horizontal = 4.dp, vertical = 1.dp)
                                    ) {
                                        Text("2", color = Color.White, fontSize = 10.sp)
                                    }
                                }
                            }
                        } else {
                             Text(
                                text = label, 
                                color = TextSecondary,
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    },
                    colors = NavigationBarItemDefaults.colors(
                        indicatorColor = Color.Transparent
                    )
                )
            }
        }
    }
}

@Composable
fun PopupOverlay(modifier: Modifier = Modifier) {
    // Hardcoded offset to match design visual
    Column(
        modifier = modifier
            .padding(top = 50.dp, end = 10.dp)
            .width(160.dp)
            .background(Color.White, RoundedCornerShape(8.dp))
            .border(0.5.dp, DividerColor, RoundedCornerShape(8.dp))
    ) {
        // Little triangle on top
        // Skipping complex path drawing for brevity, assuming box shadow does enough or simple box
        
        PopupItem(R.drawable.ic_s_s_groupchat, "发起群聊")
        Divider(color = DividerColor, thickness = 0.5.dp)
        PopupItem(R.drawable.ic_actionlist_addfriend, "添加朋友")
        Divider(color = DividerColor, thickness = 0.5.dp)
        PopupItem(R.drawable.ic_s_s_scanround, "扫一扫")
    }
}

@Composable
fun PopupItem(iconRes: Int, text: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {
        Image(
            painter = painterResource(id = iconRes),
            contentDescription = null,
            modifier = Modifier.size(20.dp)
        )
        Spacer(modifier = Modifier.width(12.dp))
        Text(text = text, fontSize = 15.sp, color = TextPrimary)
    }
}

@Preview
@Composable
fun MessagePagePreview() {
    MessagePage()
}