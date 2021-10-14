package com.example.sederekaz.shoppingmall;

import com.example.sederekaz.shoppingmall.dtos.ShoppingMallAddDTO;
import com.example.sederekaz.shoppingmall.dtos.ShoppingMallDTO;
import com.example.sederekaz.shoppingmall.dtos.ShoppingMallDeleteDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/shoppingMall")
@RequiredArgsConstructor
@CrossOrigin
public class ShoppingMallController {
    private final ShoppingMallService shoppingMallService;

    @PostMapping("/save")
    private ResponseEntity<ShoppingMallAddDTO> save(@Valid @RequestBody ShoppingMallAddDTO shoppingMallAddDTO){
        return ResponseEntity.ok(shoppingMallService.save(shoppingMallAddDTO));
    }
    @GetMapping("/getAll")
    private ResponseEntity<List<ShoppingMallDTO>> getAll(){
        return ResponseEntity.ok(shoppingMallService.getAll());
    }
    @GetMapping("/getByShoppingMallId")
    private ResponseEntity<ShoppingMallDTO> getByShoppingMallId(@Valid @RequestParam Long id){
        return ResponseEntity.ok(shoppingMallService.getByShoppingMallId(id));
    }
    @DeleteMapping("/delete")
    private ResponseEntity<Boolean> delete(@Valid @RequestParam Long id){
        return ResponseEntity.ok(shoppingMallService.delete(id));
    }

    @PutMapping("/update")
    private ResponseEntity<ShoppingMallAddDTO> update(@Valid @RequestParam Long id,@Valid @RequestBody ShoppingMallAddDTO shoppingMallAddDTO){
        return ResponseEntity.ok(shoppingMallService.update(id,shoppingMallAddDTO));
    }
}
