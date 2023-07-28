package com.example.newswithcleancode.di

import android.content.Context
import com.example.newswithcleancode.BuildConfig
import com.example.newswithcleancode.api.ApiNews
import com.example.newswithcleancode.api.NewsApiInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.Dispatchers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModules {
    @Provides
    @Singleton
    fun providesApiNews(
        @ApplicationContext context: Context
    ) = Retrofit.Builder()
        .baseUrl(BuildConfig.NEWS_BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client( provideOkHttpClient())
        .build()
        .create<ApiNews>()

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient{
        val okhttpBuilder = OkHttpClient.Builder() //and every other method after it except build() would return a Builder (Builder pattern)
        // .addInterceptor(NewsApiInterceptor(context.getString(R.string.CURRENTS_API_KEY)))
        okhttpBuilder.addInterceptor(NewsApiInterceptor(BuildConfig.CURRENTS_API_KEY))
        if(BuildConfig.DEBUG){
            okhttpBuilder .addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
        }
        return okhttpBuilder.build()
    }

    @Provides
    @Singleton
    fun providesIODispatcher() = Dispatchers.IO
}