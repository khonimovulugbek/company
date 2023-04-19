package com.company.payload;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Author: Khonimov Ulugbek
 * Date: 19.04.2023  15:08
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
public record ApiResponse(

        boolean success,
        String message,
        int code,
        Object data

) {

}
