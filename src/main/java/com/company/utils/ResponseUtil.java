package com.company.utils;

import com.company.payload.ApiResponse;

/**
 * Author: Khonimov Ulugbek
 * Date: 19.04.2023  15:18
 */
public class ResponseUtil {
    public static ApiResponse success(Object data) {
        return new ApiResponse(true, null, 200, data);
    }

    public static ApiResponse success(Object data, String message) {
        return new ApiResponse(true, message, 200, data);
    }

    public static ApiResponse error(String message, int code) {
        return new ApiResponse(false, message, code, null);
    }
}
