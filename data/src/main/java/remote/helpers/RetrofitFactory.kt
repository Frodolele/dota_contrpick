package remote.helpers

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.serialization.json.Json
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
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

        private fun getRetrofitClient(): Retrofit{
            return Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(getOkHttpInstance())
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .build()
        }
    }
}