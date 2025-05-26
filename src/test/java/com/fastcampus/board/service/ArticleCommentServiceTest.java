package com.fastcampus.board.service;

import com.fastcampus.board.domain.Article;
import com.fastcampus.board.dto.ArticleCommentDto;
import com.fastcampus.board.repository.ArticleCommentRepository;
import com.fastcampus.board.repository.ArticleRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;


@DisplayName("비즈니스 로직 - 댓글")
@ExtendWith(MockitoExtension.class)
public class ArticleCommentServiceTest {

    @InjectMocks
    private ArticleCommentService articleCommentService;
    @Mock
    private ArticleCommentRepository articleCommentRepository;
    @Mock
    private ArticleRepository articleRepository;

    @DisplayName("게시글 ID로 조회하면, 해당하는 댓글 리스트를 반환한다.")
    @Test
    void searchArticleComments() {
        // given
        given(articleRepository.findById(1L)).willReturn(Optional.of(Article.of("title", "content", "#java")));

        // when
        List<ArticleCommentDto> articleComments = articleCommentService.searchArticleComment(1L);

        // then
        assertThat(articleComments).isNotNull();
        then(articleRepository).should().findById(1L);
    }

}
