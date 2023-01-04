package br.renan.movieappdb
//implementation ("com.google.accompanist:accompanist-pager:0.28.0")
//implementation ("com.google.accompanist:accompanist-pager-indicators:0.28.0")
//implementation ("androidx.compose.ui:ui-util:1.3.2")

//
//
//@OptIn(ExperimentalPagerApi::class)
//@Composable
//fun Tabs(tabs: List<TabItem>, pagerState: PagerState) {
//    val scope = rememberCoroutineScope()
//    TabRow(
//        selectedTabIndex = pagerState.currentPage,
//        indicator = { tabPositions ->
//            TabRowDefaults.Indicator(
//                Modifier.pagerTabIndicatorOffset(pagerState, tabPositions)
//            )
//        }) {
//        tabs.forEachIndexed { index, tab ->
//            LeadingIconTab(
//                icon = { Icon(imageVector = Icons.Rounded.Add, contentDescription = "") },
//                text = { Text(tab.title) },
//                selected = pagerState.currentPage == index,
//                onClick = {
//                    scope.launch {
//                        pagerState.animateScrollToPage(index)
//                    }
//                },
//            )
//        }
//    }
//}
//
//
//@OptIn(ExperimentalPagerApi::class)
//@Composable
//fun TabsContent(tabs: List<TabItem>, pagerState: PagerState) {
//    HorizontalPager(state = pagerState, count = tabs.size) { page ->
//        Card(
//            Modifier
//                .graphicsLayer {
//                    val pageOffset = calculateCurrentOffsetForPage(page).absoluteValue
//                    lerp(
//                        start = 0.85f,
//                        stop = 1f,
//                        fraction = 1f - pageOffset.coerceIn(0f, 1f)
//                    ).also { scale ->
//                        scaleX = scale
//                        scaleY = scale
//                    }
//                    alpha = lerp(
//                        start = 0.5f,
//                        stop = 1f,
//                        fraction = 1f - pageOffset.coerceIn(0f, 1f)
//                    )
//                }
//        ) {
//        tabs[page].screen()
//        }
//    }
//}
//
//

//
//
//
//
//typealias ComposableFun = @Composable () -> Unit
//
//sealed class TabItem(var icon: Int, var title: String, var screen: ComposableFun) {
//    object Music : TabItem(
//        org.koin.androidx.navigation.R.drawable.abc_btn_borderless_material,
//        "Music",
//        { MusicScreen() })
//
//    object Movies : TabItem(
//        org.koin.androidx.compose.R.drawable.abc_btn_borderless_material,
//        "Movies",
//        { MoviesScreen() })
//
//    object Books : TabItem(
//        org.koin.androidx.navigation.R.drawable.test_level_drawable,
//        "Books",
//        { BooksScreen() })
//}