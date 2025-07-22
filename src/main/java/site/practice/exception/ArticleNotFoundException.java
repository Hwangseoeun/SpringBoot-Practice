package site.practice.exception;

public class ArticleNotFoundException extends ArticleException {

    public ArticleNotFoundException(final String message) {
        super(message);
    }
}
