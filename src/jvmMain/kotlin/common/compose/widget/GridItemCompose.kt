package common.compose.widget

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import common.compose.ui.dimen_16dp
import common.compose.ui.dimen_8dp


/*
 * Created by faisalamir on 20/11/21
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
//  Grid Type 1 Desktop
// -------------------------------------------------------------------------------------------------

@Composable
fun GridType1(imageUrlContent: String, titleTextContent: String) {
    Card(
        shape = RoundedCornerShape(dimen_8dp),
        modifier = Modifier
            .padding(end = dimen_16dp, top = dimen_16dp)
            .fillMaxWidth()
    ) {
        Box(
            modifier = Modifier
                .padding(dimen_16dp)
        ) {
            Column {
                ImageUrlDesktop(
                    url = imageUrlContent,
                    contentDescription = null,
                    modifier = Modifier.height(150.dp).fillMaxWidth(),
                    contentScale = ContentScale.Crop
                )
                Spacer(modifier = Modifier.size(dimen_8dp))
                TextTitle(titleTextContent)
            }
        }
    }
}

// -------------------------------------------------------------------------------------------------
//  Grid Type 2 Desktop
// -------------------------------------------------------------------------------------------------

@Composable
fun GridType2(
    imageUrlContent: String,
    titleTextContent: String,
    subTitleTextContent: String
) {
    Card(
        shape = RoundedCornerShape(dimen_8dp),
        modifier = Modifier
            .padding(end = dimen_16dp, top = dimen_16dp)
            .fillMaxWidth()
    ) {
        Box(
            modifier = Modifier
                .padding(dimen_16dp)
        ) {
            Column {
                ImageUrlDesktop(
                    url = imageUrlContent,
                    contentDescription = null,
                    modifier = Modifier.height(150.dp).fillMaxWidth(),
                    contentScale = ContentScale.Crop
                )
                Spacer(modifier = Modifier.size(dimen_8dp))
                TextTitle(titleTextContent)
                TextSubTitle(subTitleTextContent)
            }
        }
    }
}

// -------------------------------------------------------------------------------------------------
//  Grid Type 3 Desktop
// -------------------------------------------------------------------------------------------------

@Composable
fun GridType3(
    imageUrlContent: String,
    titleTextContent: String,
    subTitleTextContent: String,
    descTitleTextContent: String
) {
    Card(
        shape = RoundedCornerShape(dimen_8dp),
        modifier = Modifier
            .padding(end = dimen_16dp, top = dimen_16dp)
            .fillMaxWidth()
    ) {
        Box(
            modifier = Modifier
                .padding(dimen_16dp)
        ) {
            Column {
                ImageUrlDesktop(
                    url = imageUrlContent,
                    contentDescription = null,
                    modifier = Modifier.height(150.dp).fillMaxWidth(),
                    contentScale = ContentScale.Crop
                )
                Spacer(modifier = Modifier.size(dimen_8dp))
                TextTitle(titleTextContent)
                TextSubTitle(subTitleTextContent)
                Spacer(modifier = Modifier.size(dimen_8dp))
                TextDescription(descTitleTextContent)
            }
        }
    }
}

// -------------------------------------------------------------------------------------------------
//  Grid Type 7 Desktop
// -------------------------------------------------------------------------------------------------

@Composable
fun GridType7(imageUrlContent: String) {
    Card(
        shape = RoundedCornerShape(dimen_8dp),
        modifier = Modifier
            .padding(end = dimen_16dp, top = dimen_16dp)
            .fillMaxWidth()
    ) {
        Box(
            modifier = Modifier
                .padding(dimen_16dp)
        ) {
            Column {
                ImageUrlDesktop(
                    url = imageUrlContent,
                    contentDescription = null,
                    modifier = Modifier.height(150.dp).fillMaxWidth(),
                    contentScale = ContentScale.Crop
                )
            }
        }
    }
}