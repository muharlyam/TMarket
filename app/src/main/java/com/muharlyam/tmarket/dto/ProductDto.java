package com.muharlyam.tmarket.dto;

public class ProductDto {
    private Long id;
    private String name;
    private String description;
    private String imageUrl;
    private String producer;
    private Double price;
    private Long count;
    private Long total;
    private Long storeId;
    private Long productTypeId;
    private Double rank;

    public ProductDto(){}

    public ProductDto(Long id,
                      String name,
                      String description,
                      String imageUrl,
                      String producer,
                      Double price,
                      Long count,
                      Long total,
                      Long storeId,
                      Long productTypeId,
                      Double rank) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.imageUrl = imageUrl;
        this.producer = producer;
        this.price = price;
        this.count = count;
        this.total = total;
        this.storeId = storeId;
        this.productTypeId = productTypeId;
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

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public Long getProductTypeId() {
        return productTypeId;
    }

    public void setProductTypeId(Long productTypeId) {
        this.productTypeId = productTypeId;
    }

    public Double getRank() {
        return rank;
    }

    public void setRank(Double rank) {
        this.rank = rank;
    }
}
