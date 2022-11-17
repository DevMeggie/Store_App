package org.Store_App.model;

import java.util.*;

public class Store {
    private final String name = "Margreth Stores";
    private String address;
    private final String foundedDate = "2022/09/23";

    private List<Product> productList = new ArrayList<>();
    private List<Object> staffList = new ArrayList<>();

    private List<Customer> customerList = new ArrayList<>();
    private List<Applicant> applicantList = new ArrayList<>();

    private PriorityQueue<Customer> queueList = new PriorityQueue<>(new CustomerComparator());
    private Queue<Customer> fifoList= new LinkedList<>();

    public Store(String address, List<Product> productList, List<Object> staffList, List<Customer> customerList,
                 List<Applicant> applicantList, PriorityQueue<Customer> queueList, Queue<Customer> fifoList) {
        this.address = address;
        this.productList = productList;
        this.staffList = staffList;
        this.customerList = customerList;
        this.applicantList = applicantList;
        this.queueList = queueList;
        this.fifoList = fifoList;
    }

    public Store() {

    }

    public String getName() {

        return name;
    }

    public String getAddress() {

        return address;
    }

    public void setAddress(String address) {

        this.address = address;
    }

    public String getFoundedDate() {

        return foundedDate;
    }

    public List<Product> getProductList() {

        return productList;
    }

    public void setProductList(List<Product> productList) {

        this.productList = productList;
    }

    public List<Object> getStaffList() {

        return staffList;
    }

    public void setStaffList(List<Object> staffList) {

        this.staffList = staffList;
    }

    public List<Customer> getCustomerList() {

        return customerList;
    }

    public void setCustomerList(List<Customer> customerList) {

        this.customerList = customerList;
    }

    public List<Applicant> getApplicantList() {

        return applicantList;
    }

    public void setApplicantList(List<Applicant> applicantList) {
        this.applicantList = applicantList;
    }

    public PriorityQueue<Customer> getQueueList() {
        return queueList;
    }

    public void setQueueList(PriorityQueue<Customer> queueList) {
        this.queueList = queueList;
    }

    public Queue<Customer> getFifoList() {
        return fifoList;
    }

    public void setFifoList(Queue<Customer> fifoList) {
        this.fifoList = fifoList;
    }
}


