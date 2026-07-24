package com.lifelink.app.utils;

/**
 * Single source of truth for session enforcement and logout.
 *
 * ROOT CAUSE this fixes: SplashActivity only checks [SessionManager.isLoggedIn] once,
 * on cold start. If Android later recreates a previously-visible screen (e.g.
 * DashboardActivity) straight from a saved back stack — after the OS kills the app
 * process in the background and the user reopens it from Recents, or after any
 * back-stack edge case — that recreation skips Splash entirely and its login check
 * never runs. Without a check inside the recreated screen itself, a logged-out user
 * (or a stale/old account) could still see authenticated screens.
 *
 * Every Activity that requires a logged-in user must call [requireLogin] as the very
 * first line of onCreate(), before touching ViewBinding or any session-dependent data.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006\u00a8\u0006\t"}, d2 = {"Lcom/lifelink/app/utils/SessionGuard;", "", "()V", "logout", "", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "requireLogin", "", "app_debug"})
public final class SessionGuard {
    @org.jetbrains.annotations.NotNull()
    public static final com.lifelink.app.utils.SessionGuard INSTANCE = null;
    
    private SessionGuard() {
        super();
    }
    
    /**
     * @return true if there is a valid session and the caller should continue its
     * normal setup. If there is no session, the user is redirected to [LoginActivity]
     * with the back stack cleared and this Activity is finished — the caller must
     * `return` immediately in that case without doing any further work.
     */
    public final boolean requireLogin(@org.jetbrains.annotations.NotNull()
    androidx.appcompat.app.AppCompatActivity activity) {
        return false;
    }
    
    /**
     * Clears the session and resets the entire back stack so LoginActivity becomes the
     * new task root — no previous (Dashboard/Search/History/Profile/etc.) screen can be
     * reached via the back button afterwards, and reopening the app cannot resurrect
     * the old account.
     */
    public final void logout(@org.jetbrains.annotations.NotNull()
    androidx.appcompat.app.AppCompatActivity activity) {
    }
}