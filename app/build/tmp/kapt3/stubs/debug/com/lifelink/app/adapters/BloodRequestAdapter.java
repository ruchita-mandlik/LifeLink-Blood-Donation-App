package com.lifelink.app.adapters;

/**
 * Lists all emergency blood requests (pending first, most recent on top).
 * Lets the user mark a request as fulfilled or remove it entirely.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u0011\u0012B-\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\u0002\u0010\bJ\u0018\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\fH\u0016R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2 = {"Lcom/lifelink/app/adapters/BloodRequestAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/lifelink/app/entities/BloodRequest;", "Lcom/lifelink/app/adapters/BloodRequestAdapter$RequestViewHolder;", "onMarkCompleted", "Lkotlin/Function1;", "", "onDelete", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "onBindViewHolder", "holder", "position", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "DiffCallback", "RequestViewHolder", "app_debug"})
public final class BloodRequestAdapter extends androidx.recyclerview.widget.ListAdapter<com.lifelink.app.entities.BloodRequest, com.lifelink.app.adapters.BloodRequestAdapter.RequestViewHolder> {
    @org.jetbrains.annotations.NotNull()
    private final kotlin.jvm.functions.Function1<com.lifelink.app.entities.BloodRequest, kotlin.Unit> onMarkCompleted = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.jvm.functions.Function1<com.lifelink.app.entities.BloodRequest, kotlin.Unit> onDelete = null;
    
    public BloodRequestAdapter(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.lifelink.app.entities.BloodRequest, kotlin.Unit> onMarkCompleted, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.lifelink.app.entities.BloodRequest, kotlin.Unit> onDelete) {
        super(null);
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public com.lifelink.app.adapters.BloodRequestAdapter.RequestViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.lifelink.app.adapters.BloodRequestAdapter.RequestViewHolder holder, int position) {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u00c2\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"Lcom/lifelink/app/adapters/BloodRequestAdapter$DiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/lifelink/app/entities/BloodRequest;", "()V", "areContentsTheSame", "", "oldItem", "newItem", "areItemsTheSame", "app_debug"})
    static final class DiffCallback extends androidx.recyclerview.widget.DiffUtil.ItemCallback<com.lifelink.app.entities.BloodRequest> {
        @org.jetbrains.annotations.NotNull()
        public static final com.lifelink.app.adapters.BloodRequestAdapter.DiffCallback INSTANCE = null;
        
        private DiffCallback() {
            super();
        }
        
        @java.lang.Override()
        public boolean areItemsTheSame(@org.jetbrains.annotations.NotNull()
        com.lifelink.app.entities.BloodRequest oldItem, @org.jetbrains.annotations.NotNull()
        com.lifelink.app.entities.BloodRequest newItem) {
            return false;
        }
        
        @java.lang.Override()
        public boolean areContentsTheSame(@org.jetbrains.annotations.NotNull()
        com.lifelink.app.entities.BloodRequest oldItem, @org.jetbrains.annotations.NotNull()
        com.lifelink.app.entities.BloodRequest newItem) {
            return false;
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J6\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00060\n2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00060\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2 = {"Lcom/lifelink/app/adapters/BloodRequestAdapter$RequestViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/lifelink/app/databinding/ItemBloodRequestBinding;", "(Lcom/lifelink/app/databinding/ItemBloodRequestBinding;)V", "bind", "", "item", "Lcom/lifelink/app/entities/BloodRequest;", "onMarkCompleted", "Lkotlin/Function1;", "onDelete", "app_debug"})
    public static final class RequestViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private final com.lifelink.app.databinding.ItemBloodRequestBinding binding = null;
        
        public RequestViewHolder(@org.jetbrains.annotations.NotNull()
        com.lifelink.app.databinding.ItemBloodRequestBinding binding) {
            super(null);
        }
        
        public final void bind(@org.jetbrains.annotations.NotNull()
        com.lifelink.app.entities.BloodRequest item, @org.jetbrains.annotations.NotNull()
        kotlin.jvm.functions.Function1<? super com.lifelink.app.entities.BloodRequest, kotlin.Unit> onMarkCompleted, @org.jetbrains.annotations.NotNull()
        kotlin.jvm.functions.Function1<? super com.lifelink.app.entities.BloodRequest, kotlin.Unit> onDelete) {
        }
    }
}