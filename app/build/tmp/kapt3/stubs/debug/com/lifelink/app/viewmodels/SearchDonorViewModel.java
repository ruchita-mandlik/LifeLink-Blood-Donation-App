package com.lifelink.app.viewmodels;

/**
 * Drives Search Donor screen: combined search by blood group, city and free-text query
 * (name or phone). Filters are held in LiveData so changing any one of them automatically
 * re-runs the Room query via switchMap.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0007J\u000e\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0007J\u000e\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u0007R\u001c\u0010\u0005\u001a\u0010\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00070\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\u0010\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00070\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R&\u0010\n\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\f0\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\r\u001a\u0010\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00070\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006\u001b"}, d2 = {"Lcom/lifelink/app/viewmodels/SearchDonorViewModel;", "Landroidx/lifecycle/ViewModel;", "donorRepository", "Lcom/lifelink/app/repository/DonorRepository;", "(Lcom/lifelink/app/repository/DonorRepository;)V", "bloodGroupFilter", "Landroidx/lifecycle/MutableLiveData;", "", "kotlin.jvm.PlatformType", "cityFilter", "filters", "Landroidx/lifecycle/MediatorLiveData;", "Lkotlin/Triple;", "queryFilter", "searchResults", "Landroidx/lifecycle/LiveData;", "", "Lcom/lifelink/app/entities/Donor;", "getSearchResults", "()Landroidx/lifecycle/LiveData;", "setBloodGroupFilter", "", "bloodGroup", "setCityFilter", "city", "setQueryFilter", "query", "app_debug"})
public final class SearchDonorViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.lifelink.app.repository.DonorRepository donorRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.lang.String> bloodGroupFilter = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.lang.String> cityFilter = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.lang.String> queryFilter = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MediatorLiveData<kotlin.Triple<java.lang.String, java.lang.String, java.lang.String>> filters = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.util.List<com.lifelink.app.entities.Donor>> searchResults = null;
    
    public SearchDonorViewModel(@org.jetbrains.annotations.NotNull()
    com.lifelink.app.repository.DonorRepository donorRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.lifelink.app.entities.Donor>> getSearchResults() {
        return null;
    }
    
    public final void setBloodGroupFilter(@org.jetbrains.annotations.NotNull()
    java.lang.String bloodGroup) {
    }
    
    public final void setCityFilter(@org.jetbrains.annotations.NotNull()
    java.lang.String city) {
    }
    
    public final void setQueryFilter(@org.jetbrains.annotations.NotNull()
    java.lang.String query) {
    }
}