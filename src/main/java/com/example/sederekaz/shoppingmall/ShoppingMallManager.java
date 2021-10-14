package com.example.sederekaz.shoppingmall;

import com.example.sederekaz.exceptions.ShoppingMallNotFound;
import com.example.sederekaz.shoppingmall.dtos.ShoppingMallAddDTO;
import com.example.sederekaz.shoppingmall.dtos.ShoppingMallDTO;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ShoppingMallManager implements ShoppingMallService{
    private final ShoppingMallDAO shoppingMallDAO;
    private final ModelMapper modelMapper;

    @Override
    public ShoppingMallAddDTO save(ShoppingMallAddDTO shoppingMallAddDTO) {
        ShoppingMall shoppingMall = modelMapper.map(shoppingMallAddDTO,ShoppingMall.class);
        shoppingMall.setName(shoppingMallAddDTO.getName());
        return modelMapper.map(shoppingMallDAO.save(shoppingMall),ShoppingMallAddDTO.class);
    }

    @Override
    public List<ShoppingMallDTO> getAll() {
        List<ShoppingMall> shoppingMalls = shoppingMallDAO.findAll();
        List<ShoppingMallDTO> resultDtos = shoppingMalls.stream()
                .map(shoppingMall -> modelMapper.map(shoppingMall,ShoppingMallDTO.class))
                .collect(Collectors.toList());
        return resultDtos;
    }

    @Override
    public ShoppingMallDTO getByShoppingMallId(Long id) {
        Optional<ShoppingMall> shoppingMall = shoppingMallDAO.findById(id);
        if(shoppingMall.isPresent()){
            return modelMapper.map(shoppingMall.get(),ShoppingMallDTO.class);
        }
        throw new ShoppingMallNotFound("Shopping Mall doesn't exist,Sorry");
    }

    @Override
    public Boolean delete(Long id) {
        Optional<ShoppingMall> shoppingMall = shoppingMallDAO.findById(id);
        if(shoppingMall.isPresent()){
            shoppingMallDAO.deleteById(id);
            return true;
        }
        throw new ShoppingMallNotFound("Shopping Mall doesn't exist,Sorry");
    }

    @Override
    public ShoppingMallAddDTO update(Long id, ShoppingMallAddDTO shoppingMallAddDTO) {
        Optional<ShoppingMall> shoppingMall = shoppingMallDAO.findById(id);
        if(shoppingMall.isPresent()){
            shoppingMall.get().setName(shoppingMallAddDTO.getName());
            return modelMapper.map(shoppingMallDAO.save(shoppingMall.get()),ShoppingMallAddDTO.class);
        }
        throw new ShoppingMallNotFound("Shopping Mall doesn't exist,Sorry");
    }
}
