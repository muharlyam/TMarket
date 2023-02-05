package com.muharlyam.data.service;

import com.muharlyam.data.entity.DaoMaster;
import com.muharlyam.data.entity.DaoSession;
import com.muharlyam.data.entity.Profile;
import com.muharlyam.domain.dto.profile.ProfileDto;
import com.muharlyam.domain.dto.profile.TokenDto;
import com.muharlyam.domain.repository.ProfileRepository;

import org.greenrobot.greendao.database.Database;

public class ProfileService {

    ProfileRepository profileRepository;

    public ProfileService(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    public ProfileDto createUser(TokenDto tokenDto) {
        ProfileDto profileDto = profileRepository.createUser(tokenDto);
        Profile profile = new Profile();
        profile.setEmail(profileDto.getEmail());
        profile.setId(profileDto.getId());
        profile.setName(profileDto.getName());


//        long insert = daoSession.insert(profile);

        return profileDto;
    }

}
