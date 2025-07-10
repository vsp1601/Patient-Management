package com.pm.billingservice.grpc;

import billing.BillingResponse;
import billing.BillingServiceGrpc;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@GrpcService
public class BillingGrpcService extends BillingServiceGrpc.BillingServiceImplBase {
    private static final Logger log = LoggerFactory.getLogger(BillingGrpcService.class);

    @Override
    public void createBillingAccount (billing.BillingRequest billingRequest, StreamObserver<billing.BillingResponse> responseObserver) {
        log.info("createBillingAccount request received {}", billingRequest.toString());

        // Business logics here Ex. to save to Database, Perform Calculations

        BillingResponse response = BillingResponse.newBuilder()
                .setAccountID("12345")
                .setStatus("Active")
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
