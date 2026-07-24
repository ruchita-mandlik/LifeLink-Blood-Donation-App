package com.lifelink.app.dao;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u0014\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bH\'J\u001c\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t0\b2\u0006\u0010\f\u001a\u00020\rH\'J\u001c\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b2\u0006\u0010\u000f\u001a\u00020\rH\'J\u0016\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006\u00a8\u0006\u0012"}, d2 = {"Lcom/lifelink/app/dao/DonationHistoryDao;", "", "deleteHistory", "", "history", "Lcom/lifelink/app/entities/DonationHistory;", "(Lcom/lifelink/app/entities/DonationHistory;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllHistoryWithDonor", "Landroidx/lifecycle/LiveData;", "", "Lcom/lifelink/app/models/DonationHistoryUi;", "getHistoryForDonor", "donorId", "", "getRecentHistoryWithDonor", "limit", "insertHistory", "", "app_debug"})
@androidx.room.Dao()
public abstract interface DonationHistoryDao {
    
    @androidx.room.Insert()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertHistory(@org.jetbrains.annotations.NotNull()
    com.lifelink.app.entities.DonationHistory history, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion);
    
    @androidx.room.Delete()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteHistory(@org.jetbrains.annotations.NotNull()
    com.lifelink.app.entities.DonationHistory history, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM donation_history WHERE donorId = :donorId ORDER BY id DESC")
    @org.jetbrains.annotations.NotNull()
    public abstract androidx.lifecycle.LiveData<java.util.List<com.lifelink.app.entities.DonationHistory>> getHistoryForDonor(int donorId);
    
    /**
     * Joined query producing readable rows (donor name + blood group) for the history screen.
     */
    @androidx.room.Query(value = "\n        SELECT dh.id as historyId, dh.donorId as donorId, d.name as donorName,\n               d.bloodGroup as bloodGroup, dh.donationDate as donationDate,\n               dh.hospital as hospital, dh.remarks as remarks\n        FROM donation_history dh\n        INNER JOIN donors d ON dh.donorId = d.id\n        ORDER BY dh.id DESC\n        ")
    @org.jetbrains.annotations.NotNull()
    public abstract androidx.lifecycle.LiveData<java.util.List<com.lifelink.app.models.DonationHistoryUi>> getAllHistoryWithDonor();
    
    @androidx.room.Query(value = "\n        SELECT dh.id as historyId, dh.donorId as donorId, d.name as donorName,\n               d.bloodGroup as bloodGroup, dh.donationDate as donationDate,\n               dh.hospital as hospital, dh.remarks as remarks\n        FROM donation_history dh\n        INNER JOIN donors d ON dh.donorId = d.id\n        ORDER BY dh.id DESC LIMIT :limit\n        ")
    @org.jetbrains.annotations.NotNull()
    public abstract androidx.lifecycle.LiveData<java.util.List<com.lifelink.app.models.DonationHistoryUi>> getRecentHistoryWithDonor(int limit);
}