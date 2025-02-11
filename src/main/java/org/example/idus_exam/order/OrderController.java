package org.example.idus_exam.order;


import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor

public class OrderController {


    @RequestMapping("/list")
    public void login(){




    }
    @RequestMapping("/{orderidx}")
    public void aa(){

    }






}
