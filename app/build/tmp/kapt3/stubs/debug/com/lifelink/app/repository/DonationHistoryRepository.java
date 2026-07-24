package com.lifelink.app.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J$\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0086@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u0010\u0010\u0011J$\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0086@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u0014\u0010\u0011J\u001a\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u00070\u00062\u0006\u0010\u0016\u001a\u00020\u0017J\u001c\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\b\b\u0002\u0010\u0019\u001a\u00020\u0017R\u001d\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b!\n\u0005\b\u00a1\u001e0\u0001\u00a8\u0006\u001a"}, d2 = {"Lcom/lifelink/app/repository/DonationHistoryRepository;", "", "donationHistoryDao", "Lcom/lifelink/app/dao/DonationHistoryDao;", "(Lcom/lifelink/app/dao/DonationHistoryDao;)V", "allHistory", "Landroidx/lifecycle/LiveData;", "", "Lcom/lifelink/app/models/DonationHistoryUi;", "getAllHistory", "()Landroidx/lifecycle/LiveData;", "addHistory", "Lkotlin/Result;", "", "history", "Lcom/lifelink/app/entities/DonationHistory;", "addHistory-gIAlu-s", "(Lcom/lifelink/app/entities/DonationHistory;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteHistory", "", "deleteHistory-gIAlu-s", "getHistoryForDonor", "donorId", "", "getRecentHistory", "limit", "app_debug"})
public final class DonationHistoryRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.lifelink.app.dao.DonationHistoryDao donationHistoryDao = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.util.List<com.lifelink.app.models.DonationHistoryUi>> allHistory = null;
    
    public DonationHistoryRepository(@org.jetbrains.annotations.NotNull()
    com.lifelink.app.dao.DonationHistoryDao donationHistoryDao) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.lifelink.app.models.DonationHistoryUi>> getAllHistory() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.lifelink.app.models.DonationHistoryUi>> getRecentHistory(int limit) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.lifelink.app.entities.DonationHistory>> getHistoryForDonor(int donorId) {
        return null;
    }
}