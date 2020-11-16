package com.cemal.library_system.entity;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "author")
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class Author  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "author_name")
    private String authorName;
    @Column(name = "explanation")
    private String explanation;

    @JsonManagedReference(value="author")
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "author", orphanRemoval=true)
    private List<Book> book = new ArrayList<>();


}
