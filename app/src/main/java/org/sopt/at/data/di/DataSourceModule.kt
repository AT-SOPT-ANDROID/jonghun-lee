package org.sopt.at.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.sopt.at.data.datasource.UserLocalDataSource
import org.sopt.at.data.datasource.UserRemoteDataSource
import org.sopt.at.data.datasourceimpl.UserLocalDataSourceImpl
import org.sopt.at.data.datasourceimpl.UserRemoteDataSourceImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {
    @Binds
    @Singleton
    abstract fun bindUserRemoteDataSource(
        impl: UserRemoteDataSourceImpl
    ): UserRemoteDataSource

    @Binds
    @Singleton
    abstract fun bindUserLocalDataSource(
        impl: UserLocalDataSourceImpl
    ): UserLocalDataSource


}