package com.muharlyam.tmarket.dagger.module;

import com.muharlyam.data.repository.ProfileRepositoryImpl;
import com.muharlyam.domain.repository.ProfileRepository;

import dagger.Module;
import dagger.Provides;

@Module
public class ProfileModule {
    @Provides
    ProfileRepositoryImpl provideProfileRepository() {
        return new ProfileRepositoryImpl();
    }
}
