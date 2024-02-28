package com.nazaninfz.rabbitconsumer.interfaces;

import ch.qos.logback.core.spi.ContextAwareImpl;
import com.fasterxml.jackson.core.type.TypeReference;
import com.nazaninfz.messagingsharedmodel.models.ResponseTestModel;
import com.nazaninfz.messagingsharedmodel.models.request.RequestObject;
import com.nazaninfz.messagingsharedmodel.models.response.ResponseException;
import com.nazaninfz.messagingsharedmodel.models.response.ResponseObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ConsumerReceiveMethodImpl implements ConsumerReceiveMethod, ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Override
    public ResponseObject receiveAndReply(RequestObject requestObject) {
        log.info("requestObject: {}", requestObject);

        SagaCommandUseCase useCase = applicationContext.getBean(requestObject.getUseCase(), SagaCommandUseCase.class);
        Object input = useCase.deserializeInput(requestObject);
        ResponseObject responseObject = new ResponseObject().setConsumerName("");
        try {
            Object output = useCase.execute(input);
            return responseObject.setResponseBody(output);
        } catch (Exception e) {
            return responseObject.setResponseException(new ResponseException());
        }

    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
