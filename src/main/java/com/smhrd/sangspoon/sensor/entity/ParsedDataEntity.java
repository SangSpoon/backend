package com.smhrd.sangspoon.sensor.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "parsed_data")
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
public class ParsedDataEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private long waterLevel;
    private long chemicalLevel;
    private int motorStatus1;
    private int motorStatus2;
    private long flowRate;
    private long totalAmount;

    @OneToOne
    @JoinColumn(name = "sensor_data_id", nullable = false)
    private SensorDataEntity sensor;
}
