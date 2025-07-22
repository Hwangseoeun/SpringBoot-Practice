package site.practice.docs.article;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.restdocs.payload.JsonFieldType;
import site.practice.controller.ArticleController;
import site.practice.docs.RestDocsSupport;
import site.practice.dto.CreateArticleRequestDto;
import site.practice.service.ArticleService;

import static org.mockito.Mockito.mock;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.post;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class ArticleControllerDocsTest extends RestDocsSupport {

    private final ArticleService articleService = mock(ArticleService.class);

    @Override
    protected Object initController() {
        return new ArticleController(articleService);
    }

    @DisplayName("게시글 생성 API")
    @Test
    void createArticle() throws Exception {
        CreateArticleRequestDto request = new CreateArticleRequestDto(
            "그로밋의 이름은?",
            "정답 : 그로밋",
            "그로밋"
        );

        mockMvc.perform(
                post("/api/article")
                    .contentType(MediaType.APPLICATION_JSON_VALUE)
                    .content(convertToJson(request))
            )
            .andDo(print())
            .andExpect(status().isOk())
            .andDo(createDocument(
                requestFields(
                    fieldWithPath("title").type(JsonFieldType.STRING)
                        .description("게시글 제목"),
                    fieldWithPath("content").type(JsonFieldType.STRING)
                        .optional()
                        .description("게시글 내용"),
                    fieldWithPath("writerName").type(JsonFieldType.STRING)
                        .description("작성자 이름")
                ),
                responseFields(
                    fieldWithPath("message")
                        .description("응답 메시지")
                        .type(JsonFieldType.STRING))));
    }
}
