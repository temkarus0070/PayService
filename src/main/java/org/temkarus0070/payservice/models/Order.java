package org.temkarus0070.payservice.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Order {
    private String clientFIO;
    private long orderNum;
    private Collection<Good> goods;
    private Status status;
}
