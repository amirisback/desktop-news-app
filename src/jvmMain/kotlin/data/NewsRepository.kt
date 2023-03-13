package data

import model.ArticleResponse
import model.SourceResponse
import util.NewsUrl
import common.callback.ApiResponseCallback
import common.callback.ApiCallback
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import data.remote.ApiClient
import data.remote.NewsApiService

class NewsRepository : NewsDataSource {

    val disposable: CompositeDisposable by lazy { CompositeDisposable() }
    private var newsApiService = ApiClient.create<NewsApiService>(NewsUrl.BASE_URL, true)

    private val apiKey = NewsUrl.API_KEY


    override fun getTopHeadline(
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
        language: String,
        country: String,
        category: String,
        callback: ApiResponseCallback<SourceResponse>
    ) {
        callback.onShowProgress()
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
        q: String?,
        sources: String?,
        category: String?,
        country: String?,
        pageSize: Int?,
        page: Int?,
        callback: ApiResponseCallback<ArticleResponse>
    ) {
        newsApiService.getTopHeadlineRx(apiKey, q, sources, category, country, pageSize, page)
            .doOnSubscribe { callback.onShowProgress() }
            .doOnTerminate { callback.onHideProgress() }
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
            .doOnSubscribe { callback.onShowProgress() }
            .doOnTerminate { callback.onHideProgress() }
            .subscribe(object : Observer<ArticleResponse>{
                override fun onSubscribe(d: Disposable) {
                    disposable.add(d)
                }

                override fun onError(e: Throwable) {
                    callback.onFailed(500, e.localizedMessage)
                }

                override fun onComplete() {
                }

                override fun onNext(t: ArticleResponse) {
                    callback.onSuccess(t)
                }
            })
    }

    override fun getSourcesRx(
        language: String,
        country: String,
        category: String,
        callback: ApiResponseCallback<SourceResponse>
    ) {
        newsApiService.getSourcesRx(apiKey, language, country, category)
            .doOnSubscribe { callback.onShowProgress() }
            .doOnTerminate { callback.onHideProgress() }
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