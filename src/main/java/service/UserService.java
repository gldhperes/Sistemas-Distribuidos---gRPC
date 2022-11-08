package service;

import generated.APIResponse;
import generated.message;
import generated.userGrpc;
import io.grpc.stub.StreamObserver;

public class UserService extends userGrpc.userImplBase{
    @Override
    public void echo(message request, StreamObserver<APIResponse> responseObserver) {
        String msg = request.getMessage();

        APIResponse.Builder response = APIResponse.newBuilder();

        response.setResponseCode(200).setResponseMessage(msg);

        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }

    @Override
    public void reverte(message request, StreamObserver<APIResponse> responseObserver) {
        String msg = request.getMessage();
        APIResponse.Builder response = APIResponse.newBuilder();

        response.setResponseCode(200).setResponseMessage( new StringBuilder(msg).reverse().toString() );

        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }
}
