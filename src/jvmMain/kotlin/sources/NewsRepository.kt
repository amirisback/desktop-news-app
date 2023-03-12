package sources

import model.ArticleResponse
import model.SourceResponse
import util.NewsUrl
import callback.ApiResponseCallback
import callback.ApiCallback
import io.reactivex.rxjava3.schedulers.Schedulers
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import sources.remote.ApiClient
import sources.remote.NewsApiService

object NewsRepository : NewsDataSource {

    private var newsApiService = ApiClient.create<NewsApiService>(NewsUrl.BASE_URL, true)

    override fun getTopHeadline(
        apiKey: String,
        q: String?,
        sources: String?,
        category: String?,
        country: String?,
        pageSize: Int?,
        page: Int?,
        callback: ApiResponseCallback<ArticleResponse>
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
        callback: ApiResponseCallback<ArticleResponse>
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
        callback: ApiResponseCallback<SourceResponse>
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

    override fun getTopHeadlineRx(
        apiKey: String,
        q: String?,
        sources: String?,
        category: String?,
        country: String?,
        pageSize: Int?,
        page: Int?,
        callback: ApiResponseCallback<ArticleResponse>
    ) {
        newsApiService.getTopHeadlineRx(apiKey, q, sources, category, country, pageSize, page)
            .subscribeOn(Schedulers.io())
            .doOnSubscribe { callback.onShowProgress() }
            .doOnTerminate { callback.onHideProgress() }
            .observeOn(Schedulers.single())
            .subscribe(object : ApiCallback<ArticleResponse>() {
                override fun onSuccess(data: ArticleResponse) {
                    callback.onSuccess(data)
                }

                override fun onFailure(code: Int, errorMessage: String) {
                    callback.onFailed(code, errorMessage)
                }
            })
    }

    override fun getEverythingsRx(
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
        callback: ApiResponseCallback<ArticleResponse>
    ) {
        newsApiService.getEverythingsRx(
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
            .subscribeOn(Schedulers.io())
            .doOnSubscribe { callback.onShowProgress() }
            .doOnTerminate { callback.onHideProgress() }
            .observeOn(Schedulers.trampoline())
            .subscribe(object : ApiCallback<ArticleResponse>() {
                override fun onSuccess(data: ArticleResponse) {
                    callback.onSuccess(data)
                }

                override fun onFailure(code: Int, errorMessage: String) {
                    callback.onFailed(code, errorMessage)
                }
            })
    }

    override fun getSourcesRx(
        apiKey: String,
        language: String,
        country: String,
        category: String,
        callback: ApiResponseCallback<SourceResponse>
    ) {
        newsApiService.getSourcesRx(apiKey, language, country, category)
            .subscribeOn(Schedulers.io())
            .doOnSubscribe { callback.onShowProgress() }
            .doOnTerminate { callback.onHideProgress() }
            .observeOn(Schedulers.trampoline())
            .subscribe(object : ApiCallback<SourceResponse>() {
                override fun onSuccess(data: SourceResponse) {
                    callback.onSuccess(data)
                }

                override fun onFailure(code: Int, errorMessage: String) {
                    callback.onFailed(code, errorMessage)
                }
            })
    }

}