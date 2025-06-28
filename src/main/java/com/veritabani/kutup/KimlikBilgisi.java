package com.veritabani.kutup;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class KimlikBilgisi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tcNo;

    @OneToOne
    @JoinColumn(name = "kullanici_id")
    private Kullanici kullanici;
}
