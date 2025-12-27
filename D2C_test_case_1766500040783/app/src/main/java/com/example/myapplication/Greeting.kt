package com.example.myapplication

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
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

@Preview(widthDp = 375, heightDp = 812)
@Composable
fun MusicPlayerScreen() {
    val gradientBrush = Brush.verticalGradient(
        colors = listOf(
            Color(0xFF5D3B23),
            Color(0xFF271305)
        )
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(brush = gradientBrush)
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            // Status Bar
            StatusBar()

            // Top Bar
            TopBar()

            // Main Content
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .verticalScroll(rememberScrollState())
                    .padding(top = 30.dp), // 118 (y pos of cover) - 44 (status) - 44 (top bar) = 30
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // Cover
                Image(
                    painter = painterResource(id = R.drawable.img_7bb7709d9f2e07b68d082710f6347b315d5c5ca4),
                    contentDescription = "Cover",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(335.dp)
                        .clip(RoundedCornerShape(12.dp))
                        .align(Alignment.CenterHorizontally)
                )

                Spacer(modifier = Modifier.height(51.5.dp))

                // Lyrics
                Text(
                    text = "And everything you do",
                    style = TextStyle(
                        fontFamily = androidx.compose.ui.text.font.FontFamily.Default,
                        fontWeight = FontWeight.Medium,
                        fontSize = 17.sp,
                        lineHeight = 20.sp,
                        color = Color.White.copy(alpha = 0.5f)
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp)
                )

                Spacer(modifier = Modifier.height(51.dp))

                // Song Info
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp),
                    horizontalAlignment = Alignment.Start
                ) {
                    // Title and VIP
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            text = "Yellow",
                            style = TextStyle(
                                fontFamily = androidx.compose.ui.text.font.FontFamily.Default,
                                fontWeight = FontWeight.Medium,
                                fontSize = 22.sp,
                                color = Color.White
                            )
                        )
                        Spacer(modifier = Modifier.width(6.dp))
                        Box(
                            modifier = Modifier
                                .height(16.dp)
                                .background(
                                    color = Color.White.copy(alpha = 0.1f),
                                    shape = RoundedCornerShape(4.dp)
                                )
                                .padding(horizontal = 4.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "VIP",
                                style = TextStyle(
                                    fontSize = 10.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color.White
                                )
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    // Artist and Follow
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            text = "Coldplay",
                            style = TextStyle(
                                fontFamily = androidx.compose.ui.text.font.FontFamily.Default,
                                fontWeight = FontWeight.Normal,
                                fontSize = 15.sp,
                                color = Color.White.copy(alpha = 0.85f)
                            )
                        )
                        Spacer(modifier = Modifier.width(6.dp))
                        Box(
                            modifier = Modifier
                                .height(17.dp)
                                .background(
                                    color = Color.White.copy(alpha = 0.2f),
                                    shape = RoundedCornerShape(20.dp)
                                )
                                .padding(horizontal = 7.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "关注",
                                style = TextStyle(
                                    fontFamily = androidx.compose.ui.text.font.FontFamily.Default,
                                    fontSize = 9.sp,
                                    fontWeight = FontWeight.Medium,
                                    color = Color.White.copy(alpha = 0.85f)
                                )
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(26.dp))

                    // Action Row
                    ActionRow()

                    Spacer(modifier = Modifier.height(26.dp))

                    // Progress Row
                    ProgressRow()
                }

                Spacer(modifier = Modifier.height(50.dp))
            }
        }
        
        // Home Indicator
        Box(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 8.dp)
                .width(135.dp)
                .height(5.dp)
                .background(Color(0xFFFDFFFF), RoundedCornerShape(100.dp))
        )
    }
}

@Composable
fun StatusBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(44.dp)
            .padding(horizontal = 20.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Time
        Text(
            text = "9:41",
            style = TextStyle(
                fontSize = 15.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.White,
                textAlign = TextAlign.Center
            ),
            modifier = Modifier.width(54.dp)
        )
        
        // Status Icons
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(5.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_combined_shape),
                contentDescription = "Signal",
                modifier = Modifier.size(17.dp, 10.7.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.ic_wi_fi),
                contentDescription = "Wifi",
                modifier = Modifier.size(15.4.dp, 11.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.ic_battery),
                contentDescription = "Battery",
                modifier = Modifier.size(24.5.dp, 11.5.dp)
            )
        }
    }
}

@Composable
fun TopBar() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(44.dp)
            .padding(horizontal = 20.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_s_s_arrowdown_outlined),
            contentDescription = "Down Arrow",
            modifier = Modifier
                .size(24.dp)
                .align(Alignment.CenterStart)
        )

        Text(
            text = "深夜emo",
            style = TextStyle(
                fontSize = 17.sp,
                fontWeight = FontWeight.Medium,
                color = Color.White.copy(alpha = 0.85f),
                textAlign = TextAlign.Center
            ),
            modifier = Modifier.align(Alignment.Center)
        )
    }
}

@Composable
fun ActionRow() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(42.dp),
        verticalAlignment = Alignment.Top
    ) {
        // Core Actions
        Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            // Like
            ActionItem(
                iconId = R.drawable.icon_song_collect,
                text = "7w+",
                iconSize = 32.dp,
                width = 56.dp
            )
            // Comment
            ActionItem(
                iconId = R.drawable.icon_song_comment,
                text = "284",
                iconSize = 32.dp,
                width = 54.dp
            )
            // Share
            ActionItem(
                iconId = R.drawable.icon_song_share,
                text = "3771",
                iconSize = 32.dp,
                width = 58.dp
            )
        }
        
        Spacer(modifier = Modifier.width(83.dp))
        
        // List Loop
        Box(
            modifier = Modifier
                .size(24.dp)
                .align(Alignment.CenterVertically)
        ) {
            Image(
                painter = painterResource(id = R.drawable.icon_list_loop),
                contentDescription = "List Loop",
                modifier = Modifier.fillMaxSize()
            )
        }

        Spacer(modifier = Modifier.width(16.dp))

        // More
        Box(
            modifier = Modifier
                .size(24.dp)
                .align(Alignment.CenterVertically)
        ) {
            Image(
                painter = painterResource(id = R.drawable.icon_song_more),
                contentDescription = "More",
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}

@Composable
fun ActionItem(iconId: Int, text: String, iconSize: androidx.compose.ui.unit.Dp, width: androidx.compose.ui.unit.Dp) {
    Column(
        horizontalAlignment = Alignment.Start,
        modifier = Modifier.width(width)
    ) {
        Image(
            painter = painterResource(id = iconId),
            contentDescription = null,
            modifier = Modifier.size(iconSize)
        )
        Spacer(modifier = Modifier.height(0.dp)) // Adjust visual spacing if needed
        Text(
            text = text,
            style = TextStyle(
                fontSize = 12.sp,
                fontWeight = FontWeight.Medium,
                color = Color.White.copy(alpha = 0.85f)
            ),
            modifier = Modifier.offset(y = (-3).dp) // Fine tune position as per absolute layout
        )
    }
}

@Composable
fun ProgressRow() {
    Row(
        modifier = Modifier
            .width(336.dp)
            .height(32.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Markers
        Image(
            painter = painterResource(id = R.drawable.icon_frame_16888),
            contentDescription = null,
            modifier = Modifier.size(32.dp)
        )
        
        Spacer(modifier = Modifier.width(4.dp))
        
        // Progress Bar
        Box(
            modifier = Modifier
                .width(300.dp)
                .height(8.dp),
            contentAlignment = Alignment.CenterStart
        ) {
            // Track
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(3.dp)
                    .background(Color.White.copy(alpha = 0.12f), RoundedCornerShape(2.dp))
            )
            
            // Active Track
            Box(
                modifier = Modifier
                    .width(190.dp) // Mock progress width
                    .height(3.dp)
                    .background(Color.White.copy(alpha = 0.85f), RoundedCornerShape(2.dp))
            )
            
            // Thumb (Thumb position calculated to match active track end)
            Box(
                modifier = Modifier
                    .offset(x = 186.dp) // 190 - thumb radius/2 approx
                    .size(7.dp)
                    .background(Color.White, CircleShape)
            )
        }
    }
}