package org.example.gRPCSpringServer.server;

import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;
import org.example.gRPCSpringServer.server.endpoints.GRPCProcedureEndpoint;
import org.example.model.GRPCRequest;
import org.example.model.GRPCResponse;
import org.example.model.GRPCServiceGrpc;
import org.lognet.springboot.grpc.GRpcService;

@GRpcService
@RequiredArgsConstructor
public class GRPCServiceImpl extends GRPCServiceGrpc.GRPCServiceImplBase {

  private final GRPCProcedureEndpoint grpcProcedureEndpoint;

  @Override
  public void gRPCProcedure(GRPCRequest req, StreamObserver<GRPCResponse> responseObserver) {
    grpcProcedureEndpoint.gRPCProcedure(req, responseObserver);
  }
}
