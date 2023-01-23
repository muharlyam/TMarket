package com.muharlyam.tmarket.dto;

public class StoreDto {
    private Long id;
    private String name;
    private String description;
    private String imageUrl;
    private String fullName;
    private String ownerId;
    private Long storeTypeId;
    private Double rank;

    public StoreDto(){}

    public StoreDto(Long id,
                    String name,
                    String description,
                    String imageUrl,
                    String fullName,
                    String ownerId,
                    Long storeTypeId,
                    Double rank) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.imageUrl = imageUrl;
        this.fullName = fullName;
        this.ownerId = ownerId;
        this.storeTypeId = storeTypeId;
        this.rank = rank;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public Long getStoreTypeId() {
        return storeTypeId;
    }

    public void setStoreTypeId(Long storeTypeId) {
        this.storeTypeId = storeTypeId;
    }

    public Double getRank() {
        return rank;
    }

    public void setRank(Double rank) {
        this.rank = rank;
    }
}
