package com.muharlyam.tmarket.dagger.component;

import com.muharlyam.tmarket.dagger.module.ProfileModule;
import com.muharlyam.tmarket.ui.SignUpFragment;

import dagger.Component;

@Component(modules = ProfileModule.class)
public interface ProfileComponent {
    void inject(SignUpFragment obj);
}
