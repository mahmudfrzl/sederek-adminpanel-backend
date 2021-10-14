package com.example.sederekaz.shop;

import com.example.sederekaz.shop.dtos.ShopAddDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ShopManager implements ShopService{
    private final ShopDAO shopDAO;
    private final ModelMapper modelMapper;


    @Override
    public ShopAddDto save(ShopAddDto shopAddDto) {
        return null;
    }
}
