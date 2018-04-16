package com.taidang.themoviedb.presentation.di.component

import com.taidang.themoviedb.di.module.NetworkModule
import com.taidang.themoviedb.di.module.RepositoryModule
import com.taidang.themoviedb.presentation.TMDBApp
import com.taidang.themoviedb.presentation.di.ApplicationScoped
import com.taidang.themoviedb.presentation.di.module.ApplicationModule
import com.taidang.themoviedb.presentation.di.module.MapperModule
import com.taidang.themoviedb.presentation.di.module.SplashModule
import com.taidang.themoviedb.presentation.di.module.UsecaseModule
import dagger.Component

@Component(modules = [
    ApplicationModule::class,
    RepositoryModule::class,
    NetworkModule::class,
    MapperModule::class,
    UsecaseModule::class])
@ApplicationScoped
interface ApplicationComponent {
    fun inject(application: TMDBApp)

    fun plus(splashModule: SplashModule): SplashComponent
}