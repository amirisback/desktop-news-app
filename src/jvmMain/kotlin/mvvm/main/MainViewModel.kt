package mvvm.main

import model.ArticleResponse
import model.SourceResponse
import data.NewsRepository
import common.callback.ApiResponseCallback
import util.NewsConstant


/**
 * Created by Faisal Amir
 * -----------------------------------------
 * consumable-code-news-api
 * Copyright (C) 15/03/2020.
 * All rights reserved
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 *
 */

class MainViewModel {

    private val newsRepository = NewsRepository()

    fun getEverythings(callback: ApiResponseCallback<ArticleResponse>) {
        newsRepository.getEverythings(
            "Nutrisi",
            null,
            null,
            null,
            null,
            null,
            null,
            NewsConstant.COUNTRY_ID,
            null,
            null,
            null,
            callback
        )
    }

}