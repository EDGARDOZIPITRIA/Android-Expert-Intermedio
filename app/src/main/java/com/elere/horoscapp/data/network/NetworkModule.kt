package com.elere.horoscapp.data.network

import com.elere.horoscapp.BuildConfig.BASE_URL
import com.elere.horoscapp.data.RepositoryImpl
import com.elere.horoscapp.data.core.interceptors.AuthInterceptor
import com.elere.horoscapp.domain.model.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provaideRetrofit(okHttpClient: OkHttpClient): Retrofit {
       return Retrofit
            .Builder()
            .baseUrl(BASE_URL)
           .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(authInterceptor: AuthInterceptor): OkHttpClient {
        val interceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

        return OkHttpClient
            .Builder()
            .addInterceptor(interceptor)
            .addInterceptor(authInterceptor)
            .build()

    }

    @Provides
    fun provideHoroscopeApiService(retrofit: Retrofit):HoroscopeApiService{
        return retrofit.create(HoroscopeApiService::class.java)

    }

    @Provides
    fun provideRepositore(apiService: HoroscopeApiService):Repository{
        return RepositoryImpl(apiService)
    }



}