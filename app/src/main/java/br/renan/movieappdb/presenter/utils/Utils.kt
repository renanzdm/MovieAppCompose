package br.renan.movieappdb.presenter.utils

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width

import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.isUnspecified
import androidx.compose.ui.unit.sp
import androidx.core.util.rangeTo


@Composable
fun AutoResizeText(
    text: String,
    modifier: Modifier = Modifier,
    style: TextStyle = MaterialTheme.typography.body1,
    color: Color = style.color
) {
    var resizedTextStyle by remember {
        mutableStateOf(style)
    }
    var shouldDraw by remember {
        mutableStateOf(false)
    }
    
    val defaultFontSize = MaterialTheme.typography.body1.fontSize
    
    Text(text = text, color = color, modifier = modifier.drawWithContent {
        if (shouldDraw) {
            drawContent()
        }
    }, style = resizedTextStyle, softWrap = false, onTextLayout = { result ->
        if (result.didOverflowWidth) {
            if (resizedTextStyle.fontSize.isUnspecified) {
                resizedTextStyle = resizedTextStyle.copy(
                    fontSize = defaultFontSize
                )
            }
            resizedTextStyle = resizedTextStyle.copy(
                fontSize = resizedTextStyle.fontSize * 0.95
            )
        } else {
            shouldDraw = true
        }
    })
    
}


@Composable
fun LazyListState.OnBottomReached(
    loadMore: () -> Unit
) {
    val shouldLoadMore = remember {
        derivedStateOf {
            val lastVisibleItem =
                layoutInfo.visibleItemsInfo.lastOrNull() ?: return@derivedStateOf true
            
            lastVisibleItem.index == layoutInfo.totalItemsCount - 1
        }
    }
    
    LaunchedEffect(shouldLoadMore) {
        snapshotFlow { shouldLoadMore.value }.collect {
            // if should load more, then invoke loadMore
            if (it) loadMore()
        }
    }
}

@Composable
fun IndicatorCircularRate(value: Double) {
    val formattedValue: String = String.format("%.0f", (value * 100))
    Box {
        Box(
            modifier = Modifier
                .height(35.dp)
                .width(35.dp)
                .align(Alignment.Center)
                .clip(RoundedCornerShape(100.dp))
                .background(Color.Black)
        ) {
            
            Box(modifier = Modifier.align(Alignment.Center)) {
                Text(
                    text = "$formattedValue%", color = Color.White, fontSize = 16.sp,
                    textAlign=TextAlign.Center,
                    fontWeight = FontWeight.Bold
                )
            }
           
        }
        CircularProgressIndicator(
            progress = value.toFloat(),
            strokeWidth = 4.dp,
            color = MaterialTheme.colors.primary,
        )
    }
    
    
}
