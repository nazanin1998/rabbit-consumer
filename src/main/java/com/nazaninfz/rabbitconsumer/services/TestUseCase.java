package com.nazaninfz.rabbitconsumer.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nazaninfz.messagingsharedmodel.models.ResponseTestModel;
import com.nazaninfz.messagingsharedmodel.models.TestModel;
import com.nazaninfz.messagingsharedmodel.models.TestModelInner1;
import com.nazaninfz.messagingsharedmodel.models.TestModelInner2;
import com.nazaninfz.messagingsharedmodel.models.request.RequestObject;
import com.nazaninfz.rabbitconsumer.interfaces.SagaCommandUseCase;
import org.springframework.stereotype.Service;

@Service("TestUseCase")
public class TestUseCase extends SagaCommandUseCase<TestModel<TestModelInner1<TestModelInner2>>, ResponseTestModel> {

    @Override
    public TestModel<TestModelInner1<TestModelInner2>> deserializeInput(RequestObject requestObject) {
        ObjectMapper objectMapper = new ObjectMapper();
        TestModel<TestModelInner1<TestModelInner2>> p = objectMapper.convertValue(requestObject.getRequestBody(),
                new TypeReference<TestModel<TestModelInner1<TestModelInner2>>>() {
        });
        return p;
    }

    @Override
    public ResponseTestModel execute(TestModel<TestModelInner1<TestModelInner2>> input) {
        System.out.println("execute input:" + input);
        return new ResponseTestModel()
                .setAge(13)
                .setStatus("dss")
                .setName("pedrami");
    }
}
