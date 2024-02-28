package com.nazaninfz.rabbitconsumer.interfaces;

import com.nazaninfz.messagingsharedmodel.models.RollbackObject;

public abstract class SagaCommandRollbackableUseCase<I, O> extends SagaCommandUseCase<I, O> {
    public abstract void rollback(RollbackObject rollbackObject);
}
