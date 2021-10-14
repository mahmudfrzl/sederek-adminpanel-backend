package com.example.sederekaz.shop;

import com.example.sederekaz.shop.dtos.ShopAddDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/shops")
@RequiredArgsConstructor
public class ShopController {
    private final ShopService shopService;

    @PostMapping("/save")
    public ResponseEntity<ShopAddDto> save(@Valid @RequestBody ShopAddDto shopAddDto){
        return ResponseEntity.ok(shopService.save(shopAddDto));
    }
}
