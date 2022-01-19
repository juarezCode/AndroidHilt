package com.juarez.androidhilt.di

import com.juarez.androidhilt.AppNavigator
import com.juarez.androidhilt.AppNavigatorImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

//contenedor de activity porque necesitamos algo de la activity
@InstallIn(ActivityComponent::class)
@Module
abstract class NavigationModule {
    //Binds para interfaces
    @Binds
    abstract fun bindNavigator(impl: AppNavigatorImpl): AppNavigator
}