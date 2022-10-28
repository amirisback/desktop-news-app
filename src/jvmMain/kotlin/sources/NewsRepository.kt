package sources

import response.ArticleResponse
import response.SourceResponse
import util.NewsUrl
import core.ConsumeApiResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import sources.remote.FrogoApiClient
import sources.remote.NewsApiService

/**
 * Created by Faisal Amir
 * FrogoBox Inc License
 * =========================================
 * consumable-code-news-api
 * Copyright (C) 15/03/2020.
 * All rights reserved
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * LinkedIn : linkedin.com/in/faisalamircs
 * -----------------------------------------
 * FrogoBox Software Industries
 * com.frogobox.frogoconsumeapi.news.data.source
 *
 */
object NewsRepository : NewsDataSource {

    private val TAG = NewsRepository::class.java.simpleName
    private var newsApiService = FrogoApiClient.create<NewsApiService>(NewsUrl.BASE_URL)

    override fun getTopHeadline(
        apiKey: String,
        q: String?,
        sources: String?,
        category: String?,
        country: String?,
        pageSize: Int?,
        page: Int?,
        callback: ConsumeApiResponse<ArticleResponse>
    ) {
        callback.onShowProgress()
        newsApiService.getTopHeadline(apiKey, q, sources, category, country, pageSize, page)
            .enqueue(object : Callback<ArticleResponse> {

                override fun onResponse(call: Call<ArticleResponse>, response: Response<ArticleResponse>) {
                    callback.onHideProgress()
                    response.body()?.let { callback.onSuccess(it) }
                }

                override fun onFailure(call: Call<ArticleResponse>, t: Throwable) {
                    callback.onHideProgress()
                    callback.onFailed(500, t.localizedMessage)
                }

            })
    }

    override fun getEverythings(
        apiKey: String,
        q: String?,
        from: String?,
        to: String?,
        qInTitle: String?,
        sources: String?,
        domains: String?,
        excludeDomains: String?,
        language: String?,
        sortBy: String?,
        pageSize: Int?,
        page: Int?,
        callback: ConsumeApiResponse<ArticleResponse>
    ) {
        newsApiService.getEverythings(
            apiKey,
            q,
            from,
            to,
            qInTitle,
            sources,
            domains,
            excludeDomains,
            language,
            sortBy,
            pageSize,
            page
        )
            .enqueue(object : Callback<ArticleResponse> {

                override fun onResponse(call: Call<ArticleResponse>, response: Response<ArticleResponse>) {
                    callback.onHideProgress()
                    response.body()?.let { callback.onSuccess(it) }
                }

                override fun onFailure(call: Call<ArticleResponse>, t: Throwable) {
                    callback.onHideProgress()
                    callback.onFailed(500, t.localizedMessage)
                }

            })
    }

    override fun getSources(
        apiKey: String,
        language: String,
        country: String,
        category: String,
        callback: ConsumeApiResponse<SourceResponse>
    ) {
        newsApiService.getSources(apiKey, language, country, category)
            .enqueue(object : Callback<SourceResponse> {

                override fun onResponse(call: Call<SourceResponse>, response: Response<SourceResponse>) {
                    callback.onHideProgress()
                    response.body()?.let { callback.onSuccess(it) }
                }

                override fun onFailure(call: Call<SourceResponse>, t: Throwable) {
                    callback.onHideProgress()
                    callback.onFailed(500, t.localizedMessage)
                }

            })
    }
}