package edu.org.ShopperStack1.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CartNotFoundException extends RuntimeException{
    private String message;
}
