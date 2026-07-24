package com.lifelink.app.viewmodels;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u000e\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\rJ\u001a\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u00190\u000f2\u0006\u0010\u001b\u001a\u00020\u0015J\u0016\u0010\u001c\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u000f2\u0006\u0010\u001b\u001a\u00020\u0015J.\u0010\u001d\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u001f2\u0006\u0010\u0017\u001a\u00020\rR\u001a\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001d\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\""}, d2 = {"Lcom/lifelink/app/viewmodels/DonorDetailsViewModel;", "Landroidx/lifecycle/ViewModel;", "donorRepository", "Lcom/lifelink/app/repository/DonorRepository;", "donationHistoryRepository", "Lcom/lifelink/app/repository/DonationHistoryRepository;", "(Lcom/lifelink/app/repository/DonorRepository;Lcom/lifelink/app/repository/DonationHistoryRepository;)V", "_addHistoryResult", "Landroidx/lifecycle/MutableLiveData;", "Lkotlin/Result;", "", "_deleteResult", "_donor", "Lcom/lifelink/app/entities/Donor;", "addHistoryResult", "Landroidx/lifecycle/LiveData;", "getAddHistoryResult", "()Landroidx/lifecycle/LiveData;", "deleteResult", "getDeleteResult", "donorId", "", "deleteDonor", "donor", "historyForDonor", "", "Lcom/lifelink/app/entities/DonationHistory;", "id", "loadDonor", "markDonationComplete", "hospital", "", "date", "remarks", "app_debug"})
public final class DonorDetailsViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.lifelink.app.repository.DonorRepository donorRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final com.lifelink.app.repository.DonationHistoryRepository donationHistoryRepository = null;
    private int donorId = 0;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<com.lifelink.app.entities.Donor> _donor = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<kotlin.Result<kotlin.Unit>> _deleteResult = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<kotlin.Result<kotlin.Unit>> deleteResult = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<kotlin.Result<kotlin.Unit>> _addHistoryResult = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<kotlin.Result<kotlin.Unit>> addHistoryResult = null;
    
    public DonorDetailsViewModel(@org.jetbrains.annotations.NotNull()
    com.lifelink.app.repository.DonorRepository donorRepository, @org.jetbrains.annotations.NotNull()
    com.lifelink.app.repository.DonationHistoryRepository donationHistoryRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<kotlin.Result<kotlin.Unit>> getDeleteResult() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<kotlin.Result<kotlin.Unit>> getAddHistoryResult() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.lifelink.app.entities.Donor> loadDonor(int id) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.lifelink.app.entities.DonationHistory>> historyForDonor(int id) {
        return null;
    }
    
    public final void deleteDonor(@org.jetbrains.annotations.NotNull()
    com.lifelink.app.entities.Donor donor) {
    }
    
    public final void markDonationComplete(int donorId, @org.jetbrains.annotations.NotNull()
    java.lang.String hospital, @org.jetbrains.annotations.NotNull()
    java.lang.String date, @org.jetbrains.annotations.NotNull()
    java.lang.String remarks, @org.jetbrains.annotations.NotNull()
    com.lifelink.app.entities.Donor donor) {
    }
}