package com.lifelink.app.dao;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u0014\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t0\bH\'J\u0014\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\t0\bH\'J\u0018\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\b2\u0006\u0010\r\u001a\u00020\u000eH\'J\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00052\u0006\u0010\r\u001a\u00020\u000eH\u00a7@\u00a2\u0006\u0002\u0010\u0010J\u000e\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\bH\'J\u0016\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J,\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t0\b2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0016H\'J\u0016\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006\u00a8\u0006\u001a"}, d2 = {"Lcom/lifelink/app/dao/DonorDao;", "", "deleteDonor", "", "donor", "Lcom/lifelink/app/entities/Donor;", "(Lcom/lifelink/app/entities/Donor;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllDonors", "Landroidx/lifecycle/LiveData;", "", "getBloodGroupStats", "Lcom/lifelink/app/models/BloodGroupStat;", "getDonorById", "id", "", "getDonorByIdSync", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getTotalDonorCount", "insertDonor", "", "searchDonors", "bloodGroup", "", "city", "query", "updateDonor", "app_debug"})
@androidx.room.Dao()
public abstract interface DonorDao {
    
    @androidx.room.Insert(onConflict = 3)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertDonor(@org.jetbrains.annotations.NotNull()
    com.lifelink.app.entities.Donor donor, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion);
    
    @androidx.room.Update()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object updateDonor(@org.jetbrains.annotations.NotNull()
    com.lifelink.app.entities.Donor donor, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Delete()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteDonor(@org.jetbrains.annotations.NotNull()
    com.lifelink.app.entities.Donor donor, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM donors ORDER BY name ASC")
    @org.jetbrains.annotations.NotNull()
    public abstract androidx.lifecycle.LiveData<java.util.List<com.lifelink.app.entities.Donor>> getAllDonors();
    
    @androidx.room.Query(value = "SELECT * FROM donors WHERE id = :id LIMIT 1")
    @org.jetbrains.annotations.NotNull()
    public abstract androidx.lifecycle.LiveData<com.lifelink.app.entities.Donor> getDonorById(int id);
    
    @androidx.room.Query(value = "SELECT * FROM donors WHERE id = :id LIMIT 1")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getDonorByIdSync(int id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.lifelink.app.entities.Donor> $completion);
    
    @androidx.room.Query(value = "SELECT COUNT(*) FROM donors")
    @org.jetbrains.annotations.NotNull()
    public abstract androidx.lifecycle.LiveData<java.lang.Integer> getTotalDonorCount();
    
    /**
     * Combined search across blood group and city. Empty parameters ("") match all rows
     * because the LIKE pattern becomes '%' when the field is blank.
     */
    @androidx.room.Query(value = "\n        SELECT * FROM donors\n        WHERE (:bloodGroup = \'\' OR bloodGroup = :bloodGroup)\n        AND (:city = \'\' OR city LIKE \'%\' || :city || \'%\')\n        AND (:query = \'\' OR name LIKE \'%\' || :query || \'%\' OR phone LIKE \'%\' || :query || \'%\')\n        ORDER BY name ASC\n        ")
    @org.jetbrains.annotations.NotNull()
    public abstract androidx.lifecycle.LiveData<java.util.List<com.lifelink.app.entities.Donor>> searchDonors(@org.jetbrains.annotations.NotNull()
    java.lang.String bloodGroup, @org.jetbrains.annotations.NotNull()
    java.lang.String city, @org.jetbrains.annotations.NotNull()
    java.lang.String query);
    
    @androidx.room.Query(value = "SELECT bloodGroup, COUNT(*) as donorCount FROM donors GROUP BY bloodGroup")
    @org.jetbrains.annotations.NotNull()
    public abstract androidx.lifecycle.LiveData<java.util.List<com.lifelink.app.models.BloodGroupStat>> getBloodGroupStats();
}