package com.company.car;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
@Service
@AllArgsConstructor
public class CarService{

    private final CarRepository carRepository;
    private final RestTemplate restTemplate;

    public void registerCar(CarRegistrationRequest carRegistrationRequest) {
        Car car = Car.builder()
                .mark(carRegistrationRequest.mark())
                .model(carRegistrationRequest.model())
                .year(carRegistrationRequest.year())
                .build();
        carRepository.saveAndFlush(car);

        BrokenCarCheckResponse brokenCarCheckResponse = restTemplate.getForObject(
                "http://BROKENCAR/api/broken-check/{carId}",
                BrokenCarCheckResponse.class,
                car.getId()
        );

        if (brokenCarCheckResponse.isBroken()) {
            throw new IllegalStateException("broken");
        }
    }
}
