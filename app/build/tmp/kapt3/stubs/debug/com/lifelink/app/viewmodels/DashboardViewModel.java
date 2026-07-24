package com.lifelink.app.viewmodels;

/**
 * Feeds the Dashboard: total donor count, blood group breakdown, and recent donations.
 * All streams are LiveData from Room, so the UI updates automatically as data changes.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006R\u001d\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001d\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\t0\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\f\u00a8\u0006\u0013"}, d2 = {"Lcom/lifelink/app/viewmodels/DashboardViewModel;", "Landroidx/lifecycle/ViewModel;", "donorRepository", "Lcom/lifelink/app/repository/DonorRepository;", "donationHistoryRepository", "Lcom/lifelink/app/repository/DonationHistoryRepository;", "(Lcom/lifelink/app/repository/DonorRepository;Lcom/lifelink/app/repository/DonationHistoryRepository;)V", "bloodGroupStats", "Landroidx/lifecycle/LiveData;", "", "Lcom/lifelink/app/models/BloodGroupStat;", "getBloodGroupStats", "()Landroidx/lifecycle/LiveData;", "recentDonations", "Lcom/lifelink/app/models/DonationHistoryUi;", "getRecentDonations", "totalDonors", "", "getTotalDonors", "app_debug"})
public final class DashboardViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.lang.Integer> totalDonors = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.util.List<com.lifelink.app.models.BloodGroupStat>> bloodGroupStats = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.util.List<com.lifelink.app.models.DonationHistoryUi>> recentDonations = null;
    
    public DashboardViewModel(@org.jetbrains.annotations.NotNull()
    com.lifelink.app.repository.DonorRepository donorRepository, @org.jetbrains.annotations.NotNull()
    com.lifelink.app.repository.DonationHistoryRepository donationHistoryRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.Integer> getTotalDonors() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.lifelink.app.models.BloodGroupStat>> getBloodGroupStats() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.lifelink.app.models.DonationHistoryUi>> getRecentDonations() {
        return null;
    }
}