package edu.org.ShopperStack1.util;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ResponseStructure<T> {
    private int statusCode;
    private String message;
    private T data;

}
