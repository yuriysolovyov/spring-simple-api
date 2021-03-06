package de.solovyov.demo.service;

import de.solovyov.demo.dao.PersonDao;
import de.solovyov.demo.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PersonService {

    private final PersonDao personDao;

    @Autowired
    public PersonService(@Qualifier("postgres") PersonDao personDao) {
        this.personDao = personDao;
    }

    public boolean addPerson(Person person) {
        return personDao.insertPerson(person);
    }

    public List<Person> getAllPeople() {
        return this.personDao.selectAllPeople();
    }

    public Optional<Person> getPersonById(UUID id) { return this.personDao.selectPersonById(id); }

    public boolean deletePerson(UUID id) {
        return this.personDao.deletePersonById(id);
    }

    public boolean updatePerson(UUID id, Person person) {
        return this.personDao.updatePersonById(id, person);
    }
}
