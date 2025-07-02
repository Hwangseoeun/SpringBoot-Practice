package site.practice.common.exception;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import site.practice.common.response.ErrorCode;

@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
@Getter
public enum CommonErrorCode implements ErrorCode {
    INTERNAL_SERVER_APPLICATION("애플리케이션 레벨 서버 오류가 발생하였습니다."),
    ;

    private final String message;
}
