package com.veritabani.kutup;

import lombok.Data;

@Data
public class KullaniciDTO {
    private String ad;
    private String tcNo;
}
// sen şimdi kullanicida tcNo tanımlamadın ama burada dto su olmasına rağmen var bunun nedeni biz kullaniciyi mappedBy ile kimlikbilgisi
// tablosuna bağladığımızda kimlikbilgisi tablosunda olan özelliklerde kullanıcıya geçmiş oldu yani kullanıcı sınıfında tcNo olmasa bile
// biz onu kimlikbilgisi sınıfıyla bağladığımız için kimlik bilgisi sınıfındaki özellikleride kendi özelliği gibi alabiliyor