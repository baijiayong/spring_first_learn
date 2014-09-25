package com.baldurtech.admin.contact.repository;

import com.baldurtech.contact.core.domain.Contact;

import java.util.List;

public interface AdminContactRepository {
    public List<Contact> findAllContacts();
    public Contact getById(Contact contact);
    public Contact create(Contact contact);
    public Contact delete(Contact contact);
    public Contact update(Contact updateContact, Contact contact);
}