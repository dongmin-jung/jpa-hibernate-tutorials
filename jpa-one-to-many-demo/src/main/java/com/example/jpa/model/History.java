package com.example.jpa.model;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.math.BigDecimal;

/**
 * Created by rajeevkumarsingh on 21/11/17.
 */
@Entity
@Table(name = "history")
public class History extends AuditModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    private String image_url;

    @Size(max = 100)
    private String ordered_date;

    private Integer num_people;

    private Integer price;

    @Lob
    private String ordered_menu;

    @Lob
    private String comment;

    private BigDecimal rating;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "tastezip_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
    @JsonIdentityReference(alwaysAsId=true)
    @JsonProperty("tastezip_id")
    private TasteZip tasteZip;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImageUrl() {
        return image_url;
    }

    public void setImageUrl(String image_url) {
        this.image_url = image_url;
    }

    public String getOrderedDate() {
        return ordered_date;
    }

    public void setOrderedDate(String ordered_date) {
        this.ordered_date = ordered_date;
    }

    public Integer getNumPeople() {
        return num_people;
    }

    public void setNumPeople(Integer num_people) {
        this.num_people = num_people;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getOrderedMenu() {
        return ordered_menu;
    }

    public void setOrderedMenu(String ordered_menu) {
        this.ordered_menu = ordered_menu;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public BigDecimal getRating() {
        return rating;
    }

    public void setRating(BigDecimal rating) {
        this.rating = rating;
    }

    public TasteZip getTasteZip() {
        return tasteZip;
    }

    public void setTasteZip(TasteZip tasteZip) {
        this.tasteZip = tasteZip;
    }
}
