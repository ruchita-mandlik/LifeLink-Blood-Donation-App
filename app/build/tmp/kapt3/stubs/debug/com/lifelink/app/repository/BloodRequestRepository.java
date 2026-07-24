package com.lifelink.app.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J$\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u000e\u001a\u00020\bH\u0086@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u000f\u0010\u0010J$\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\f2\u0006\u0010\u000e\u001a\u00020\bH\u0086@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u0013\u0010\u0010J$\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00120\f2\u0006\u0010\u000e\u001a\u00020\bH\u0086@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u0015\u0010\u0010R\u001d\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b!\n\u0005\b\u00a1\u001e0\u0001\u00a8\u0006\u0016"}, d2 = {"Lcom/lifelink/app/repository/BloodRequestRepository;", "", "bloodRequestDao", "Lcom/lifelink/app/dao/BloodRequestDao;", "(Lcom/lifelink/app/dao/BloodRequestDao;)V", "allRequests", "Landroidx/lifecycle/LiveData;", "", "Lcom/lifelink/app/entities/BloodRequest;", "getAllRequests", "()Landroidx/lifecycle/LiveData;", "addRequest", "Lkotlin/Result;", "", "request", "addRequest-gIAlu-s", "(Lcom/lifelink/app/entities/BloodRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteRequest", "", "deleteRequest-gIAlu-s", "updateRequest", "updateRequest-gIAlu-s", "app_debug"})
public final class BloodRequestRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.lifelink.app.dao.BloodRequestDao bloodRequestDao = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.util.List<com.lifelink.app.entities.BloodRequest>> allRequests = null;
    
    public BloodRequestRepository(@org.jetbrains.annotations.NotNull()
    com.lifelink.app.dao.BloodRequestDao bloodRequestDao) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.lifelink.app.entities.BloodRequest>> getAllRequests() {
        return null;
    }
}