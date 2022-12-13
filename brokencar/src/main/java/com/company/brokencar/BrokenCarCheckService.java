package com.company.brokencar;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class BrokenCarCheckService {

    private final BrokenCarCheckHistoryRepository brokenCheckHistoryRepository;

    public boolean isBrokenCar(Integer carId) {
        brokenCheckHistoryRepository.save(
                BrokenCarCheckHistory.builder()
                        .carId(carId)
                        .isBroken(true)
                        .createdAt(LocalDateTime.now())
                        .build()
        );
        return false;
    }
}
