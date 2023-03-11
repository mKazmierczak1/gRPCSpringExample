package org.example.gRPCSpringClient.client;

import io.grpc.ManagedChannelBuilder;
import org.example.model.GRPCRequest;
import org.example.model.GRPCServiceGrpc;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Client implements CommandLineRunner {

  private static final String ADDRESS = "localhost";
  private static final int PORT = 6565;

  @Override
  public void run(String... args) {
    var channel = ManagedChannelBuilder.forAddress(ADDRESS, PORT).usePlaintext().build();
    var stub = GRPCServiceGrpc.newBlockingStub(channel);
    var request = GRPCRequest.newBuilder().setName("name").setAge(21).build();
    var response = stub.gRPCProcedure(request);

    System.out.println(response);
    channel.shutdown();
  }
}
