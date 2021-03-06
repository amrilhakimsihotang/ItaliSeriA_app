package com.amrilhs.italiaseria.core.di

import android.content.Context
import androidx.room.Room
import com.amrilhs.italiaseria.core.data.source.local.room.ItaliaSeriADatabase
import com.amrilhs.italiaseria.core.data.source.local.room.ItalianSeriaDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Singleton
    @Provides

    fun provideDatabase(@ApplicationContext context: Context): ItaliaSeriADatabase =
        Room.databaseBuilder(
            context,
            ItaliaSeriADatabase::class.java, "LEAGUE.db"
        ).fallbackToDestructiveMigration().build()

    @Provides
    fun prodiveItaliaSeriaDao(database: ItaliaSeriADatabase):ItalianSeriaDao = database.italianSeriaDao()
}