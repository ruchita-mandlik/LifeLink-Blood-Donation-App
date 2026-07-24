package com.lifelink.app.activities;

/**
 * Search tab: combined search across free-text query, blood group chips, and city —
 * all filters compose together against Room via [SearchDonorViewModel].
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\r\u001a\u00020\u000eH\u0002J\u0012\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0014J\b\u0010\u0012\u001a\u00020\u000eH\u0002J\b\u0010\u0013\u001a\u00020\u000eH\u0002J\b\u0010\u0014\u001a\u00020\u000eH\u0002J\b\u0010\u0015\u001a\u00020\u000eH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0016"}, d2 = {"Lcom/lifelink/app/activities/SearchDonorActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "adapter", "Lcom/lifelink/app/adapters/DonorAdapter;", "binding", "Lcom/lifelink/app/databinding/ActivitySearchDonorBinding;", "viewModel", "Lcom/lifelink/app/viewmodels/SearchDonorViewModel;", "getViewModel", "()Lcom/lifelink/app/viewmodels/SearchDonorViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "observeViewModel", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "setupBloodGroupChips", "setupCityFilter", "setupRecyclerView", "setupSearchView", "app_debug"})
public final class SearchDonorActivity extends androidx.appcompat.app.AppCompatActivity {
    private com.lifelink.app.databinding.ActivitySearchDonorBinding binding;
    private com.lifelink.app.adapters.DonorAdapter adapter;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy viewModel$delegate = null;
    
    public SearchDonorActivity() {
        super();
    }
    
    private final com.lifelink.app.viewmodels.SearchDonorViewModel getViewModel() {
        return null;
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void setupRecyclerView() {
    }
    
    private final void setupBloodGroupChips() {
    }
    
    private final void setupSearchView() {
    }
    
    private final void setupCityFilter() {
    }
    
    private final void observeViewModel() {
    }
}