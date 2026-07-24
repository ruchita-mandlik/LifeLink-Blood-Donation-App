package com.lifelink.app.utils;

/**
 * The app uses 4 top-level Activities (Dashboard/Search/History/Profile) that each host
 * their own BottomNavigationView, rather than a single Activity with Fragments — matching
 * the "Intent Navigation" requirement. This helper wires tab selection consistently so
 * behavior/animations stay identical across all four screens.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u000bB\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n\u00a8\u0006\f"}, d2 = {"Lcom/lifelink/app/utils/NavigationHelper;", "", "()V", "setup", "", "activity", "Landroid/app/Activity;", "bottomNav", "Lcom/google/android/material/bottomnavigation/BottomNavigationView;", "current", "Lcom/lifelink/app/utils/NavigationHelper$Tab;", "Tab", "app_debug"})
public final class NavigationHelper {
    @org.jetbrains.annotations.NotNull()
    public static final com.lifelink.app.utils.NavigationHelper INSTANCE = null;
    
    private NavigationHelper() {
        super();
    }
    
    public final void setup(@org.jetbrains.annotations.NotNull()
    android.app.Activity activity, @org.jetbrains.annotations.NotNull()
    com.google.android.material.bottomnavigation.BottomNavigationView bottomNav, @org.jetbrains.annotations.NotNull()
    com.lifelink.app.utils.NavigationHelper.Tab current) {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/lifelink/app/utils/NavigationHelper$Tab;", "", "(Ljava/lang/String;I)V", "HOME", "SEARCH", "HISTORY", "PROFILE", "app_debug"})
    public static enum Tab {
        /*public static final*/ HOME /* = new HOME() */,
        /*public static final*/ SEARCH /* = new SEARCH() */,
        /*public static final*/ HISTORY /* = new HISTORY() */,
        /*public static final*/ PROFILE /* = new PROFILE() */;
        
        Tab() {
        }
        
        @org.jetbrains.annotations.NotNull()
        public static kotlin.enums.EnumEntries<com.lifelink.app.utils.NavigationHelper.Tab> getEntries() {
            return null;
        }
    }
}