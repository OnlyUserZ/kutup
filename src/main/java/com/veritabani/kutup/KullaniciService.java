package com.veritabani.kutup;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KullaniciService {
	
    @Autowired
    private final KullaniciRepository kullaniciRepository;

    public KullaniciDTO kullaniciOlustur(KullaniciDTO dto) {
        Kullanici kullanici = new Kullanici();
        kullanici.setAd(dto.getAd());

        KimlikBilgisi kimlik = new KimlikBilgisi();
        kimlik.setTcNo(dto.getTcNo());
        kimlik.setKullanici(kullanici);

        kullanici.setKimlik(kimlik);

        Kullanici kaydedilen = kullaniciRepository.save(kullanici);

        KullaniciDTO cevap = new KullaniciDTO();
        cevap.setAd(kaydedilen.getAd());
        cevap.setTcNo(kaydedilen.getKimlik().getTcNo());
        return cevap;
    }

    public Page<KullaniciDTO> kullanicilariGetir(Pageable pageable) {
        return kullaniciRepository.findAll(pageable).map(k -> {
            KullaniciDTO dto = new KullaniciDTO();
            dto.setAd(k.getAd()); 
            dto.setTcNo(k.getKimlik().getTcNo());
            return dto;
        });
    }
}
