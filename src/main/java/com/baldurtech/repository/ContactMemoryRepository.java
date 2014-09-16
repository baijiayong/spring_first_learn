package com.baldurtech.repository;

import java.util.List;
import java.util.ArrayList;

import com.baldurtech.core.Contact;

public class ContactMemoryRepository implements ContactRepository {
 
    @Override
    public List<Contact> findAllContact() {
        return new ArrayList<Contact>();
    }
}