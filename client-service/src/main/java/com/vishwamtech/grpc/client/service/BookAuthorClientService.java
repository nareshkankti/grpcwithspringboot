package com.vishwamtech.grpc.client.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.google.protobuf.Descriptors.FieldDescriptor;
import com.vishwamtech.Author;
import com.vishwamtech.BookAuthorServiceGrpc.BookAuthorServiceBlockingStub;

import net.devh.boot.grpc.client.inject.GrpcClient;

@Service
public class BookAuthorClientService {
	
	@GrpcClient(value = "grpc-devproblems-service")
	BookAuthorServiceBlockingStub synchronousClient;
	
	public Map<FieldDescriptor, Object> getAuthor(int authorId) {
		Author authorRequest = Author.newBuilder().setAuthorId(authorId).build();
		Author authorResponse = synchronousClient.getAuthor(authorRequest);
		return authorResponse.getAllFields();		
	}

}
