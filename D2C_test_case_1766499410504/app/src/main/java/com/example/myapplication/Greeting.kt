package com.example.myapplication

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
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
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.R

@Composable
fun MusicPlaylistScreen() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(0xFF121212)
    ) {
        Column {
            // Simulated Status Bar Padding
            Spacer(modifier = Modifier.height(44.dp))

            // Search Bar
            SearchBar()

            // Tabs
            TabsRow()

            // Content Grid
            MusicStaggeredGrid()
        }
    }
}

@Composable
fun SearchBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 6.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Search Input Box
        Box(
            modifier = Modifier
                .weight(1f)
                .height(36.dp)
                .background(
                    color = Color(0xFFFFFFFF).copy(alpha = 0.05f),
                    shape = RoundedCornerShape(18.dp)
                )
                .padding(horizontal = 12.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxSize(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_search),
                    contentDescription = "Search",
                    tint = Color.White,
                    modifier = Modifier.size(14.dp)
                )
                Spacer(modifier = Modifier.width(6.dp))
                Text(
                    text = "爱人错过",
                    style = TextStyle(
                        fontSize = 14.sp,
                        color = Color.White.copy(alpha = 0.85f),
                        fontWeight = FontWeight.Medium
                    ),
                    modifier = Modifier.weight(1f)
                )
                Icon(
                    painter = painterResource(id = R.drawable.ic_search_clear),
                    contentDescription = "Clear",
                    tint = Color.Unspecified,
                    modifier = Modifier.size(16.dp)
                )
            }
        }
        
        // Cancel Button
        Text(
            text = "取消",
            style = TextStyle(
                fontSize = 15.sp,
                color = Color.White.copy(alpha = 0.5f),
                fontWeight = FontWeight.Medium
            ),
            modifier = Modifier.padding(start = 16.dp)
        )
    }
}

@Composable
fun TabsRow() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 12.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            val tabs = listOf("综合", "歌曲", "歌单", "视频", "专辑", "音乐人")
            val selectedIndex = 2 // "歌单"

            tabs.forEachIndexed { index, title ->
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = title,
                        style = TextStyle(
                            fontSize = 15.sp,
                            color = if (index == selectedIndex) Color.White else Color.White.copy(alpha = 0.5f),
                            fontWeight = FontWeight.Medium
                        )
                    )
                    if (index == selectedIndex) {
                        Spacer(modifier = Modifier.height(4.dp))
                        Box(
                            modifier = Modifier
                                .width(10.dp)
                                .height(2.dp)
                                .background(
                                    color = Color.White.copy(alpha = 0.85f),
                                    shape = RoundedCornerShape(1.dp)
                                )
                        )
                    } else {
                        Spacer(modifier = Modifier.height(6.dp))
                    }
                }
            }
        }
    }
}

data class MusicItem(
    val imageRes: Int,
    val heightDp: Dp,
    val title: String,
    val subtitle: String,
    val avatarRes: Int,
    val duration: String? = null,
    val playCount: String? = null
)

@Composable
fun MusicStaggeredGrid() {
    val items = listOf(
        MusicItem(
            imageRes = R.drawable.img_4bee3a453ef38c5f5d0837ca84fa12a9984c9de7,
            heightDp = 228.dp,
            title = "告五人 爱人错过 我肯定在几百年前就说过爱你",
            subtitle = "告五人",
            avatarRes = R.drawable.img_0ef0aef3083a301ec4eb62e5b59c6e1b1df73579,
            duration = "02:21"
        ),
        MusicItem(
            imageRes = R.drawable.img_dc5b65f2bda5bef6ea109c43afb88db9e1f6f8e2,
            heightDp = 113.dp,
            title = "爱人错过 - 丁程鑫",
            subtitle = "橘子汽水",
            avatarRes = R.drawable.img_5f65ea9edfb70d59399a3551aa49a0dfa47f3bcd,
            duration = "02:21"
        ),
        MusicItem(
            imageRes = R.drawable.img_a28cd9c02132bccd6893f7d2d0b4a254bf4e99d9,
            heightDp = 228.dp,
            title = "爱人错过 张真源/贺峻霖",
            subtitle = "Dydy",
            avatarRes = R.drawable.img_c021d0c98cde42c719f8ce59a8e39995fc62e5b5,
            duration = "02:21"
        ),
        MusicItem(
            imageRes = R.drawable.img_f6735fc8cead196947838a4ac895766d15e36960,
            heightDp = 113.dp,
            title = "告五人 - 爱人错过 我肯定在几百年前就说过爱你",
            subtitle = "Appoint",
            avatarRes = R.drawable.img_23a84b73b6ba25efc5cc78845c4aafc5ef7bf52b,
            duration = "02:21"
        ),
        MusicItem(
            imageRes = R.drawable.img_adbf4369f8024549c9dd2e4d909461518611bc7c,
            heightDp = 113.dp,
            title = "爱人错过 - 丁程鑫",
            subtitle = "矮的花",
            avatarRes = R.drawable.img_c021d0c98cde42c719f8ce59a8e39995fc62e5b5,
            playCount = "21.7w"
        ),
        MusicItem(
            imageRes = R.drawable.img_661066638658e9276042eec67425e93774badd2e,
            heightDp = 228.dp,
            title = "告五人 - 爱人错过 我肯定在几百年前就说过爱你",
            subtitle = "告五人",
            avatarRes = R.drawable.img_0ef0aef3083a301ec4eb62e5b59c6e1b1df73579,
            playCount = "21.7w"
        ),
        MusicItem(
            imageRes = R.drawable.img_adbf4369f8024549c9dd2e4d909461518611bc7c,
            heightDp = 228.dp,
            title = "爱人错过 张真源/贺峻霖",
            subtitle = "Dydy",
            avatarRes = R.drawable.img_c021d0c98cde42c719f8ce59a8e39995fc62e5b5,
            duration = "02:21"
        )
    )

    LazyVerticalStaggeredGrid(
        columns = StaggeredGridCells.Fixed(2),
        contentPadding = PaddingValues(horizontal = 12.dp, vertical = 12.dp),
        verticalItemSpacing = 8.dp,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier.fillMaxSize()
    ) {
        items(items) { item ->
            MusicCard(item)
        }
    }
}

@Composable
fun MusicCard(item: MusicItem) {
    Column {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(item.heightDp)
                .clip(RoundedCornerShape(6.dp))
        ) {
            Image(
                painter = painterResource(id = item.imageRes),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
            
            // Gradient Overlay
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
                    .align(Alignment.BottomCenter)
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(Color.Transparent, Color(0x57000000))
                        )
                    )
            )

            // Overlay Content (Duration or Heart+Count)
            Row(
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(start = 8.dp, bottom = 6.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                if (item.playCount != null) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_s_s_heart),
                        contentDescription = null,
                        tint = Color.White.copy(alpha = 0.75f),
                        modifier = Modifier.size(12.dp)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = item.playCount,
                        style = TextStyle(
                            fontSize = 12.sp,
                            color = Color.White.copy(alpha = 0.75f),
                            fontWeight = FontWeight.Medium
                        )
                    )
                } else if (item.duration != null) {
                    Text(
                        text = item.duration,
                        style = TextStyle(
                            fontSize = 12.sp,
                            color = Color.White.copy(alpha = 0.75f),
                            fontWeight = FontWeight.Medium
                        )
                    )
                }
            }
        }
        
        Spacer(modifier = Modifier.height(8.dp))
        
        // Title
        Text(
            text = item.title,
            style = TextStyle(
                fontSize = 13.sp,
                color = Color.White.copy(alpha = 0.85f),
                fontWeight = FontWeight.Medium,
                lineHeight = 18.2.sp
            ),
            maxLines = 2,
            overflow = TextOverflow.Ellipsis
        )
        
        Spacer(modifier = Modifier.height(4.dp))
        
        // Subtitle
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(id = item.avatarRes),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(16.dp)
                    .clip(RoundedCornerShape(27.dp))
            )
            Spacer(modifier = Modifier.width(4.dp))
            Text(
                text = item.subtitle,
                style = TextStyle(
                    fontSize = 13.sp,
                    color = Color.White.copy(alpha = 0.35f),
                    fontWeight = FontWeight.Normal
                ),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
        
        Spacer(modifier = Modifier.height(12.dp))
    }
}

@Preview(showBackground = true, widthDp = 375, heightDp = 812)
@Composable
fun PreviewMusicPlaylistScreen() {
    MusicPlaylistScreen()
}