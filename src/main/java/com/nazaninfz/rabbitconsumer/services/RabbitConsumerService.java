package com.nazaninfz.rabbitconsumer.services;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nazaninfz.messagingsharedmodel.models.ResponseTestModel;
import com.nazaninfz.messagingsharedmodel.models.TestModel;
import com.nazaninfz.messagingsharedmodel.models.request.RequestObject;
import com.nazaninfz.messagingsharedmodel.models.response.ResponseObject;
import com.nazaninfz.rabbitconsumer.interfaces.ConsumerReceiveMethod;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class RabbitConsumerService {

    private final ConsumerReceiveMethod method;

    @RabbitListener(
            queues = {"queueTest2"}
//            concurrency = "${rabbitmq.concurrency.execution-queue}"
    )
    public ResponseObject receiveAndReply(RequestObject requestObject) {

        try {
//            long timeout = requestObject.getTimeout();
//
//            long sendDateMillis = requestObject.getRequestSendDate().toInstant().toEpochMilli();
//            long currentDateMillis = new Date().toInstant().toEpochMilli();
//
//            long millisBetween = currentDateMillis - sendDateMillis;

//            if (millisBetween > timeout) return createTimeoutResponse();
            return method.receiveAndReply(requestObject);
        } catch (Exception e) {
            log.error("exception in execution topic consumer", e);
            return null;
        }

    }
}
