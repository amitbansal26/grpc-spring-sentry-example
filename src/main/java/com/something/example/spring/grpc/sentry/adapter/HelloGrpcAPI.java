package com.something.example.spring.grpc.sentry.adapter;

import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;
import org.something.example.spring.grpc.sentry.HelloGrpc;
import org.something.example.spring.grpc.sentry.HiRequest;
import org.something.example.spring.grpc.sentry.HiResponse;
import org.springframework.util.StringUtils;

@GRpcService
public class HelloGrpcAPI extends HelloGrpc.HelloImplBase {

    @Override
    public void hi(HiRequest request, StreamObserver<HiResponse> responseObserver) {
        if (StringUtils.isEmpty(request.getPhrase())) {
            throw new IllegalArgumentException("I can't hear you!");
        }
        responseObserver.onNext(
                HiResponse.newBuilder()
                .setPhrase(
                        String.format("Yep, I heard your '%s'", request.getPhrase())
                ).build()
        );
        responseObserver.onCompleted();
    }
}
