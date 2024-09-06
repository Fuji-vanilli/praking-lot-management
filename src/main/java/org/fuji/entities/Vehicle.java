package org.fuji.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Vehicle {
    private String type;
    private String registration;
    private String color;
}
