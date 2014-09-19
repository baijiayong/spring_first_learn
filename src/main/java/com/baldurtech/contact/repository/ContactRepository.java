package com.baldurtech.contact.repository;

import java.util.List;

import com.baldurtech.contact.core.domain.Contact;

public interface ContactRepository {
    public List<Contact> findAllContact();
    public List<Contact> getById(Long id);
}