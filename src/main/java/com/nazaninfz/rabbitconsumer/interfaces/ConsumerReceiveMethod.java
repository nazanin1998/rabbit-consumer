package com.nazaninfz.rabbitconsumer.interfaces;

import com.nazaninfz.messagingsharedmodel.models.request.RequestObject;
import com.nazaninfz.messagingsharedmodel.models.response.ResponseObject;

public interface ConsumerReceiveMethod {
    ResponseObject receiveAndReply(RequestObject requestObject);
}
