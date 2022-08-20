package com.movieproject.movieproject.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "comment")
@Data
public class Comment {
    @Id
    Long id;
    Boolean is_deleted;

    @Lob
    @Column(columnDefinition = "text")
    String text;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id",nullable = false) // user_id'ye bağlandı
    @OnDelete(action = OnDeleteAction.CASCADE)  // user silinince yorumları da silinir
    @JsonIgnore
    User user;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="movie_id",nullable = false) // movie_id'ye bağlandı
    @OnDelete(action = OnDeleteAction.CASCADE)  // film silinince yorumları da silinir
    @JsonIgnore
    Movie movie;
}
