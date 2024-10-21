package com.example.jetpack_compose_app_transaction.di

import android.app.Application
import androidx.room.Room
import com.example.jetpack_compose_app_transaction.data.data_source.TransactionsDB
import com.example.jetpack_compose_app_transaction.data.repository.TransactionRepositoryImpl
import com.example.jetpack_compose_app_transaction.domain.repository.TransactionRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun providesQuestionsCacheDB(application: Application): TransactionsDB {
        return Room.databaseBuilder(
            application,
            TransactionsDB::class.java,
            TransactionsDB.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun providesTransactionRepository(
        db: TransactionsDB
    ): TransactionRepository {
        return TransactionRepositoryImpl(db.transactionDao)
    }
}