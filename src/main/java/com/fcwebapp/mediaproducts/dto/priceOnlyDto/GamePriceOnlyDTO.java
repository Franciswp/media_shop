package com.fcwebapp.mediaproducts.dto.priceOnlyDto;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

@Data
@RequiredArgsConstructor
public class GamePriceOnlyDTO {
    @NotEmpty(message = "Price must not be empty")
    @Digits(integer = 6, fraction = 2)
    private BigDecimal price;
}
