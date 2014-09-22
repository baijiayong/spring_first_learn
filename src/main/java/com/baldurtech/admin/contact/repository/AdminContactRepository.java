package com.baldurtech.admin.contact.repository;

import com.baldurtech.contact.core.domain.Contact;

import java.util.List;

public interface AdminContactRepository {
    public List<Contact> findAllContacts();
}