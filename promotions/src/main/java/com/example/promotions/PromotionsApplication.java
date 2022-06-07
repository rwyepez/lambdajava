package com.example.promotions;

import com.example.promotions.entity.Promotion;
import com.example.promotions.repository.PromotionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

@SpringBootApplication
public class PromotionsApplication {

	@Autowired
	private PromotionRepository promotionRepository;

	@Bean
	public Supplier<List<Promotion>> promotions(){
		return () -> promotionRepository.promotionsList();
	}

	@Bean
	public Function<Promotion, List<Promotion>> findByDate(){
		return (input) -> promotionRepository.promotionsList().stream().filter(promotion -> promotion.getFecha().equals(input.getFecha())).collect(Collectors.toList());
	}

	public static void main(String[] args) {
		SpringApplication.run(PromotionsApplication.class, args);
	}

}
