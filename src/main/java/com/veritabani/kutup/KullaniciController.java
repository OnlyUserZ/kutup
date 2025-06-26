package com.veritabani.kutup;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/kullanicilar")
@RequiredArgsConstructor
public class KullaniciController {

    private final KullaniciService kullaniciService;

    // Kullanıcı oluştur
    @PostMapping("/ekle")
    public KullaniciDTO kullaniciEkle(@RequestBody KullaniciDTO dto) {
        return kullaniciService.kullaniciOlustur(dto);
    }

    // Sayfalı ve sıralı kullanıcı listele
    @GetMapping("/listele")
    public Page<KullaniciDTO> kullaniciListele(
            @RequestParam(defaultValue = "0") int sayfa,
            @RequestParam(defaultValue = "5") int boyut,
            @RequestParam(defaultValue = "id") String siralaAlan,
            @RequestParam(defaultValue = "asc") String siralamaYonu
    ) {
        Sort sort = siralamaYonu.equalsIgnoreCase("desc")
                ? Sort.by(siralaAlan).descending()
                : Sort.by(siralaAlan).ascending();

        Pageable pageable = PageRequest.of(sayfa, boyut, sort);
        return kullaniciService.kullanicilariGetir(pageable);
    }
}
