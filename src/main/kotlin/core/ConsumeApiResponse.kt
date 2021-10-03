package core

import androidx.compose.runtime.Composable

/*
 * Created by faisalamir on 21/08/21
 * FrogoConsumeApi
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 * Copyright (C) 2021 FrogoBox Inc.      
 * All rights reserved
 *
 */
interface ConsumeApiResponse<T> {

    fun onSuccess(data: T)

    fun onFailed(statusCode: Int, errorMessage: String)

    fun onShowProgress()

    fun onHideProgress()

}