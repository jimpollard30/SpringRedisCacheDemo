package com.example;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class SlowService {

    public String fetchData(long key) {
        // Simulate slow data retrieval
        try {
            Thread.sleep(2200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        DemoDomainObject ddo = new DemoDomainObject();
        ddo.setKey(key);  
        ddo.setMsg("Data for key" + key);
        ddo.setTimestamp(new SimpleDateFormat("yyyyMMdd_HH:mm:ss").format(Calendar.getInstance().getTime()));
        
        ObjectMapper om = new ObjectMapper();
        try {
			String jsonString = om.writeValueAsString(ddo);
			return jsonString;
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "mapper exception";
		}
        
        
    }
}

