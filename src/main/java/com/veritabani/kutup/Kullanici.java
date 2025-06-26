package com.veritabani.kutup;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Kullanici {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ad;

    @OneToOne(mappedBy = "kullanici", cascade = CascadeType.ALL)
    private KimlikBilgisi kimlik; // cascade mappedBy lı sınıfa koyulur
}

