package by.it.academy.adorop.controller.commands;

import by.it.academy.adorop.controller.commands.exceptions.NoSuchEntityException;
import by.it.academy.adorop.controller.utils.FromConsoleBuilder;
import by.it.academy.adorop.controller.utils.InputReader;
import by.it.academy.adorop.dao.AddressDAO;
import by.it.academy.adorop.dao.DAO;
import by.it.academy.adorop.dao.PersonDAO;
import by.it.academy.adorop.dao.exceptions.DaoException;
import by.it.academy.adorop.entities.Address;
import by.it.academy.adorop.entities.Person;
import org.hibernate.NonUniqueObjectException;

public class AddAddressCommand extends Command {

    private DAO<Person> personDAO = PersonDAO.getInstance();
    private DAO<Address> addressDAO = AddressDAO.getInstance();
    @Override
    public void execute() {
        print("Insert person id - ");
        try {
            Person person = getEntity(personDAO, InputReader.readInteger());
            Address addressFromConsole = FromConsoleBuilder.buildObject(Address.class);
            if (person.getAddress() != null) {
                addressFromConsole.setId(person.getAddress().getId());
                addressDAO.update(addressFromConsole);
            }
            else {
                person.setAddress(addressFromConsole);
                personDAO.update(person);
            }
            System.out.println(person);

        } catch (NumberFormatException e) {
            System.out.println("Should be a number");
            execute();
        } catch (DaoException e) {
            logger.error(e);
        } catch (NoSuchEntityException e) {
            catchNoSuchEntityException();
        }
    }
}
