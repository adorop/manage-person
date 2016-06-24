package by.it.academy.adorop.dao;

import by.it.academy.adorop.dao.exceptions.DaoException;
import by.it.academy.adorop.entities.Person;

public class PersonDAO extends BasicDAO<Person> {

    private static PersonDAO INSTANCE = new PersonDAO();

    private PersonDAO() {}

    public static PersonDAO getInstance() {
        return INSTANCE;
    }

    public void update(Integer id, String firstName) throws DaoException {
        try {
            transaction = session.beginTransaction();
            Person person = session.get(Person.class, id);
            person.setFirstName(firstName);
            transaction.commit();
        } catch (Exception e) {
            logger.error(e);
            transaction.rollback();
            throw new DaoException();
        }
    }

}
