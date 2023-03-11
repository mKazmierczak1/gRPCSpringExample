package org.example.gRPCSpringServer.server.endpoints;

import io.grpc.stub.StreamObserver;
import org.example.model.GRPCRequest;
import org.example.model.GRPCResponse;

public interface GRPCProcedureEndpoint {
  void gRPCProcedure(GRPCRequest req, StreamObserver<GRPCResponse> responseObserver);
}
