package com.muharlyam.domain.dto.profile;

public class TokenDto {
    String tokenId;

    public TokenDto(String tokenId) {
        this.tokenId = tokenId;
    }

    public String getTokenId() {
        return tokenId;
    }

    public void setTokenId(String tokenId) {
        this.tokenId = tokenId;
    }
}
