package common.compose.widget

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.Dp
import common.compose.ui.dimen_0dp
import common.compose.ui.dimen_font_18sp


/*
 * Created by faisalamir on 19/11/21
 * 
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 * Copyright (C) 2021 FrogoBox Inc.      
 * All rights reserved
 *
 */

// -------------------------------------------------------------------------------------------------
//  Text Top App Bar
// -------------------------------------------------------------------------------------------------

@Composable
fun TextTopAppBar(titleContent: String) {
    Text(text = titleContent, fontSize = dimen_font_18sp)
}

// -------------------------------------------------------------------------------------------------
//  Simple Top App Bar
// -------------------------------------------------------------------------------------------------

@Composable
fun SimpleTopAppBar(titleContent: String, elevationContent: Dp?) {
    if (elevationContent != null) {
        TopAppBar(
            elevation = elevationContent,
            title = {
                TextTopAppBar(titleContent)
            },
            backgroundColor = MaterialTheme.colors.primarySurface
        )
    } else {
        TopAppBar(
            elevation = dimen_0dp,
            title = {
                TextTopAppBar(titleContent)
            },
            backgroundColor = MaterialTheme.colors.primarySurface
        )
    }
}


// -------------------------------------------------------------------------------------------------
//  Detail Top App Bar
// -------------------------------------------------------------------------------------------------

@Composable
fun DetailTopAppBar(titleContent: String, elevationContent: Dp?) {
    if (elevationContent != null) {
        TopAppBar(
            elevation = elevationContent,
            title = {
                TextTopAppBar(titleContent)
            },
            backgroundColor = MaterialTheme.colors.primarySurface,
            navigationIcon = {
                IconButton(onClick = {/* Do Something*/ }) {
                    Icon(Icons.Filled.ArrowBack, null)
                }
            })
    } else {
        TopAppBar(
            elevation = dimen_0dp,
            title = {
                TextTopAppBar(titleContent)
            },
            backgroundColor = MaterialTheme.colors.primarySurface,
            navigationIcon = {
                IconButton(onClick = {/* Do Something*/ }) {
                    Icon(Icons.Filled.ArrowBack, null)
                }
            })
    }
}


//@Composable
//fun SimpleTopAppBarSample(titleContent: String, elevationContent: Dp?) {
//    TopAppBar(
//        elevation = 4.dp,
//        title = {
//            Text(text = titleContent)
//        },
//        backgroundColor = MaterialTheme.colors.primarySurface,
//        navigationIcon = {
//            IconButton(onClick = {/* Do Something*/ }) {
//                Icon(Icons.Filled.ArrowBack, null)
//            }
//        }, actions = {
//            IconButton(onClick = {/* Do Something*/ }) {
//                Icon(Icons.Filled.Share, null)
//            }
//            IconButton(onClick = {/* Do Something*/ }) {
//                Icon(Icons.Filled.Settings, null)
//            }
//        })
//}