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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun VipScreen() {
    Scaffold(
        bottomBar = { BottomNavBar() },
        containerColor = Color(0xFF121212)
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = innerPadding.calculateBottomPadding())
        ) {
            // 1. Background Content
            BackgroundGrid()

            // 2. Scrollable Sheet Content
            val scrollState = rememberScrollState()
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(scrollState)
            ) {
                // Transparent space for background visibility
                Spacer(modifier = Modifier.height(127.dp))

                Box(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    // Sheet Background & Content
                    Column(
                        modifier = Modifier
                            .padding(top = 50.dp) // Space for half avatar
                            .fillMaxWidth()
                            .background(
                                color = Color(0xFF121212).copy(alpha = 0.95f),
                                shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp)
                            )
                            .padding(bottom = 80.dp) // Bottom padding for scrolling
                    ) {
                        Spacer(modifier = Modifier.height(60.dp)) // Space inside for avatar

                        // Profile Info
                        ProfileInfoSection()

                        // Middle Banner (VIP)
                        VipBannerSection()

                        // Tabs
                        TabSection()

                        // Song List
                        SongListSection()
                    }

                    // Avatar (Overlapping)
                    Image(
                        painter = painterResource(id = R.drawable.img_f7fbc82541ddcf52fd4178802ca5116197fb80c1),
                        contentDescription = "Avatar",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .align(Alignment.TopCenter)
                            .size(100.dp)
                            .clip(CircleShape)
                            .border(1.dp, Color.White.copy(alpha = 0.1f), CircleShape)
                    )
                }
            }

            // 3. Top Navigation Bar
            TopNavBar()
        }
    }
}

@Composable
fun BackgroundGrid() {
    Row(
        modifier = Modifier
            .fillMaxSize()
            .alpha(0.3f),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        val colModifier = Modifier.weight(1f).fillMaxHeight()
        // Column 1
        Column(colModifier, verticalArrangement = Arrangement.spacedBy(8.dp)) {
            BgImage(R.drawable.img_6633a8d04a1cda5a8b8f90bf41f87d251c51ba0d)
            BgImage(R.drawable.img_4cd5fb347d63e9e413842cfce938653cee3b4f91)
            BgImage(R.drawable.img_5be8e224fe9dd21271d217575caa22a678aec20a)
            BgImage(R.drawable.img_5be8e224fe9dd21271d217575caa22a678aec20a)
            BgImage(R.drawable.img_5be8e224fe9dd21271d217575caa22a678aec20a)
            BgImage(R.drawable.img_cd2aad3a71df3fdb156e6709ca6cea34dff337b7)
            BgImage(R.drawable.img_59d8b621c0e13258ac5275c93708a02e1e8b7da2)
        }
        // Column 2
        Column(colModifier, verticalArrangement = Arrangement.spacedBy(8.dp)) {
            Spacer(Modifier.height(40.dp))
            BgImage(R.drawable.img_d7a79a220d3a288280f147870ee4a3375c48a494)
            BgImage(R.drawable.img_a90df7a8aafe8c7cbcc0b8434befe45694824895)
            BgImage(R.drawable.img_64f8e20bb14588c1ed214798e8382df8af9c6be8)
            BgImage(R.drawable.img_64f8e20bb14588c1ed214798e8382df8af9c6be8)
            BgImage(R.drawable.img_b468267a62c052e7433e67206dc8b66967aea493)
            BgImage(R.drawable.img_f8313dd373c5c7eb6789218974b8420c32d88989)
        }
        // Column 3
        Column(colModifier, verticalArrangement = Arrangement.spacedBy(8.dp)) {
            Spacer(Modifier.height(20.dp))
            BgImage(R.drawable.img_d44bb56e27524488382f1785ab25f6f784138338)
            BgImage(R.drawable.img_a4ab4b825d907ee9d389cf2c304d03e6b8e862a0)
            BgImage(R.drawable.img_f8313dd373c5c7eb6789218974b8420c32d88989)
            BgImage(R.drawable.img_6633a8d04a1cda5a8b8f90bf41f87d251c51ba0d)
            BgImage(R.drawable.img_59d8b621c0e13258ac5275c93708a02e1e8b7da2)
            BgImage(R.drawable.img_f8313dd373c5c7eb6789218974b8420c32d88989)
        }
        // Column 4
        Column(colModifier, verticalArrangement = Arrangement.spacedBy(8.dp)) {
            BgImage(R.drawable.img_bb54a7fd322d16a2c9dadcd5b5b84bde6646f784)
            BgImage(R.drawable.img_2724e2dea350ff5783a3f5e15b7ab3809d061e45)
            BgImage(R.drawable.img_d7a79a220d3a288280f147870ee4a3375c48a494)
            BgImage(R.drawable.img_d7a79a220d3a288280f147870ee4a3375c48a494)
            BgImage(R.drawable.img_7feffe94641e7caea07a1f5ba4f075e6b30163d0)
            BgImage(R.drawable.img_2724e2dea350ff5783a3f5e15b7ab3809d061e45)
            BgImage(R.drawable.img_f0ffae22532bc54afd2c5d3a0ac1d62532257f48)
        }
    }
}

@Composable
fun BgImage(resId: Int) {
    Image(
        painter = painterResource(id = resId),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp) // Approximate height
            .clip(RoundedCornerShape(8.dp))
    )
}

@Composable
fun TopNavBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 44.dp, start = 20.dp, end = 20.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = R.drawable.nav_message_normal),
            contentDescription = "Message",
            modifier = Modifier.size(24.dp)
        )
        Image(
            painter = painterResource(id = R.drawable.nav_settings),
            contentDescription = "Settings",
            modifier = Modifier.size(24.dp)
        )
    }
}

@Composable
fun BottomNavBar() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(83.dp)
            .background(Color(0xFF121212).copy(alpha = 0.85f))
            .blur(40.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.Top
        ) {
            BottomNavItem("发现", R.drawable.ic_tab_discovery)
            BottomNavItem("音乐", R.drawable.ic_tab_music)
            BottomNavItem("我的", R.drawable.ic_tab_me)
        }
    }
}

@Composable
fun BottomNavItem(label: String, iconRes: Int) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Image(
            painter = painterResource(id = iconRes),
            contentDescription = label,
            modifier = Modifier.size(24.dp)
        )
        Text(
            text = label,
            color = Color.White.copy(alpha = 0.35f),
            fontSize = 11.sp,
            fontWeight = FontWeight.Medium
        )
    }
}

@Composable
fun ProfileInfoSection() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ) {
        // Name
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = "奇妙叶",
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold
            )
            Spacer(modifier = Modifier.width(4.dp))
            Image(
                painter = painterResource(id = R.drawable.ic_vip_logo),
                contentDescription = "VIP",
                modifier = Modifier.size(width = 24.dp, height = 10.dp)
            )
        }

        Spacer(modifier = Modifier.height(12.dp))

        // Tags
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(id = R.drawable.ic_metab_male),
                    contentDescription = "Male",
                    modifier = Modifier.size(10.dp)
                )
                Spacer(modifier = Modifier.width(2.dp))
                Text("22岁", color = Color.White.copy(alpha = 0.75f), fontSize = 11.sp)
            }
            HorizontalDivider(modifier = Modifier.height(8.dp).width(1.dp), color = Color.White.copy(alpha = 0.2f))
            Text("浙江·宁波", color = Color.White.copy(alpha = 0.75f), fontSize = 11.sp)
            HorizontalDivider(modifier = Modifier.height(8.dp).width(1.dp), color = Color.White.copy(alpha = 0.2f))
            Text("上海交通大学", color = Color.White.copy(alpha = 0.75f), fontSize = 11.sp)
        }

        Spacer(modifier = Modifier.height(12.dp))

        // Stats
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            StatItem("562", "关注")
            Spacer(modifier = Modifier.width(24.dp))
            StatItem("40", "粉丝")
            Spacer(modifier = Modifier.width(24.dp))
            StatItem("106", "获赞")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Douyin Link
        Row(
            modifier = Modifier
                .background(Color(0xFF292929).copy(alpha = 0.85f), RoundedCornerShape(40.dp))
                .padding(horizontal = 12.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_douyin_logo),
                contentDescription = null,
                modifier = Modifier.size(16.dp)
            )
            Spacer(modifier = Modifier.width(6.dp))
            Text("抖音主页", color = Color.White.copy(alpha = 0.75f), fontSize = 11.sp)
            Spacer(modifier = Modifier.width(8.dp))
            HorizontalDivider(modifier = Modifier.height(10.dp).width(1.dp), color = Color.White.copy(alpha = 0.2f))
            Spacer(modifier = Modifier.width(8.dp))
            Text("抖音知名摄影师", color = Color.White.copy(alpha = 0.75f), fontSize = 11.sp)
            Spacer(modifier = Modifier.width(4.dp))
            Image(
                painter = painterResource(id = R.drawable.ic_comment_arrow_right_middle),
                contentDescription = null,
                modifier = Modifier.size(width = 5.dp, height = 9.dp)
            )
        }
    }
}

@Composable
fun StatItem(number: String, label: String) {
    Row(verticalAlignment = Alignment.Bottom) {
        Text(number, color = Color.White.copy(alpha = 0.85f), fontSize = 14.sp, fontWeight = FontWeight.Medium)
        Spacer(modifier = Modifier.width(4.dp))
        Text(label, color = Color.White.copy(alpha = 0.75f), fontSize = 13.sp)
    }
}

@Composable
fun VipBannerSection() {
    Box(
        modifier = Modifier
            .padding(horizontal = 20.dp, vertical = 20.dp)
            .fillMaxWidth()
            .height(60.dp)
            .background(Color(0xFF3A3A3C), RoundedCornerShape(12.dp))
            .padding(horizontal = 12.dp)
    ) {
        Column(
            modifier = Modifier.align(Alignment.CenterStart),
            verticalArrangement = Arrangement.Center
        ) {
            Text("VIP 限时最低价", color = Color.White.copy(alpha = 0.85f), fontSize = 15.sp, fontWeight = FontWeight.Medium)
            Spacer(modifier = Modifier.height(2.dp))
            Text("天天送活动已到期，已领取X天", color = Color.White.copy(alpha = 0.5f), fontSize = 13.sp)
        }

        Row(
            modifier = Modifier.align(Alignment.CenterEnd),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Overlapping Avatars
            Box(modifier = Modifier.width(50.dp).height(24.dp)) {
                Image(
                    painter = painterResource(id = R.drawable.img_72cf826174c292109c4ed9e4a0687614d76e31d2),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.size(24.dp).clip(CircleShape).border(1.dp, Color(0xFF3A3A3C), CircleShape)
                )
                Image(
                    painter = painterResource(id = R.drawable.img_e11df817967da2685c4215a9c380a4f5210351f5),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.offset(x = 16.dp).size(24.dp).clip(CircleShape).border(1.dp, Color(0xFF3A3A3C), CircleShape)
                )
            }
            Spacer(modifier = Modifier.width(4.dp))
            Image(
                painter = painterResource(id = R.drawable.ic_arrow_right),
                contentDescription = null,
                modifier = Modifier.size(width = 6.dp, height = 12.dp).alpha(0.5f)
            )
        }
    }
}

@Composable
fun TabSection() {
    Column(modifier = Modifier.fillMaxWidth()) {
        LazyRow(
            contentPadding = PaddingValues(horizontal = 20.dp),
            horizontalArrangement = Arrangement.spacedBy(40.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            item { TabText("歌单", false) }
            item { TabText("参与的话题", false) }
            item { TabText("已购", false) }
            item { 
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text("下载", color = Color.White.copy(alpha = 0.85f), fontSize = 14.sp, fontWeight = FontWeight.Medium)
                    Spacer(modifier = Modifier.height(4.dp))
                    Box(modifier = Modifier.size(width = 14.dp, height = 2.dp).background(Color.White.copy(alpha = 0.85f), RoundedCornerShape(2.dp)))
                }
            }
            item { TabText("历史播放", false) }
        }
        Spacer(modifier = Modifier.height(16.dp))
    }
}

@Composable
fun TabText(text: String, isSelected: Boolean) {
    Text(
        text = text,
        color = if (isSelected) Color.White.copy(alpha = 0.85f) else Color.White.copy(alpha = 0.35f),
        fontSize = 14.sp,
        fontWeight = FontWeight.Medium
    )
}

@Composable
fun SongListSection() {
    Column(modifier = Modifier.padding(horizontal = 20.dp)) {
        SongItem("1", R.drawable.img_e9259635324809946e717b54074fc1c259c694f3, "富士山下", "陈奕迅 · The Moment", true, true, false, false)
        SongItem("2", R.drawable.img_182304fb2094856181c57d4c42e79f0dd2dd122b, "红玫瑰", "陈奕迅 · The Moment", true, true, false, false)
        SongItem("3", R.drawable.img_b65aa7df295d140896e381f019a1b7ca4dbb195d, "不要说话", "陈奕迅 · 逆光", true, true, false, false)
        SongItem("4", R.drawable.img_e9259635324809946e717b54074fc1c259c694f3, "Scared To Be Lonely", "Martin Garrix/Dua Lipa · Scared to be lo...", true, false, false, false)
        SongItem("5", R.drawable.img_b65aa7df295d140896e381f019a1b7ca4dbb195d, "IDGAF(Explicit)", "Dua Lipa ·  Dua Lipa(Deluxe)", true, true, true, true)
    }
}

@Composable
fun SongItem(
    index: String,
    coverRes: Int,
    title: String,
    subtitle: String,
    showActions: Boolean,
    isVip: Boolean,
    isOriginal: Boolean,
    isNew: Boolean
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = index,
            color = Color.White.copy(alpha = 0.5f),
            fontSize = 15.sp,
            modifier = Modifier.width(20.dp)
        )
        Spacer(modifier = Modifier.width(12.dp))
        Image(
            painter = painterResource(id = coverRes),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.size(52.dp).clip(RoundedCornerShape(4.dp))
        )
        Spacer(modifier = Modifier.width(12.dp))
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = title,
                color = Color.White.copy(alpha = 0.9f),
                fontSize = 15.sp,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Spacer(modifier = Modifier.height(4.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                if (isVip) {
                    TagItem("VIP")
                    Spacer(modifier = Modifier.width(4.dp))
                }
                if (isOriginal) {
                    TagItem("原唱")
                    Spacer(modifier = Modifier.width(4.dp))
                }
                if (isNew) {
                    TagItem("新歌")
                    Spacer(modifier = Modifier.width(4.dp))
                }
                Text(
                    text = subtitle,
                    color = Color.White.copy(alpha = 0.5f),
                    fontSize = 13.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
        if (showActions) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(id = R.drawable.ic_cut_in_playlist),
                    contentDescription = "Next",
                    modifier = Modifier.size(24.dp).alpha(0.5f)
                )
                Spacer(modifier = Modifier.width(16.dp))
                Image(
                    painter = painterResource(id = R.drawable.ic_heart),
                    contentDescription = "Like",
                    modifier = Modifier.size(24.dp).alpha(0.5f)
                )
                Spacer(modifier = Modifier.width(16.dp))
                Image(
                    painter = painterResource(id = R.drawable.ic_three_point_vertical),
                    contentDescription = "More",
                    modifier = Modifier.size(24.dp).alpha(0.5f)
                )
            }
        }
    }
}

@Composable
fun TagItem(text: String) {
    Box(
        modifier = Modifier
            .border(1.dp, Color(0xFF00CB5A).copy(alpha = 0.2f), RoundedCornerShape(4.dp))
            .background(Color(0xFF00CB5A).copy(alpha = 0.2f), RoundedCornerShape(4.dp))
            .padding(horizontal = 4.dp, vertical = 1.dp)
    ) {
        Text(
            text = text,
            color = Color(0xFF00CB5A),
            fontSize = 8.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Preview(widthDp = 375, heightDp = 812)
@Composable
fun VipScreenPreview() {
    VipScreen()
}