package br.renan.movieappdb

import android.app.Application
import br.renan.movieappdb.domain.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MovieDbApplication : Application(){

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@MovieDbApplication)
            modules(appModule)
        }
    }


}