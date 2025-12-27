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
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
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
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// Color definitions based on design
val ColorOrangeBrand = Color(0xFFFA6725)
val ColorBlackPrimary = Color(0xFF161823)
val ColorGraySecondary = Color(0xFF8C8F9F) // Gray 40 approx
val ColorGrayTertiary = Color(0xFFC4C7D0) // Gray 20/30 approx
val ColorBgWhite = Color(0xFFFFFFFF)
val ColorBlueLink = Color(0xFF1367C8) // "更多" color approx

@Composable
fun BookReviewScreen() {
    Scaffold(
        topBar = { TopNavBar() },
        containerColor = ColorBgWhite
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            contentPadding = PaddingValues(bottom = 20.dp)
        ) {
            item { RatingCard() }
            item { SearchBar() }
            item { TagsSection() }
            items(3) { // Mock reviews
                ReviewItem()
                Divider(
                    color = Color(0xFFF2F2F2),
                    thickness = 0.5.dp,
                    modifier = Modifier.padding(horizontal = 16.dp)
                )
            }
        }
    }
}

@Composable
fun TopNavBar() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(44.dp)
            .background(ColorBgWhite)
    ) {
        // Back Button
        Image(
            painter = painterResource(id = R.drawable.global_back24),
            contentDescription = "Back",
            modifier = Modifier
                .align(Alignment.CenterStart)
                .padding(start = 16.dp)
                .size(24.dp)
        )

        // Title
        Text(
            text = "十日终焉",
            color = ColorBlackPrimary,
            fontSize = 18.sp,
            fontWeight = FontWeight.Medium,
            modifier = Modifier.align(Alignment.Center)
        )

        // Right Action Button
        Box(
            modifier = Modifier
                .align(Alignment.CenterEnd)
                .padding(end = 16.dp)
                .width(60.dp)
                .height(24.dp)
                .background(
                    color = ColorOrangeBrand.copy(alpha = 0.03f),
                    shape = RoundedCornerShape(22.dp)
                )
                .border(
                    width = 0.5.dp,
                    color = ColorOrangeBrand.copy(alpha = 0.1f), // Assuming very subtle border or none
                    shape = RoundedCornerShape(22.dp)
                ),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "写点评",
                color = ColorBlackPrimary,
                fontSize = 12.sp,
                fontWeight = FontWeight.Medium
            )
        }
    }
}

@Composable
fun RatingCard() {
    Box(
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .fillMaxWidth()
            .height(88.dp)
            .background(
                color = ColorOrangeBrand.copy(alpha = 0.03f),
                shape = RoundedCornerShape(8.dp)
            )
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Left Side: Score
            Column(
                modifier = Modifier
                    .padding(start = 16.dp)
                    .width(90.dp),
                verticalArrangement = Arrangement.Center
            ) {
                Row(verticalAlignment = Alignment.Bottom) {
                    Text(
                        text = "9.7",
                        color = ColorBlackPrimary,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Medium,
                        lineHeight = 30.sp
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = "分",
                        color = ColorBlackPrimary,
                        fontSize = 12.sp,
                        modifier = Modifier.padding(bottom = 4.dp)
                    )
                }
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    text = "130.3万人点评",
                    color = ColorGraySecondary,
                    fontSize = 12.sp
                )
            }

            Spacer(modifier = Modifier.width(20.dp))

            // Right Side: Histogram
            Column(
                verticalArrangement = Arrangement.spacedBy(4.dp),
                modifier = Modifier.padding(vertical = 12.dp)
            ) {
                // 5 Stars to 1 Star
                StarHistogramRow(score = 1.0f) // 5 stars
                StarHistogramRow(score = 0.1f) // 4 stars
                StarHistogramRow(score = 0.05f) // 3 stars
                StarHistogramRow(score = 0.02f) // 2 stars
                StarHistogramRow(score = 0.02f) // 1 star
            }
        }
    }
}

@Composable
fun StarHistogramRow(score: Float) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.height(8.dp)
    ) {
        // Star Icon - using a filled star for the row label
        Image(
            painter = painterResource(id = R.drawable.ic_star_filled_small),
            contentDescription = null,
            modifier = Modifier.size(8.dp),
            alpha = 0.3f // Design shows lighter stars for labels
        )
        Spacer(modifier = Modifier.width(8.dp))
        // Progress Bar
        Box(
            modifier = Modifier
                .width(138.dp)
                .height(4.dp)
                .background(Color.Black.copy(alpha = 0.06f), RoundedCornerShape(1.dp))
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth(score)
                    .height(4.dp)
                    .background(ColorOrangeBrand, RoundedCornerShape(1.dp))
            )
        }
    }
}

@Composable
fun SearchBar() {
    Box(
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .fillMaxWidth()
            .height(36.dp)
            .background(
                color = ColorGraySecondary.copy(alpha = 0.1f), // Gray 3 approx
                shape = RoundedCornerShape(6.dp)
            ),
        contentAlignment = Alignment.CenterStart
    ) {
        Row(
            modifier = Modifier.padding(horizontal = 12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.discover_search),
                contentDescription = "Search",
                modifier = Modifier.size(16.dp)
            )
            Spacer(modifier = Modifier.width(6.dp))
            Text(
                text = "搜索 我在精神病院学斩神 的书评",
                color = ColorGraySecondary,
                fontSize = 14.sp
            )
        }
    }
}

@Composable
fun TagsSection() {
    LazyRow(
        modifier = Modifier.fillMaxWidth(),
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        item {
            TagChip(text = "全部 123", selected = true)
        }
        item {
            TagChip(text = "最新", selected = false)
        }
        item {
            TagChip(text = "长评 29", selected = false)
        }
        item {
            TagChip(text = "精彩 6", selected = false)
        }
        item {
            TagChip(text = "中二 6", selected = false)
        }
    }
}

@Composable
fun TagChip(text: String, selected: Boolean) {
    Box(
        modifier = Modifier
            .height(30.dp)
            .background(
                color = if (selected) ColorOrangeBrand.copy(alpha = 0.1f) else Color.Black.copy(alpha = 0.03f),
                shape = RoundedCornerShape(6.dp)
            )
            .padding(horizontal = 14.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            fontSize = 12.sp,
            color = if (selected) ColorOrangeBrand else ColorBlackPrimary,
            fontWeight = if (selected) FontWeight.Medium else FontWeight.Normal
        )
    }
}

@Composable
fun ReviewItem() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        // Header
        Row(modifier = Modifier.fillMaxWidth()) {
            // Avatar
            Image(
                painter = painterResource(id = R.drawable.img_7707903c155943cbec4eb65758da343917c4701b),
                contentDescription = "Avatar",
                modifier = Modifier
                    .size(28.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.width(8.dp))
            Column {
                // Name and More
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "一念之间",
                        fontSize = 12.sp,
                        color = ColorBlackPrimary
                    )
                    Image(
                        painter = painterResource(id = R.drawable.ic_more_vert),
                        contentDescription = "More",
                        modifier = Modifier.size(20.dp)
                    )
                }
                
                Spacer(modifier = Modifier.height(2.dp))
                
                // Meta Info
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = "阅读326分钟后点评",
                        fontSize = 12.sp,
                        color = ColorGraySecondary
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Box(modifier = Modifier
                        .size(2.dp)
                        .background(ColorGraySecondary, CircleShape))
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = "共同读过7本书",
                        fontSize = 12.sp,
                        color = ColorGraySecondary
                    )
                }
                
                Spacer(modifier = Modifier.height(2.dp))
                
                // Stars
                Row(verticalAlignment = Alignment.CenterVertically) {
                    repeat(5) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_star_filled_small),
                            contentDescription = null,
                            modifier = Modifier
                                .size(10.dp)
                                .padding(end = 1.dp)
                        )
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(10.dp))

        // Content
        Text(
            text = "这个小说包含了亲情，友情，爱国等多元素，有时主角还有点可爱。文风轻快，颇具古风美，这是一本暗恋的小说，虽然我没有暗恋过别人，但真颇具",
            fontSize = 16.sp,
            color = ColorBlackPrimary,
            lineHeight = 26.sp,
            maxLines = 3,
            overflow = TextOverflow.Ellipsis
        )
        
        Spacer(modifier = Modifier.height(4.dp))
        
        Text(
            text = "更多",
            fontSize = 16.sp,
            color = ColorBlueLink
        )

        Spacer(modifier = Modifier.height(12.dp))

        // Footer
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "01月13日",
                fontSize = 12.sp,
                color = ColorGraySecondary
            )

            Row(verticalAlignment = Alignment.CenterVertically) {
                // Like Button
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_thumb_up),
                        contentDescription = "Like",
                        modifier = Modifier.size(16.dp)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = "56",
                        fontSize = 12.sp,
                        color = ColorBlackPrimary
                    )
                }
                
                Spacer(modifier = Modifier.width(20.dp))
                
                // Comment Button
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_comment),
                        contentDescription = "Comment",
                        modifier = Modifier.size(16.dp)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = "32",
                        fontSize = 12.sp,
                        color = ColorBlackPrimary
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BookReviewScreenPreview() {
    BookReviewScreen()
}