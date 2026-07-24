package com.lifelink.app.activities;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\r\u001a\u00020\u000eH\u0002J\b\u0010\u000f\u001a\u00020\u000eH\u0002J\u0010\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0010\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\b\u0010\u0014\u001a\u00020\u000eH\u0002J\u0012\u0010\u0015\u001a\u00020\u000e2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0014J\b\u0010\u0018\u001a\u00020\u000eH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0019"}, d2 = {"Lcom/lifelink/app/activities/BloodRequestActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "binding", "Lcom/lifelink/app/databinding/ActivityBloodRequestBinding;", "requestAdapter", "Lcom/lifelink/app/adapters/BloodRequestAdapter;", "viewModel", "Lcom/lifelink/app/viewmodels/BloodRequestViewModel;", "getViewModel", "()Lcom/lifelink/app/viewmodels/BloodRequestViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "attemptSubmit", "", "clearForm", "confirmDelete", "request", "Lcom/lifelink/app/entities/BloodRequest;", "confirmMarkCompleted", "observeViewModel", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "setupRequestsList", "app_debug"})
public final class BloodRequestActivity extends androidx.appcompat.app.AppCompatActivity {
    private com.lifelink.app.databinding.ActivityBloodRequestBinding binding;
    private com.lifelink.app.adapters.BloodRequestAdapter requestAdapter;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy viewModel$delegate = null;
    
    public BloodRequestActivity() {
        super();
    }
    
    private final com.lifelink.app.viewmodels.BloodRequestViewModel getViewModel() {
        return null;
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void setupRequestsList() {
    }
    
    private final void confirmMarkCompleted(com.lifelink.app.entities.BloodRequest request) {
    }
    
    private final void confirmDelete(com.lifelink.app.entities.BloodRequest request) {
    }
    
    private final void attemptSubmit() {
    }
    
    private final void observeViewModel() {
    }
    
    private final void clearForm() {
    }
}