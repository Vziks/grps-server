package info.vziks;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;


public class App {
    public static void main(String[] args) throws IOException, InterruptedException {
        Server server = ServerBuilder.forPort(8080).addService(new HelloServiceImpl()).build();
        server.start();
        System.out.println("Start gRPC server");
        server.awaitTermination();
    }
}
