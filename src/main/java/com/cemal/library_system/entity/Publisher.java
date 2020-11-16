package com.cemal.library_system.entity;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "publisher")
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "publisher_name")
    private String publisherName;
    @Column(name="explanation")
    private String explanation;
    @JsonIgnoreProperties(ignoreUnknown=true)
    @JsonManagedReference(value="publisher")
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "publisher", orphanRemoval=true)
    private List<Book> book = new ArrayList<>();
}
