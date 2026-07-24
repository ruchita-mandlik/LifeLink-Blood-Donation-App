package com.lifelink.app.repository;

/**
 * Single source of truth for donor CRUD + search operations.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J$\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u0010\u0014\u001a\u00020\bH\u0086@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u0015\u0010\u0016J$\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u00122\u0006\u0010\u0014\u001a\u00020\bH\u0086@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u0019\u0010\u0016J\u0016\u0010\u001a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00062\u0006\u0010\u001b\u001a\u00020\u000fJ\u0018\u0010\u001c\u001a\u0004\u0018\u00010\b2\u0006\u0010\u001b\u001a\u00020\u000fH\u0086@\u00a2\u0006\u0002\u0010\u001dJ*\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020 J$\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00180\u00122\u0006\u0010\u0014\u001a\u00020\bH\u0086@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b$\u0010\u0016R\u001d\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001d\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\n\u0082\u0002\u000b\n\u0002\b!\n\u0005\b\u00a1\u001e0\u0001\u00a8\u0006%"}, d2 = {"Lcom/lifelink/app/repository/DonorRepository;", "", "donorDao", "Lcom/lifelink/app/dao/DonorDao;", "(Lcom/lifelink/app/dao/DonorDao;)V", "allDonors", "Landroidx/lifecycle/LiveData;", "", "Lcom/lifelink/app/entities/Donor;", "getAllDonors", "()Landroidx/lifecycle/LiveData;", "bloodGroupStats", "Lcom/lifelink/app/models/BloodGroupStat;", "getBloodGroupStats", "totalDonorCount", "", "getTotalDonorCount", "addDonor", "Lkotlin/Result;", "", "donor", "addDonor-gIAlu-s", "(Lcom/lifelink/app/entities/Donor;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteDonor", "", "deleteDonor-gIAlu-s", "getDonorById", "id", "getDonorByIdSync", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "searchDonors", "bloodGroup", "", "city", "query", "updateDonor", "updateDonor-gIAlu-s", "app_debug"})
public final class DonorRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.lifelink.app.dao.DonorDao donorDao = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.util.List<com.lifelink.app.entities.Donor>> allDonors = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.lang.Integer> totalDonorCount = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.util.List<com.lifelink.app.models.BloodGroupStat>> bloodGroupStats = null;
    
    public DonorRepository(@org.jetbrains.annotations.NotNull()
    com.lifelink.app.dao.DonorDao donorDao) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.lifelink.app.entities.Donor>> getAllDonors() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.Integer> getTotalDonorCount() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.lifelink.app.models.BloodGroupStat>> getBloodGroupStats() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.lifelink.app.entities.Donor> getDonorById(int id) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getDonorByIdSync(int id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.lifelink.app.entities.Donor> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.lifelink.app.entities.Donor>> searchDonors(@org.jetbrains.annotations.NotNull()
    java.lang.String bloodGroup, @org.jetbrains.annotations.NotNull()
    java.lang.String city, @org.jetbrains.annotations.NotNull()
    java.lang.String query) {
        return null;
    }
}