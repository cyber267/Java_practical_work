package fr.epita.person.services;

public class PersonExtractionException extends Exception {
    public PersonExtractionException(Exception e) {
        super(e);
    }
}