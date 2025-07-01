package site.practice.common.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;

@Getter
public class ApiResponse<T> {

    private final String message;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final T data;

    public static ApiResponse<Void> success(final SuccessCode code) {
        return new ApiResponse<>(code.getMessage(), null);
    }

    public static <T> ApiResponse<T> successWithData(final SuccessCode code, final T data) {
        return new ApiResponse<>(code.getMessage(), data);
    }

    public static ApiResponse<Void> fail(final ErrorCode errorCode, final String message) {
        return new ApiResponse<>( message, null);
    }

    private ApiResponse(
        final String message,
        final T data
    ) {
        this.message = message;
        this.data = data;
    }
}