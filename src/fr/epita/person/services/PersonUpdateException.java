package fr.epita.person.services;

public class PersonUpdateException extends Throwable {
    public PersonUpdateException(Exception e) {
        super(e);
    }
}