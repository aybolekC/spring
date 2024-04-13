package com.aya.bootstrap;

import com.aya.repository.RegionRepository;
import jakarta.persistence.Column;
import org.hibernate.cache.spi.RegionFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataGenerator implements CommandLineRunner {


    private final RegionRepository regionRepository;

    public DataGenerator(RegionRepository regionRepository) {
        this.regionRepository = regionRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("===============================REGION START============================");

        System.out.println("findByCountry: " + regionRepository.findByCountry("Canada"));

        System.out.println("findDistinctByCountry: " + regionRepository.findDistinctByCountry("United States"));


        System.out.println("findByCountryContaining: " + regionRepository.findByCountryContaining("United"));


        System.out.println("findByCountryContainingOrderBOrderByCountry: " + regionRepository.findByCountryContainingOrderByCountry("Asia"));
        System.out.println("findByCountryContainingOrderBOrderByCountry: " + regionRepository.findByCountryContainingOrderByCountry("United"));
        System.out.println("findTopByCountry: " + regionRepository.findTop2ByCountry("Canada"));




        System.out.println("===============================REGION END============================");




    }
}
