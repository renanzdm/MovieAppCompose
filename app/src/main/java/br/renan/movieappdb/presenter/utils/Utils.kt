package br.renan.movieappdb.presenter.utils

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*

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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.isUnspecified


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
            if (it) loadMore()
        }
    }
}

@Composable
fun IndicatorCircularRate(value: Double) {
    val formattedValue: String = String.format("%.0f", (value * 100))
    Box(modifier = Modifier
        .height(40.dp)
        .width(40.dp)
        .clip(RoundedCornerShape(100.dp))
        .background(Color.Black)) {
        Text(
            modifier = Modifier.align(Alignment.Center),
            text = "$formattedValue%",
            color = Color.White,
        )
        CircularProgressIndicator(
            progress = value.toFloat(),
            strokeWidth = 4.dp,
            color = MaterialTheme.colors.primary,
        )
    }
    
    
}


@Composable
@Preview
fun PreviewIndicator(){
   IndicatorCircularRate(value = 1.00)
   
   
   
}
