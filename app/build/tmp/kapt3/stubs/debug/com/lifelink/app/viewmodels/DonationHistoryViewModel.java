package com.lifelink.app.viewmodels;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u001d\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u000b"}, d2 = {"Lcom/lifelink/app/viewmodels/DonationHistoryViewModel;", "Landroidx/lifecycle/ViewModel;", "donationHistoryRepository", "Lcom/lifelink/app/repository/DonationHistoryRepository;", "(Lcom/lifelink/app/repository/DonationHistoryRepository;)V", "allHistory", "Landroidx/lifecycle/LiveData;", "", "Lcom/lifelink/app/models/DonationHistoryUi;", "getAllHistory", "()Landroidx/lifecycle/LiveData;", "app_debug"})
public final class DonationHistoryViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.util.List<com.lifelink.app.models.DonationHistoryUi>> allHistory = null;
    
    public DonationHistoryViewModel(@org.jetbrains.annotations.NotNull()
    com.lifelink.app.repository.DonationHistoryRepository donationHistoryRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.lifelink.app.models.DonationHistoryUi>> getAllHistory() {
        return null;
    }
}