package com.startup.ecoapp.di

import com.startup.ecoapp.core.network.createRetrofitService
import com.startup.shared.categories.data.api.CategoriesApi
import com.startup.shared.categories.data.repository.CategoriesRepositoryImpl
import com.startup.shared.categories.domain.repository.CategoriesRepository
import com.startup.shared.categories.domain.usecase.CreateCategoryUseCase
import com.startup.shared.categories.domain.usecase.GetCategoriesUseCase
import org.koin.core.qualifier.named
import org.koin.dsl.module

val categoriesModule = module {
	factory { createRetrofitService<CategoriesApi>(get(named(ORIGINAL))) }

	single<CategoriesRepository> { CategoriesRepositoryImpl(get()) }

	single { CreateCategoryUseCase(get()) }
	single { GetCategoriesUseCase(get()) }
}