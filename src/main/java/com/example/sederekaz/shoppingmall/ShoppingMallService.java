package com.example.sederekaz.shoppingmall;

import com.example.sederekaz.shoppingmall.dtos.ShoppingMallAddDTO;
import com.example.sederekaz.shoppingmall.dtos.ShoppingMallDTO;
import com.example.sederekaz.shoppingmall.dtos.ShoppingMallDeleteDto;

import java.util.List;

public interface ShoppingMallService {
    ShoppingMallAddDTO save(ShoppingMallAddDTO shoppingMallAddDTO);

    List<ShoppingMallDTO> getAll();

    ShoppingMallDTO getByShoppingMallId(Long id);

    Boolean delete(Long id);

    ShoppingMallAddDTO update(Long id, ShoppingMallAddDTO shoppingMallAddDTO);
}
