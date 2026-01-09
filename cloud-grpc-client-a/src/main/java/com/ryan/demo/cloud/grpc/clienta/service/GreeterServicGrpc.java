package com.ryan.demo.cloud.grpc.clienta.service;

/**
 * @ClassName GreeterClient
 * @Description TODO
 * @Author ryan
 * @Date 2026/1/9 09:16
 * @Version 1.0
 **/
import com.ryan.demo.cloud.grpc.GreeterServiceGrpc;
import com.ryan.demo.cloud.grpc.HelloReply;
import com.ryan.demo.cloud.grpc.HelloRequest;
import io.grpc.ManagedChannel;
import org.springframework.stereotype.Service;

@Service
public class GreeterServicGrpc {

    private final GrpcChannelFactory factory;

    public GreeterServicGrpc(GrpcChannelFactory factory) {
        this.factory = factory;
    }

    public String sayHello(String name) throws Exception {
        ManagedChannel channel =
                factory.getChannel("cloud-grpc-server-a");
        GreeterServiceGrpc.GreeterServiceBlockingStub stub =
                GreeterServiceGrpc.newBlockingStub(channel);

        HelloReply reply = stub.sayHello(
                HelloRequest.newBuilder()
                        .setName(name)
                        .build()
        );

        return reply.getMessage();
    }
}

