package com.fastcampus.board.service;

import com.fastcampus.board.domain.Article;
import com.fastcampus.board.domain.type.SearchType;
import com.fastcampus.board.dto.ArticleDto;
import com.fastcampus.board.dto.ArticleUpdateDto;
import com.fastcampus.board.repository.ArticleRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.*;

@DisplayName("비즈니스 로직 - 게시글")
@ExtendWith(MockitoExtension.class)
class ArticleServiceTest {

    @InjectMocks
    private ArticleService articleService;
    @Mock
    private ArticleRepository articleRepository;

    @DisplayName("게시글을 검색하면, 게시글 리스트를 반환한다.")
    @Test
    void searchArticles() {
        // given

        // when
        Page<ArticleDto> articles = articleService.searchArticles(SearchType.TITLE, "search keyword");

        // then
        assertThat(articles).isNotNull();
    }

    @DisplayName("게시글을 조회하면, 게시글을 반환한다.")
    @Test
    void searchArticle() {
        // given

        // when
        ArticleDto article = articleService.searchArticle(1L);

        // then
        assertThat(article).isNull();
    }

    @DisplayName("게시글 정보를 입력하면, 게시글을 생성한다.")
    @Test
    void saveArticle() {
        // given
        given(articleRepository.save(any(Article.class))).willReturn(null);

        // when
        articleService.saveArticle(ArticleDto.of(LocalDateTime.now(), "Uno", "title", "content", "#java"));

        // then
        then(articleRepository).should().save(any(Article.class));
    }

    @DisplayName("게시글 정보를 입력하면, 게시글을 수정한다.")
    @Test
    void updateArticle() {
        // given
        given(articleRepository.save(any(Article.class))).willReturn(null);

        // when
        articleService.updateArticle(1L, ArticleUpdateDto.of("title", "content", "#java"));

        // then
        then(articleRepository).should().save(any(Article.class));
    }

    @DisplayName("게시글 ID를 입력하면, 게시글을 삭제한다.")
    @Test
    void deleteArticle() {
        // given
        willDoNothing().given(articleRepository).delete(any(Article.class));

        // when
        articleService.deleteArticle(1L);

        // then
        then(articleRepository).should().delete(any(Article.class));
    }

}
