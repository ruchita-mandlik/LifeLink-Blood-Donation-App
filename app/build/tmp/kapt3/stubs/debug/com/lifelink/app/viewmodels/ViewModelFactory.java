package com.lifelink.app.viewmodels;

/**
 * Single generic factory for every ViewModel in the app. Each ViewModel takes only
 * the repositories it needs; unused parameters are simply not read by that ViewModel.
 * This avoids writing a bespoke Factory class per screen.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u00a2\u0006\u0002\u0010\nJ%\u0010\u000b\u001a\u0002H\f\"\b\b\u0000\u0010\f*\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\f0\u000fH\u0016\u00a2\u0006\u0002\u0010\u0010R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2 = {"Lcom/lifelink/app/viewmodels/ViewModelFactory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "userRepository", "Lcom/lifelink/app/repository/UserRepository;", "donorRepository", "Lcom/lifelink/app/repository/DonorRepository;", "bloodRequestRepository", "Lcom/lifelink/app/repository/BloodRequestRepository;", "donationHistoryRepository", "Lcom/lifelink/app/repository/DonationHistoryRepository;", "(Lcom/lifelink/app/repository/UserRepository;Lcom/lifelink/app/repository/DonorRepository;Lcom/lifelink/app/repository/BloodRequestRepository;Lcom/lifelink/app/repository/DonationHistoryRepository;)V", "create", "T", "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "app_debug"})
public final class ViewModelFactory implements androidx.lifecycle.ViewModelProvider.Factory {
    @org.jetbrains.annotations.Nullable()
    private final com.lifelink.app.repository.UserRepository userRepository = null;
    @org.jetbrains.annotations.Nullable()
    private final com.lifelink.app.repository.DonorRepository donorRepository = null;
    @org.jetbrains.annotations.Nullable()
    private final com.lifelink.app.repository.BloodRequestRepository bloodRequestRepository = null;
    @org.jetbrains.annotations.Nullable()
    private final com.lifelink.app.repository.DonationHistoryRepository donationHistoryRepository = null;
    
    public ViewModelFactory(@org.jetbrains.annotations.Nullable()
    com.lifelink.app.repository.UserRepository userRepository, @org.jetbrains.annotations.Nullable()
    com.lifelink.app.repository.DonorRepository donorRepository, @org.jetbrains.annotations.Nullable()
    com.lifelink.app.repository.BloodRequestRepository bloodRequestRepository, @org.jetbrains.annotations.Nullable()
    com.lifelink.app.repository.DonationHistoryRepository donationHistoryRepository) {
        super();
    }
    
    @java.lang.Override()
    @kotlin.Suppress(names = {"UNCHECKED_CAST"})
    @org.jetbrains.annotations.NotNull()
    public <T extends androidx.lifecycle.ViewModel>T create(@org.jetbrains.annotations.NotNull()
    java.lang.Class<T> modelClass) {
        return null;
    }
    
    public ViewModelFactory() {
        super();
    }
}