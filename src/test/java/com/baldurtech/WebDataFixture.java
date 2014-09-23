package com.baldurtech;

import com.baldurtech.contact.core.domain.Contact;
import com.baldurtech.contact.events.AllContactsListEvent;
import com.baldurtech.contact.events.RequestAllContactItemsEvent;
import com.baldurtech.contact.events.ContactDetailsEvent;
import com.baldurtech.contact.events.RequestContactDetailsEvent;
import com.baldurtech.department.events.AllDepartmentItemsEvent;
import com.baldurtech.department.events.RequestAllDepartmentItemsEvent;
import com.baldurtech.department.events.RequestDepartmentDetailsEvent;
import com.baldurtech.department.events.DepartmentDetailsEvent;
import com.baldurtech.department.core.domain.Department;

import java.util.List;
import java.util.ArrayList;

public class WebDataFixture {
    public static AllContactsListEvent allContactList() {
        Contact contact1 = new Contact();
        contact1.setName("Xiao Bai");
        contact1.setMobile("18234444444");
        contact1.setEmail("xiaobai@gmail.com");
        contact1.setVpmn("62222");
        
        Contact contact2 = new Contact();
        contact2.setName("Shi Hang");
        contact2.setMobile("18766666666");
        contact2.setEmail("shihang@gmail.com");
        contact2.setVpmn("63333");
        
        List<Contact> contacts = new ArrayList<Contact>();
        contacts.add(contact1);
        contacts.add(contact2);
        
        return new AllContactsListEvent(contacts);
    }
    
      public static AllDepartmentItemsEvent allDepartmentsList() {
        Department department1 = new Department();
        department1.setName("Technology");
        department1.setAddress("BeiZhang");
        department1.setParent("Baldurtech");
        department1.setMemo("memo");
        
        Department department2 = new Department();
        department2.setName("Human Resource");
        department2.setAddress("BeiZhang");
        department2.setParent("Baldurtech");
        department2.setMemo("memo");
        
        List<Department> departments = new ArrayList<Department>();
        departments.add(department1);
        departments.add(department2);
        
        return new AllDepartmentItemsEvent(departments);
    }
    
     public static DepartmentDetailsEvent departmentDetails(Department department) {
        department.setName("Human Resource");
        department.setAddress("BeiZhang");
        department.setParent("Baldurtech");
        department.setMemo("memo");
       
        return new DepartmentDetailsEvent(department);
    }
    
    public static Department createDepartment() {
        Department department = new Department();
        
        department.setName("Human Resource");
        department.setAddress("BeiZhang");
        department.setParent("Baldurtech");
        department.setMemo("memo");
        
        return department;
    }
    
    public static ContactDetailsEvent contactDetails(Contact contact) {
        contact.setName("Xiaobai");
        contact.setMobile("18234444444");
        contact.setVpmn("64444");
        contact.setEmail("xiaobai@gmail.com");
       
        return new ContactDetailsEvent(contact);
    }
    
    public static Contact createContact() {
        Contact contact = new Contact();
        contact.setName("Xiaobai");
        contact.setMobile("18233333333");
        contact.setVpmn("63333");
        contact.setEmail("xiaobai@gmail.com");
        contact.setHomeAddress("Taiyuan");
        contact.setOfficeAddress("BeiZhang");
        contact.setJob("HR");
        contact.setJobLevel(9L);
        
        return contact;
    }
}