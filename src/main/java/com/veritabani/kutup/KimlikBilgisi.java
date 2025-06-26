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
//Hangi taraf diğerine bağımlıysa joincolumn (SQL de foreign key) oraya koyulur mesela kullanıcı olmadan adres varolamaz
//ama adres olmadan o kullanıcı varolabilir burada bağımlı sınıf adrestir o yüzden bağımlı olana joincolumn koyuyoruz
//mesela insanın annesiyle bağı olsun ben annem ölüncede varolurum ben olmazsam zaten annem diye bir şey olmaz buradada anneye joincolumn koyarız