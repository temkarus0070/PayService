package org.temkarus0070.payservice.models;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class Good {
    private long id;
    private String name;
    private double price;
    private int count;
    private double sum;
}