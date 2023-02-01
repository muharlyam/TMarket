package com.muharlyam.domain.service;

import com.muharlyam.domain.dto.profile.ProfileDto;
import com.muharlyam.domain.dto.profile.TokenDto;
import com.muharlyam.domain.repository.ProfileRepository;

public class ProfileService {

    ProfileRepository profileRepository;

    public ProfileService(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    public ProfileDto createUser(TokenDto tokenDto) {
        return profileRepository.createUser(tokenDto);
        // todo save
    }

}
