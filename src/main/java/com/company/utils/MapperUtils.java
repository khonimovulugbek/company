package com.company.utils;

import org.modelmapper.ModelMapper;

/**
 * Author: Khonimov Ulugbek
 * Date: 19.04.2023  15:11
 */
public class MapperUtils {
    private static final ModelMapper mapper = new ModelMapper();

    public static <R, T> R map(T source, Class<R> destinationType) {
        try {

            return mapper.map(source, destinationType);
        } catch (Exception e) {
            return null;
        }

    }
}
