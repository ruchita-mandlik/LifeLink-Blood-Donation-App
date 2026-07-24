package com.lifelink.app;

/**
 * Application-wide singleton holder for the database and repositories.
 * Keeping repository instantiation here avoids re-creating them (and their DAOs)
 * in every Activity / ViewModelFactory.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\"\u001a\u00020#H\u0016R\u001b\u0010\u0003\u001a\u00020\u00048FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\t\u001a\u00020\n8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\r\u0010\b\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u000e\u001a\u00020\u000f8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0012\u0010\b\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0013\u001a\u00020\u00148FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0017\u0010\b\u001a\u0004\b\u0015\u0010\u0016R\u001e\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u0019@BX\u0086.\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u001b\u0010\u001d\u001a\u00020\u001e8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b!\u0010\b\u001a\u0004\b\u001f\u0010 \u00a8\u0006$"}, d2 = {"Lcom/lifelink/app/LifeLinkApp;", "Landroid/app/Application;", "()V", "bloodRequestRepository", "Lcom/lifelink/app/repository/BloodRequestRepository;", "getBloodRequestRepository", "()Lcom/lifelink/app/repository/BloodRequestRepository;", "bloodRequestRepository$delegate", "Lkotlin/Lazy;", "database", "Lcom/lifelink/app/database/AppDatabase;", "getDatabase", "()Lcom/lifelink/app/database/AppDatabase;", "database$delegate", "donationHistoryRepository", "Lcom/lifelink/app/repository/DonationHistoryRepository;", "getDonationHistoryRepository", "()Lcom/lifelink/app/repository/DonationHistoryRepository;", "donationHistoryRepository$delegate", "donorRepository", "Lcom/lifelink/app/repository/DonorRepository;", "getDonorRepository", "()Lcom/lifelink/app/repository/DonorRepository;", "donorRepository$delegate", "<set-?>", "Lcom/lifelink/app/preferences/SessionManager;", "sessionManager", "getSessionManager", "()Lcom/lifelink/app/preferences/SessionManager;", "userRepository", "Lcom/lifelink/app/repository/UserRepository;", "getUserRepository", "()Lcom/lifelink/app/repository/UserRepository;", "userRepository$delegate", "onCreate", "", "app_debug"})
public final class LifeLinkApp extends android.app.Application {
    private com.lifelink.app.preferences.SessionManager sessionManager;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy database$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy userRepository$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy donorRepository$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy bloodRequestRepository$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy donationHistoryRepository$delegate = null;
    
    public LifeLinkApp() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.lifelink.app.preferences.SessionManager getSessionManager() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.lifelink.app.database.AppDatabase getDatabase() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.lifelink.app.repository.UserRepository getUserRepository() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.lifelink.app.repository.DonorRepository getDonorRepository() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.lifelink.app.repository.BloodRequestRepository getBloodRequestRepository() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.lifelink.app.repository.DonationHistoryRepository getDonationHistoryRepository() {
        return null;
    }
    
    @java.lang.Override()
    public void onCreate() {
    }
}