package com.example.demo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UpdateBoardDto {

    @NotNull
    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    private String description;

}
