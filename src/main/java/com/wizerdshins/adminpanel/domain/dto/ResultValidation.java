package com.wizerdshins.adminpanel.domain.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.springframework.validation.FieldError;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResultValidation {

    private Boolean success;
    List<FieldError> errors;
    private String reason;

    public ResultValidation(Boolean success) {
        this.success = success;
    }

    public ResultValidation(Boolean success,
                            List<FieldError> errors) {
        this.success = success;
        this.errors = errors;
    }

    public ResultValidation(Boolean success, String reason) {
        this.success = success;
        this.reason = reason;
    }
}
