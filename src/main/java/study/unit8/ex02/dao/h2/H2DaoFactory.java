package study.unit8.ex02.dao.h2;

import study.unit8.ex02.connections.ConnectionPool;
import study.unit8.ex02.dao.AuthorDao;
import study.unit8.ex02.dao.BookDao;
import study.unit8.ex02.dao.DaoFactory;
import study.unit8.ex02.dao.UserDao;

class H2DaoFactory implements DaoFactory {

    private final ConnectionPool connectionPool;

    public H2DaoFactory(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }

    public BookDao getBookDao() {
        return new H2BookDao(connectionPool);
    }

    public UserDao getUserDao() {
        return new H2UserDao(connectionPool);
    }

    public AuthorDao getAuthorDao() {
        return new H2AuthorDao(connectionPool);
    }
}
