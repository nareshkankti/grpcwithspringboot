package com.vishwamtech.grpc.client.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.google.protobuf.Descriptors.FieldDescriptor;
import com.vishwamtech.grpc.client.service.BookAuthorClientService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class BookAuthorController {
	
	@Autowired
	private BookAuthorClientService bookAuthorClientService;

    @GetMapping("/author/{id}")
    public Map<FieldDescriptor, Object> getAuthor(@PathVariable String id) {
        return bookAuthorClientService.getAuthor(Integer.parseInt(id));
    }

}
