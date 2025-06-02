package org.sopt.at.data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.sopt.at.data.service.UserService
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {

    @Provides
    @Singleton
    fun provideUserService(retrofit: Retrofit): UserService =
        retrofit.create(UserService::class.java)
}