package com.konztic.tragosapp.di

import com.konztic.tragosapp.data.DataSourceImpl
import com.konztic.tragosapp.domain.DataSource
import com.konztic.tragosapp.domain.Repo
import com.konztic.tragosapp.domain.RepoImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent

@Module
@InstallIn(ActivityRetainedComponent::class)
abstract class ActivityModule {

    @Binds
    abstract fun bindRepoImpl(repoImpl: RepoImpl): Repo

    @Binds
    abstract fun bindDataSourceImpl(dataSourceImpl: DataSourceImpl): DataSource

}