package com.lifelink.app.activities;

/**
 * Handles both "Register Donor" (new) and "Edit Donor" flows. When launched with
 * [Constants.EXTRA_DONOR_ID] it pre-fills the form from the existing donor and
 * updates instead of inserting on save.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\r\u001a\u00020\u000eH\u0002J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\b\u0010\u0012\u001a\u00020\u000eH\u0002J\u0012\u0010\u0013\u001a\u00020\u000e2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0014J\b\u0010\u0016\u001a\u00020\u000eH\u0002J\b\u0010\u0017\u001a\u00020\u000eH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0018"}, d2 = {"Lcom/lifelink/app/activities/RegisterDonorActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "binding", "Lcom/lifelink/app/databinding/ActivityRegisterDonorBinding;", "editingDonor", "Lcom/lifelink/app/entities/Donor;", "viewModel", "Lcom/lifelink/app/viewmodels/RegisterDonorViewModel;", "getViewModel", "()Lcom/lifelink/app/viewmodels/RegisterDonorViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "attemptSave", "", "loadDonorForEdit", "donorId", "", "observeViewModel", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "setupDatePicker", "setupSpinners", "app_debug"})
public final class RegisterDonorActivity extends androidx.appcompat.app.AppCompatActivity {
    private com.lifelink.app.databinding.ActivityRegisterDonorBinding binding;
    @org.jetbrains.annotations.Nullable()
    private com.lifelink.app.entities.Donor editingDonor;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy viewModel$delegate = null;
    
    public RegisterDonorActivity() {
        super();
    }
    
    private final com.lifelink.app.viewmodels.RegisterDonorViewModel getViewModel() {
        return null;
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void setupSpinners() {
    }
    
    private final void setupDatePicker() {
    }
    
    private final void loadDonorForEdit(int donorId) {
    }
    
    private final void attemptSave() {
    }
    
    private final void observeViewModel() {
    }
}