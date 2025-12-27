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
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.R

@Composable
fun AlbumEntryScreen() {
    Scaffold(
        containerColor = Color.White
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            // Simulated Status Bar Spacer
            Spacer(modifier = Modifier.height(47.dp))

            // Header
            Header()

            // Tabs
            Tabs()

            // Grid Content with Banner
            Box(modifier = Modifier.fillMaxSize()) {
                PhotoGrid()
                MemoriesBanner()
            }
        }
    }
}

@Composable
fun Header() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(54.dp)
            .padding(horizontal = 12.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        // Back Button
        Box(
            modifier = Modifier
                .size(24.dp)
                .padding(start = 4.dp), 
            contentAlignment = Alignment.Center
        ) {
             Image(
                painter = painterResource(id = R.drawable.ic_back),
                contentDescription = "Back",
                modifier = Modifier.size(12.dp)
            )
        }

        // Title Group
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(start = 24.dp) // Optical centering adjustment
        ) {
            Text(
                text = "所有照片",
                color = Color(0xFF161823),
                fontSize = 17.sp,
                fontWeight = FontWeight.Medium,
                lineHeight = 23.8.sp
            )
            Spacer(modifier = Modifier.width(4.dp))
            Image(
                painter = painterResource(id = R.drawable.ic_more),
                contentDescription = "More",
                modifier = Modifier.size(10.dp)
            )
        }

        // Cancel Multiselect Button
        Box(
            modifier = Modifier
                .height(32.dp)
                .background(
                    color = Color(0xFF161823).copy(alpha = 0.05f),
                    shape = RoundedCornerShape(36.dp)
                )
                .padding(horizontal = 12.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "取消多选",
                color = Color(0xFF161823),
                fontSize = 15.sp,
                fontWeight = FontWeight.Medium,
                lineHeight = 21.sp
            )
        }
    }
}

@Composable
fun Tabs() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(40.dp),
        verticalAlignment = Alignment.Top,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        // Tab Items
        TabItem(text = "收藏", opacity = 0.6f)
        
        // Selected Item "All"
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.width(60.dp)
        ) {
            Text(
                text = "全部",
                color = Color(0xFF161823),
                fontSize = 15.sp,
                fontWeight = FontWeight.Medium,
                lineHeight = 21.sp,
                modifier = Modifier.padding(top = 9.dp)
            )
            Spacer(modifier = Modifier.height(6.dp))
            Box(
                modifier = Modifier
                    .width(32.dp)
                    .height(2.dp)
                    .background(Color(0xFF161823))
            )
        }

        TabItem(text = "视频", opacity = 0.6f)
        TabItem(text = "图片", opacity = 0.6f)
        TabItem(text = "动图", opacity = 0.6f)
    }
}

@Composable
fun TabItem(text: String, opacity: Float) {
    Box(
        modifier = Modifier
            .width(60.dp)
            .height(40.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            color = Color(0xFF161823).copy(alpha = 0.75f),
            fontSize = 15.sp,
            fontWeight = FontWeight.Normal,
            lineHeight = 21.sp,
            modifier = Modifier.alpha(opacity)
        )
    }
}

@Composable
fun MemoriesBanner() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp)
            .background(Color(0xFF161823).copy(alpha = 0.05f))
            .padding(horizontal = 12.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.img_ac3c967ae04976afb114012d5f638146646568ef),
                contentDescription = null,
                modifier = Modifier
                    .size(32.dp)
                    .clip(RoundedCornerShape(4.dp)),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "往年今日 2018 年 7 月 25 日",
                color = Color(0xFF161823),
                fontSize = 13.sp,
                fontWeight = FontWeight.Medium,
                lineHeight = 18.2.sp
            )
            Spacer(modifier = Modifier.weight(1f))
            Image(
                painter = painterResource(id = R.drawable.ic_s_s_arrowright),
                contentDescription = null,
                modifier = Modifier.size(16.dp)
            )
        }
    }
}

@Composable
fun PhotoGrid() {
    // 3 Columns, spacing 2dp
    Column(
        verticalArrangement = Arrangement.spacedBy(2.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        // Row 1
        Row(horizontalArrangement = Arrangement.spacedBy(2.dp)) {
            GridImage(R.drawable.img_a4dd0d7083646df70b2feceb678e2739ebcaf169)
            GridImage(R.drawable.img_eed007215db8eb8b03c7c77337f8122070375136)
            GridImage(R.drawable.img_0b4176aa7d7dbe0137c16b7099cca1f21ff91d49)
        }
        // Row 2
        Row(horizontalArrangement = Arrangement.spacedBy(2.dp)) {
            GridImage(R.drawable.img_868ce84ef49f1ec55dfffdb8498df3e4280be422)
            GridImage(R.drawable.img_118c0ccfb4f416e7fe99d2bc775c0de6c23a3b54)
            GridImage(R.drawable.img_f997a9c373c698b791056d942a6eea2bc3081be5)
        }
        // Row 3
        Row(horizontalArrangement = Arrangement.spacedBy(2.dp)) {
            GridImage(R.drawable.img_b8309a74efbdc304532711f7e7da4fed3fb8498f)
            GridImage(R.drawable.img_582720836168d895ea43a1cda52f5ae361c57e9c)
            GridImage(
                R.drawable.img_7ab079c548ab1479d66f02ac4dac715279f1b4ed,
                selectedIndex = 1
            )
        }
        // Row 4
        Row(horizontalArrangement = Arrangement.spacedBy(2.dp)) {
            GridImage(R.drawable.img_5be951f714a514a2470bcb19c6d9285c40e24236)
            GridImage(
                R.drawable.img_d5d5cf9d5ec103a52876e340887cc46ada085de2,
                showLiveIcon = true
            )
            GridImage(
                R.drawable.img_e83fb73a43a75352a707eb3cbc892ac6fc182894,
                selectedIndex = 2
            )
        }
        // Row 5
        Row(horizontalArrangement = Arrangement.spacedBy(2.dp)) {
            GridImage(R.drawable.img_4ff47d0565e65a2cf97b061bc2759e6faf1f68cd)
            GridImage(R.drawable.img_af34d888af4cccaae75549bbdfd032a5384412fb)
            GridImage(R.drawable.img_d58af7889477d24c76784355d97417c02795686c)
        }
    }
}

@Composable
fun androidx.compose.foundation.layout.RowScope.GridImage(
    resId: Int,
    selectedIndex: Int? = null,
    showLiveIcon: Boolean = false
) {
    Box(
        modifier = Modifier
            .weight(1f)
            .aspectRatio(1f)
    ) {
        Image(
            painter = painterResource(id = resId),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        
        // Selection Indicator (Top Right)
        if (selectedIndex != null) {
            Box(
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(6.dp)
                    .size(24.dp)
                    .background(Color(0xFFFE2C55), CircleShape)
                    .border(2.dp, Color.White, CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = selectedIndex.toString(),
                    color = Color.White,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Medium
                )
            }
        } else {
             // Unselected circle outline
             Box(
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(6.dp)
                    .size(24.dp)
                    .background(Color.Black.copy(alpha = 0.1f), CircleShape)
                    .border(2.dp, Color.White, CircleShape)
            )
        }

        // Live Icon Overlay (Bottom Left/Center roughly)
        if (showLiveIcon) {
             Image(
                painter = painterResource(id = R.drawable.livephoto20_ic),
                contentDescription = null,
                modifier = Modifier
                    .size(20.dp)
                    .align(Alignment.BottomStart)
                    .offset(x = 6.dp, y = (-6).dp)
            )
        }
    }
}

@Preview(widthDp = 390, heightDp = 736)
@Composable
fun PreviewAlbumEntry() {
    AlbumEntryScreen()
}