package com.ecsfin.grpc.service;

import com.ecsfin.grpc.GreetingRequest;
import com.ecsfin.grpc.GreetingResponse;
import com.ecsfin.grpc.GreetingServiceGrpc;

import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class GreetingsServiceImpl extends GreetingServiceGrpc.GreetingServiceImplBase {

	@Override
	public void greeting(GreetingRequest request, StreamObserver<GreetingResponse> responseObserver) {

		String msg = request.getMessage();
		System.out.println("Recived msg : " + msg);

		var respMsg = GreetingResponse.newBuilder()
				.setMessage(String.format("Received msg %s. Hello from server...", msg))
				.build();

		responseObserver.onNext(respMsg);
		responseObserver.onCompleted();

	}

}
