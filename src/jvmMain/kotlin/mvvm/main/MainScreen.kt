package mvvm.main

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import common.callback.ApiResponseCallback
import common.compose.ui.dimen_0dp
import common.compose.ui.dimen_16dp
import common.compose.widget.*
import model.Article
import model.ArticleResponse

/**
 * Created by Faisal Amir on 13/03/23
 * -----------------------------------------
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 * Copyright (C) Frogobox ID / amirisback
 * All rights reserved
 */

class MainScreen {

    companion object {
        const val TAG = "MainScreen"
        const val TITLE_SCREEN = "Main Screen"
    }

    private val viewModel = MainViewModel()

    @Composable
    fun Create() {
        SetupUI()
    }

    @OptIn(ExperimentalFoundationApi::class)
    @Composable
    fun SetupRvComponent(dataState: List<Article>) {

        Row(horizontalArrangement = Arrangement.SpaceEvenly) {
            LazyColumn(
                modifier = Modifier.width(300.dp).fillMaxHeight(),
                contentPadding = PaddingValues(bottom = dimen_16dp)
            ) {
                items(dataState.size) { index ->
                    ListType3(
                        dataState[index].title!!,
                        dataState[index].author!!,
                        dataState[index].content!!
                    )
                }

            }
            LazyFixedGrid(
                data = dataState,
                spanCount = 2,
                contentPadding = PaddingValues(bottom = dimen_16dp)
            ) {
                it.title?.let { it1 ->
                    it.author?.let { it2 ->
                        it.content?.let { it3 ->
                            it.urlToImage?.let { it4 ->
                                GridType3(
                                    it4,
                                    it1,
                                    it2,
                                    it3
                                )
                            }
                        }
                    }
                }
            }

        }
    }

    @Composable
    fun SetupUI() {

        var dataState: List<Article> by remember { mutableStateOf(emptyList()) }
        var progressState: Boolean by remember { mutableStateOf(false) }

        viewModel.getEverythings(object : ApiResponseCallback<ArticleResponse> {
            override fun onSuccess(data: ArticleResponse) {
                for (i in data.articles?.indices!!) {
                    println("${i + 1}.\t ${data.articles?.get(i)?.title}")
                }
                dataState = data.articles!!
            }

            override fun onFailed(statusCode: Int, errorMessage: String) {
                // Your failed to do
            }

            override fun onShowProgress() {
                // Your Progress Show
                println("Show Progress")
                progressState = true
            }

            override fun onHideProgress() {
                // Your Progress Hide
                println("Hide Progress")
                progressState = false
            }

        })


        Column {
            SimpleTopAppBar(TITLE_SCREEN, dimen_0dp)

            if (progressState) {
                CircularProgressIndicator()
            } else {
                SetupRvComponent(dataState)
            }

        }
    }
}