package com.company.brokencar;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class BrokenCarCheckHistory {
    @Id
    @SequenceGenerator(
            name = "broken_id_sequence",
            sequenceName = "broken_id_sequence"
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "broken_id_sequence")
    private Integer id;
    private Integer carId;
    private Boolean isBroken;
    private LocalDateTime createdAt;
}
