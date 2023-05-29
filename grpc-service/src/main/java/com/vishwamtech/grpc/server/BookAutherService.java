package com.vishwamtech.grpc.server;

import com.vishwamtech.Author;
import com.vishwamtech.TempDB;
import com.vishwamtech.BookAuthorServiceGrpc.BookAuthorServiceImplBase;

import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class BookAutherService extends BookAuthorServiceImplBase {
	
	@Override	
	public void getAuthor(Author request, StreamObserver<Author> responseObserver) {
		TempDB.getAuthorsFromTempDb()
		.stream()
		.filter(author -> author.getAuthorId() == request.getAuthorId())
		.findFirst()
		.ifPresent(responseObserver::onNext);
		//responseObserver.onError(new Throwable());
		responseObserver.onCompleted();
	}

}
