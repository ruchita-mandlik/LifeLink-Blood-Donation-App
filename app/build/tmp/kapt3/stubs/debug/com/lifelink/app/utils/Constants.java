package com.lifelink.app.utils;

/**
 * App-wide constant values: static lists and Intent extra keys.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\t\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u0019\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\n\n\u0002\u0010\b\u001a\u0004\b\f\u0010\u0007R\u000e\u0010\r\u001a\u00020\u000eX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0086T\u00a2\u0006\u0002\n\u0000R\u0019\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0011\u0010\u0007\u00a8\u0006\u0012"}, d2 = {"Lcom/lifelink/app/utils/Constants;", "", "()V", "BLOOD_GROUPS", "", "", "getBLOOD_GROUPS", "()[Ljava/lang/String;", "[Ljava/lang/String;", "DATE_FORMAT", "EXTRA_DONOR_ID", "GENDERS", "getGENDERS", "MAX_DONOR_AGE", "", "MIN_DONOR_AGE", "URGENCY_LEVELS", "getURGENCY_LEVELS", "app_debug"})
public final class Constants {
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String[] BLOOD_GROUPS = {"A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-"};
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String[] GENDERS = {"Male", "Female", "Other"};
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String[] URGENCY_LEVELS = {"Low", "Medium", "High", "Critical"};
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String EXTRA_DONOR_ID = "extra_donor_id";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String DATE_FORMAT = "dd/MM/yyyy";
    public static final int MIN_DONOR_AGE = 18;
    public static final int MAX_DONOR_AGE = 65;
    @org.jetbrains.annotations.NotNull()
    public static final com.lifelink.app.utils.Constants INSTANCE = null;
    
    private Constants() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String[] getBLOOD_GROUPS() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String[] getGENDERS() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String[] getURGENCY_LEVELS() {
        return null;
    }
}