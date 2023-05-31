package com.startup.ecoapp

import android.app.Application
import com.startup.ecoapp.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidFileProperties
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class App : Application() {

	companion object {

		const val BACKEND = "BACKEND"
		private const val BACKEND_ENDPOINT = ""//TODO(Вставить ссылку на бэкенд)

		internal lateinit var INSTANCE: App
			private set
	}

	override fun onCreate() {
		super.onCreate()

		INSTANCE = this

		startKoin {
			androidLogger(Level.ERROR)
			androidContext(this@App)
			properties(mapOf(BACKEND to BACKEND_ENDPOINT))
			androidFileProperties()

			modules(appModule)
		}
	}
}
