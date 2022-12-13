package com.company.car;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("api/cars")
@AllArgsConstructor
public class CarController {

    private final CarService carService;

    @PostMapping
    public void registerCars(@RequestBody CarRegistrationRequest carRegistrationRequest) {
        log.info("new car registration {}", carRegistrationRequest);
        carService.registerCar(carRegistrationRequest);
    }
}
