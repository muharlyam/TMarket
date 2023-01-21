package com.muharlyam.tmarket.dto;

import java.util.List;

public class RecommendationDto {
    private String profileId;
    private List<StoreDto> likeStores;
    private List<ProductDto> likeProducts;
    private List<StoreDto> topStores;
    private List<ProductDto> topProducts;

    public RecommendationDto(String profileId,
                             List<StoreDto> likeStores,
                             List<ProductDto> likeProducts,
                             List<StoreDto> topStores,
                             List<ProductDto> topProducts) {
        this.profileId = profileId;
        this.likeStores = likeStores;
        this.likeProducts = likeProducts;
        this.topStores = topStores;
        this.topProducts = topProducts;
    }

    public String getProfileId() {
        return profileId;
    }

    public void setProfileId(String profileId) {
        this.profileId = profileId;
    }

    public List<StoreDto> getLikeStores() {
        return likeStores;
    }

    public void setLikeStores(List<StoreDto> likeStores) {
        this.likeStores = likeStores;
    }

    public List<ProductDto> getLikeProducts() {
        return likeProducts;
    }

    public void setLikeProducts(List<ProductDto> likeProducts) {
        this.likeProducts = likeProducts;
    }

    public List<StoreDto> getTopStores() {
        return topStores;
    }

    public void setTopStores(List<StoreDto> topStores) {
        this.topStores = topStores;
    }

    public List<ProductDto> getTopProducts() {
        return topProducts;
    }

    public void setTopProducts(List<ProductDto> topProducts) {
        this.topProducts = topProducts;
    }
}
