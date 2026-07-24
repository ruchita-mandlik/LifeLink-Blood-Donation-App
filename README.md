# LifeLink – Smart Blood Donation Application

A production-style Android app built with Kotlin, XML (Views, not Compose), MVVM,
Room, Repository Pattern, LiveData, ViewBinding and Material Design 3.

## How to open & build

1. Open Android Studio (Koala/2024.1 or newer recommended).
2. **File → Open** → select the `LifeLink` project root (the folder containing
   `settings.gradle`).
3. Android Studio will detect there's no `gradle-wrapper.jar` bundled (binary
   files aren't included in this handoff) and prompt you to **use the Gradle
   version defined by the project** — accept it, or run:
   ```
   gradle wrapper --gradle-version 8.7
   ```
   once from a terminal in the project root if you have a local Gradle
   installation, which will generate the missing wrapper jar/scripts from the
   `gradle/wrapper/gradle-wrapper.properties` already included.
4. Let Gradle sync (it will download AGP 8.5.2, Kotlin 1.9.24, and the
   AndroidX/Material/Room dependencies declared in `gradle/libs.versions.toml`).
5. Run the `app` configuration on an emulator or device with **minSdk 24+**.

## Architecture

```
UI (Activities + ViewBinding)
   ↓ observes LiveData
ViewModel (per screen, created via a single ViewModelFactory)
   ↓ calls suspend/LiveData functions
Repository (one per entity: User / Donor / BloodRequest / DonationHistory)
   ↓ wraps
Room DAO → Room Database (SQLite, single "lifelink_database")
```

Session/login state is kept in `SharedPreferences` via `SessionManager`, exposed
through the `LifeLinkApp` Application subclass alongside lazily-built repositories.

## Screens

Splash → Login/Register → Dashboard (Home tab) → Register/Edit Donor,
Search Donor, Donor Details, Blood Request, Donation History, Profile,
Edit Profile, Settings, About.

The four bottom-navigation destinations (Dashboard, Search, History, Profile)
are separate Activities linked via Intents (see `utils/NavigationHelper.kt`),
matching the "Intent Navigation" requirement rather than a single
Activity+Fragments shell.

## Notes

- All amounts, dates and blood groups are validated client-side in
  `utils/Validator.kt` before hitting Room.
- Launcher icon is defined as vector-based adaptive icon
  (`drawable/ic_launcher_background.xml` + `ic_launcher_foreground.xml`,
  wired in `mipmap-anydpi-v26/`), with a `layer-list` fallback in `mipmap/`
  for pre-API-26 devices — no binary PNGs required.
- No network permissions are declared; the app is fully offline (Room only).
