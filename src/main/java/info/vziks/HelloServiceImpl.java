package info.vziks;

import info.vziks.grpc.AppServiceGrpc;
import info.vziks.grpc.AppServiceOuterClass;
import io.grpc.stub.StreamObserver;

/**
 * Class HelloServiceImpl
 * Project grpcdemo
 *
 * @author Anton Prokhorov <vziks@live.ru>
 */
public class HelloServiceImpl extends AppServiceGrpc.AppServiceImplBase {

    @Override
    public void hello(AppServiceOuterClass.AppRequest request, StreamObserver<AppServiceOuterClass.AppResponse> responseObserver) {


        for (int i = 0; i < 1000; i++) {

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(request);
            AppServiceOuterClass.AppResponse response = AppServiceOuterClass.AppResponse
                    .newBuilder()
                    .setHello("Hello server " + request.getName() + " Arr" + request.getArrList())
                    .build();
            responseObserver.onNext(response);
        }

        responseObserver.onCompleted();
    }
}
