package common.compose.widget

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
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
//  List Type 1
// -------------------------------------------------------------------------------------------------

@Composable
fun ListType1(titleTextContent: String) {
    Card(
        shape = RoundedCornerShape(dimen_8dp),
        modifier = Modifier
            .padding(start = dimen_16dp, end = dimen_16dp, top = dimen_16dp)
            .fillMaxWidth()
    ) {
        Box(
            modifier = Modifier
                .padding(dimen_16dp)
        ) {
            TextTitle(textContent = titleTextContent)
        }
    }
}

// -------------------------------------------------------------------------------------------------
//  List Type 2
// -------------------------------------------------------------------------------------------------

@Composable
fun ListType2(titleTextContent: String, subTitleTextContent: String) {
    Card(
        shape = RoundedCornerShape(dimen_8dp),
        modifier = Modifier
            .padding(start = dimen_16dp, end = dimen_16dp, top = dimen_16dp)
            .fillMaxWidth()
    ) {
        Box(
            modifier = Modifier
                .padding(dimen_16dp)
        ) {
            Column {
                TextTitle(textContent = titleTextContent)
                TextSubTitle(textContent = subTitleTextContent)
            }
        }
    }
}

// -------------------------------------------------------------------------------------------------
//  List Type 3
// -------------------------------------------------------------------------------------------------

@Composable
fun ListType3(
    titleTextContent: String,
    subTitleTextContent: String,
    descTitleTextContent: String
) {
    Card(
        shape = RoundedCornerShape(dimen_8dp),
        modifier = Modifier
            .padding(start = dimen_16dp, end = dimen_16dp, top = dimen_16dp)
            .fillMaxWidth()
    ) {
        Box(
            modifier = Modifier
                .padding(dimen_16dp)
        ) {
            Column {
                TextTitle(textContent = titleTextContent)
                TextSubTitle(textContent = subTitleTextContent)
                Spacer(Modifier.size(dimen_8dp))
                TextDescription(textContent = descTitleTextContent)
            }
        }
    }
}

// -------------------------------------------------------------------------------------------------
//  List Type 4 Desktop
// -------------------------------------------------------------------------------------------------

@Composable
fun ListType4(imageUrlContent: String, titleTextContent: String) {
    Card(
        shape = RoundedCornerShape(dimen_8dp),
        modifier = Modifier
            .padding(start = dimen_16dp, end = dimen_16dp, top = dimen_16dp)
            .fillMaxWidth()
    ) {
        Box(
            modifier = Modifier
                .padding(dimen_16dp)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                ImageUrlDesktop(
                    url = imageUrlContent,
                    contentDescription = null,
                    modifier = Modifier.size(dimen_48dp),
                    contentScale = ContentScale.Crop
                )
                Spacer(modifier = Modifier.size(dimen_16dp))
                TextTitle(titleTextContent)
            }
        }
    }
}

// -------------------------------------------------------------------------------------------------
//  List Type 5 Desktop
// -------------------------------------------------------------------------------------------------

@Composable
fun ListType5(imageUrlContent: String, titleTextContent: String, subTitleTextContent: String) {
    Card(
        shape = RoundedCornerShape(dimen_8dp),
        modifier = Modifier
            .padding(start = dimen_16dp, end = dimen_16dp, top = dimen_16dp)
            .fillMaxWidth()
    ) {
        Box(
            modifier = Modifier
                .padding(dimen_16dp)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                ImageUrlDesktop(
                    url = imageUrlContent,
                    contentDescription = null,
                    modifier = Modifier.size(dimen_48dp),
                    contentScale = ContentScale.Crop
                )
                Spacer(modifier = Modifier.size(dimen_16dp))
                Column {
                    TextTitle(titleTextContent)
                    TextSubTitle(subTitleTextContent)
                }
            }
        }
    }
}

// -------------------------------------------------------------------------------------------------
//  List Type 6 Desktop
// -------------------------------------------------------------------------------------------------

@Composable
fun ListType6(
    imageUrlContent: String,
    titleTextContent: String,
    subTitleTextContent: String,
    descTitleTextContent: String
) {
    Card(
        shape = RoundedCornerShape(dimen_8dp),
        modifier = Modifier
            .padding(start = dimen_16dp, end = dimen_16dp, top = dimen_16dp)
            .fillMaxWidth()
    ) {
        Box(
            modifier = Modifier
                .padding(dimen_16dp)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                ImageUrlDesktop(
                    url = imageUrlContent,
                    contentDescription = null,
                    modifier = Modifier.size(width = dimen_72dp, height = dimen_96dp),
                    contentScale = ContentScale.Crop
                )
                Spacer(modifier = Modifier.size(dimen_16dp))
                Column {
                    TextTitle(titleTextContent)
                    TextSubTitle(subTitleTextContent)
                    Spacer(modifier = Modifier.size(dimen_16dp))
                    TextDescription(descTitleTextContent)
                }
            }
        }
    }
}

// -------------------------------------------------------------------------------------------------
//  List Type 7 Desktop
// -------------------------------------------------------------------------------------------------

@Composable
fun ListType7(imageUrlContent: String, titleTextContent: String) {
    Card(
        shape = RoundedCornerShape(dimen_8dp),
        modifier = Modifier
            .padding(start = dimen_16dp, end = dimen_16dp, top = dimen_16dp)
            .fillMaxWidth()
    ) {
        Box(
            modifier = Modifier
                .padding(dimen_16dp)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                ImageUrlDesktop(
                    url = imageUrlContent,
                    contentDescription = null,
                    modifier = Modifier.size(dimen_48dp),
                    contentScale = ContentScale.Crop
                )
                Spacer(modifier = Modifier.size(dimen_16dp))
                TextTitle(titleTextContent)
            }
        }
    }
}

// -------------------------------------------------------------------------------------------------
//  List Type 8 Desktop
// -------------------------------------------------------------------------------------------------

@Composable
fun ListType8(imageUrlContent: String, titleTextContent: String, subTitleTextContent: String) {
    Card(
        shape = RoundedCornerShape(dimen_8dp),
        modifier = Modifier
            .padding(start = dimen_16dp, end = dimen_16dp, top = dimen_16dp)
            .fillMaxWidth()
    ) {
        Box(
            modifier = Modifier
                .padding(dimen_16dp)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                ImageUrlDesktop(
                    url = imageUrlContent,
                    contentDescription = null,
                    modifier = Modifier.size(dimen_48dp),
                    contentScale = ContentScale.Crop
                )
                Spacer(modifier = Modifier.size(dimen_16dp))
                Column {
                    TextTitle(titleTextContent)
                    TextSubTitle(subTitleTextContent)
                }
            }
        }
    }
}

// -------------------------------------------------------------------------------------------------
//  List Type 9 Desktop
// -------------------------------------------------------------------------------------------------

@Composable
fun ListType9(imageUrlContent: String, titleTextContent: String) {
    Card(
        shape = RoundedCornerShape(dimen_8dp),
        modifier = Modifier
            .padding(start = dimen_16dp, end = dimen_16dp, top = dimen_16dp)
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
//  List Type 10 Desktop
// -------------------------------------------------------------------------------------------------

@Composable
fun ListType10(
    imageUrlContent: String,
    titleTextContent: String,
    subTitleTextContent: String
) {
    Card(
        shape = RoundedCornerShape(dimen_8dp),
        modifier = Modifier
            .padding(start = dimen_16dp, end = dimen_16dp, top = dimen_16dp)
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
//  List Type 11 Desktop
// -------------------------------------------------------------------------------------------------

@Composable
fun ListType11(
    imageUrlContent: String,
    titleTextContent: String,
    subTitleTextContent: String,
    descTitleTextContent: String
) {
    Card(
        shape = RoundedCornerShape(dimen_8dp),
        modifier = Modifier
            .padding(start = dimen_16dp, end = dimen_16dp, top = dimen_16dp)
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
//  List Type 12
// -------------------------------------------------------------------------------------------------

@Composable
fun ListType12(titleTextContent: String) {
    Card(
        shape = RoundedCornerShape(dimen_8dp),
        modifier = Modifier
            .padding(start = dimen_16dp, end = dimen_16dp, top = dimen_16dp)
    ) {
        Box(
            modifier = Modifier
                .padding(dimen_16dp)
        ) {
            TextTitle(titleTextContent)
        }
    }
}