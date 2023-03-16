package org.example;
import com.example.grpc.GreetingServiceGrpc;
import com.example.grpc.GrretingService;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class Client {

    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder.forTarget("localhost:8080")
                .usePlaintext().build();
        GreetingServiceGrpc.GreetingServiceBlockingStub stub =
                GreetingServiceGrpc.newBlockingStub(channel);
        GrretingService.HelloRequest request = GrretingService.HelloRequest.newBuilder()
                .setName("Ilona A").build();
        //удаленный вызов процедуры greeting() на сервере
        GrretingService.HelloResponse response =  stub.greeting(request);
        System.out.println(response);
        channel.shutdownNow();
    }

}
