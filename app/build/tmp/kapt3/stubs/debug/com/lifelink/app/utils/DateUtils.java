package com.lifelink.app.utils;

/**
 * Small wrapper around [DatePickerDialog] that formats the chosen date as dd/MM/yyyy
 * and writes it straight into the target EditText — used by Register Donor, Donation
 * History and Blood Request screens.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0006J \u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000eR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lcom/lifelink/app/utils/DateUtils;", "", "()V", "formatter", "Ljava/text/SimpleDateFormat;", "getCurrentDate", "", "showDatePicker", "", "context", "Landroid/content/Context;", "target", "Landroid/widget/EditText;", "allowFutureDates", "", "app_debug"})
public final class DateUtils {
    @org.jetbrains.annotations.NotNull()
    private static final java.text.SimpleDateFormat formatter = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.lifelink.app.utils.DateUtils INSTANCE = null;
    
    private DateUtils() {
        super();
    }
    
    public final void showDatePicker(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    android.widget.EditText target, boolean allowFutureDates) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCurrentDate() {
        return null;
    }
}