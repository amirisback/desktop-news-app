package common.compose.widget

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import common.compose.ui.*


/*
 * Created by faisalamir on 18/11/21
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
//  Text Title
// -------------------------------------------------------------------------------------------------

@Composable
fun TextTitle(textContent: String) {
    Text(
        text = textContent,
        color = ColorPrimaryDark,
        fontWeight = FontWeight.Bold,
        fontSize = dimen_font_16sp,
        maxLines = 1
    )
}

@Composable
fun TextTitle(textContent: String, colorContent: Color) {
    Text(
        text = textContent,
        color = colorContent,
        fontWeight = FontWeight.Bold,
        fontSize = dimen_font_16sp,
        maxLines = 1
    )
}


// -------------------------------------------------------------------------------------------------
//  Text Sub Title
// -------------------------------------------------------------------------------------------------

@Composable
fun TextSubTitle(textContent: String) {
    Text(
        text = textContent,
        color = ColorBlack,
        fontSize = dimen_font_12sp,
        maxLines = 1
    )
}

@Composable
fun TextSubTitle(textContent: String, colorContent: Color) {
    Text(
        text = textContent,
        color = colorContent,
        fontSize = dimen_font_12sp,
        maxLines = 1
    )
}


// -------------------------------------------------------------------------------------------------
//  Text Description
// -------------------------------------------------------------------------------------------------

@Composable
fun TextDescription(textContent: String) {
    Text(
        text = textContent,
        color = ColorBlack,
        fontSize = dimen_font_11sp,
        maxLines = 3
    )
}

@Composable
fun TextDescription(textContent: String, colorContent: Color) {
    Text(
        text = textContent,
        color = colorContent,
        fontSize = dimen_font_11sp,
        maxLines = 3
    )
}