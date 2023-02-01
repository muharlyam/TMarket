package com.muharlyam.domain.repository;

import com.muharlyam.domain.dto.profile.ProfileDto;
import com.muharlyam.domain.dto.profile.TokenDto;

public interface ProfileRepository {
    ProfileDto createUser(TokenDto tokenId);
}
