package com.lifelink.app.utils;

/**
 * Lightweight, reusable "loading" progress dialog shown during Room DB operations
 * that might take a moment (registration, search, saving records). Built
 * programmatically to avoid needing an extra layout file.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u0007\u001a\u00020\bJ\u0010\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2 = {"Lcom/lifelink/app/utils/LoadingDialog;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "dialog", "Landroid/app/Dialog;", "dismiss", "", "show", "message", "", "app_debug"})
public final class LoadingDialog {
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    @org.jetbrains.annotations.Nullable()
    private android.app.Dialog dialog;
    
    public LoadingDialog(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    public final void show(@org.jetbrains.annotations.NotNull()
    java.lang.String message) {
    }
    
    public final void dismiss() {
    }
}