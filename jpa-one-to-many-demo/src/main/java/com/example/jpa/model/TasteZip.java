package com.example.jpa.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import java.math.BigDecimal;

/**
 * Created by rajeevkumarsingh on 21/11/17.
 */
@Entity
@Table(name = "tastezips")
public class TasteZip extends AuditModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 100)
    @Column(unique = true)
    private String name;

    @Lob
    private String thumbnail_url;

    @Lob
    private String description;

    @Lob
    private String main_menu;

    @Size(max = 100)
    private String location;

    @Size(max = 100)
    private String avg_price;

    @Size(max = 100)
    private String work_time;

    @Lob
    private String external_url;

    @Lob
    private String map_url;

    private BigDecimal avg_rating;

    private Integer num_orders;

    private BigDecimal rank_score;
    

    // @NotNull
    // @Lob
    // private String content;

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

    public String getThumbnailUrl() {
        return thumbnail_url;
    }

    public void setThumbnailUrl(String thumbnail_url) {
        this.thumbnail_url = thumbnail_url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMainMenu() {
        return main_menu;
    }

    public void setMainMenu(String main_menu) {
        this.main_menu = main_menu;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getAvgPrice() {
        return avg_price;
    }

    public void setAvgPrice(String avg_price) {
        this.avg_price = avg_price;
    }

    public String getWorkTime() {
        return work_time;
    }

    public void setWorkTime(String work_time) {
        this.work_time = work_time;
    }

    public String getExternalUrl() {
        return external_url;
    }

    public void setExternalUrl(String external_url) {
        this.external_url = external_url;
    }

    public String getMapUrl() {
        return map_url;
    }

    public void setMapUrl(String map_url) {
        this.map_url = map_url;
    }

    public BigDecimal getAvgRating() {
        return avg_rating;
    }

    public void setAvgRating(BigDecimal avg_rating) {
        this.avg_rating = avg_rating;
    }

    public Integer getNumOrders() {
        return num_orders;
    }

    public void setNumOrders(Integer num_orders) {
        this.num_orders = num_orders;
    }

    public BigDecimal getRankScore() {
        return rank_score;
    }

    public void setRankScore(BigDecimal rank_score) {
        this.rank_score = rank_score;
    }

}
