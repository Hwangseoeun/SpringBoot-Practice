package site.practice.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import site.practice.common.response.SuccessCode;

@Getter
@RequiredArgsConstructor
public enum ArticleSuccessCode implements SuccessCode {

    CREATE_ARTICLE("게시글을 생성하였습니다."),
    GET_ARTICLE("게시글을 조회하였습니다."),
    GET_ARTICLES("전체 게시글을 조회하였습니다."),
    UPDATE_ARTICLE("게시글을 수정하였습니다."),
    DELETE_ARTICLE("게시글을 삭제하였습니다."),
    ;

    private final String message;
}
