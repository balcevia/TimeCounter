package com.balcewicz.timecounter.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AuthRequest {
    @NotEmpty
    private String username;
    @NotEmpty
    private String password;
}
