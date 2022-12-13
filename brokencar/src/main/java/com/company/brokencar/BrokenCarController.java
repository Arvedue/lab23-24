package com.company.brokencar;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/broken-check")
@AllArgsConstructor
@Slf4j
public class BrokenCarController {

    private final BrokenCarCheckService brokenCheckService;

    @GetMapping(path = "{carId}")
    public BrokenCarCheckResponse isBroken(@PathVariable("carId") Integer carId) {
        boolean isBrokenCar = brokenCheckService.isBrokenCar(carId);
        log.info("Broken car check request for car {}", carId);
        return new BrokenCarCheckResponse(isBrokenCar);
    }
}
