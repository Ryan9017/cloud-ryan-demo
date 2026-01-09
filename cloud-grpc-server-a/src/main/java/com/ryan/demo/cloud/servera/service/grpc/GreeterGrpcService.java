package com.ryan.demo.cloud.servera.service.grpc;

/**
 * @ClassName GreeterGrpcService
 * @Description TODO
 * @Author ryan
 * @Date 2026/1/9 09:02
 * @Version 1.0
 **/
import com.ryan.demo.cloud.grpc.GreeterServiceGrpc;
import com.ryan.demo.cloud.grpc.HelloReply;
import com.ryan.demo.cloud.grpc.HelloRequest;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class GreeterGrpcService
        extends GreeterServiceGrpc.GreeterServiceImplBase {

    @Override
    public void sayHello(
            HelloRequest request,
            StreamObserver<HelloReply> responseObserver) {

        HelloReply reply = HelloReply.newBuilder()
                .setMessage("Hello " + request.getName())
                .build();

        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }
}

