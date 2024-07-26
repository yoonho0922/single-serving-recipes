package com.yoon.netstlevel.common.response;

public record ErrorResponse(
        String message,
        String errorCode,
        int statusCode
) {
}
