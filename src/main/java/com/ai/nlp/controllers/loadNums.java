package com.ai.nlp.controllers;

import com.ai.nlp.names.phoneNums;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by
 * @author Derrick on 14-Oct-18.
 */

@RestController
public class loadNums {
    @GetMapping("/nums")
    public void showNums(){
        phoneNums.phoneNumbers();
    }
}
