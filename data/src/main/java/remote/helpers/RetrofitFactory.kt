package remote.helpers

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.UnstableDefault
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import remote.services.HeroesService
import retrofit2.Retrofit

class RetrofitFactory {

    companion object {
        // Where we give information
        val baseUrl = "https://api.opendota.com/api/"

        private fun getOkHttpInstance(): OkHttpClient {
            val loggingInterceptor = HttpLoggingInterceptor()
            loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

            // Pattern is Builder.
            return OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .build()
        }

        @UnstableDefault
        private fun getRetrofitClient(): Retrofit{
            return Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(getOkHttpInstance())
                .addConverterFactory(Json.nonstrict.asConverterFactory("application/json".toMediaTypeOrNull()!!))
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .build()
                }

        @UnstableDefault
        fun getHeroesService() = RetrofitFactory.getRetrofitClient().create(HeroesService::class.java)
        }


}