package com.apiunifametro.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record GameRecordDto(@NotBlank String name, @NotNull BigDecimal value) {
}
