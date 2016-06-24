package by.it.academy.adorop.dao;

import by.it.academy.adorop.entities.Address;

public class AddressDAO extends BasicDAO<Address> {

    private static AddressDAO INSTANCE = new AddressDAO();

    private AddressDAO() {
    }

    public static AddressDAO getInstance() {
        return INSTANCE;
    }
}
