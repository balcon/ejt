package study.unit8.ex02.dao;

public interface DaoFactory {
    BookDao getBookDao();

    UserDao getUserDao();

    AuthorDao getAuthorDao();
}
