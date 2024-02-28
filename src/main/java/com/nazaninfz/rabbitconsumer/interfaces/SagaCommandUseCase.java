package com.nazaninfz.rabbitconsumer.interfaces;

import com.nazaninfz.messagingsharedmodel.models.request.RequestObject;
import com.nazaninfz.messagingsharedmodel.models.response.ResponseObject;

public abstract class SagaCommandUseCase<I, O> extends UseCase<I, O> {
    public abstract I deserializeInput(RequestObject requestObject);
}
