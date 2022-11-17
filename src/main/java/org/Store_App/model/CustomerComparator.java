package org.Store_App.model;

import java.util.Comparator;

public class CustomerComparator implements Comparator<Customer> {

    @Override
    public int compare(Customer o1, Customer o2) {
//        if (o1.getCart().get(0).getQty() < o2.getCart().get(0).getQty()) {
    //        return 1;
   //     }
  //      return -1;
 return o1.getCart().get(0).getQty() < o2.getCart().get(0).getQty() ? 1 : -1;
    }
}
