package com.baldurtech.repository;

import java.util.List;

import com.baldurtech.core.Contact;

public interface ContactRepository {
    public List<Contact> findAllContact();
    public Contact getById(Long id);
}