package info.vziks;

import info.vziks.grpc.AppRequest;
import info.vziks.grpc.AppResponse;
import info.vziks.grpc.AppServiceGrpc;
import io.grpc.stub.StreamObserver;

/**
 * Class HelloServiceImpl
 * Project grpcdemo
 *
 * @author Anton Prokhorov <vziks@live.ru>
 */
public class HelloServiceImpl extends AppServiceGrpc.AppServiceImplBase {

    @Override
    public void hello(AppRequest request, StreamObserver<AppResponse> responseObserver) {


        for (int i = 0; i < 100; i++) {

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(request);
            AppResponse response = AppResponse
                    .newBuilder()
                    .setHello(i + " Hello server " + request.getName() + " Arr" + request.getArrList())
                    .build();
            responseObserver.onNext(response);
        }

        responseObserver.onCompleted();
    }
}
