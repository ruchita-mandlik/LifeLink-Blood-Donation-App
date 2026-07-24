# Add project specific ProGuard rules here.
# Keep Room entities and DAOs
-keep class com.lifelink.app.entities.** { *; }
-keep class com.lifelink.app.database.** { *; }

# Keep ViewModels
-keep class com.lifelink.app.viewmodels.** { *; }

# General Android
-keepattributes *Annotation*
-keepattributes SourceFile,LineNumberTable
