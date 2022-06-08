package com.sparta.delivery.controller;

import com.sparta.delivery.dto.FoodDto;
import com.sparta.delivery.model.Food;
import com.sparta.delivery.service.FoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class FoodController {

    private final FoodService foodService;


    // 음식 등록
    @PostMapping("/restaurant/{restaurantId}/food/register")
    public void registerFoodAndRestaurantId(@PathVariable Long restaurantId, @RequestBody List<FoodDto> foodDto){
        foodService.registerFood(restaurantId, foodDto);
    }

    // 메뉴판 조회
    @GetMapping("/restaurant/{restaurantId}/foods")
    public List<Food> getRestaurantFoodList(@PathVariable Long restaurantId){
        return foodService.getRestaurantFoodList(restaurantId);
    }
}
