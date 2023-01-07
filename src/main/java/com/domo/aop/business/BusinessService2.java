package com.domo.aop.business;

import java.util.Arrays;

import org.springframework.stereotype.Service;

import com.domo.aop.data.DataService2;

@Service
public class BusinessService2 {

    private DataService2 dataService2;

    public BusinessService2(DataService2 dataService2) {
        this.dataService2 = dataService2;
    }

    public int calculateMin() {
        int[] data = dataService2.retrieveData();

        try {
            Thread.sleep(30);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        // throw new RuntimeException("Something Went Wrong");
        return Arrays.stream(data).min().orElse(0);
    }
}