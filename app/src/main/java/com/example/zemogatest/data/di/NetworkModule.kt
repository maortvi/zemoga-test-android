package com.example.zemogatest.data.di

import com.example.zemogatest.BuildConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.*
import io.ktor.client.engine.okhttp.*
import io.ktor.client.features.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.request.*
import io.ktor.http.*
import kotlinx.serialization.json.Json
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.security.cert.X509Certificate
import javax.inject.Qualifier
import javax.inject.Singleton
import javax.net.ssl.SSLContext
import javax.net.ssl.X509TrustManager

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    @ZemogaHttpClient
    fun provideHttpClient(
        json: Json,
        okHttpClient: OkHttpClient,
    ): HttpClient = HttpClient(OkHttp) {
        defaultRequest {
            host = "jsonplaceholder.typicode.com"
            if (!headers.contains(HttpHeaders.ContentType)) {
                contentType(ContentType.Application.Json)
            }
            url {
                protocol = URLProtocol.HTTPS
            }
        }
        engine {
            preconfigured = okHttpClient
        }
        install(JsonFeature) {
            serializer = KotlinxSerializer(json)
        }
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(
        loggingInterceptor: HttpLoggingInterceptor
    ): OkHttpClient {
        // Create a trust manager that does not validate certificate chains
        val trustAllCerts = object : X509TrustManager {
            override fun checkClientTrusted(
                chain: Array<out X509Certificate>?,
                authType: String?
            ) {
            }

            override fun checkServerTrusted(
                chain: Array<out X509Certificate>?,
                authType: String?
            ) {
            }

            override fun getAcceptedIssuers() = arrayOf<X509Certificate>()
        }

        // Install the all-trusting trust manager
        val sslContext = SSLContext.getInstance("SSL")
        sslContext.init(null, arrayOf(trustAllCerts), java.security.SecureRandom())
        // Create an ssl socket factory with our all-trusting manager
        val sslSocketFactory = sslContext.socketFactory

        return OkHttpClient.Builder()
            .sslSocketFactory(sslSocketFactory = sslSocketFactory, trustManager = trustAllCerts)
            .hostnameVerifier { hostname, session -> true }
            .addInterceptor(loggingInterceptor)
            .build()
    }

    @Provides
    @Singleton
    fun provideLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply {
            level =
                if (BuildConfig.DEBUG)
                    HttpLoggingInterceptor.Level.BODY
                else
                    HttpLoggingInterceptor.Level.NONE
        }
    }

}

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class ZemogaHttpClient
