package com.musalaSoft.musalaSoft.entity;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@Data
@Builder
@EqualsAndHashCode
public class ErrorDetail {

    private String message;

    private String details;

    private LocalDate date;

    public ErrorDetail(String message, String details, LocalDate date){
        super();
        this.message=message;
        this.details=details;
        this.date=date;
    }

}