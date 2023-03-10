package com.gamemania.exceptions;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StandardError {

    @JsonFormat(pattern = "YYYY-MM-dd : HH:mm:ss")
    protected LocalDateTime timestamp;
    protected Integer status;
    protected String error;
    protected String message;
    protected String path;
}
