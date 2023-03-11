package org.example.gRPCSpringServer.server.endpoints;

import io.grpc.stub.StreamObserver;
import org.example.model.GRPCRequest;
import org.example.model.GRPCResponse;
import org.springframework.stereotype.Component;

@Component
public class GRPCProcedureEndpointImpl implements GRPCProcedureEndpoint {

  @Override
  public void gRPCProcedure(GRPCRequest req, StreamObserver<GRPCResponse> responseObserver) {
    System.out.println("...called GrpcProcedure");
    String msg;

    if (req.getAge() > 18) {
      msg = "Mr/Ms " + req.getName();
    } else {
      msg = "Boy/Girl";
    }

    GRPCResponse response = GRPCResponse.newBuilder().setMessage("Hello " + msg).build();
    responseObserver.onNext(response);
    responseObserver.onCompleted();
  }
}
