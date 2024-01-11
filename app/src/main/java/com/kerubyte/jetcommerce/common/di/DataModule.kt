package com.kerubyte.jetcommerce.common.di

import com.kerubyte.jetcommerce.common.data.DatabaseInteractorImpl
import com.kerubyte.jetcommerce.common.data.ProductRepositoryImpl
import com.kerubyte.jetcommerce.common.domain.data.DatabaseInteractor
import com.kerubyte.jetcommerce.common.domain.data.ProductRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {
    @Binds
    abstract fun bindDatabaseInteractor(
        databaseInteractorImpl: DatabaseInteractorImpl
    ): DatabaseInteractor

    @Binds
    abstract fun bindProductRepository(
        productServiceImpl: ProductRepositoryImpl
    ): ProductRepository
}