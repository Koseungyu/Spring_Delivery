package com.sparta.delivery.model;
import com.sparta.delivery.dto.FoodDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@AllArgsConstructor // @Builder 사용할때 필요함.
@NoArgsConstructor
@Getter
@Entity
@Builder
public class Food {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int price;

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;


    public Food(FoodDto foodDto){
        this.id = foodDto.getRestaurantId();
        this.name = foodDto.getName();
        this.price = foodDto.getPrice();

    }
}
