package org.temkarus0070.payservice.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

public @Data
@NoArgsConstructor
@AllArgsConstructor
class Order {
    private String clientFIO;
    private long orderNum;
    private Collection<Good> goods;
    private Status status;

}
